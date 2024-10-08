package com.crud.Vista;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author silvae
 */
@Entity
public class DatosImplicadosV implements Serializable {

    @Id
    private String num_docu_ident;
    private String nombre_completo;
    private String telefono;
    private String tipo_doc_ident;
    private String observacion;

    public DatosImplicadosV(String num_docu_ident, String nombre_completo, String telefono, String tipo_doc_ident, String observacion) {
        this.num_docu_ident = num_docu_ident;
        this.nombre_completo = nombre_completo;
        this.telefono = telefono;
        this.tipo_doc_ident = tipo_doc_ident;
        this.observacion = observacion;
    }

    public DatosImplicadosV() {
    }

    public String getNum_docu_ident() {
        return num_docu_ident;
    }

    public void setNum_docu_ident(String num_docu_ident) {
        this.num_docu_ident = num_docu_ident;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo_doc_ident() {
        return tipo_doc_ident;
    }

    public void setTipo_doc_ident(String tipo_doc_ident) {
        this.tipo_doc_ident = tipo_doc_ident;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
