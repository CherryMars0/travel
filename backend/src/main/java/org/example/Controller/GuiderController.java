package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.example.Response.ResponseResult;
import org.example.Services.GuiderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/Scenic")
public class GuiderController {
    private GuiderServiceImpl guiderService;

    @Autowired
    public void GuiderService(GuiderServiceImpl guiderService) {
        this.guiderService = guiderService;
    }

    @GetMapping("/getGuides")
    public ResponseResult getGuides(){
        return  guiderService.allGuides();
    }

}
