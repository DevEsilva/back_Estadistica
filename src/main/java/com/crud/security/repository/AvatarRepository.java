package com.crud.security.repository;

import com.crud.entity.Avatar;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author silvae
 */
@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Integer> {

    List<Avatar> findAllByActivo(int activo);

}
