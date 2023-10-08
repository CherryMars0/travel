package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.example.Response.ResponseResult;
import org.example.Services.UserServiceImpl;
import org.example.Utils.Uuid;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/User")
public class UserController {
    private UserServiceImpl userService;
    @Autowired
    public void UserService(UserServiceImpl userService){
        this.userService = userService;
    }
    @PostMapping("login")
    public ResponseResult Login(@RequestBody User user){
        return userService.Login(user);
    }

    @PostMapping("signup")
    public ResponseResult register(@RequestBody User user){
        user.setId(Uuid.getUUID());
        return userService.Signup(user);
    }
}
