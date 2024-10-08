package com.crud.repository;

import com.crud.entity.Cargos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author esilva
 */
@Repository
public interface CargosRepository extends JpaRepository<Cargos, Integer> {

    Optional<Cargos> findByCodigo(String codigo);

}
