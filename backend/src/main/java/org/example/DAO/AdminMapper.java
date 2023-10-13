package org.example.DAO;

import org.example.DAO.rowMapper.AdminRowMapper;
import org.example.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("AdminMapper")
public class AdminMapper implements AdminDao{

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public AdminMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Admin> findAdminByName(String name) {
         final String sql= """
                select * from admin where name = ?;
                """;
        return jdbcTemplate.query(sql,new AdminRowMapper(),name).stream().findFirst();
    }
}
