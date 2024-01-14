package com.jeju.main.global.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckApiController {
    @RequestMapping("/")
    public String MeetUpServer() {
        return "제주도 게하~~~!";
    }
}
