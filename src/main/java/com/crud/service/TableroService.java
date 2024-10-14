package com.crud.service;

import com.crud.entity.Tableros;
import com.crud.repository.TablerosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author esilva
 */
@Service
@Transactional
public class TableroService {

    @Autowired
    TablerosRepository tablerosRepository;

    public boolean save(Tableros tablero) {
        Tableros tablerito = tablerosRepository.save(tablero);
        return tablerito != null;
    }

    public List<Tableros> Listado() {

        return tablerosRepository.findByActivo(0);
    }
    
    
  public Tableros tablero(String nombre) {

        return tablerosRepository.findByNombretablero(nombre);
    }
    
}
