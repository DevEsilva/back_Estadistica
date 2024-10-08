package com.crud.service;

import com.crud.entity.OrgInstructor;
import com.crud.repository.OrgInstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author silvae
 */
@Service
@Transactional
public class OrgInstructorService {

    @Autowired
    OrgInstructorRepository orgInstructorRepository;

    public OrgInstructor obtenerOrgInstructor(int id) {
        return orgInstructorRepository.OrgInstructornfo(id);
    }

    public OrgInstructor guardar(OrgInstructor org) {
        return orgInstructorRepository.save(org);
    }

}
