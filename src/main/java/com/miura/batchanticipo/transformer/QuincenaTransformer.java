package com.miura.batchanticipo.transformer;


import com.miura.batchanticipo.model.Colaborador;
import com.miura.batchanticipo.model.ImporteAnticipo;
import com.miura.batchanticipo.model.Pago_STP;
import com.miura.batchanticipo.model.SolicitudAnticipo;
import com.miura.batchanticipo.utils.JSONPathUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface QuincenaTransformer {

    public static Colaborador transformConsultaSaldo(String rawDBJSON) {

        List<String> jsonPaths = new ArrayList<String>();
        jsonPaths.add("saldo");
        jsonPaths.add("fechaLimite");
        jsonPaths.add("idColaborador");
        jsonPaths.add("nombre");
        jsonPaths.add("apellido_pat");
        jsonPaths.add("apellido_mat");
        jsonPaths.add("importeMinimo");
        jsonPaths.add("importeMaximo");
        jsonPaths.add("mensajeApp");

        Map<String, String> pathValues = JSONPathUtil.evaluateJSONPath(rawDBJSON,jsonPaths);

        for (String mapPVkey : pathValues.keySet()){
            String mapPVval = pathValues.get(mapPVkey);
            //apiJSON = apiJSON.replace("$" + mapPVkey,mapPVval);
        }

        Colaborador colaborador = new Colaborador();
        colaborador.setIdColaborador(Integer.parseInt(pathValues.get("idColaborador")));
        //colaborador.setMontoDisponible(Double.parseDouble(pathValues.get("saldo")));
        colaborador.setMontoDisponible(pathValues.get("saldo"));
        colaborador.setNombre(pathValues.get("nombre"));
        colaborador.setaMaterno(pathValues.get("apellido_mat"));
        colaborador.setaPaterno(pathValues.get("apellido_pat"));
        colaborador.setFechaLimite(pathValues.get("fechaLimite"));
        colaborador.setMonto_min(pathValues.get("importeMinimo"));
        colaborador.setMonto_max(pathValues.get("importeMaximo"));
        colaborador.setMensajeApp(pathValues.get("mensajeApp"));
        //colaborador.set
        //colaborador.set
        //colaborador.set

        return colaborador;
    }

    public static ImporteAnticipo transformComisionAnticipo(String dbJSON) {
        //{"saldo": 1275.00, "total": 129.50, "comision": 9.50, "mensajeApp": "SUCCESS: RÃ¡scale mi JSON",
        // "fechaLimite": "2021-02-01 07:27:18.000000", "importeValido": 120.00}
        List<String> jsonPaths = new ArrayList<String>();
        jsonPaths.add("saldo");
        jsonPaths.add("total");
        jsonPaths.add("comision");
        jsonPaths.add("mensajeApp");
        jsonPaths.add("fechaLimite");
        jsonPaths.add("importeValido");

        Map<String, String> pathValues = getValueMap(dbJSON,jsonPaths);

        ImporteAnticipo importeAnticipo = new ImporteAnticipo();
        importeAnticipo.setImporteComision(pathValues.get("comision"));
        importeAnticipo.setImporteTotal(pathValues.get("total"));
        importeAnticipo.setIdColaborador(null);
        importeAnticipo.setImporteSolicitado(null);

        return importeAnticipo;
    }

    public static SolicitudAnticipo transformSolitiudAnticipo(String dbJSON){
        //{"mensajeApp": "Ã‰xito total Judah!"}
        //{"clnt_id": 186, "id_anti": 125, "pers_id": 225, "mensajeApp": "?xito total Judah!",
        // "fchSolicita": "2021-02-28 19:13:54.000000", "fch_ingreso": "0001-01-21",
        // "conceptoPago": "\"Adelanto de N?mina\"",
        // "folio_origen": "AQ-1-125", "claveAutorizacion": "En proceso..",
        // "cuentaBeneficiario": "002996789012345678", "nombreBeneficiario": "Ulises Contreras Carrera",
        // "referenciaNumerica": 125, "rfcCurpBeneficiario": "COCU920206NR2"}
        List<String> jsonPaths = new ArrayList<String>();
        jsonPaths.add("mensajeApp");
        jsonPaths.add("fchSolicita");
        jsonPaths.add("claveAutorizacion");

        jsonPaths.add("clnt_id");
        jsonPaths.add("id_anti");
        jsonPaths.add("pers_id");
        jsonPaths.add("fch_ingreso");
        jsonPaths.add("conceptoPago");
        jsonPaths.add("folio_origen");
        jsonPaths.add("cuentaBeneficiario");
        jsonPaths.add("nombreBeneficiario");
        jsonPaths.add("referenciaNumerica");
        jsonPaths.add("rfcCurpBeneficiario");
        jsonPaths.add("banco");
        jsonPaths.add("dispersor");

        Map<String, String> pathValues = getValueMap(dbJSON,jsonPaths);

        SolicitudAnticipo solicitudAnticipo = new SolicitudAnticipo();
        solicitudAnticipo.setMensajeApp(pathValues.get("mensajeApp"));
        solicitudAnticipo.setFechaOperacion(pathValues.get("fchSolicita"));
        solicitudAnticipo.setClaveAutorizacion(pathValues.get("claveAutorizacion"));

        solicitudAnticipo.setClnt_id(pathValues.get("clnt_id"));
        solicitudAnticipo.setId_anti(pathValues.get("id_anti"));
        solicitudAnticipo.setPers_id(pathValues.get("pers_id"));
        solicitudAnticipo.setFch_ingreso(pathValues.get("fch_ingreso"));
        solicitudAnticipo.setConceptoPago(pathValues.get("conceptoPago"));
        solicitudAnticipo.setFolio_origen(pathValues.get("folio_origen"));
        solicitudAnticipo.setCuentaBeneficiario(pathValues.get("cuentaBeneficiario"));
        solicitudAnticipo.setNombreBeneficiario(pathValues.get("nombreBeneficiario"));
        solicitudAnticipo.setReferenciaNumerica(pathValues.get("referenciaNumerica"));
        solicitudAnticipo.setRfcCurpBeneficiario(pathValues.get("rfcCurpBeneficiario"));

        solicitudAnticipo.setInstitucionContraparte(pathValues.get("banco"));
        solicitudAnticipo.setDispersor(Integer.parseInt(pathValues.get("dispersor")));

        return solicitudAnticipo;
    }

    public static Pago_STP transformResponsePagoSTP(String dbJSON){
        Pago_STP pago_stp = new Pago_STP();

        List<String> jsonPaths = new ArrayList<String>();
        jsonPaths.add("$['cadenaCifrada']");
        jsonPaths.add("$['cadena']");
        jsonPaths.add("$['response'].['resultado'].['id']");
        jsonPaths.add("$['response']");

        Map<String, String> pathValues = getValueMap(dbJSON,jsonPaths);

        pago_stp.setCadenaSellada(pathValues.get("$['cadenaCifrada']"));
        pago_stp.setResultadoSTP(pathValues.get("$['response'].['resultado'].['id']"));
        pago_stp.setCadenaOriginal(pathValues.get("$['cadena']"));
        pago_stp.setResponse(pathValues.get("$['response']"));

        return pago_stp;
    }

    public static Map<String, String> getValueMap(String jsonString, List<String> jsonPaths){
        Map<String, String> pathValues = JSONPathUtil.evaluateJSONPath(jsonString,jsonPaths);

        for (String mapPVkey : pathValues.keySet()){
            String mapPVval = pathValues.get(mapPVkey);
        }
        return pathValues;
     }

    public static Pago_STP transformResponsePagoSTPBP(String dbJSON){


        List<String> jsonPaths = new ArrayList<String>();
        jsonPaths.add("$['cadenaSellada']");
        jsonPaths.add("$['cadenaOriginal']");
        jsonPaths.add("$['claveRastreo']");


        Map<String, String> pathValues = getValueMap(dbJSON,jsonPaths);
        Pago_STP pago_stp = new Pago_STP();
        pago_stp.setCadenaSellada(pathValues.get("$['cadenaSellada']"));
        pago_stp.setResultadoSTP(pathValues.get("$['claveRastreo']"));
        pago_stp.setCadenaOriginal(pathValues.get("$['cadenaOriginal']"));
        pago_stp.setResponse(dbJSON);

        return pago_stp;
    }
}
