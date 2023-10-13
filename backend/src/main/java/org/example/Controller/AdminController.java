package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.example.Response.ResponseResult;
import org.example.Services.AdminServiceImpl;
import org.example.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/Admin")
public class AdminController {

    private AdminServiceImpl adminService;

    @Autowired
    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestBody Admin admin){
        System.out.println(admin.toString());
        return  adminService.adminLogin(admin);
    }
}
