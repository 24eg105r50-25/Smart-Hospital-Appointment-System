package com.hospital.controller;

import com.hospital.entity.*;
import com.hospital.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("doctors", doctorRepository.findAll());
        return "patient-dashboard";
    }

    @PostMapping("/book")
    public String bookAppointment(@RequestParam Long doctorId, @RequestParam String date, @RequestParam String reason) {
        // Simplified booking logic
        Appointment appointment = new Appointment();
        // In a real app, we'd get the current logged-in patient
        appointment.setDoctor(doctorRepository.findById(doctorId).orElseThrow());
        appointment.setReason(reason);
        appointment.setStatus("SCHEDULED");
        appointmentRepository.save(appointment);
        return "redirect:/patient/dashboard";
    }
}
