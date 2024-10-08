package com.crud.dto;

/**
 * @author silvae
 */
public class ImplicadoDTO {

    private String NombreCompleto;
    private String TipoDocumentoIdentidad;
    private String NumeroDocumentoIdentidad;
    private String Telefono;
    private String Observacion;

    public ImplicadoDTO() {
    }

    public ImplicadoDTO(String NombreCompleto, String TipoDocumentoIdentidad, String NumeroDocumentoIdentidad, String Telefono, String Observacion) {
        this.NombreCompleto = NombreCompleto;
        this.TipoDocumentoIdentidad = TipoDocumentoIdentidad;
        this.NumeroDocumentoIdentidad = NumeroDocumentoIdentidad;
        this.Telefono = Telefono;
        this.Observacion = Observacion;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getTipoDocumentoIdentidad() {
        return TipoDocumentoIdentidad;
    }

    public void setTipoDocumentoIdentidad(String TipoDocumentoIdentidad) {
        this.TipoDocumentoIdentidad = TipoDocumentoIdentidad;
    }

    public String getNumeroDocumentoIdentidad() {
        return NumeroDocumentoIdentidad;
    }

    public void setNumeroDocumentoIdentidad(String NumeroDocumentoIdentidad) {
        this.NumeroDocumentoIdentidad = NumeroDocumentoIdentidad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    
   
}
