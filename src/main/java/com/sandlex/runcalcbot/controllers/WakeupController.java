package com.sandlex.runcalcbot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WakeupController {

    @GetMapping("/wakeup")
    public String status() {
        return "Ready to roll";
    }
}
