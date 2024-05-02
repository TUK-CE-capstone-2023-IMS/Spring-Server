package com.example.springserver.Radar.dto.image;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponse {
    private int id;
    private boolean success;
    private String name;
    private String url;
    private String message;
}