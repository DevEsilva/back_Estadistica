package com.crud.security.service;

import com.crud.entity.Avatar;
import com.crud.security.repository.AvatarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author silvae
 */
@Service
@Transactional
public class AvatarService {

    @Autowired
    AvatarRepository avatarRepository;

    public void save(Avatar avatar) {
        avatarRepository.save(avatar);
    }

    public List<Avatar> List() {
        return avatarRepository.findAllByActivo(0);
    }

}
