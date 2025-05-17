package com.Practica2025_Cortez.aplicacionBancaria;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class Practica2025Application {

    public static void main(String[] args) {
    	
    	SpringApplication app = new SpringApplication(Practica2025Application.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        app.run(args);
        SpringApplication.run(Practica2025Application.class, args);
    }
    
    // Redireccionar la ruta raíz a la página de inicio de clientes
    @GetMapping("/")
    public String home() {
        return "redirect:/clientes/";
    }
}