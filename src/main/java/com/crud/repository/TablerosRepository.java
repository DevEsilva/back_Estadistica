package com.crud.repository;

import com.crud.entity.Tableros;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author esilva
 */
@Repository
public interface TablerosRepository extends JpaRepository<Tableros, Integer> {

    Tableros findByNombretablero(String tablero);
    
    List<Tableros> findByActivo(int activo);
    
}
