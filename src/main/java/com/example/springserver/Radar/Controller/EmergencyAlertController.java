package com.example.springserver.Radar.Controller;

import com.example.springserver.Radar.Service.EmergencyAlertService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class EmergencyAlertController {

    private final EmergencyAlertService emergencyAlertService;

    public EmergencyAlertController(EmergencyAlertService emergencyAlertService) {
        this.emergencyAlertService = emergencyAlertService;
    }

    @GetMapping("/alert")
    public SseEmitter subscribeToAlerts() {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        this.emergencyAlertService.setEmitter(emitter);

        emitter.onCompletion(() -> this.emergencyAlertService.setEmitter(null));
        emitter.onTimeout(() -> this.emergencyAlertService.setEmitter(null));
        emitter.onError((e) -> this.emergencyAlertService.setEmitter(null));

        return emitter;
    }
}
