package com.crud.controller;

import com.crud.dto.AvatarDTO;
import com.crud.entity.Avatar;
import com.crud.security.service.AvatarService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author silvae
 */
@RestController
@RequestMapping("/Avatar")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class AvatarControlller {

    @Autowired
    private AvatarService avatarService;

    @GetMapping("/lista")
    public ResponseEntity<List<AvatarDTO>> list() {
        try {
            List<Avatar> list = avatarService.List();
            List<AvatarDTO> Listavatardto = list.stream()
                    .map(avatar -> new AvatarDTO(
                    avatar.getNombre(),
                    avatar.getRuta().getRuta() + avatar.getNombre() + avatar.getExtension().getExtension(),
                    avatar.getDescripcion()
            )).collect(Collectors.toList());

            return new ResponseEntity(Listavatardto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
