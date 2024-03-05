package com.example.springserver.Radar.Repository;


import com.example.springserver.Radar.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
