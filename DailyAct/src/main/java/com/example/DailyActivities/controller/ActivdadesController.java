package com.example.DailyActivities.controller;

import com.example.DailyActivities.model.Activdades; // Cambiar a Actividades si es necesario
import com.example.DailyActivities.service.ActivdadesService; // Cambiar a Actividades si es necesario
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activdades") // Cambiar a /api/actividades si es necesario
public class ActivdadesController {
    @Autowired
    private ActivdadesService activdadesService; // Cambiar a Actividades si es necesario

    @GetMapping
    public List<Activdades> listarActivdades() { // Cambiar a listarActividades si es necesario
        return activdadesService.verActivdades();
    }

}