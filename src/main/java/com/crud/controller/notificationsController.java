package com.crud.controller;

import com.crud.dto.Mensaje;
import com.crud.entity.notifications;
import com.crud.service.notificationsService;
import com.crud.util.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author silvae
 */
@RestController
@RequestMapping("/notifications")
@Api(tags = "notifications", description = "Metodos")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class notificationsController {

    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
    private final String pattern2 = "yyyy-mm-dd HH:mm:ss";
    private final SimpleDateFormat dateFormat2 = new SimpleDateFormat(pattern2);

    @Autowired
    private Utils util;

    @Autowired
    private notificationsService notificationService;

    @GetMapping("/lista")
    public ResponseEntity<List<notifications>> list() {
        try {
            List<notifications> list = notificationService.ListNotificactions();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/CreateNotifications")
    public ResponseEntity<?> CreateNotifications() {
        try {
            if (notificationService.CreateNotifications()) {
                return new ResponseEntity(new Mensaje("Se crearon correctamente las notificaciónes", 0, "Creación correcta"), HttpStatus.OK);
            } else {
                return new ResponseEntity(new Mensaje("No se crearon las notificaciónes", 99, "Error al crear notificaciónes"), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/ActualizarLectura/{id}/{lectura}")
    @ApiOperation("Actualiza la lectura de la notificación: 0 No visto , 1 visto")
    public ResponseEntity<?> updateNotifications(@PathVariable("id") int id, @PathVariable("lectura") int lectura) {
        notifications notification;
        notification = notificationService.Notificaction(id, 0);
        if (notification == null) {
            return new ResponseEntity(new Mensaje("No existe notificación", 99, "Error al actualizar notificación"), HttpStatus.NOT_FOUND);
        }
        //   String date = dateFormat2.format(new Date());
        notification.setLectura(lectura);
        notification.setFechaActualizacion(new Date());
        notification.setUsuarioActualizador(util.userActivo());
        notificationService.Save(notification);
        return new ResponseEntity(new Mensaje("Se actualiza correctamente la notificación", 0, "Actualizacion correcta"), HttpStatus.OK);
    }

    @PutMapping("/Eliminar/{id}")
    @ApiOperation("Desactiva la notificación")
    public ResponseEntity<?> updateNotifications(@PathVariable("id") int id) {
        notifications notification;
        notification = notificationService.Notificaction(id, 0);
        if (notification == null) {
            return new ResponseEntity(new Mensaje("No existe notificación", 99, "Error al eliminar notificación"), HttpStatus.NOT_FOUND);
        }
        //   String date = dateFormat2.format(new Date());
        notification.setFechaActualizacion(new Date());
        notification.setEstado(1);
        notification.setUsuarioActualizador(util.userActivo());
        notificationService.Save(notification);
        return new ResponseEntity(new Mensaje("Se elimina correctamente la notificación", 0, "Eliminación correcta"), HttpStatus.OK);
    }

}
