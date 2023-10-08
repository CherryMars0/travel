package org.example.DAO;

import org.example.entity.Location;
import org.example.DAO.rowMapper.LocationRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("LocationMapper")
public class LocationMapper implements LocationDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LocationMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Location> selectLocationByName(String name) {
        final String sql= """
                select * from Location where LocationName=?;
                """;
        return jdbcTemplate.query(sql,new LocationRowMapper(),name).stream().findFirst();
    }

    @Override
    public List<Location> selectLocationAll() {
        final String sql= """
                select * from Location;
                """;
        return jdbcTemplate.query(sql,new LocationRowMapper());
    }
}
