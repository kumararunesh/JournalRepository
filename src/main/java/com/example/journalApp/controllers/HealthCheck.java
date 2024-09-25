package com.example.journalApp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/health-check")
    public String checkHealth()
    {
        return "OK";
    }
}
