package com.crud.repository;

import com.crud.dto.NotificacionesDTO;
import java.util.List;
import java.util.Observable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author silvae
 */
@Repository
public interface NotificacionesRepository extends JpaRepository<NotificacionesDTO, Integer> {

    @Query(value = "EXEC sp_GetNotificaciones :estado", nativeQuery = true)
    List<NotificacionesDTO> Notificaciones(@Param("estado") int estado);

   

}
