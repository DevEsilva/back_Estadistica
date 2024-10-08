package com.crud.repository;

import com.crud.Vista.DatosExpedientesV;
import com.crud.entity.Establecimientos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author esilva
 */
@Repository
public interface EstablecimientosRepository extends JpaRepository<Establecimientos, Integer> {

    public Optional<Establecimientos> findByCodigo(String codigo);

}
