package com.crud.repository;

import com.crud.entity.OrgInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author silvae
 */
@Repository
public interface OrgInstructorRepository extends JpaRepository<OrgInstructor, Integer> {

    @Query(value="SELECT o FROM org_instructor o  WHERE o.id = :id",nativeQuery = true)
    OrgInstructor OrgInstructornfo(@Param("id") int id);

}
