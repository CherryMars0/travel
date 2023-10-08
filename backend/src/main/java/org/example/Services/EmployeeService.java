package org.example.Services;

import org.example.entity.Employee;
import org.example.Response.ResponseResult;

public interface EmployeeService {
    ResponseResult allEmployee();

    ResponseResult selectEmployeeById(int id);

    ResponseResult deleteEmployeeById(int id);

    ResponseResult updateEmployeeById(Employee employee, int id);

    ResponseResult insertEmployee(Employee employee);
}
