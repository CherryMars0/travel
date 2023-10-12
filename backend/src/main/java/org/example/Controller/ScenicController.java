package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.example.Response.ResponseResult;
import org.example.Services.ScenicServiceImpl;
import org.example.entity.POI;
import org.example.entity.Scenic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/Scenic")
public class ScenicController {
    private ScenicServiceImpl scenicService;

    @Autowired
    public void ScenicService(ScenicServiceImpl scenicService) {
        this.scenicService = scenicService;
    }

    @GetMapping("/getScenicByCityName/{name}")
    public ResponseResult getScenicByCityName(@PathVariable String name){
        return  scenicService.selectScenicByCityName(name);
    }
    @GetMapping("/getScenicById/{id}")
    public ResponseResult getScenicById(@PathVariable String id){
        return scenicService.selectScenicById(id);
    }

    @PostMapping("/searchHotal")
    public ResponseResult searchHotal(@RequestBody POI poi){
        return  scenicService.searchPOI(poi.getPoint(),poi.getName(),poi.getRadius());
    }

    @GetMapping ("/getScenicInfo/{name}")
    public ResponseResult getScenicInfo(@PathVariable String name){
        return  scenicService.getScenicInfo(name);
    }
}
