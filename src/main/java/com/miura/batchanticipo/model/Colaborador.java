package com.miura.batchanticipo.model;

import java.util.Date;

public class Colaborador {

    private Integer idColaborador;
    private String montoDisponible;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String token;
    private String fechaLimite;
    private String beneficioAdicional;

    private Integer personaId;
    private Date fechaIngreso;
    private Integer clienteId;

    private String monto_min;
    private String monto_max;
    private String mensajeApp;

    public Colaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Colaborador(Integer idColaborador, String montoDisponible, String nombre, String aPaterno, String aMaterno) {
        this.idColaborador = idColaborador;
        this.montoDisponible = montoDisponible;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
    }

    public Colaborador(){

    }

    @Override
    public String toString() {
        return "Colaborador{" +
                "idColaborador=" + idColaborador +
                ", montoDisponible='" + montoDisponible + '\'' +
                ", nombre='" + nombre + '\'' +
                ", aPaterno='" + aPaterno + '\'' +
                ", aMaterno='" + aMaterno + '\'' +
                ", token='" + token + '\'' +
                ", fechaLimite='" + fechaLimite + '\'' +
                '}';
    }

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getMontoDisponible() {
        return montoDisponible;
    }

    public void setMontoDisponible(String montoDisponible) {
        this.montoDisponible = montoDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBeneficioAdicional() {
        return beneficioAdicional;
    }

    public void setBeneficioAdicional(String beneficioAdicional) {
        this.beneficioAdicional = beneficioAdicional;
    }

    /**
     * @return the personaId
     */
    public Integer getPersonaId() {
        return personaId;
    }

    /**
     * @param personaId the personaId to set
     */
    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    /**
     * @return the fechaIngreso
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the clienteId
     */
    public Integer getClienteId() {
        return clienteId;
    }

    /**
     * @param clienteId the clienteId to set
     */
    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getMonto_min() {
        return monto_min;
    }

    public void setMonto_min(String monto_min) {
        this.monto_min = monto_min;
    }

    public String getMonto_max() {
        return monto_max;
    }

    public void setMonto_max(String monto_max) {
        this.monto_max = monto_max;
    }

    public String getMensajeApp() {
        return mensajeApp;
    }

    public void setMensajeApp(String mensajeApp) {
        this.mensajeApp = mensajeApp;
    }
}
