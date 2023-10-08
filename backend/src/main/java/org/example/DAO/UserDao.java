package org.example.DAO;

import org.example.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> selectUserByName(String name);
    UserDetails authUserByName(String name);

    List<User> selectAllUser();

    Optional<User> addUser(User user);
}
