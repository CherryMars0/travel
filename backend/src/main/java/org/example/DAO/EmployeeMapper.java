package org.example.DAO;

import org.example.entity.Employee;
import org.example.DAO.rowMapper.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("EmployeeMapper")
public class EmployeeMapper implements EmployeeDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Employee> selectEmployeeByName(String name) {
        final String sql= """
                select * from Employee where userName=?;
                """;
        return jdbcTemplate.query(sql,new EmployeeRowMapper(),name).stream().findFirst();
    }

    @Override
    public List<Employee> selectEmployeeAll() {
        final String sql= """
                select * from Employee;
                """;
        return jdbcTemplate.query(sql,new EmployeeRowMapper());
    }

    @Override
    public Optional<Employee> selectEmployeeById(int id) {
        final String sql= """
                select * from Employee where employeeId=?;
                """;
        return jdbcTemplate.query(sql,new EmployeeRowMapper(),id).stream().findFirst();
    }

    @Override
    public List<Employee> deleteEmployeeById(int id) {
        final String Indexical = """
                ALTER TABLE Employee AUTO_INCREMENT=?;
                """;

        jdbcTemplate.update(Indexical,id);

        final String sql = """
                delete from Employee where employeeId=?;
                """;

        jdbcTemplate.update(sql,id);

        return selectEmployeeAll();
    }

    @Override
    public List<Employee> updateEmployeeById(Employee employee,int id) {
        final String sql= """
                update Employee set userName=?,gender=?,age=?,baseSalary=?,locationId=? where employeeId = ?;
                """;
        jdbcTemplate.update(sql,employee.getUserName(),employee.getGender(),
                employee.getAge(),employee.getBaseSalary(),employee.getLocationId(),id);
        return selectEmployeeAll();
    }

    @Override
    public List<Employee> insertEmployee(Employee employee) {
        final String sql= """
                insert into Employee(EmployeeId,userName,gender,age,baseSalary,locationId) value(?,?,?,?,?,?);
                """;
        int res = jdbcTemplate.update(sql,employee.getEmployeeId(),employee.getUserName(),employee.getGender(),
                employee.getAge(),employee.getBaseSalary(),employee.getLocationId());
        if(res>0){
            return selectEmployeeAll();
        }else {
            return null;
        }
    }
}
