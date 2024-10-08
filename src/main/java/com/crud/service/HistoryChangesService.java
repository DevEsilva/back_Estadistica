package com.crud.service;

import com.crud.entity.HistoryChanges;
import com.crud.repository.HistoryChangesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author silvae
 */
@Service
@Transactional
public class HistoryChangesService {

    @Autowired
    HistoryChangesRepository changesRepository;

    public HistoryChanges save(HistoryChanges historyChanges) {
        return changesRepository.save(historyChanges);
    }
    
    
}
