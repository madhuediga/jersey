package com.medical.web.example.services;

import com.medical.web.example.model.User;
import com.medical.web.example.repositery.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserRepo repo;

    public boolean save(User user) {
       User save= repo.save(user);
       return true;
    }

    public User findByEmail(String email) {
       Optional<User> find = repo.findByEmail(email);
        return find.orElse(null);
    }

    public User findByConfirmationToken(String token) {
       Optional<User> find= repo.findByConfirmationToken(token);
        return find.orElse(null);
    }

    public List<User> findAll() {
        return repo.findAll();
    }
}
