package com.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * @author silvae
 */
@Entity
public class Rutas implements Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ruta;

    private String nombre;

    @JsonIgnore
    private int activo;

    @JsonIgnore
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fcreate;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date fupdate;

    public Rutas() {
    }

    public Rutas(String ruta, String nombre, int activo, Date fcreate) {
        this.ruta = ruta;
        this.nombre = nombre;
        this.activo = activo;
        this.fcreate = fcreate;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Date getFcreate() {
        return fcreate;
    }

    public void setFcreate(Date fcreate) {
        this.fcreate = fcreate;
    }

    public Date getFupdate() {
        return fupdate;
    }

    public void setFupdate(Date fupdate) {
        this.fupdate = fupdate;
    }

  
    

}
