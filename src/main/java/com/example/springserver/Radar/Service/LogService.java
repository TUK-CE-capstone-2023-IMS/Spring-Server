package com.example.springserver.Radar.Service;

import com.example.springserver.Radar.Entity.Log;
import com.example.springserver.Radar.Repository.LogRepository;
import com.example.springserver.Radar.dto.log.LogResponse;
import com.example.springserver.Radar.dto.log.LogSaveRequest;
import com.example.springserver.Radar.dto.log.LogSaveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogService {
    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    // 특정 환자의 num 번째 로그를 가져오는 메소드
    public LogResponse getNum(String patientId, int num) {
        List<Log> logs = logRepository.findByPatientid(patientId);

        if (logs.isEmpty() || num <= 0 || num > logs.size()) {
            return LogResponse.builder()
                    .success(false)
                    .message("Failed to find log data")
                    .build();
        }

        Log log = logs.get(num - 1);

        return LogResponse.builder()
                .success(true)
                .patientid(log.getPatientid())
                .datetime(log.getDatetime())
                .type(log.getType())
                .content(log.getContent())
                .x(log.getX())
                .y(log.getY())
                .area(log.getArea())
                .message("Success")
                .build();
    }

    // 로그를 저장하는 메소드
    public LogSaveResponse save(LogSaveRequest logSaveRequest) {
        Log log = Log.builder()
                .patientid(logSaveRequest.getPatientid())
                .datetime(logSaveRequest.getDatetime())
                .type(logSaveRequest.getType())
                .content(logSaveRequest.getContent())
                .x(logSaveRequest.getX())
                .y(logSaveRequest.getY())
                .area(logSaveRequest.getArea())
                .build();

        Log savedLog = logRepository.save(log);

        return LogSaveResponse.builder()
                .success(true)
                .patientid(savedLog.getPatientid())
                .datetime(savedLog.getDatetime())
                .type(savedLog.getType())
                .x(savedLog.getX())
                .y(savedLog.getY())
                .area(savedLog.getArea())
                .message("로그가 성공적으로 저장되었습니다.")
                .build();
    }

    // 특정 환자의 모든 로그를 가져오는 메소드
    public List<LogResponse> getAllLogs(String patientId) {
        List<Log> logs = logRepository.findByPatientid(patientId);

        if (logs.isEmpty()) {
            return Collections.emptyList();
        }

        return logs.stream()
                .map(log -> LogResponse.builder()
                        .success(true)
                        .patientid(log.getPatientid())
                        .datetime(log.getDatetime())
                        .type(log.getType())
                        .content(log.getContent())
                        .x(log.getX())
                        .y(log.getY())
                        .area(log.getArea())
                        .message("Log data retrieved successfully")
                        .build())
                .collect(Collectors.toList());
    }

    public List<LogResponse> getLogsByArea(int area) {
        List<Log> logs = logRepository.findByArea(area);
        return logs.stream().map(log ->
                LogResponse.builder()
                        .patientid(log.getPatientid())
                        .datetime(log.getDatetime())
                        .type(log.getType())
                        .content(log.getContent())
                        .x(log.getX())
                        .y(log.getY())
                        .area(log.getArea())
                        .build()
        ).collect(Collectors.toList());
    }
}
