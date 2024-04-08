package com.example.springserver.Radar.dto.manager;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SigninRequest {
    private String managerid;
    private String password;
    private String name;
    private String age;
    private String sex;
    private String phone;
    private String email;
    private String address;
    private String etc;
}
