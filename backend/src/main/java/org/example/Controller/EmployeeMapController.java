package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class EmployeeMapController {
    @GetMapping("/")
    public String Index () {
        return "index";
    }
}
