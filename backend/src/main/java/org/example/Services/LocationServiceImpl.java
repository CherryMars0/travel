package org.example.Services;

import org.example.DAO.LocationDao;
import org.example.entity.Location;
import org.example.Response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class LocationServiceImpl implements LocationService{
    private LocationDao locationDao;

    @Autowired
    public LocationServiceImpl(@Qualifier("LocationMapper")LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public ResponseResult allLocation() {
        return ResponseResult.SUCCESS().setData(locationDao.selectLocationAll());
    }

    @Override
    public ResponseResult driverLocation(Location Origin, Location Target) {
        String origin = Origin.getLatitude() + "," + Origin.getLongitude();
        String destination = Target.getLatitude() + ',' + Target.getLongitude();
        String AK ="skR1XKGZitEQLNBx1PdtH1sesGHSPIjn";
        String endPoint = "http://api.map.baidu.com/directionlite/v1/driving?";
        URI uri = URI.create(endPoint + "origin=" + origin + "&destination=" + destination + "&output=json" + "&ak=" + AK);
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
        HttpResponse response = null;
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            e.printStackTrace();
        }
        assert response != null;
        return ResponseResult.SUCCESS().setData(response.body().toString());
    }
}