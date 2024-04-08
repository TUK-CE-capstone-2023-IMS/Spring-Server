package com.example.springserver.Radar.Repository;


import com.example.springserver.Radar.Entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {

    List<Log> findByPatientid(String patientId);
}
