package com.crud.repository;

import com.crud.Vista.DatosImplicadosV;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author silvae
 */
@Repository
public interface DatosInvolucradosRepositoryVista extends JpaRepository<DatosImplicadosV, Integer> {

    @Query(value = "EXEC sp_GetListaInvolucrados :id", nativeQuery = true)
    List<DatosImplicadosV> ConsultaDatosImplicados(@Param("id") int id);
    
    

}
