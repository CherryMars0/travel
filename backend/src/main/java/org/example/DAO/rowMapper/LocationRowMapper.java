package org.example.DAO.rowMapper;

import org.example.entity.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationRowMapper implements RowMapper<Location> {
    @Override
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Location(rs.getString("locationId"), rs.getNString("locationName")
                ,rs.getNString("latitude"),rs.getNString("longitude"));
    }
}
