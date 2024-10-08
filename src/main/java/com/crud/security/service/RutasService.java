package com.crud.security.service;

import com.crud.entity.Rutas;
import com.crud.security.repository.RutasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author silvae
 */
@Service
@Transactional
public class RutasService {

    @Autowired
    RutasRepository rutasRepository;

    public void save(Rutas ruta) {
        rutasRepository.save(ruta);
    }

    public Rutas ruta(String name) {
        return rutasRepository.findByNombreAndActivo(name, 0);
    }
}
