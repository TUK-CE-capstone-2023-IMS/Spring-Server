package com.example.springserver.Radar.Repository;


import com.example.springserver.Radar.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByManagerid(String userId);

    Patient findByPatientid(String patientId);
}
