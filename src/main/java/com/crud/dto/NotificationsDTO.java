package com.crud.dto;

import java.util.Date;

/**
 * @author silvae
 */
public class NotificationsDTO {


    private int id;
    private String descripcion;
    private int estado;
    private int lectura;
    private String observacion;
    private String usuario;

    public NotificationsDTO() {
    }

    public NotificationsDTO(int id, String descripcion, int estado, int lectura, String observacion, String usuario) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.lectura = lectura;
        this.observacion = observacion;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

   
    
   

}
