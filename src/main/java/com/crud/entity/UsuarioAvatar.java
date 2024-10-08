package com.crud.entity;

import com.crud.security.entity.Usuario;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author silvae
 */
public class UsuarioAvatar {

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;
    
}
