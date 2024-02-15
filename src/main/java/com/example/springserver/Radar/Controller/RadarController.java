package com.example.springserver.Radar.Controller;

import com.example.springserver.Radar.Service.RadarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/radar")
public class RadarController {

    private final RadarService radarService;

    @Autowired
    public RadarController(RadarService radarService) {

        this.radarService = radarService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
