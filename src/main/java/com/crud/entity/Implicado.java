package com.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author silvae
 */
@Entity
@Table(name = "implicado")
public class Implicado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    private String Nombre_Completo;

    private String Tipo_DocIdent;

    @Column(name = "num_docu_ident", nullable = false)
    private String numDocIdent;

    private String Telefono;

    private String Observacion;

    @JsonIgnore
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_Creacion;

    @JsonIgnore
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_Actualizacion;

    @JsonIgnore
    private int activo;
    

    public Implicado() {
    }

    public Implicado(int id, String Nombre_Completo, String Tipo_DocIdent, String numDocIdent, String Telefono, String Observacion, Date Fecha_Creacion, Date Fecha_Actualizacion, int activo) {
        this.id = id;
        this.Nombre_Completo = Nombre_Completo;
        this.Tipo_DocIdent = Tipo_DocIdent;
        this.numDocIdent = numDocIdent;
        this.Telefono = Telefono;
        this.Observacion = Observacion;
        this.Fecha_Creacion = Fecha_Creacion;
        this.Fecha_Actualizacion = Fecha_Actualizacion;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_Completo() {
        return Nombre_Completo;
    }

    public void setNombre_Completo(String Nombre_Completo) {
        this.Nombre_Completo = Nombre_Completo;
    }

    public String getTipo_DocIdent() {
        return Tipo_DocIdent;
    }

    public void setTipo_DocIdent(String Tipo_DocIdent) {
        this.Tipo_DocIdent = Tipo_DocIdent;
    }

    public String getNumDocIdent() {
        return numDocIdent;
    }

    public void setNumDocIdent(String numDocIdent) {
        this.numDocIdent = numDocIdent;
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
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

 
    
}
