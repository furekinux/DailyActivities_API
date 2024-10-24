package com.example.DailyActivities.service;

import com.example.DailyActivities.model.Activdades;
import com.example.DailyActivities.repository.ActivdadesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivdadesService {
    @Autowired
    private ActivdadesRepository activdadesRepository;

    // Agregar nueva 'Activdad' :)
    public Activdades guardarActivdad(Activdades activdades){
        return activdadesRepository.save(activdades);
    }

    // Ver TODAS las 'Activdades' :)
    public List<Activdades> verActivdades(){
        return activdadesRepository.findAll();
    }

    // Ver TODAS las 'Activdades' de x usuario :)
    public List<Activdades> verActivdadesUsuario(Long id_user){
        return activdadesRepository.findByUsuario(id_user);
    }

    // Buscar actividad con x id :)
    public Optional<Activdades> buscarActivdad(Long id_Act){
        return activdadesRepository.findById(id_Act);
    }

    // Editar actividad con x id :(
    public Activdades editarActivdad(Long id, Activdades activdades) {
        Activdades activdadesExistente = activdadesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Actividad no encontrada con id: " + id));

        activdadesExistente.setTitulo(activdades.getTitulo());
        activdadesExistente.setDescripcion(activdades.getDescripcion());
        activdadesExistente.setPrioridad(activdades.getPrioridad());

        activdadesExistente.setEstado(activdades.getEstado().getEstado());

        return activdadesRepository.save(activdadesExistente);
    }


    public void borrarActivdad(Long id){
        activdadesRepository.deleteById(id);
    }

}
