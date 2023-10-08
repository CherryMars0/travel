package org.example.Controller;


import lombok.RequiredArgsConstructor;
import org.example.entity.Employee;
import org.example.entity.Location;
import org.example.entity.User;
import org.example.Response.ResponseResult;
import org.example.Services.EmployeeServiceImpl;
import org.example.Services.LocationServiceImpl;
import org.example.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/employee")
public class EmployeeApiController {
    private UserServiceImpl userService;
    private EmployeeServiceImpl employeeService;
    private LocationServiceImpl locationService;

    @Autowired
    public void LocationService(LocationServiceImpl locationService) {
        this.locationService = locationService;
    }
    @Autowired
    public void EmployeeService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    @Autowired
    public void UserService(UserServiceImpl userService){
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseResult Login(@RequestBody User user){
        return userService.Login(user);
    }

    @PostMapping("signup")
    public ResponseResult Signup(@RequestBody User user){
        return userService.Signup(user);
    }

    @GetMapping("allUser")
    public ResponseResult allUser(){
        return userService.allUser();
    }

    @GetMapping("allEmployee")
    public ResponseResult allEmployee(){
        return employeeService.allEmployee();
    }

    @GetMapping("allLocation")
    public ResponseResult allLocation(){
        return locationService.allLocation();
    }

    @GetMapping("employeeById/{id}")
    public ResponseResult EmployeeById(@PathVariable("id") int id){
        return employeeService.selectEmployeeById(id);
    }

    @PostMapping("locationDriver")
    public ResponseResult locationDriver(@RequestBody Map<String, Location> location){
        return locationService.driverLocation(location.get("Origin"),location.get("Target"));
    }

    @GetMapping("employeeDeleteById/{id}")
    public ResponseResult employeeDeleteById(@PathVariable("id") int id){
        return employeeService.deleteEmployeeById(id);
    }

    @PostMapping("employeeUpdateById/{id}")
    public ResponseResult employeeUpdateById(@RequestBody Employee employee, @PathVariable("id") int id){
        return employeeService.updateEmployeeById(employee,id);
    }

    @PostMapping("employeeInsert")
    public ResponseResult employeeAdd(@RequestBody Employee employee){
        return employeeService.insertEmployee(employee);
    }
}
