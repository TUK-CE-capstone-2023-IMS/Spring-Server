package com.example.springserver.Radar.Repository;


import com.example.springserver.Radar.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByManagerid(String userId);
    List<Patient> findAll();
    Patient findByPatientid(String patientId);

    int countByManagerid(String managerId);
}
