package org.example.Services;

import org.example.DAO.ScenicDao;
import org.example.Response.ResponseResult;
import org.example.entity.Scenic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class ScenicServiceImpl implements ScenicService{
    private ScenicDao scenicDao;
    @Autowired
    public ScenicServiceImpl(@Qualifier("ScenicMapper") ScenicDao scenicDao) {
        this.scenicDao = scenicDao;
    }


    public ResponseResult selectScenicByCityName(String name) {
        return  ResponseResult.SUCCESS().setData(scenicDao.selectScenicByCityName(name));
    }


    public ResponseResult selectScenicById(String id){
        return ResponseResult.SUCCESS().setData(scenicDao.selectScenicById(id));
    }

    @Override
    public ResponseResult searchPOI(String point,String POI,String radius) {
         final String URL = "https://api.map.baidu.com/place/v2/search?";
         final String AK = "skR1XKGZitEQLNBx1PdtH1sesGHSPIjn";
        URI uri = URI.create(URL + "query=" + POI + "&location=" + point+ "&radius="
                + radius + "&output=json&ak=" + AK);
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
        HttpResponse response = null;
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            e.printStackTrace();
        }
        assert response != null;
        return  ResponseResult.SUCCESS().setData(response.body().toString());
    }
}
