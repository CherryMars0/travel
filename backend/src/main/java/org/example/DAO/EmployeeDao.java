package org.example.DAO;

import org.example.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    Optional<Employee> selectEmployeeByName(String name);
    List<Employee> selectEmployeeAll();

    Optional<Employee> selectEmployeeById(int id);

    List<Employee> deleteEmployeeById(int id);

    List<Employee>updateEmployeeById(Employee employee,int id);

    List<Employee> insertEmployee(Employee employee);
}
