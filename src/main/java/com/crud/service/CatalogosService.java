package com.crud.service;

import com.crud.entity.Cargos;
import com.crud.entity.Establecimientos;
import com.crud.entity.Sexo;
import com.crud.repository.CargosRepository;
import com.crud.repository.EstablecimientosRepository;
import com.crud.repository.SexoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author esilva
 */
@Service
@Transactional
public class CatalogosService {

    @Autowired
    EstablecimientosRepository establecimientosRepository;

    @Autowired
    SexoRepository sexoRepository;

    @Autowired
    CargosRepository cargosRepository;

    public List<Establecimientos> ListaEstablecimientos() {

        return establecimientosRepository.findAll();

    }

    public List<Sexo> ListaSexos() {

        return sexoRepository.findAll();

    }

    public List<Cargos> ListaCargos() {

        return cargosRepository.findAll();

    }
}
