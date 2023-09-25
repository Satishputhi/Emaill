package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EmailService;

@RestController
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    
    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody Map<String, String> emailData) {
        String to = emailData.get("to");
        String subject = emailData.get("subject");
        String text = emailData.get("text");
        emailService.sendEmail(to, subject, text);
    }
}
