package com.crud.util;

import com.crud.entity.HistoryChanges;
import com.crud.service.HistoryChangesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author silvae
 */
@Component
public class Utils {

    @Autowired
    private HistoryChangesService changesService; // Suponiendo que tienes un servicio para guardar los cambios

    /**
     * @param descripcion
     * @param fecha
     * @param idTable: Tabla a la cua lse afecta
     * @param user
     * @param table: Tabla a la cua lse afecta
     */
    public void SaveChanges(String descripcion, Date fecha, int idTable, String user, String table) {
        try {
            HistoryChanges hc = new HistoryChanges();
            hc.setActivo(1);
            hc.setDescripcion(descripcion);
            hc.setFechaCreacion(fecha);
            hc.setIdTable(idTable);
            hc.setTable(table);
            hc.setUsuario(user);
            changesService.save(hc);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     *
     * @return
     */
    public String userActivo() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            return username;
        } catch (Exception e) {
            return "";

        }
    }

    /**
     * @param request
     * @return
     */
    public String obtenip(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress != null && !ipAddress.isEmpty()) {
            ipAddress = ipAddress.split(",")[0].trim();
        } else {
            // Si el encabezado X-Forwarded-For está vacío o no está presente, obtén la dirección IP remota del cliente
            // Esto es útil si la solicitud no ha pasado por un proxy o un balanceador de carga
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }
}
