package com.crud.service;

import com.crud.entity.Cargos;
import com.crud.repository.CargosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author esilva
 */
@Service
@Transactional
public class CargosService {

    @Autowired
    CargosRepository cargosRepository;

    public boolean save(Cargos cargo) {
        Cargos carg = cargosRepository.save(cargo);
        return carg != null;
    }

}
