package com.crud.repository;

import com.crud.entity.Stpad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author silvae
 */
@Repository
public interface StpadRepository extends JpaRepository<Stpad, Integer> {

    @Query(value="SELECT i FROM stpad i  WHERE i.infor_precan = :infor_precan",nativeQuery = true)
    Stpad StpadInfo(@Param("infor_precan") String infor_precan);

}
