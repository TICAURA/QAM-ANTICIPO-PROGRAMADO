package com.miura.batchanticipo.model;

import lombok.Data;

import java.util.Date;

public @Data
class AnticipoProgramado {

    private int idProgramacionAnticipo;
    private Date fechaAnticipo;
    private Date fechaSiguienteAnticipo;
    private double monto;
    private int errores;
    private Date fechaCreacion;
    private int periodo;
    private int colaborador;
}
