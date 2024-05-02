package com.example.springserver.Radar.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;;
    @Builder.Default
    @Column(nullable = false)
    private String name = "noimage";
    @Builder.Default
    private String url = "![image](https://github.com/TUK-CE-capstone-2023-IMS/Spring-Server/assets/37824506/31f06a76-aeac-43a8-880b-649028ea4110)";
}