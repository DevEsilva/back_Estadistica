package com.crud.service;

import com.crud.entity.notifications;
import com.crud.repository.notificationsRepository;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author silvae
 */
@Service
@Transactional
public class notificationsService {

    @Autowired
    notificationsRepository notificationRepository;

    public notifications Save(notifications notification) {
        return notificationRepository.save(notification);
    }

    public Optional<notifications> existID(int id) {
        return notificationRepository.findById(id);
    }

    public List<notifications> ListNotificactions() {
        return notificationRepository.findByEstadoOrderByFechaCreacionDesc(0);
    }

    public notifications Notificaction(int id, int state) {
        return notificationRepository.findByIdAndEstado(id, state);
    }

    public boolean CreateNotifications() {
        return notificationRepository.CreateNotificaciones();
    }
}
