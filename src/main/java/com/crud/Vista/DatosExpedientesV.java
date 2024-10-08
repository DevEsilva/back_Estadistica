package com.crud.Vista;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * @author silvae
 */
@Entity
public class DatosExpedientesV implements Serializable {

    @Id
    @JsonIgnore
    private int id;
    private String expediente;
    private String area;
    private String asunto_materia;
    private String casos_recibidos;
    private String codigo_integridad;
    private String estado_actual;
    /*   @Temporal(TemporalType.TIMESTAMP)
  private Date fecha_actualizacion_datos;*/
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha_conocimiento_rh;
    /*   @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_creacion_datos;*/
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha_hechos;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha_prescr_iniciar_pad;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha_recep_stapad;
    private String rec_impug;
    private String anio;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha_stpad;
    private String infor_precan_stpad;
    private String observacion_stpad;
    private String sanc_propta_stpad;
    private String area_org_inst;
    private String carta_inicio_pad_org_inst;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha_inform_final_org_inst;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha_noti_inicio_pad_org_inst;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha_pres_rip_org_inst;
    private String observacion_org_inst;
    private String sancion_propuesta_org_inst;
    private String decision_org_sanc;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha_informe_oral_org_sanc;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha_noti_resolucion_org_sanc;
    private String num_resolucion_orgsanc;
    private String observacion_org_sanc;
    @Transient
    private List<DatosImplicadosV> implicados;

    public DatosExpedientesV() {
    }

    public DatosExpedientesV(int id, String expediente, String area, String asunto_materia, String casos_recibidos, String codigo_integridad, String estado_actual, LocalDate fecha_conocimiento_rh, LocalDate fecha_hechos, LocalDate fecha_prescr_iniciar_pad, LocalDate fecha_recep_stapad, String rec_impug, String anio, LocalDate fecha_stpad, String infor_precan_stpad, String observacion_stpad, String sanc_propta_stpad, String area_org_inst, String carta_inicio_pad_org_inst, LocalDate fecha_inform_final_org_inst, LocalDate fecha_noti_inicio_pad_org_inst, LocalDate fecha_pres_rip_org_inst, String observacion_org_inst, String sancion_propuesta_org_inst, String decision_org_sanc, LocalDate fecha_informe_oral_org_sanc, LocalDate fecha_noti_resolucion_org_sanc, String num_resolucion_orgsanc, String observacion_org_sanc) {
        this.id = id;
        this.expediente = expediente;
        this.area = area;
        this.asunto_materia = asunto_materia;
        this.casos_recibidos = casos_recibidos;
        this.codigo_integridad = codigo_integridad;
        this.estado_actual = estado_actual;
        this.fecha_conocimiento_rh = fecha_conocimiento_rh;
        this.fecha_hechos = fecha_hechos;
        this.fecha_prescr_iniciar_pad = fecha_prescr_iniciar_pad;
        this.fecha_recep_stapad = fecha_recep_stapad;
        this.rec_impug = rec_impug;
        this.anio = anio;
        this.fecha_stpad = fecha_stpad;
        this.infor_precan_stpad = infor_precan_stpad;
        this.observacion_stpad = observacion_stpad;
        this.sanc_propta_stpad = sanc_propta_stpad;
        this.area_org_inst = area_org_inst;
        this.carta_inicio_pad_org_inst = carta_inicio_pad_org_inst;
        this.fecha_inform_final_org_inst = fecha_inform_final_org_inst;
        this.fecha_noti_inicio_pad_org_inst = fecha_noti_inicio_pad_org_inst;
        this.fecha_pres_rip_org_inst = fecha_pres_rip_org_inst;
        this.observacion_org_inst = observacion_org_inst;
        this.sancion_propuesta_org_inst = sancion_propuesta_org_inst;
        this.decision_org_sanc = decision_org_sanc;
        this.fecha_informe_oral_org_sanc = fecha_informe_oral_org_sanc;
        this.fecha_noti_resolucion_org_sanc = fecha_noti_resolucion_org_sanc;
        this.num_resolucion_orgsanc = num_resolucion_orgsanc;
        this.observacion_org_sanc = observacion_org_sanc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAsunto_materia() {
        return asunto_materia;
    }

    public void setAsunto_materia(String asunto_materia) {
        this.asunto_materia = asunto_materia;
    }

    public String getCasos_recibidos() {
        return casos_recibidos;
    }

    public void setCasos_recibidos(String casos_recibidos) {
        this.casos_recibidos = casos_recibidos;
    }

    public String getCodigo_integridad() {
        return codigo_integridad;
    }

    public void setCodigo_integridad(String codigo_integridad) {
        this.codigo_integridad = codigo_integridad;
    }

    public String getEstado_actual() {
        return estado_actual;
    }

    public void setEstado_actual(String estado_actual) {
        this.estado_actual = estado_actual;
    }

    public LocalDate getFecha_conocimiento_rh() {
        return fecha_conocimiento_rh;
    }

    public void setFecha_conocimiento_rh(LocalDate fecha_conocimiento_rh) {
        this.fecha_conocimiento_rh = fecha_conocimiento_rh;
    }

    public LocalDate getFecha_hechos() {
        return fecha_hechos;
    }

    public void setFecha_hechos(LocalDate fecha_hechos) {
        this.fecha_hechos = fecha_hechos;
    }

    public LocalDate getFecha_prescr_iniciar_pad() {
        return fecha_prescr_iniciar_pad;
    }

    public void setFecha_prescr_iniciar_pad(LocalDate fecha_prescr_iniciar_pad) {
        this.fecha_prescr_iniciar_pad = fecha_prescr_iniciar_pad;
    }

    public LocalDate getFecha_recep_stapad() {
        return fecha_recep_stapad;
    }

    public void setFecha_recep_stapad(LocalDate fecha_recep_stapad) {
        this.fecha_recep_stapad = fecha_recep_stapad;
    }

    public String getRec_impug() {
        return rec_impug;
    }

    public void setRec_impug(String rec_impug) {
        this.rec_impug = rec_impug;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public LocalDate getFecha_stpad() {
        return fecha_stpad;
    }

    public void setFecha_stpad(LocalDate fecha_stpad) {
        this.fecha_stpad = fecha_stpad;
    }

    public String getInfor_precan_stpad() {
        return infor_precan_stpad;
    }

    public void setInfor_precan_stpad(String infor_precan_stpad) {
        this.infor_precan_stpad = infor_precan_stpad;
    }

    public String getObservacion_stpad() {
        return observacion_stpad;
    }

    public void setObservacion_stpad(String observacion_stpad) {
        this.observacion_stpad = observacion_stpad;
    }

    public String getSanc_propta_stpad() {
        return sanc_propta_stpad;
    }

    public void setSanc_propta_stpad(String sanc_propta_stpad) {
        this.sanc_propta_stpad = sanc_propta_stpad;
    }

    public String getArea_org_inst() {
        return area_org_inst;
    }

    public void setArea_org_inst(String area_org_inst) {
        this.area_org_inst = area_org_inst;
    }

    public String getCarta_inicio_pad_org_inst() {
        return carta_inicio_pad_org_inst;
    }

    public void setCarta_inicio_pad_org_inst(String carta_inicio_pad_org_inst) {
        this.carta_inicio_pad_org_inst = carta_inicio_pad_org_inst;
    }

    public LocalDate getFecha_inform_final_org_inst() {
        return fecha_inform_final_org_inst;
    }

    public void setFecha_inform_final_org_inst(LocalDate fecha_inform_final_org_inst) {
        this.fecha_inform_final_org_inst = fecha_inform_final_org_inst;
    }

    public LocalDate getFecha_noti_inicio_pad_org_inst() {
        return fecha_noti_inicio_pad_org_inst;
    }

    public void setFecha_noti_inicio_pad_org_inst(LocalDate fecha_noti_inicio_pad_org_inst) {
        this.fecha_noti_inicio_pad_org_inst = fecha_noti_inicio_pad_org_inst;
    }

    public LocalDate getFecha_pres_rip_org_inst() {
        return fecha_pres_rip_org_inst;
    }

    public void setFecha_pres_rip_org_inst(LocalDate fecha_pres_rip_org_inst) {
        this.fecha_pres_rip_org_inst = fecha_pres_rip_org_inst;
    }

    public String getObservacion_org_inst() {
        return observacion_org_inst;
    }

    public void setObservacion_org_inst(String observacion_org_inst) {
        this.observacion_org_inst = observacion_org_inst;
    }

    public String getSancion_propuesta_org_inst() {
        return sancion_propuesta_org_inst;
    }

    public void setSancion_propuesta_org_inst(String sancion_propuesta_org_inst) {
        this.sancion_propuesta_org_inst = sancion_propuesta_org_inst;
    }

    public String getDecision_org_sanc() {
        return decision_org_sanc;
    }

    public void setDecision_org_sanc(String decision_org_sanc) {
        this.decision_org_sanc = decision_org_sanc;
    }

    public LocalDate getFecha_informe_oral_org_sanc() {
        return fecha_informe_oral_org_sanc;
    }

    public void setFecha_informe_oral_org_sanc(LocalDate fecha_informe_oral_org_sanc) {
        this.fecha_informe_oral_org_sanc = fecha_informe_oral_org_sanc;
    }

    public LocalDate getFecha_noti_resolucion_org_sanc() {
        return fecha_noti_resolucion_org_sanc;
    }

    public void setFecha_noti_resolucion_org_sanc(LocalDate fecha_noti_resolucion_org_sanc) {
        this.fecha_noti_resolucion_org_sanc = fecha_noti_resolucion_org_sanc;
    }

    public String getNum_resolucion_orgsanc() {
        return num_resolucion_orgsanc;
    }

    public void setNum_resolucion_orgsanc(String num_resolucion_orgsanc) {
        this.num_resolucion_orgsanc = num_resolucion_orgsanc;
    }

    public String getObservacion_org_sanc() {
        return observacion_org_sanc;
    }

    public void setObservacion_org_sanc(String observacion_org_sanc) {
        this.observacion_org_sanc = observacion_org_sanc;
    }

    public List<DatosImplicadosV> getImplicados() {
        return implicados;
    }

    public void setImplicados(List<DatosImplicadosV> implicados) {
        this.implicados = implicados;
    }

}
