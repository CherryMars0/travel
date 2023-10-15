package org.example.DAO;

import org.example.entity.Scenic;

import java.util.List;
import java.util.Optional;

public interface ScenicDao {

    List<Scenic> selectScenicByCityName(String name);
    Optional<Scenic> selectScenicById(String id);

    Integer ScenicCount();

    List<Scenic> selectScenicByCount(String start,String end);
}
