package com.example.springserver.Radar.Service;

import com.example.springserver.Radar.Entity.Manager;
import com.example.springserver.Radar.Repository.ManagerRepository;
import com.example.springserver.Radar.dto.LoginRequest;
import com.example.springserver.Radar.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private ManagerRepository managerRepository;

    public LoginResponse login(LoginRequest loginRequest){
        LoginResponse loginResponse = new LoginResponse();


        Manager manager = managerRepository.findByUserid(loginRequest.getUserId());
        loginResponse.setAccept(false);

        if(manager != null) {
            loginResponse.setAccept(true);
            loginResponse.setName(manager.getName());
        }

        return loginResponse;
    }
}
