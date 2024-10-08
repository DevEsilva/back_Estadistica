package com.crud.repository;

import com.crud.entity.HistoryChanges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author silvae
 */
@Repository

public interface HistoryChangesRepository extends JpaRepository<HistoryChanges, Integer> {

}
