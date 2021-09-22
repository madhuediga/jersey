package com.medical.web.example.controller;

import com.medical.web.example.model.Appointment;
import com.medical.web.example.services.AdminService;
import com.medical.web.example.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/save-app")
    public ResponseEntity<?> saveEmployee(@RequestBody Appointment app){
      appointmentService.save(app);
      return new ResponseEntity<>("saved", HttpStatus.ACCEPTED);
    }
}
