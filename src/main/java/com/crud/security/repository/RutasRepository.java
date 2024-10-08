package com.crud.security.repository;

import com.crud.entity.Rutas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author silvae
 */
@Repository
public interface RutasRepository extends JpaRepository<Rutas, Integer> {

    Rutas findByNombreAndActivo(String name, int Activo);

}
