package com.crud.repository;


import com.crud.entity.Sexo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author esilva
 */
@Repository
public interface SexoRepository extends JpaRepository<Sexo, Integer> {
    
        Optional<Sexo> findByCodigo(String codigo);

}
