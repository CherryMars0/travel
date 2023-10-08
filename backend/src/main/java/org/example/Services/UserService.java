package org.example.Services;

import org.example.entity.User;
import org.example.Response.ResponseResult;

import java.util.Optional;

public interface UserService {
    ResponseResult Login(User user);

    ResponseResult allUser();

    Optional<User> selectUserByName(String name);
    ResponseResult Signup(User user);
}
