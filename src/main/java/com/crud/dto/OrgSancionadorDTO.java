package com.crud.dto;

/**
 * @author silvae
 */
public class OrgSancionadorDTO {

    private String Fecha_Notifi_Iniciofs;
    private String Fecha_InformeOral;
    private String Num_Resolucion_Sanc;
    private String Decision;
    private String Fecha_Notific_Resolucion;
    private String Observacion;

    public OrgSancionadorDTO() {
    }

    public OrgSancionadorDTO(String Fecha_Notifi_Iniciofs, String Fecha_InformeOral, String Num_Resolucion_Sanc, String Decision, String Fecha_Notific_Resolucion, String Observacion) {
        this.Fecha_Notifi_Iniciofs = Fecha_Notifi_Iniciofs;
        this.Fecha_InformeOral = Fecha_InformeOral;
        this.Num_Resolucion_Sanc = Num_Resolucion_Sanc;
        this.Decision = Decision;
        this.Fecha_Notific_Resolucion = Fecha_Notific_Resolucion;
        this.Observacion = Observacion;
    }

    public String getFecha_Notifi_Iniciofs() {
        return Fecha_Notifi_Iniciofs;
    }

    public void setFecha_Notifi_Iniciofs(String Fecha_Notifi_Iniciofs) {
        this.Fecha_Notifi_Iniciofs = Fecha_Notifi_Iniciofs;
    }

    public String getFecha_InformeOral() {
        return Fecha_InformeOral;
    }

    public void setFecha_InformeOral(String Fecha_InformeOral) {
        this.Fecha_InformeOral = Fecha_InformeOral;
    }

    public String getNum_Resolucion_Sanc() {
        return Num_Resolucion_Sanc;
    }

    public void setNum_Resolucion_Sanc(String Num_Resolucion_Sanc) {
        this.Num_Resolucion_Sanc = Num_Resolucion_Sanc;
    }

    public String getDecision() {
        return Decision;
    }

    public void setDecision(String Decision) {
        this.Decision = Decision;
    }

    public String getFecha_Notific_Resolucion() {
        return Fecha_Notific_Resolucion;
    }

    public void setFecha_Notific_Resolucion(String Fecha_Notific_Resolucion) {
        this.Fecha_Notific_Resolucion = Fecha_Notific_Resolucion;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }
    
    
    
    
}
