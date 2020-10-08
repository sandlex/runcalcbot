package com.sandlex.running.runcalc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    
    @GetMapping("/calculate")
    public String calculate(@RequestParam String condition) {
        return "Get it! for " + condition;
    }
}
