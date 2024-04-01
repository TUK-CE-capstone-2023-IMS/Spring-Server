package com.example.springserver.Radar.Service;

import com.example.springserver.Radar.Repository.LogRepository;
import com.example.springserver.Radar.Repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {
    @Autowired
    private LogRepository logRepository;
}
