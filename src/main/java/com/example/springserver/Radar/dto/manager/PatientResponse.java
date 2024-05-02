package com.example.springserver.Radar.dto.manager;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponse {
    private String patientid;
    private String name;
    private String sex;
    private String age;
    private String phone;
    private String email;
    private String address;
    private String emergencycall;
    private String imagename;
    private String height;
    private String weight;
}