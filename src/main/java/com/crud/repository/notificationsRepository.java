package com.crud.repository;

import com.crud.entity.notifications;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author silvae
 */
@Repository
public interface notificationsRepository extends JpaRepository<notifications, Integer> {

    List<notifications> findByEstadoOrderByFechaCreacionDesc(int state);

    notifications findByIdAndEstado(int id, int state);

    @Query(value = "EXEC sp_GetCreateNotifications", nativeQuery = true)
    boolean CreateNotificaciones();

}
