package com.crud.entity;

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
@Table(name = "history_changes")
public class HistoryChanges implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int Id;

    @Column(name = "name_table", nullable = false)
    private String Table;

    @Column(name = "id_table")
    private int IdTable;

    @Column(name = "user_h", nullable = false)
    private String usuario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = false)
    private Date FechaCreacion;

    @Column(name = "description", nullable = false)
    private String Descripcion;

    @Column(name = "activo", nullable = false)
    private int Activo;

    public HistoryChanges() {
    }

    public HistoryChanges(int Id, String Table, int IdTable, String usuario, Date FechaCreacion, String Descripcion, int Activo) {
        this.Id = Id;
        this.Table = Table;
        this.IdTable = IdTable;
        this.usuario = usuario;
        this.FechaCreacion = FechaCreacion;
        this.Descripcion = Descripcion;
        this.Activo = Activo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTable() {
        return Table;
    }

    public void setTable(String Table) {
        this.Table = Table;
    }

    public int getIdTable() {
        return IdTable;
    }

    public void setIdTable(int IdTable) {
        this.IdTable = IdTable;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getActivo() {
        return Activo;
    }

    public void setActivo(int Activo) {
        this.Activo = Activo;
    }

   
   
    
}
