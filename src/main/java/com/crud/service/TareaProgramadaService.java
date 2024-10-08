package com.crud.service;

import com.crud.util.Utils;
import com.crud.util.constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author silvae
 */
@Component
public class TareaProgramadaService {

    @Autowired
    private notificationsService notificationService;

    @Autowired
    private Utils util;

    private final SimpleDateFormat dateFormat2 = new SimpleDateFormat(constants.fecha_hora);

    @Autowired
    public TareaProgramadaService(notificationsService notificationService) {
        this.notificationService = notificationService;
    }

    // Este método se ejecutará según la expresión cron especificada
    @Scheduled(cron = "0 1 1 * * ?") // Ejecutar todos los días a las 12 del mediodía
    public void ejecutarTareaProgramada() {
        // Llama al método CreateNotifications de tu servicio
        try {
            boolean resultado = notificationService.CreateNotifications();
            // Maneja el resultado según lo necesites
            if (resultado) {
                System.out.println("Se crearon correctamente las notificaciones.");
                util.SaveChanges(constants.SeCreo + " las " + constants.Notificaciones, new Date(), 0, util.userActivo(), constants.Notifications);
            } else {
                System.out.println("No se crearon las notificaciones.");
                util.SaveChanges(constants.Intento_Creacion + " las " + constants.Notificaciones, new Date(), 0, util.userActivo(), constants.Notifications);
            }
        } catch (Exception e) {
            util.SaveChanges(constants.Excepcion_Crear + " las " + constants.Notificaciones + ": " + e.getMessage(), new Date(), 0, util.userActivo(), constants.Notifications);
        }
    }
}
