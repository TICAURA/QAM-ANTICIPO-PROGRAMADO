package com.miura.batchanticipo.utils;

public enum PeriodoENUM {
    SEMANAL(0),
    QUINCENAL(1),
    MENSUAL(2);


    private int id;


    private PeriodoENUM(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
