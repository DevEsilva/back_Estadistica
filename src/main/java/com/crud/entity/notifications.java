package com.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "notifications")
public class notifications implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(name = "proceedings", nullable = false)
    private String expediente;

    @Column(name = "description", nullable = false)
    private String descripcion;

    @JsonIgnore
    @Column(name = "state", nullable = false)
    private int estado;

    @Column(name = "reading", nullable = false)
    private int lectura;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    private Date fechaCreacion;

    @JsonIgnore
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    @JsonIgnore
    @Column(name = "observation")
    private String observacion;

    @JsonIgnore
    @Column(name = "user_update")
    private String usuarioActualizador;

    public notifications() {
    }

    public notifications(int id, String expediente, String descripcion, int estado, int lectura, Date fechaCreacion, Date fechaActualizacion, String observacion, String usuarioActualizador) {
        this.id = id;
        this.expediente = expediente;
        this.descripcion = descripcion;
        this.estado = estado;
        this.lectura = lectura;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.observacion = observacion;
        this.usuarioActualizador = usuarioActualizador;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getLectura() {
        return lectura;
    }

    public void setLectura(int lectura) {
        this.lectura = lectura;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getUsuarioActualizador() {
        return usuarioActualizador;
    }

    public void setUsuarioActualizador(String usuarioActualizador) {
        this.usuarioActualizador = usuarioActualizador;
    }

    

}
