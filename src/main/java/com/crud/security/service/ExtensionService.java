package com.crud.security.service;

import com.crud.entity.Extension;
import com.crud.security.repository.ExtensionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author silvae
 */
@Service
@Transactional
public class ExtensionService {

    @Autowired
    ExtensionRepository extensionRepository;

    public void save(Extension extension) {
        extensionRepository.save(extension);
    }

    public List<Extension> List() {
        return extensionRepository.findAllByActivo(0);
    }

}
