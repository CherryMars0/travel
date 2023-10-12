package org.example.DAO.rowMapper;

import org.example.entity.Guider;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuiderRowMapper implements RowMapper<Guider> {
    @Override
    public Guider mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Guider(rs.getString("id"), rs.getString("name"),
                rs.getString("scope"), rs.getString("address"),
                rs.getString("desc"), rs.getString("sex"),
                rs.getString("qq"), rs.getString("hot"));
    }
}
