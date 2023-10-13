package org.example.Services;

import org.example.Response.ResponseResult;
import org.example.entity.Admin;


public interface AdminService {

    ResponseResult adminLogin(Admin admin);
}
