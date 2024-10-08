package com.crud.repository;

import com.crud.entity.DatosPrincipales;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author silvae
 */
@Repository
public interface ExpedientesRepository extends JpaRepository<DatosPrincipales, Integer> {

    @Query(value = "EXEC sp_GetListadoDocs :estado", nativeQuery = true)
    List<DatosPrincipales> ConsultaDatosPrincpales(@Param("estado") int estado);

   
    @Query(value = "SELECT COUNT(*) FROM datos_principales f WHERE f.activo =:activo and f.expediente =:expediente", nativeQuery = true)
    int existeExpediente(@Param("expediente") String expediente, @Param("activo") int activo);
    
    

}
