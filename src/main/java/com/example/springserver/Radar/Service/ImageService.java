package com.example.springserver.Radar.Service;

import com.example.springserver.Radar.Entity.Image;
import com.example.springserver.Radar.Repository.ImageRepository;
import com.example.springserver.Radar.dto.image.ImageRequest;
import com.example.springserver.Radar.dto.image.ImageResponse;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public ImageResponse create(ImageRequest imageRequest) {
        // ImageRequest에서 필요한 정보를 추출하여 Image 엔티티 생성
        Image newImage = Image.builder()
                .name(imageRequest.getName())
                .url(imageRequest.getUrl())
                .build();

        // 이미지를 저장하고 저장된 이미지의 ID를 가져옴
        Image savedImage = imageRepository.save(newImage);
        int savedImageId = savedImage.getId();

        // 이미지 저장 성공 여부에 따른 응답 메시지 생성
        String message = (savedImageId > 0) ? "Image created successfully." : "Failed to create image.";

        // ImageResponse 객체 생성하여 반환
        return ImageResponse.builder()
                .id(savedImageId)
                .success(savedImageId > 0)
                .name(savedImage.getName())
                .url(savedImage.getUrl())
                .message(message)
                .build();
    }

    public ImageResponse getImageUrlByName(String name) {
        // 이미지 이름으로 이미지를 조회합니다.
        Image image = imageRepository.findByName(name);

        // 이미지가 존재하는지 확인합니다.
        if (image != null) {
            // 이미지가 존재할 경우 해당 이미지의 정보를 ImageResponse로 반환합니다.
            return ImageResponse.builder()
                    .id(image.getId())
                    .success(true)
                    .name(image.getName())
                    .url(image.getUrl())
                    .message("Image URL retrieved successfully.")
                    .build();
        } else {
            // 이미지가 존재하지 않을 경우에는 실패를 의미하는 메시지를 반환합니다.
            return ImageResponse.builder()
                    .success(false)
                    .message("Image with name '" + name + "' not found.")
                    .build();
        }
    }
}
