package com.crud.dto;

/**
 * @author silvae
 */
public class AvatarDTO {

    private String nombre;

    private String ruta;

    private String descripcion;

    public AvatarDTO(String nombre, String ruta, String descripcion) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.descripcion = descripcion;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

}
