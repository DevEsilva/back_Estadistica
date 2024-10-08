package com.crud.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author silvae
 */
@Entity
@Table(name = "OrgSancionador")
public class OrgSancionador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date Fecha_Notifi_Iniciofs;
    @Temporal(TemporalType.DATE)
    private Date Fecha_InformeOral;
    private String Num_Resolucion_Sanc;
    private String Decision;
    @Temporal(TemporalType.DATE)
    private Date Fecha_Notific_Resolucion;
    private Date Fecha_Creacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_Actualizacion;
    private String Observacion;
    private int Activo;

    public OrgSancionador() {
    }

    public OrgSancionador(int id, Date Fecha_Notifi_Iniciofs, Date Fecha_InformeOral, String Num_Resolucion_Sanc, String Decision, Date Fecha_Notific_Resolucion, Date Fecha_Creacion, Date Fecha_Actualizacion, String Observacion, int Activo) {
        this.id = id;
        this.Fecha_Notifi_Iniciofs = Fecha_Notifi_Iniciofs;
        this.Fecha_InformeOral = Fecha_InformeOral;
        this.Num_Resolucion_Sanc = Num_Resolucion_Sanc;
        this.Decision = Decision;
        this.Fecha_Notific_Resolucion = Fecha_Notific_Resolucion;
        this.Fecha_Creacion = Fecha_Creacion;
        this.Fecha_Actualizacion = Fecha_Actualizacion;
        this.Observacion = Observacion;
        this.Activo = Activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_Notifi_Iniciofs() {
        return Fecha_Notifi_Iniciofs;
    }

    public void setFecha_Notifi_Iniciofs(Date Fecha_Notifi_Iniciofs) {
        this.Fecha_Notifi_Iniciofs = Fecha_Notifi_Iniciofs;
    }

    public Date getFecha_InformeOral() {
        return Fecha_InformeOral;
    }

    public void setFecha_InformeOral(Date Fecha_InformeOral) {
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

    public Date getFecha_Notific_Resolucion() {
        return Fecha_Notific_Resolucion;
    }

    public void setFecha_Notific_Resolucion(Date Fecha_Notific_Resolucion) {
        this.Fecha_Notific_Resolucion = Fecha_Notific_Resolucion;
    }

    public Date getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public void setFecha_Creacion(Date Fecha_Creacion) {
        this.Fecha_Creacion = Fecha_Creacion;
    }

    public Date getFecha_Actualizacion() {
        return Fecha_Actualizacion;
    }

    public void setFecha_Actualizacion(Date Fecha_Actualizacion) {
        this.Fecha_Actualizacion = Fecha_Actualizacion;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public int getActivo() {
        return Activo;
    }

    public void setActivo(int Activo) {
        this.Activo = Activo;
    }

  
}
