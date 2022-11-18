package kau.software.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public String main() {

        return "frontend/main";
    }



}
