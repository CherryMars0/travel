package org.example.DAO;

import org.example.entity.Admin;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AdminDao {


    Optional<Admin> findAdminByName(String name);
}
