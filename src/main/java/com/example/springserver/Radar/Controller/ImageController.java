package com.example.springserver.Radar.Controller;

import com.example.springserver.Radar.Service.ImageService;
import com.example.springserver.Radar.dto.image.ImageRequest;
import com.example.springserver.Radar.dto.image.ImageResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;
    @Operation(summary = "Create Image Info", description = "이미지 url와 department로 이미지 추가")
    @PostMapping("/image")
    public ImageResponse createInfo(@RequestBody ImageRequest imageRequest) {

        return imageService.create(imageRequest);
    }

    @Operation(summary = "get Image url by name", description = "name으로 iamge url 요청")
    @GetMapping("/name")
    public ImageResponse getImageUrlByName(@RequestParam String name) {
        return imageService.getImageUrlByName(name);
    }
}
