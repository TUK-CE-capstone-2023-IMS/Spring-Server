package com.example.springserver.Radar.dto.log;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogSaveResponse {
    private boolean success;
    private String patientid;
    private String datetime;
    private String type;
    private String message;
    private float x;
    private float y;
    private int area;
}
