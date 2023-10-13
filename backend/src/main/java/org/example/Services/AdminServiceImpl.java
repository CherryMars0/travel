package org.example.Services;

import org.example.DAO.AdminDao;
import org.example.Response.ResponseResult;
import org.example.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    public AdminServiceImpl(@Qualifier("AdminMapper")AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    private AdminDao adminDao;
    @Override
    public ResponseResult adminLogin(Admin admin) {
        Optional<Admin> userD = adminDao.findAdminByName(admin.getName());
        if (userD.isPresent()){
            if(admin.getPassword().equals(userD.get().getPassword())){
                userD.stream().findFirst().get().setPassword("******");
                return ResponseResult.LOGIN_SUCCESS().setData(userD);
            }else {
                return ResponseResult.LOGIN_FAILED().setData("wrong user password!");
            }
        }else {
            return ResponseResult.LOGIN_FAILED().setData("User does not exist!");
        }
    }
}
