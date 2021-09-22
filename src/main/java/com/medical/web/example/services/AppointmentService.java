package com.medical.web.example.services;

import com.medical.web.example.model.Appointment;
import com.medical.web.example.repositery.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService{

    @Autowired
    private AppointmentRepo repo;

    public boolean save(Appointment app) {
        Appointment save= repo.save(app);
        return true;
    }

    public List<Appointment> findAll() {
        return repo.findAll();
    }
}
