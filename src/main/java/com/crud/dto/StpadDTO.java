package com.crud.dto;

import com.crud.entity.Implicado;

/**
 * @author silvae
 */
public class StpadDTO {

    private String Infor_PrecaN;
    private String Fecha;
    private String SancPropta;
    private String Observacion;

    public StpadDTO() {
    }

    public StpadDTO(String Infor_PrecaN, String Fecha, String SancPropta, String Observacion) {
        this.Infor_PrecaN = Infor_PrecaN;
        this.Fecha = Fecha;
        this.SancPropta = SancPropta;
        this.Observacion = Observacion;
    }

    public String getInfor_PrecaN() {
        return Infor_PrecaN;
    }

    public void setInfor_PrecaN(String Infor_PrecaN) {
        this.Infor_PrecaN = Infor_PrecaN;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
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

}
