package com.hospital_appointment_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppointmentController {

    @GetMapping("/appointments")
    public String appointments() {
        return "appointments";
    }

    @PostMapping("/appointments")
    public String bookAppointment(
            @RequestParam("patientName") String patientName,
            @RequestParam("doctor") String doctor,
            @RequestParam("date") String date,
            @RequestParam("time") String time,
            Model model,
            RedirectAttributes redirectAttributes) {

        model.addAttribute("patientName", patientName);
        model.addAttribute("doctor", doctor);
        model.addAttribute("date", date);
        model.addAttribute("time", time);

        return "appointment-success";
    }
}