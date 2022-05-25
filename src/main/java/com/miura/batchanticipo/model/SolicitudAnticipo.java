package com.miura.batchanticipo.model;


public class SolicitudAnticipo {

    private Integer idColaborador;

    private String claveAutorizacion;
    private String fechaOperacion;

    private Double importeTotal;
    private String mensajeApp;

    private String clnt_id;
    private String id_anti;
    private String pers_id;
    private String fch_ingreso;
    private String conceptoPago;
    private String folio_origen;
    private String cuentaBeneficiario;
    private String nombreBeneficiario;
    private String referenciaNumerica;
    private String rfcCurpBeneficiario;
    private String beneficioAdicional;

    private Pago_STP pago_stp;

    private String institucionContraparte;

    private int dispersor;
    //private String token;

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getClaveAutorizacion() {
        return claveAutorizacion;
    }

    public void setClaveAutorizacion(String claveAutorizacion) {
        this.claveAutorizacion = claveAutorizacion;
    }

    public String getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(String fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getClnt_id() {
        return clnt_id;
    }

    public void setClnt_id(String clnt_id) {
        this.clnt_id = clnt_id;
    }

    public String getId_anti() {
        return id_anti;
    }

    public void setId_anti(String id_anti) {
        this.id_anti = id_anti;
    }

    public String getPers_id() {
        return pers_id;
    }

    public void setPers_id(String pers_id) {
        this.pers_id = pers_id;
    }

    public String getFch_ingreso() {
        return fch_ingreso;
    }

    public void setFch_ingreso(String fch_ingreso) {
        this.fch_ingreso = fch_ingreso;
    }

    public String getConceptoPago() {
        return conceptoPago;
    }

    public void setConceptoPago(String conceptoPago) {
        this.conceptoPago = conceptoPago;
    }

    public String getFolio_origen() {
        return folio_origen;
    }

    public void setFolio_origen(String folio_origen) {
        this.folio_origen = folio_origen;
    }

    public String getCuentaBeneficiario() {
        return cuentaBeneficiario;
    }

    public void setCuentaBeneficiario(String cuentaBeneficiario) {
        this.cuentaBeneficiario = cuentaBeneficiario;
    }

    public String getNombreBeneficiario() {
        return nombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario) {
        this.nombreBeneficiario = nombreBeneficiario;
    }

    public String getReferenciaNumerica() {
        return referenciaNumerica;
    }

    public void setReferenciaNumerica(String referenciaNumerica) {
        this.referenciaNumerica = referenciaNumerica;
    }

    public String getRfcCurpBeneficiario() {
        return rfcCurpBeneficiario;
    }

    public void setRfcCurpBeneficiario(String rfcCurpBeneficiario) {
        this.rfcCurpBeneficiario = rfcCurpBeneficiario;
    }

    public Pago_STP getPago_stp() {
        return pago_stp;
    }

    public void setPago_stp(Pago_STP pago_stp) {
        this.pago_stp = pago_stp;
    }

    public String getInstitucionContraparte() {
        return institucionContraparte;
    }

    public void setInstitucionContraparte(String institucionContraparte) {
        this.institucionContraparte = institucionContraparte;
    }

    @Override
    public String toString() {
        return "SolicitudAnticipo{" +
                "idColaborador=" + idColaborador +
                ", claveAutorizacion='" + claveAutorizacion + '\'' +
                ", fechaOperacion='" + fechaOperacion + '\'' +
                ", importeTotal=" + importeTotal +
                ", mensajeApp='" + mensajeApp + '\'' +
                ", clnt_id='" + clnt_id + '\'' +
                ", id_anti='" + id_anti + '\'' +
                ", pers_id='" + pers_id + '\'' +
                ", fch_ingreso='" + fch_ingreso + '\'' +
                ", conceptoPago='" + conceptoPago + '\'' +
                ", folio_origen='" + folio_origen + '\'' +
                ", cuentaBeneficiario='" + cuentaBeneficiario + '\'' +
                ", nombreBeneficiario='" + nombreBeneficiario + '\'' +
                ", referenciaNumerica='" + referenciaNumerica + '\'' +
                ", rfcCurpBeneficiario='" + rfcCurpBeneficiario + '\'' +
                ", pago_stp=" + pago_stp +
                ", institucionContraparte='" + institucionContraparte + '\'' +
                '}';
    }

    //public SolicitudAnticipo(Integer idColaborador, String claveAutorizacion, String fechaOperacion, Double importeTotal) {
    public SolicitudAnticipo(Integer idColaborador, String claveAutorizacion, String fechaOperacion, Double importeTotal) {
        this.idColaborador = idColaborador;
        this.claveAutorizacion = claveAutorizacion;
        this.fechaOperacion = fechaOperacion;
        this.importeTotal = importeTotal;
    }

    public String getMensajeApp() {
        return mensajeApp;
    }

    public void setMensajeApp(String mensajeApp) {
        this.mensajeApp = mensajeApp;
    }

    public SolicitudAnticipo() {
    }

    public String getBeneficioAdicional() {
        return beneficioAdicional;
    }

    public void setBeneficioAdicional(String beneficioAdicional) {
        this.beneficioAdicional = beneficioAdicional;
    }

    public int getDispersor() {
        return dispersor;
    }

    public void setDispersor(int dispersor) {
        this.dispersor = dispersor;
    }
}
