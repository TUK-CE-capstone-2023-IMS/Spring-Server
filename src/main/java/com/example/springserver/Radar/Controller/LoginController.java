package com.example.springserver.Radar.Controller;

import com.example.springserver.Radar.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
}
