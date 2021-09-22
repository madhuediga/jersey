package com.medical.web.example.controller;

import com.medical.web.example.model.User;
import com.medical.web.example.services.EmailService;
import com.medical.web.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    public RegisterController(UserService userService,EmailService emailService){
        this.userService=userService;
        this.emailService=emailService;
    }
    @PostMapping("/registration")
    public ResponseEntity<?> UserRegistration(@RequestBody User user) {
        User existUser = userService.findByEmail(user.getEmail());
        if (existUser != null) {
            return new ResponseEntity<String>("Email already exits", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            user.setEnabled(true);
            user.setRole("ROLE_USER");
            user.setConfirmationToken(UUID.randomUUID().toString());
            userService.save(user);

            String appUrl="localhost:8080";

            SimpleMailMessage registrationEmail= new SimpleMailMessage();
            registrationEmail.setTo(user.getEmail());
            registrationEmail.setSubject("RegistrationConfirmation");
            registrationEmail.setText("To conform your e=mail address, please click the link below:\n"+appUrl+
                    "/confirm?token="+user.getConfirmationToken());
            registrationEmail.setFrom("madhuediga10@gmail.com");
            emailService.sendEmail(registrationEmail);
            return new ResponseEntity<>("user registered successful",HttpStatus.ACCEPTED);
        }
    }
    @GetMapping("/confirm")
    public ResponseEntity<?> confirmRegistration(@RequestParam("token")String token){
        User user=userService.findByConfirmationToken(token);
        if (user == null){
           return new ResponseEntity<String>("invalidToken",HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return  new ResponseEntity<String>("confirmationToken", HttpStatus.valueOf(user.getConfirmationToken()));
        }
    }


}
