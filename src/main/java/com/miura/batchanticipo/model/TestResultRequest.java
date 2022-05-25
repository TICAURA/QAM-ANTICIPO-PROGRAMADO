package com.miura.batchanticipo.model;

public class TestResultRequest {

    private String id;
    private String empresa;
    private String folioOrigen;
    private String estado;
    private String causaDevolucion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFolioOrigen() {
        return folioOrigen;
    }

    public void setFolioOrigen(String folioOrigen) {
        this.folioOrigen = folioOrigen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCausaDevolucion() {
        return causaDevolucion;
    }

    public void setCausaDevolucion(String causaDevolucion) {
        this.causaDevolucion = causaDevolucion;
    }

    @Override
    public String toString() {
        return "STPResult{" +
                "id='" + id + '\'' +
                ", empresa='" + empresa + '\'' +
                ", folioOrigen='" + folioOrigen + '\'' +
                ", estado='" + estado + '\'' +
                ", causaDevolucion='" + causaDevolucion + '\'' +
                '}';
    }
}
