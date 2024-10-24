package com.example.DailyActivities.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumPrioridad {
    ALTA("alta"), MEDIA("media"), BAJA("baja");

    private String prioridad;

    EnumPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @JsonValue
    public String getPrioridad(){
        return prioridad;
    }

}
