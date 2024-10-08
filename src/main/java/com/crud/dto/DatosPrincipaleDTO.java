package com.crud.dto;

import java.util.List;

/**
 * @author silvae
 */
public class DatosPrincipaleDTO {

    private String Expediente;
    private String anio;
    private String Codigo_Integridad;
    private String Area;
    private String Casos_Recibidos;
    private String Asunto_Materia;
    private List<ImplicadoDTO> Implicados;
    private String Fecha_Hechos;
    private String Fecha_Conocimiento_RH;
    private String Fecha_Recep_Stapad;
    private String Fecha_Prescr_IniciarPad;
    private String Rec_Impug;
    private String Estado_Actual;
    private StpadDTO Stpad;
    private OrgInstructorDTO OrgInstructor;
    private OrgSancionadorDTO OrgSancionador;

    public DatosPrincipaleDTO() {
    }

    public DatosPrincipaleDTO(String Expediente, String anio, String Codigo_Integridad, String Area, String Casos_Recibidos, String Asunto_Materia, List<ImplicadoDTO> Implicados, String Fecha_Hechos, String Fecha_Conocimiento_RH, String Fecha_Recep_Stapad, String Fecha_Prescr_IniciarPad, String Rec_Impug, String Estado_Actual, StpadDTO Stpad, OrgInstructorDTO OrgInstructor, OrgSancionadorDTO OrgSancionador) {
        this.Expediente = Expediente;
        this.anio = anio;
        this.Codigo_Integridad = Codigo_Integridad;
        this.Area = Area;
        this.Casos_Recibidos = Casos_Recibidos;
        this.Asunto_Materia = Asunto_Materia;
        this.Implicados = Implicados;
        this.Fecha_Hechos = Fecha_Hechos;
        this.Fecha_Conocimiento_RH = Fecha_Conocimiento_RH;
        this.Fecha_Recep_Stapad = Fecha_Recep_Stapad;
        this.Fecha_Prescr_IniciarPad = Fecha_Prescr_IniciarPad;
        this.Rec_Impug = Rec_Impug;
        this.Estado_Actual = Estado_Actual;
        this.Stpad = Stpad;
        this.OrgInstructor = OrgInstructor;
        this.OrgSancionador = OrgSancionador;
    }

    public String getExpediente() {
        return Expediente;
    }

    public void setExpediente(String Expediente) {
        this.Expediente = Expediente;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getCodigo_Integridad() {
        return Codigo_Integridad;
    }

    public void setCodigo_Integridad(String Codigo_Integridad) {
        this.Codigo_Integridad = Codigo_Integridad;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getCasos_Recibidos() {
        return Casos_Recibidos;
    }

    public void setCasos_Recibidos(String Casos_Recibidos) {
        this.Casos_Recibidos = Casos_Recibidos;
    }

    public String getAsunto_Materia() {
        return Asunto_Materia;
    }

    public void setAsunto_Materia(String Asunto_Materia) {
        this.Asunto_Materia = Asunto_Materia;
    }

    public List<ImplicadoDTO> getImplicados() {
        return Implicados;
    }

    public void setImplicados(List<ImplicadoDTO> Implicados) {
        this.Implicados = Implicados;
    }

    public String getFecha_Hechos() {
        return Fecha_Hechos;
    }

    public void setFecha_Hechos(String Fecha_Hechos) {
        this.Fecha_Hechos = Fecha_Hechos;
    }

    public String getFecha_Conocimiento_RH() {
        return Fecha_Conocimiento_RH;
    }

    public void setFecha_Conocimiento_RH(String Fecha_Conocimiento_RH) {
        this.Fecha_Conocimiento_RH = Fecha_Conocimiento_RH;
    }

    public String getFecha_Recep_Stapad() {
        return Fecha_Recep_Stapad;
    }

    public void setFecha_Recep_Stapad(String Fecha_Recep_Stapad) {
        this.Fecha_Recep_Stapad = Fecha_Recep_Stapad;
    }

    public String getFecha_Prescr_IniciarPad() {
        return Fecha_Prescr_IniciarPad;
    }

    public void setFecha_Prescr_IniciarPad(String Fecha_Prescr_IniciarPad) {
        this.Fecha_Prescr_IniciarPad = Fecha_Prescr_IniciarPad;
    }

    public String getRec_Impug() {
        return Rec_Impug;
    }

    public void setRec_Impug(String Rec_Impug) {
        this.Rec_Impug = Rec_Impug;
    }

    public String getEstado_Actual() {
        return Estado_Actual;
    }

    public void setEstado_Actual(String Estado_Actual) {
        this.Estado_Actual = Estado_Actual;
    }

    public StpadDTO getStpad() {
        return Stpad;
    }

    public void setStpad(StpadDTO Stpad) {
        this.Stpad = Stpad;
    }

    public OrgInstructorDTO getOrgInstructor() {
        return OrgInstructor;
    }

    public void setOrgInstructor(OrgInstructorDTO OrgInstructor) {
        this.OrgInstructor = OrgInstructor;
    }

    public OrgSancionadorDTO getOrgSancionador() {
        return OrgSancionador;
    }

    public void setOrgSancionador(OrgSancionadorDTO OrgSancionador) {
        this.OrgSancionador = OrgSancionador;
    }


}
