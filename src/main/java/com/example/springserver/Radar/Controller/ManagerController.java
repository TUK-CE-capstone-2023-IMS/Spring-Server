package com.example.springserver.Radar.Controller;


import com.example.springserver.Radar.Service.ManagerService;
import com.example.springserver.Radar.dto.manager.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @Operation(summary = "Manager SignIn", description = "Manager 개인정보를 전송하여 회원가입합니다.")
    @PostMapping("/signin")
    public ManagerResponse signin(@RequestBody SigninRequest signinRequest) {

        return managerService.signin(signinRequest);
    }

    @Operation(summary = "Manager SignOut", description = "Manager의 ID와 비밀번호를 전송하여 회원탈퇴합니다.")
    @PostMapping("/signout")
    public ManagerResponse signout(@RequestBody SignoutRequest signoutRequest) {

        return managerService.signout(signoutRequest);
    }

    @Operation(summary = "Manager Login", description = "Manager의 ID와 비밀번호를 전송하여 로그인 가능 여부를 확인합니다.")
    @PostMapping("/login")
    public ManagerResponse login(@RequestBody LoginRequest loginRequest) {

        System.out.println(loginRequest);
        System.out.println(managerService.login(loginRequest));

        return managerService.login(loginRequest);
    }

    @Operation(summary = "Manager Logout", description = "ManagerId를 전송하여 로그아웃 요청")
    @GetMapping("/logout")
    public ManagerResponse logout(@RequestParam String managerId) {
        return managerService.logout(managerId);
    }

    @Operation(summary = "Manager info", description = "ManagerId를 전송하여 회원정보 요청")
    @GetMapping("/info")
    public ManagerInfoResponse info(@RequestParam String managerId) {
        return managerService.info(managerId);
    }

    @Operation(summary = "Manager info", description = "ManagerId를 전송하여 환자정보 요청")
    @GetMapping("/patientInfo")
    public ManagerInfoResponse patientsInfo(@RequestParam String managerId) {
        return managerService.info(managerId);
    }

    //adf
    @Operation(summary = "Manager info", description = "ManagerId를 전송하여 환자수 요청")
    @GetMapping("/patientCount")
    public ManagerInfoResponse PatientCount(@RequestParam String managerId) {
        return managerService.info(managerId);
    }


}
