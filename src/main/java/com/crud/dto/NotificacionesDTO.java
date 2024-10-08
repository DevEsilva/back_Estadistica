package com.crud.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author silvae
 */
@Entity
public class NotificacionesDTO implements Serializable {
    
    @Id
    private String expediente;
    private String fecha_pad;
    private String dias_restantes;
    private String urgencia;

    public NotificacionesDTO() {
    }

    
    public NotificacionesDTO(String expediente, String fecha_pad, String dias_restantes, String urgencia) {
        this.expediente = expediente;
        this.fecha_pad = fecha_pad;
        this.dias_restantes = dias_restantes;
        this.urgencia = urgencia;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getFecha_pad() {
        return fecha_pad;
    }

    public void setFecha_pad(String fecha_pad) {
        this.fecha_pad = fecha_pad;
    }

    public String getDias_restantes() {
        return dias_restantes;
    }

    public void setDias_restantes(String dias_restantes) {
        this.dias_restantes = dias_restantes;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

        
    
    
}
