package org.example.DAO.rowMapper;

import org.example.entity.Scenic;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScenicRowMapper implements RowMapper<Scenic> {
    @Override
    public Scenic mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Scenic(rs.getNString("name"),rs.getNString("img"),rs.getNString("area")
                ,rs.getNString("price"),rs.getNString("point"),rs.getNString("id")
                ,rs.getNString("hot"),rs.getNString("intro"),rs.getNString("address")
                ,rs.getNString("level"),rs.getNString("sold"));
    }
}
