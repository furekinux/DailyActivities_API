package com.example.DailyActivities.controller;

import com.example.DailyActivities.model.Usuarios;
import com.example.DailyActivities.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public List<Usuarios> listarUsuarios(){
        return usuariosService.verUsuarios();
    }
}
