package com.crud.service;

import com.crud.entity.Sexo;
import com.crud.repository.SexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author esilva
 */
@Service
@Transactional    
public class SexoService {

    @Autowired
    SexoRepository sexoRepository;

    public boolean save(Sexo sexo) {
        Sexo sex = sexoRepository.save(sexo);
        return sex != null;
    }
}
