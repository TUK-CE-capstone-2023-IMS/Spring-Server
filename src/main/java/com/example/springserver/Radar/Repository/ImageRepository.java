package com.example.springserver.Radar.Repository;


import com.example.springserver.Radar.Entity.Image;
import com.example.springserver.Radar.Entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findByName(String name);
}