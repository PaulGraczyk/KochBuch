package com.example.kochbuch.controller;

import com.example.kochbuch.service.KochBuchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class KochBuchHomeController {

    private final KochBuchService kochBuchService;

    public KochBuchHomeController(KochBuchService kochBuchService) {
        this.kochBuchService = kochBuchService;
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

}




