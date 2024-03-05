package com.example.springserver.Radar.Controller;

import com.example.springserver.Radar.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final UserService userService;
    @GetMapping(value = "/hello/{name}")
    public String hello(String name) {
        return name;
    }
}
