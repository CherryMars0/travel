package org.example.DAO;

import org.example.entity.Location;

import java.util.List;
import java.util.Optional;

public interface LocationDao {
    Optional<Location> selectLocationByName(String name);
    List<Location> selectLocationAll();
}
