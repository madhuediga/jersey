package com.medical.web.example.services;

import com.medical.web.example.model.Admin;
import com.medical.web.example.repositery.AdminRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService{

    @Autowired
    private AdminRepositery repo;

    public boolean save(Admin admin) {
      Admin save  =repo.save(admin);
        return true;
    }
    public Admin findByEmail(String email) {
        Optional<Admin> find =repo.findByEmail(email);
        return find.orElse(null);
    }

    public List<Admin> findByRole(String role) {
        List<Admin> find=repo.findByRole(role);
        return find;
    }

    public List<Admin> findAll() {
        return repo.findAll();
    }
}
