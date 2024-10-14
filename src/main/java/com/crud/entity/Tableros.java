package com.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author esilva
 */
@Entity
public class Tableros implements Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombretablero;
    private String urlpwb;
    private String nombredescarga;
    private String urldescarga;
    private String pixelesAlto;
    private int activo;

    public Tableros() {
    }

    public Tableros(int id, String nombretablero, String urlpwb, String nombredescarga, String urldescarga, String pixelesAlto, int activo) {
        this.id = id;
        this.nombretablero = nombretablero;
        this.urlpwb = urlpwb;
        this.nombredescarga = nombredescarga;
        this.urldescarga = urldescarga;
        this.pixelesAlto = pixelesAlto;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombretablero() {
        return nombretablero;
    }

    public void setNombretablero(String nombretablero) {
        this.nombretablero = nombretablero;
    }

    public String getUrlpwb() {
        return urlpwb;
    }

    public void setUrlpwb(String urlpwb) {
        this.urlpwb = urlpwb;
    }

    public String getNombredescarga() {
        return nombredescarga;
    }

    public void setNombredescarga(String nombredescarga) {
        this.nombredescarga = nombredescarga;
    }

    public String getUrldescarga() {
        return urldescarga;
    }

    public void setUrldescarga(String urldescarga) {
        this.urldescarga = urldescarga;
    }

    public String getPixelesAlto() {
        return pixelesAlto;
    }

    public void setPixelesAlto(String pixelesAlto) {
        this.pixelesAlto = pixelesAlto;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    
}
