package com.example.DailyActivities.model;

import jakarta.persistence.*;

@Entity
@Table(name = "activdades")
public class Activdades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_fk", nullable = false)
    private Usuarios usuario_fk;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EnumEstado estado;

    @Enumerated(EnumType.STRING)
    @Column(name = "prioridad",nullable = false)
    private EnumPrioridad prioridad;

    public Activdades() {}

    public Activdades(Usuarios usuario_fk, String titulo, String descripcion, EnumEstado estado, EnumPrioridad prioridad) {
        this.usuario_fk = usuario_fk;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado != null ? estado : EnumEstado.PENDIENTE;
        this.prioridad = prioridad != null ? prioridad : EnumPrioridad.MEDIA;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuarios getUsuario_fk() {
        return usuario_fk;
    }

    public void setUsuario_fk(Usuarios usuario_fk) {
        this.usuario_fk = usuario_fk;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EnumEstado getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = EnumEstado.fromValue(estado);
    }

    public EnumPrioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(EnumPrioridad prioridad) {
        this.prioridad = prioridad; // Suponiendo que EnumPrioridad ya está bien definido
    }
}
