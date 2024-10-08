package com.crud.entity;

import java.io.Serializable;
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
@Table(name = "OrgInstructor")
public class OrgInstructor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private String Area;
    private String Carta_InicioPad;
    @Temporal(TemporalType.DATE)
    private Date Fecha_Notificacion_InicioPad;
    @Temporal(TemporalType.DATE)
    private Date Fecha_PresRIPCAnio;
    @Temporal(TemporalType.DATE)
    private Date Fecha_InformeFinal;
    private String Sancion_Propuesta;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_Creacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_Actualizacion;
    private String Observacion;
    private int Activo;

    public OrgInstructor() {
    }

    public OrgInstructor(int id, String Area, String Carta_InicioPad, Date Fecha_Notificacion_InicioPad, Date Fecha_PresRIPCAnio, Date Fecha_InformeFinal, String Sancion_Propuesta, Date Fecha_Creacion, Date Fecha_Actualizacion, String Observacion, int Activo) {
        this.id = id;
        this.Area = Area;
        this.Carta_InicioPad = Carta_InicioPad;
        this.Fecha_Notificacion_InicioPad = Fecha_Notificacion_InicioPad;
        this.Fecha_PresRIPCAnio = Fecha_PresRIPCAnio;
        this.Fecha_InformeFinal = Fecha_InformeFinal;
        this.Sancion_Propuesta = Sancion_Propuesta;
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

    public Date getFecha_Notificacion_InicioPad() {
        return Fecha_Notificacion_InicioPad;
    }

    public void setFecha_Notificacion_InicioPad(Date Fecha_Notificacion_InicioPad) {
        this.Fecha_Notificacion_InicioPad = Fecha_Notificacion_InicioPad;
    }

    public Date getFecha_PresRIPCAnio() {
        return Fecha_PresRIPCAnio;
    }

    public void setFecha_PresRIPCAnio(Date Fecha_PresRIPCAnio) {
        this.Fecha_PresRIPCAnio = Fecha_PresRIPCAnio;
    }

    public Date getFecha_InformeFinal() {
        return Fecha_InformeFinal;
    }

    public void setFecha_InformeFinal(Date Fecha_InformeFinal) {
        this.Fecha_InformeFinal = Fecha_InformeFinal;
    }

    public String getSancion_Propuesta() {
        return Sancion_Propuesta;
    }

    public void setSancion_Propuesta(String Sancion_Propuesta) {
        this.Sancion_Propuesta = Sancion_Propuesta;
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
