package org.example.DAO.rowMapper;

import org.example.entity.Admin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRowMapper implements RowMapper<Admin> {
    @Override
    public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
        return  new Admin(rs.getNString("id")
                ,rs.getNString("name"), rs.getNString("password"));
    }
}
