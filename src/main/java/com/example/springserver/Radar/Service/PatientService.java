package com.example.springserver.Radar.Service;

import com.example.springserver.Radar.Entity.Patient;
import com.example.springserver.Radar.Repository.PatientRepository;
import com.example.springserver.Radar.dto.patient.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public PatientResponse create(PatientSaveRequest patientSaveRequest) {
        // patientid로 이미 존재하는 환자를 조회
        Patient existingPatient = patientRepository.findByPatientid(patientSaveRequest.getPatientid());
        if (existingPatient != null) {
            return PatientResponse.builder()
                    .success(false)
                    .message("이미 존재하는 환자입니다.")
                    .build();
        }

        // PatientSaveRequest에서 필요한 정보를 추출하여 Patient 엔티티 생성
        Patient patient = Patient.builder()
                .patientid(patientSaveRequest.getPatientid())
                .name(patientSaveRequest.getName())
                .sex(patientSaveRequest.getSex())
                .age(patientSaveRequest.getAge())
                .phone(patientSaveRequest.getPhone())
                .email(patientSaveRequest.getEmail())
                .address(patientSaveRequest.getAddress())
                .emergencycall(patientSaveRequest.getEmergencycall())
                .managerid(patientSaveRequest.getManagerid())
                .build();

        // 생성된 Patient 엔티티를 저장
        Patient savedPatient = patientRepository.save(patient);

        // 저장된 환자 정보를 기반으로 응답 생성
        return PatientResponse.builder()
                .id(savedPatient.getId())
                .success(true)
                .managerId(savedPatient.getManagerid())
                .name(savedPatient.getName())
                .message("환자 정보가 성공적으로 저장되었습니다.")
                .build();
    }

    // 개인 감지 영역 설정 메서드
    public PatientResponse setting(DectionZoneConfigurationRequest request) {
        // 요청에서 patientid 가져오기
        String patientId = request.getPatientid();

        // patientid로 해당 환자 정보 가져오기
        Patient patient = patientRepository.findByPatientid(patientId);

        // 해당 환자가 존재하는지 확인
        if (patient == null) {
            // 환자가 존재하지 않으면 실패 응답 반환
            return PatientResponse.builder()
                    .success(false)
                    .message("환자를 찾을 수 없습니다.")
                    .build();
        }

        // 요청에서 감지 영역 데이터 가져오기
        patient.setX1(request.getX1());
        patient.setX2(request.getX2());
        patient.setY1(request.getY1());
        patient.setY2(request.getY2());
        patient.setZ1(request.getZ1());
        patient.setZ2(request.getZ2());
        patient.setZslope(request.getZslope());
        patient.setYslope2(request.getYslope2());

        // 감지 영역 데이터를 저장
        patientRepository.save(patient);

        // 성공 응답 반환
        return PatientResponse.builder()
                .success(true)
                .message("감지 영역 설정이 업데이트되었습니다.")
                .build();
    }

    public DectionZoneConfigurationResponse getSetting(String patientId) {
        // 환자 ID를 사용하여 해당 환자의 정보를 데이터베이스에서 조회합니다.
        Patient patient = patientRepository.findByPatientid(patientId);

        // 조회된 환자의 정보가 없으면 예외를 발생시킵니다.
        if (patient == null) {
            throw new RuntimeException("환자를 찾을 수 없습니다.");
        }

        // 조회된 환자의 정보를 DectionZoneConfigurationResponse 객체로 매핑하여 반환합니다.
        return DectionZoneConfigurationResponse.builder()
                .patientid(patient.getPatientid())
                .name(patient.getName())
                .X1(patient.getX1())
                .X2(patient.getX2())
                .Y1(patient.getY1())
                .Y2(patient.getY2())
                .Z1(patient.getZ1())
                .Z2(patient.getZ2())
                .Zslope(patient.getZslope())
                .Yslope2(patient.getYslope2())
                .build();
    }

    public PatientInfoResponse getInfo(String patientId) {
        // 환자 ID를 사용하여 해당 환자의 정보를 데이터베이스에서 조회합니다.
        Patient patient = patientRepository.findByPatientid(patientId);

        // 조회된 환자의 정보가 없으면 예외를 발생시킵니다.
        if (patient == null) {
            throw new RuntimeException("환자를 찾을 수 없습니다.");
        }

        // 조회된 환자의 정보를 PatientInfoResponse 객체로 매핑하여 반환합니다.
        return PatientInfoResponse.builder()
                .patientid(patient.getPatientid())
                .name(patient.getName())
                .sex(patient.getSex())
                .age(patient.getAge())
                .phone(patient.getPhone())
                .email(patient.getEmail())
                .address(patient.getAddress())
                .emergencycall(patient.getEmergencycall())
                .managerid(patient.getManagerid())
                .build();
    }

    public PatientResponse deleteInfo(String patientId) {
        // 환자 정보를 삭제합니다.
        Patient patient = patientRepository.findByPatientid(patientId);
        if (patient == null) {
            throw new EntityNotFoundException("환자를 찾을 수 없습니다.");
        }
        patientRepository.delete(patient);

        // 삭제 결과 응답 생성
        return PatientResponse.builder()
                .success(true)
                .message("환자 정보가 성공적으로 삭제되었습니다.")
                .build();
    }

    public PatientResponse updateInfo(PatientUpdateRequest patientUpdateRequest) {
        // 환자 정보를 업데이트합니다.
        Patient patient = patientRepository.findByPatientid(patientUpdateRequest.getPatientid());
        if (patient == null) {
            throw new EntityNotFoundException("환자를 찾을 수 없습니다.");
        }
        patient.setName(patientUpdateRequest.getName());
        patient.setSex(patientUpdateRequest.getSex());
        patient.setAge(patientUpdateRequest.getAge());
        patient.setPhone(patientUpdateRequest.getPhone());
        patient.setEmail(patientUpdateRequest.getEmail());
        patient.setAddress(patientUpdateRequest.getAddress());
        patient.setEmergencycall(patientUpdateRequest.getEmergencycall());
        patient.setManagerid(patientUpdateRequest.getManagerid());

        // 데이터베이스에 변경사항을 저장합니다.
        patientRepository.save(patient);

        // 업데이트 결과 응답 생성
        return PatientResponse.builder()
                .success(true)
                .message("환자 정보가 성공적으로 업데이트되었습니다.")
                .build();
    }
}