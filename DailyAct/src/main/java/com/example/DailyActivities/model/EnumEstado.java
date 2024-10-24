package com.example.DailyActivities.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumEstado {
    PENDIENTE("pendiente"),
    EN_PROCESO("en proceso"),
    COMPLETADA("completada");

    private final String estado;

    EnumEstado(String estado) {
        this.estado = estado;
    }

    @JsonValue
    public String getEstado() {
        return estado;
    }

    public static EnumEstado fromValue(String value) {
        for (EnumEstado estado : values()) {
            if (estado.estado.equals(value)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("No enum constant for value: " + value);
    }
}
