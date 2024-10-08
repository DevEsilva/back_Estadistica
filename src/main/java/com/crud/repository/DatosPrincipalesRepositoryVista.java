package com.crud.repository;

import com.crud.Vista.DatosExpedientesV;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author silvae
 */

@Repository
public interface DatosPrincipalesRepositoryVista extends JpaRepository<DatosExpedientesV, Integer> {

    @Query(value = "EXEC sp_GetListadoDocs :estado", nativeQuery = true)
    List<DatosExpedientesV> ConsultaDatosPrincpales(@Param("estado") int estado);
    
}
