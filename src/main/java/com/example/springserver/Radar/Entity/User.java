package com.example.springserver.Radar.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;
    private String name;
    private String age;
    private String sex;
    private String phone;
    private String email;
    private String address;
    private String etc;
}
