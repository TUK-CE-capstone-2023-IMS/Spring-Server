package com.example.springserver.Radar.Controller;

import com.example.springserver.Radar.Service.EmergencyAlertService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    private final EmergencyAlertService emergencyAlertService;

    public StatusController(EmergencyAlertService emergencyAlertService) {
        this.emergencyAlertService = emergencyAlertService;
    }

    @PostMapping("/status")
    public void receiveStatus(@RequestBody Status status) {
        if ("fall".equals(status.getState())) {
            status.setState("fall");
            emergencyAlertService.notifyEmergency();
        }
    }

    static class Status {
        private String state;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
}
