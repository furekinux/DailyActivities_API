package com.example.DailyActivities.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_usuario",unique = true, nullable = false,length = 100)
    private String nombre_usuario;

    @Column(name = "email",unique = true, nullable = false,length = 50)
    private String email;

    @Column(name = "contrasena_hash", nullable = false)
    private String contrasena_hash;

    public Usuarios(){}

    public Usuarios(String nombre_usuario, String email, String contrasena_hash){
        this.nombre_usuario = nombre_usuario;
        this.email = email;
        this.contrasena_hash = contrasena_hash;
    }

    public Long getId() {
        return id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena_hash() {
        return contrasena_hash;
    }

    public void setContrasena_hash(String contrasena_hash) {
        this.contrasena_hash = contrasena_hash;
    }
    
}
