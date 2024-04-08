package com.example.springserver.Radar.Repository;


import com.example.springserver.Radar.Entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Manager findByManagerid(String managerId);

    boolean existsByManagerid(String managerid);
}