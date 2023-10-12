package org.example.DAO;

import org.example.DAO.rowMapper.GuiderRowMapper;
import org.example.entity.Guider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("GuiderMapper")
public class GuiderMapper implements GuiderDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GuiderMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Guider> selectGuiderAll() {
        final String sql= """
                select * from guides;
                """;
        return jdbcTemplate.query(sql,new GuiderRowMapper());
    }
}
