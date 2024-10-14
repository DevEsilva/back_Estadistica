package com.crud.service;

import com.crud.entity.HistoryChanges;
import com.crud.repository.HistoryChangesRepository;
import java.util.List;
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

    public List<HistoryChanges> Historias(String usuario) {

        List<HistoryChanges> historias = changesRepository.findAllByUsuario(usuario);

        return historias;

    }

}
