package com.example.springserver.Radar.Service;

import com.example.springserver.Radar.Entity.Manager;
import com.example.springserver.Radar.Repository.ManagerRepository;
import com.example.springserver.Radar.dto.manager.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public ManagerResponse signin(SigninRequest signinRequest) {
        // 중복된 managerid가 있는지 확인
        if (managerRepository.existsByManagerid(signinRequest.getManagerid())) {
            return ManagerResponse.builder()
                    .success(false)
                    .message("이미 사용 중인 아이디입니다.")
                    .build();
        }

        // SigninRequest에서 필요한 정보를 추출하여 Manager 엔티티 생성
        Manager manager = Manager.builder()
                .managerid(signinRequest.getManagerid())
                .password(signinRequest.getPassword())
                .name(signinRequest.getName())
                .age(signinRequest.getAge())
                .sex(signinRequest.getSex())
                .phone(signinRequest.getPhone())
                .email(signinRequest.getEmail())
                .address(signinRequest.getAddress())
                .etc(signinRequest.getEtc())
                .build();

        // 생성된 Manager 엔티티를 저장
        Manager savedManager = managerRepository.save(manager);

        // 회원가입 결과를 반환
        return ManagerResponse.builder()
                .success(true)
                .name(savedManager.getName())
                .managerId(savedManager.getManagerid())
                .message("매니저 회원가입이 성공적으로 완료되었습니다.")
                .build();
    }
    public ManagerResponse signout(SignoutRequest signoutRequest) {
        ManagerResponse managerResponse = new ManagerResponse();

        String managerId = signoutRequest.getManagerid();
        String password = signoutRequest.getPassword();

        // 매니저 ID로 매니저 조회
        Manager manager = managerRepository.findByManagerid(managerId);

        if (manager == null) {
            // 매니저가 없는 경우
            managerResponse.setSuccess(false);
            managerResponse.setMessage("회원탈퇴 실패: 해당 매니저 ID를 찾을 수 없습니다.");
            return managerResponse;
        }

        if (!manager.getPassword().equals(password)) {
            // 비밀번호가 다른 경우
            managerResponse.setSuccess(false);
            managerResponse.setMessage("회원탈퇴 실패: 비밀번호가 일치하지 않습니다.");
            return managerResponse;
        }

        // 매니저가 있는 경우이고, 비밀번호도 일치하는 경우에만 삭제
        managerRepository.delete(manager);

        managerResponse.setSuccess(true);
        managerResponse.setMessage("회원탈퇴 성공: manager ID " + managerId + "가 회원탈퇴되었습니다.");

        return managerResponse;
    }

    public ManagerResponse login(LoginRequest loginRequest) {
        // 사용자가 제공한 아이디로 매니저 정보를 조회합니다.
        Manager manager = managerRepository.findByManagerid(loginRequest.getManagerId());

        // 매니저가 존재하지 않거나 비밀번호가 일치하지 않는 경우 로그인 실패로 처리합니다.
        if (manager == null || !manager.getPassword().equals(loginRequest.getPassword())) {
            return ManagerResponse.builder()
                    .success(false)
                    .message("로그인에 실패했습니다. 아이디 또는 비밀번호를 확인해주세요.")
                    .build();
        }

        // 로그인 성공으로 처리합니다.
        return ManagerResponse.builder()
                .success(true)
                .message("로그인에 성공했습니다.")
                .name(manager.getName())
                .managerId(manager.getManagerid())
                .build();
    }

    public ManagerResponse logout(String managerId) {
        // 로그아웃 처리 로직을 구현합니다. 여기서는 단순히 로그아웃 성공 메시지만 반환합니다.
        return ManagerResponse.builder()
                .success(true)
                .message("manager " + managerId + "가 로그아웃되었습니다.")
                .build();
    }

    public ManagerInfoResponse info(String managerId) {
        // ManagerId를 사용하여 해당 Manager 정보를 조회
        Manager manager = managerRepository.findByManagerid(managerId);
        if (manager == null) {
            return ManagerInfoResponse.builder()
                    .success(false)
                    .message("해당 매니저를 찾을 수 없습니다.")
                    .build();
        }

        // Manager 정보를 ManagerInfoResponse로 변환하여 반환
        return ManagerInfoResponse.builder()
                .success(true)
                .message("매니저 정보 조회가 성공적으로 완료되었습니다.")
                .managerid(manager.getManagerid())
                .password(manager.getPassword()) // 패스워드 정보는 민감한 정보이므로 보안 이슈를 고려해야 합니다.
                .name(manager.getName())
                .age(manager.getAge())
                .sex(manager.getSex())
                .phone(manager.getPhone())
                .email(manager.getEmail())
                .address(manager.getAddress())
                .etc(manager.getEtc())
                .build();
    }
}