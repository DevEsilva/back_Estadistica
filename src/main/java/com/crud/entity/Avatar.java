package com.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * @author silvae
 */
@Entity
public class Avatar implements Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "ruta_id")
    private Rutas ruta;

    @ManyToOne
    @JoinColumn(name = "extension_id")
    private Extension extension;

    @JsonIgnore
    private int activo;

    private String descripcion;

    @JsonIgnore
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fcreate;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    private Date fupdate;

    public Avatar() {
    }

    public Avatar(String nombre, Rutas ruta, Extension extension, int activo, String descripcion, Date fcreate) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.extension = extension;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fcreate = fcreate;
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rutas getRuta() {
        return ruta;
    }

    public void setRuta(Rutas ruta) {
        this.ruta = ruta;
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
