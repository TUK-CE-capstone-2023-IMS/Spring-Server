package com.example.springserver.Radar.dto.log;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogResponse {
    private boolean success;
    private String message;
    private String patientid;
    private String datetime;
    private String type;
    private String content;
    private float x;
    private float y;
    private int area;
}
