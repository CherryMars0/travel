package org.example.DAO;

import org.example.DAO.rowMapper.ScenicRowMapper;
import org.example.entity.Scenic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("ScenicMapper")
public class ScenicMapper implements ScenicDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ScenicMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Scenic> selectScenicByCityName(String name) {
        final String sql = """
            select * from scenics where area like
        """ + new StringBuilder().append('"').append("%").append(name).append("%").append('"');
        return jdbcTemplate.query(sql,new ScenicRowMapper());
    }

    public Optional<Scenic> selectScenicById(String id){
        final String sql = """
               select * from scenics where id = ? limit 1;
        """;
        return jdbcTemplate.query(sql,new ScenicRowMapper(),id).stream().findFirst();
    }

    @Override
    public Integer ScenicCount() {
        final String sql ="""
            select count(*) from scenics;    
        """;
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    @Override
    public List<Scenic> selectScenicByCount(String start,String end) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from scenics limit ").append(start).append(",").append(end);
        return jdbcTemplate.query(sb.toString(),new ScenicRowMapper());
    }
}
