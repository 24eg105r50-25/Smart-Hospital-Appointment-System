package com.hospital_appointment_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QueueController {

    @GetMapping("/queue")
    public String queue() {
        return "queue";
    }
}
