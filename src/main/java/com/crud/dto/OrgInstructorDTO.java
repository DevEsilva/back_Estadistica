package com.crud.dto;

/**
 * @author silvae
 */
public class OrgInstructorDTO {

    private String Area;
    private String Carta_InicioPad;
    private String Fecha_Notificacion_InicioPad;
    private String Fecha_PresRIPCAnio;
    private String Fecha_InformeFinal;
    private String Sancion_Propuesta;
    private String Observacion;

    public OrgInstructorDTO() {
    }

    
    
    public OrgInstructorDTO(String Area, String Carta_InicioPad, String Fecha_Notificacion_InicioPad, String Fecha_PresRIPCAnio, String Fecha_InformeFinal, String Sancion_Propuesta, String Observacion) {
        this.Area = Area;
        this.Carta_InicioPad = Carta_InicioPad;
        this.Fecha_Notificacion_InicioPad = Fecha_Notificacion_InicioPad;
        this.Fecha_PresRIPCAnio = Fecha_PresRIPCAnio;
        this.Fecha_InformeFinal = Fecha_InformeFinal;
        this.Sancion_Propuesta = Sancion_Propuesta;
        this.Observacion = Observacion;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getCarta_InicioPad() {
        return Carta_InicioPad;
    }

    public void setCarta_InicioPad(String Carta_InicioPad) {
        this.Carta_InicioPad = Carta_InicioPad;
    }

    public String getFecha_Notificacion_InicioPad() {
        return Fecha_Notificacion_InicioPad;
    }

    public void setFecha_Notificacion_InicioPad(String Fecha_Notificacion_InicioPad) {
        this.Fecha_Notificacion_InicioPad = Fecha_Notificacion_InicioPad;
    }

    public String getFecha_PresRIPCAnio() {
        return Fecha_PresRIPCAnio;
    }

    public void setFecha_PresRIPCAnio(String Fecha_PresRIPCAnio) {
        this.Fecha_PresRIPCAnio = Fecha_PresRIPCAnio;
    }

    public String getFecha_InformeFinal() {
        return Fecha_InformeFinal;
    }

    public void setFecha_InformeFinal(String Fecha_InformeFinal) {
        this.Fecha_InformeFinal = Fecha_InformeFinal;
    }

    public String getSancion_Propuesta() {
        return Sancion_Propuesta;
    }

    public void setSancion_Propuesta(String Sancion_Propuesta) {
        this.Sancion_Propuesta = Sancion_Propuesta;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    
    
}
