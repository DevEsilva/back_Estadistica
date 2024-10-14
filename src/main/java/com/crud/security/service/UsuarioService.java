package com.crud.security.service;

import com.crud.entity.HistoryChanges;
import com.crud.security.entity.Usuario;
import com.crud.security.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario getByNombreUsuario(String nombreUsuario) {
        Optional<Usuario> user = usuarioRepository.findByNombreUsuario(nombreUsuario);
        if (!user.isPresent()) {
            return null;
        }

        return user.get();
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> lista() {
        return usuarioRepository.findAll();
    }
    

}
