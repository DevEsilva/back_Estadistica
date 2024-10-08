package com.crud.service;

import com.crud.entity.OrgSancionador;
import com.crud.repository.OrgSancionadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author silvae
 */
@Service
@Transactional
public class OrgSancionadorService {

    @Autowired
    OrgSancionadorRepository orgSancionadorRepository;

    public OrgSancionador obtenerOrgInstructor(int id) {
        return orgSancionadorRepository.OrgSancionadorInfo(id);
    }

    public OrgSancionador guardar(OrgSancionador org) {
        return orgSancionadorRepository.save(org);
    }

}
