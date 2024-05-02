package com.example.springserver.Radar.dto.manager;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagerResponse {
    private String success;
    private String name;
    private String managerId;
    private String message;
}