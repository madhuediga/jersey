package com.medical.web.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {

    private JavaMailSender mainSender;

    @Autowired
    public EmailService(JavaMailSender mainSender){
        this.mainSender=mainSender;
    }

    @Async
    public void sendEmail(SimpleMailMessage email){
        mainSender.send(email);
    }
}
