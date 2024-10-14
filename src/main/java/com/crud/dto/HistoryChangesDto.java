package com.crud.dto;

/**
 * @author esilva
 */
public class HistoryChangesDto {

    private String Table;

    private String IdAfectado;

    private String Usuario;

    private String FechaCreacion;

    private String Descripcion;

    public String getTable() {
        return Table;
    }

    public void setTable(String Table) {
        this.Table = Table;
    }

    public String getIdAfectado() {
        return IdAfectado;
    }

    public void setIdAfectado(String IdAfectado) {
        this.IdAfectado = IdAfectado;
    }



    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

}
