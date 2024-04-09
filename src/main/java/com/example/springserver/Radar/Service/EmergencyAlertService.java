package com.example.springserver.Radar.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class EmergencyAlertService {

    private SseEmitter emitter;

    public SseEmitter getEmitter() {
        return emitter;
    }

    public void setEmitter(SseEmitter emitter) {
        this.emitter = emitter;
    }

    public void notifyEmergency() {
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event().name("emergency").data("Fall detected!"));
                System.out.println("send");
            } catch (Exception e) {
                this.emitter = null;
            }
        }
    }
}
