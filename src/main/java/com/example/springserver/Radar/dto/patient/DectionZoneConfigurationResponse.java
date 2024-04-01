package com.example.springserver.Radar.dto.patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DectionZoneConfigurationRequest {
    private String patientid;
    private String X1;
    private String X2;
    private String Y1;
    private String Y2;
    private String Z1;
    private String Z2;
    private String Zslope;
    private String Yslope2;
}
