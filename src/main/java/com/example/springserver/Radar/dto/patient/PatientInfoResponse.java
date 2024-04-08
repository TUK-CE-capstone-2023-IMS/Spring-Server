package com.example.springserver.Radar.dto.patient;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientInfoResponse {
    private String patientid;
    private String name;
    private String sex;
    private String age;
    private String phone;
    private String email;
    private String address;
    private String emergencycall;
    private String managerid;
}