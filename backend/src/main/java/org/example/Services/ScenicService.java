package org.example.Services;

import org.example.Response.ResponseResult;

public interface ScenicService {

    ResponseResult selectScenicByCityName(String name);
    ResponseResult selectScenicById(String id);

    ResponseResult searchPOI(String point,String POI,String radius);

    ResponseResult getScenicInfo(String name);

    ResponseResult ScenicCount();

    ResponseResult selectScenicByCount(String start,String end);
}
