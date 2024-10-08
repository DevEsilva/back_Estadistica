package com.crud.security.repository;

import com.crud.entity.Extension;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author silvae
 */
@Repository
public interface ExtensionRepository extends JpaRepository<Extension, Integer> {

    List<Extension> findAllByActivo(int activo);
}
