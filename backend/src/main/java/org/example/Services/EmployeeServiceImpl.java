package org.example.Services;

import org.example.DAO.EmployeeDao;
import org.example.entity.Employee;
import org.example.Response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDao;
    @Autowired
    public EmployeeServiceImpl(@Qualifier("EmployeeMapper")EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public ResponseResult allEmployee() {
        return ResponseResult.SUCCESS().setData(employeeDao.selectEmployeeAll());
    }

    @Override
    public ResponseResult selectEmployeeById(int id) {
        return ResponseResult.SUCCESS().setData(employeeDao.selectEmployeeById(id));
    }

    @Override
    public ResponseResult deleteEmployeeById(int id) {
        return ResponseResult.SUCCESS().setData(employeeDao.deleteEmployeeById(id));
    }

    @Override
    public ResponseResult updateEmployeeById(Employee employee, int id) {
        return ResponseResult.SUCCESS().setData(employeeDao.updateEmployeeById(employee,id));
    }

    @Override
    public ResponseResult insertEmployee(Employee employee) {
        if(employee != null){
            return ResponseResult.SUCCESS().setData(employeeDao.insertEmployee(employee));
        }else {
            return ResponseResult.FAILED().setData("employee insert failed");
        }
    }
}