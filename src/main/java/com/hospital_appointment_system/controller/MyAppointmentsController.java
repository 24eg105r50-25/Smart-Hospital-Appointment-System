package com.hospital_appointment_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyAppointmentsController {

    @GetMapping("/my-appointments")
    public String myAppointments() {
        return "my-appointments";
    }
}
