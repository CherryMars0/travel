package org.example.DAO.rowMapper;

import org.example.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(rs.getString("employeeId"), rs.getString("userName")
                ,rs.getString("gender"),rs.getInt("age")
                ,rs.getString("baseSalary"),rs.getString("locationId"));
    }
}
