package com.crud.service;

import com.crud.entity.Stpad;
import com.crud.repository.StpadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author silvae
 */
@Service
@Transactional                                                                                                                                                                                                                                                                                                                       
public class StpadService {

    @Autowired
    StpadRepository stpadrepository;

    public Stpad obtenerStpad(String infor_precan) {
        return stpadrepository.StpadInfo(infor_precan);
    }
     public Stpad guardar(Stpad stpad) {
        return stpadrepository.save(stpad);
    }
    

}
