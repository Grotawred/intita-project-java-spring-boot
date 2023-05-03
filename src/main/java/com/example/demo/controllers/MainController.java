package com.example.demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {

    @Operation(summary = "Get all books for editing")
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

}
