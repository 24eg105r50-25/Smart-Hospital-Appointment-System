package com.hospital.controller;

import com.hospital.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "doctor-dashboard";
    }

    @PostMapping("/complete/{id}")
    public String completeAppointment(@PathVariable Long id) {
        // logic to mark as completed
        return "redirect:/doctor/dashboard";
    }
}
