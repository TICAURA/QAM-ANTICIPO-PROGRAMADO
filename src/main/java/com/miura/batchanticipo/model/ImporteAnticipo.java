package com.miura.batchanticipo.model;

public class ImporteAnticipo {
    private Integer idColaborador;

    //private Double importeSolicitado;
    //private Double importeComision;
    private String importeSolicitado;
    private String importeComision;

    //private Double importeTotal;
    private String importeTotal;

    private Double montoPromocion;
    private Integer idPromocion;

    //private String errMessage;
    private String token;

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getImporteSolicitado() {
        return importeSolicitado;
    }

    public void setImporteSolicitado(String importeSolicitado) {
        this.importeSolicitado = importeSolicitado;
    }

    public String getImporteComision() {
        return importeComision;
    }

    public void setImporteComision(String importeComision) {
        this.importeComision = importeComision;
    }

    public String getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(String importeTotal) {
        this.importeTotal = importeTotal;
    }


    public ImporteAnticipo(Integer idColaborador, String importeSolicitado, String importeComision, String importeTotal) {
        this.idColaborador = idColaborador;
        this.importeSolicitado = importeSolicitado;
        this.importeComision = importeComision;
        this.importeTotal = importeTotal;
    }

    @Override
    public String toString() {
        return "ImporteAnticipo{" +
                "idColaborador=" + idColaborador +
                ", importeSolicitado='" + importeSolicitado + '\'' +
                ", importeComision='" + importeComision + '\'' +
                ", importeTotal='" + importeTotal + '\'' +
                ", montoPromocion='" + montoPromocion + '\'' +
                ", idPromocion='" + idPromocion + '\'' +

                ", token='" + token + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public Double getMontoPromocion() {
        return montoPromocion;
    }

    public void setMontoPromocion(Double montoPromocion) {
        this.montoPromocion = montoPromocion;
    }

    public Integer getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public ImporteAnticipo() {
    }
}
