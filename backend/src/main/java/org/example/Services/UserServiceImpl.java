package org.example.Services;


import org.example.DAO.UserDao;
import org.example.entity.User;
import org.example.Response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(@Qualifier("UserMapper")UserDao userDao){
        this.userDao = userDao;
    }

    public ResponseResult Login(User user){
        Optional<User> userD = userDao.selectUserByName(user.getUserName());
        if (userD.isPresent()){
            if(user.getPassword().equals(userD.get().getPassword())){
                userD.stream().findFirst().get().setPassword("******");
                return ResponseResult.LOGIN_SUCCESS().setData(userD);
            }else {
                return ResponseResult.LOGIN_FAILED().setData("wrong user password!");
            }
        }else {
            return ResponseResult.LOGIN_FAILED().setData("User does not exist!");
        }
    }

    @Override
    public ResponseResult allUser() {
        return ResponseResult.SUCCESS().setData(userDao.selectAllUser());
    }

    @Override
    public Optional<User> selectUserByName(String name) {
        return userDao.selectUserByName(name);
    }

    @Override
    public ResponseResult Signup(User user) {
        if(selectUserByName(user.getUserName()).isEmpty()){
            return ResponseResult.SUCCESS().setData(userDao.addUser(user));
        }else {
            return ResponseResult.FAILED().setData("user is exist");
        }
    }
}
