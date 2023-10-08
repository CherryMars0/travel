package org.example.Services;

import org.example.entity.Location;
import org.example.Response.ResponseResult;

public interface LocationService {
    ResponseResult allLocation();

    ResponseResult driverLocation(Location Origin,Location Target);
}
