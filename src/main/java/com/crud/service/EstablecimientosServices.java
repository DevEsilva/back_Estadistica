package com.crud.service;

import com.crud.entity.Establecimientos;
import com.crud.repository.EstablecimientosRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author esilva
 */
@Service
@Transactional
public class EstablecimientosServices {

    @Autowired
    EstablecimientosRepository establecimientosRepository;

    public boolean save(Establecimientos establecimientos) {
        Establecimientos esta = establecimientosRepository.save(establecimientos);
        return esta != null;
    }

    public Establecimientos establecimiento(String codigo) {
        Optional<Establecimientos> esta = establecimientosRepository.findByCodigo(codigo);
        if (!esta.isPresent()) {
            return null;
        }
        return esta.get();
    }
}
