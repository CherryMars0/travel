package org.example.Services;

import org.example.DAO.EmployeeDao;
import org.example.DAO.GuiderDao;
import org.example.Response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GuiderServiceImpl implements GuiderService{

    private GuiderDao guiderDao;

    @Autowired
    public GuiderServiceImpl(@Qualifier("GuiderMapper") GuiderDao guiderDao) {
        this.guiderDao = guiderDao;
    }

    public ResponseResult allGuides(){
        return ResponseResult.SUCCESS().setData(guiderDao.selectGuiderAll());
    }
}
