package com.example.springserver.Radar.Controller;

import com.example.springserver.Radar.Service.LogService;
import com.example.springserver.Radar.dto.log.LogResponse;
import com.example.springserver.Radar.dto.log.LogSaveRequest;
import com.example.springserver.Radar.dto.log.LogSaveResponse;
import com.example.springserver.Radar.dto.manager.ManagerResponse;
import com.example.springserver.Radar.dto.manager.SignoutRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;

    @Operation(summary = "log datas", description = "patientId의 num번째 로그 정보 반환")
    @GetMapping("/log")
    public LogResponse getLogData(@RequestParam String patientId, @RequestParam int num) {
        return logService.getNum(patientId, num);
    }

    @Operation(summary = "log save", description = "patientId로 로그 정보 저장")
    @PostMapping("/log")
    public LogSaveResponse LogSave(@RequestBody LogSaveRequest logSaveRequest) {

        return logService.save(logSaveRequest);
    }

    @Operation(summary = "log datas", description = "patientId의 모든 로그 정보 반환")
    @GetMapping("/log/all")
    public List<LogResponse> getLogDatas(@RequestParam String patientId) {
        return logService.getAllLogs(patientId);
    }
}
