package com.crud.repository;

import com.crud.entity.OrgSancionador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author silvae
 */
@Repository
public interface OrgSancionadorRepository extends JpaRepository<OrgSancionador, Integer> {

    @Query(value = "SELECT o FROM org_sancionador o  WHERE o.id = :id", nativeQuery = true)
    OrgSancionador OrgSancionadorInfo(@Param("id") int id);
    
}
