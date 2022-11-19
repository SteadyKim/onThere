package kau.software.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ResultController {

    @GetMapping("/result")
    public String result () {

        return "frontend/result";
    }
}
