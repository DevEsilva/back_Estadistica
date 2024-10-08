package com.crud.repository;

import com.crud.entity.Implicado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author silvae
 */
@Repository
public interface ImplicadosRepository extends JpaRepository<Implicado, Integer> {

    @Query(value = "SELECT * FROM implicado WHERE num_docu_ident = :numDoc AND activo = :activo", nativeQuery = true)
    Implicado ImplicadoporNumDoc(@Param("numDoc") String numDoc, @Param("activo") int activo);

    boolean existsBynumDocIdentAndActivo(String numDocIdent, int Activo);

    List<Implicado> findAllByActivo(int Activo);

    Implicado findByNumDocIdentAndActivo(String dni, int Activo);

    @Query(value = "EXEC sp_GetExistIdInvolucrado :idImplicados", nativeQuery = true)
    List<String> countIdImplicado(@Param("idImplicados") int idImplicados);

}
