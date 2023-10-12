package org.example.Services;

import org.example.Response.ResponseResult;
import org.example.entity.Scenic;

public interface ScenicService {

    ResponseResult selectScenicByCityName(String name);
    ResponseResult selectScenicById(String id);

    ResponseResult searchPOI(String point,String POI,String radius);
}
