package com.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * @author silvae
 */
@Entity
public class Extension implements Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String extension;

    @JsonIgnore
    private int activo;

    private String nombre;

    @JsonIgnore
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fcreate;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date fupdate;

    public Extension() {
    }

    public Extension(String extension, int activo, String nombre, Date fcreate) {
        this.extension = extension;
        this.activo = activo;
        this.nombre = nombre;
        this.fcreate = fcreate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
