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
@Table(name = "Stpad")
public class Stpad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private String Infor_PrecaN;
    @Temporal(TemporalType.DATE)
    private Date Fecha;
    private String SancPropta;
    private String Observacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_Creacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_Actualizacion;
    private int Activo;

    public Stpad() {
    }

    public Stpad(int id, String Infor_PrecaN, Date Fecha, String SancPropta, String Observacion, Date Fecha_Creacion, Date Fecha_Actualizacion, int Activo) {
        this.id = id;
        this.Infor_PrecaN = Infor_PrecaN;
        this.Fecha = Fecha;
        this.SancPropta = SancPropta;
        this.Observacion = Observacion;
        this.Fecha_Creacion = Fecha_Creacion;
        this.Fecha_Actualizacion = Fecha_Actualizacion;
        this.Activo = Activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfor_PrecaN() {
        return Infor_PrecaN;
    }

    public void setInfor_PrecaN(String Infor_PrecaN) {
        this.Infor_PrecaN = Infor_PrecaN;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getSancPropta() {
        return SancPropta;
    }

    public void setSancPropta(String SancPropta) {
        this.SancPropta = SancPropta;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
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

    public int getActivo() {
        return Activo;
    }

    public void setActivo(int Activo) {
        this.Activo = Activo;
    }

    
    

}
