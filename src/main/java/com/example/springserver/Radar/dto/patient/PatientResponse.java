package com.example.springserver.Radar.dto.patient;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse {
    private int id;
    private boolean success;
    private String managerId;
    private String name;
    private String message;
}