package com.example.springserver.Radar.Repository;


import com.example.springserver.Radar.Entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Manager, Long> {
    Manager findByUserid(String userId);
}
