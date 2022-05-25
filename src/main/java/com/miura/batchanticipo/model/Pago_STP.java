package com.miura.batchanticipo.model;

public class Pago_STP {
    private String cadenaOriginal;
    private String cadenaSellada;
    private String resultadoSTP;
    private String response;

    public String getCadenaOriginal() {
        return cadenaOriginal;
    }

    public void setCadenaOriginal(String cadenaOriginal) {
        this.cadenaOriginal = cadenaOriginal;
    }

    public String getCadenaSellada() {
        return cadenaSellada;
    }

    public void setCadenaSellada(String cadenaSellada) {
        this.cadenaSellada = cadenaSellada;
    }

    public String getResultadoSTP() {
        return resultadoSTP;
    }

    public void setResultadoSTP(String resultadoSTP) {
        this.resultadoSTP = resultadoSTP;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Pago_STP{" +
                "cadenaOriginal='" + cadenaOriginal + '\'' +
                ", cadenaSellada='" + cadenaSellada + '\'' +
                ", resultadoSTP='" + resultadoSTP + '\'' +
                ", response='" + response + '\'' +
                '}';
    }


}
