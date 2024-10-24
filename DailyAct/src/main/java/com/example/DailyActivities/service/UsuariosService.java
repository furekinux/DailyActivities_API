package com.example.DailyActivities.service;

import com.example.DailyActivities.model.Usuarios;
import com.example.DailyActivities.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    public Usuarios guardarUsuario(Usuarios usuarios){
        return usuariosRepository.save(usuarios);
    }

    public List<Usuarios> verUsuarios(){
        return usuariosRepository.findAll();
    }

    public Optional<Usuarios> buscarUsuario(Long id_usuario){
        return usuariosRepository.findById(id_usuario);
    }

    public void borrarUsuario(Long id){
        usuariosRepository.deleteById(id);
    }
}
