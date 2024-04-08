package com.example.springserver.Radar.Service;

import com.example.springserver.Radar.Entity.Log;
import com.example.springserver.Radar.Entity.Manager;
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
    public LogResponse getNum(String patientId, int num) {
        // 해당 환자의 로그를 조회합니다.
        List<Log> logs = logRepository.findByPatientid(patientId);

        // 조회된 로그가 없거나 num이 올바르지 않은 경우에 대한 처리
        if (logs.isEmpty() || num <= 0 || num > logs.size()) {
            // 실패 응답을 생성하여 반환
            return LogResponse.builder()
                    .success(false)
                    .message("Failed to find log data")
                    .build();
        }

        // num번째 로그를 가져옵니다.
        Log log = logs.get(num - 1);

        // 가져온 로그 정보를 LogResponse 객체로 변환하여 반환합니다.
        return LogResponse.builder()
                .success(true)
                .patientid(log.getPatientid())
                .datetime(log.getDatetime())
                .type(log.getType())
                .message("Success")
                .build();
    }
    public LogSaveResponse save(LogSaveRequest logSaveRequest) {
        // LogSaveRequest에서 필요한 정보를 추출하여 Log 엔티티 생성
        Log log = Log.builder()
                .patientid(logSaveRequest.getPatientid())
                .datetime(logSaveRequest.getDatetime())
                .type(logSaveRequest.getType())
                .content(logSaveRequest.getContent())
                .build();

        // 생성된 Log 엔티티를 저장
        Log savedLog = logRepository.save(log);

        // 저장 결과 응답 생성
        return LogSaveResponse.builder()
                .success(true)
                .patientid(savedLog.getPatientid())
                .datetime(savedLog.getDatetime())
                .type(savedLog.getType())
                .message("로그가 성공적으로 저장되었습니다.")
                .build();
    }

    public List<LogResponse> getAllLogs(String patientId) {
        // 해당 환자의 모든 로그를 조회합니다.
        List<Log> logs = logRepository.findByPatientid(patientId);

        // 로그가 없는 경우 빈 리스트 반환
        if (logs.isEmpty()) {
            return Collections.emptyList();
        }

        // Log 엔티티를 LogResponse로 변환하여 리스트에 담아 반환합니다.
        return logs.stream()
                .map(log -> LogResponse.builder()
                        .success(true)
                        .patientid(log.getPatientid())
                        .datetime(log.getDatetime())
                        .type(log.getType())
                        .message("Success")
                        .build())
                .collect(Collectors.toList());
    }

}
