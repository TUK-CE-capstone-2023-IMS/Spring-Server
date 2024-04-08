package com.example.springserver.Radar.Controller;

import com.example.springserver.Radar.Service.PatientService;
import com.example.springserver.Radar.dto.patient.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    @Operation(summary = "Create Patient Info", description = "개인정보를 전달하여 회원 생성")
    @PostMapping("/info")
    public PatientResponse createInfo(@RequestBody PatientSaveRequest patientSaveRequest) {

        return patientService.create(patientSaveRequest);
    }

    @Operation(summary = "Get Patient Info", description = "Patient id를 주면 개인정보를 반환")
    @GetMapping("/info")
    public PatientInfoResponse getInfo(@RequestParam String patientId) {

        return patientService.getInfo(patientId);
    }

    @Operation(summary = "Delete Patient Info", description = "Patient id를 주면 환자 삭제")
    @DeleteMapping("/info")
    public PatientResponse DeleteInfo(@RequestParam String patientId) {

        return patientService.deleteInfo(patientId);
    }

    @Operation(summary = "Update Patient Info", description = "PatientId 사용하여 개인 정보 수정")
    @PutMapping("/info")
    public PatientResponse DeleteInfo(@RequestBody PatientUpdateRequest patientUpdateRequest) {

        return patientService.updateInfo(patientUpdateRequest);
    }

    @Operation(summary = "Detection Zone Configuration Setting", description = "Patient id와 개인 감지 영역 데이터를 주면 이를 업데이트")
    @PutMapping("/setting")
    public PatientResponse patient(@RequestBody DectionZoneConfigurationRequest dectionZoneConfigurationRequest) {

        return patientService.setting(dectionZoneConfigurationRequest);
    }

    @Operation(summary = "Detection Zone Configuration Info", description = "Patient id를 주면 개인 감지 영역 데이터를 반환")
    @GetMapping("/setting")
    public DectionZoneConfigurationResponse patient(@RequestParam String patientId) {

        return patientService.getSetting(patientId);
    }
}
