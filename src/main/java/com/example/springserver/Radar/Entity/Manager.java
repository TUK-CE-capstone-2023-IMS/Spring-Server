package com.example.springserver.Radar.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String managerid;
    private String password;
    private String name;
    private String age;
    private String sex;
    private String phone;
    private String email;
    private String address;
    @Builder.Default
    private String department = "basic";
    private String etc;
}
