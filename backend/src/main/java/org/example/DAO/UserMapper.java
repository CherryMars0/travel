package org.example.DAO;

import org.example.entity.User;
import org.example.DAO.rowMapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository("UserMapper")
public class UserMapper implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> selectUserByName(String name) {
        final String sql= """
                select * from User where username=?;
                """;
        return jdbcTemplate.query(sql,new UserRowMapper(),name).stream().findFirst();
    }

    @Override
    public UserDetails authUserByName(String name) {
        Optional<User> user = selectUserByName(name);
        List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new org.springframework.security.core.userdetails.User(
                    user.get().getUsername(),user.get().getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")))
        );
        return APPLICATION_USERS.stream().filter(u -> u.getUsername().equals(name))
                .findFirst().orElseThrow(() -> new UsernameNotFoundException("no user was founded !"));
    }

    @Override
    public List<User> selectAllUser() {
        final String sql= """
                select * from User;
                """;
        return jdbcTemplate.query(sql,new UserRowMapper());
    }

    @Override
    public Optional<User> addUser(User user) {
        final String sql= """
                insert into User(username,password) value(?,?);
                """;
        int res = jdbcTemplate.update(sql,user.getUsername(),user.getPassword());
        if(res > 0){
            return selectUserByName(user.getUsername());
        }else {
            return Optional.empty();
        }
    }
}
