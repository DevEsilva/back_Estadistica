package com.crud.controller;

import com.crud.dto.DatosUsuarioDTO;
import com.crud.dto.Mensaje;
import com.crud.entity.Cargos;
import com.crud.entity.Establecimientos;
import com.crud.entity.Sexo;
import com.crud.entity.Tableros;
import com.crud.repository.CargosRepository;
import com.crud.repository.SexoRepository;
import com.crud.security.entity.Rol;
import com.crud.security.entity.Usuario;
import com.crud.security.repository.AvatarRepository;
import com.crud.security.service.UsuarioService;
import com.crud.service.CatalogosService;
import com.crud.service.EstablecimientosServices;
import com.crud.service.TableroService;
import com.crud.util.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author esilva
 */
@RestController
@RequestMapping("/catalogos")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class CatalogosController {

    @Autowired
    CatalogosService catalogosService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private AvatarRepository avatarRepository;

    @Autowired
    private CargosRepository cargosRepository;

    @Autowired
    private SexoRepository sexoRepository;

    @Autowired
    private Utils util;

    @Autowired
    private EstablecimientosServices establecimientosServices;

    @Autowired
    private TableroService tableroService;

    @GetMapping("/listaEstablecimientos")
    public ResponseEntity<List<Establecimientos>> list() {
        try {
            List<Establecimientos> list = catalogosService.ListaEstablecimientos();

            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/datos")// datos unitarios por session
    public ResponseEntity<?> datos() {
        try {
            Usuario usuario = usuarioService.getByNombreUsuario(util.userActivo());
            DatosUsuarioDTO dto = new DatosUsuarioDTO();
            dto.setUsuario(usuario.getNombreUsuario());
            dto.setNombre(usuario.getNombre());
            dto.setEmail(usuario.getEmail());
            Optional<Cargos> Cargo = cargosRepository.findById(usuario.getId_cargo());
            dto.setCargo(Cargo.get().getDescripcion());
            Optional<Sexo> sexo = sexoRepository.findById(usuario.getId_sexo());
            dto.setSexo(sexo.get().getDescripcion());
            dto.setCelular(usuario.getCelular());
            Set<Rol> roles = usuario.getRoles();
            String roles2;

            if (roles.size() == 2) {
                roles2 = "ADMINISTRADOR";
            } else {
                roles2 = "USUARIO";
            }
            dto.setRol(roles2);
            Establecimientos estable = establecimientosServices.establecimiento(usuario.getEstablecimiento());
            dto.setEstablecimiento(estable.getEstablecimiento());
            return new ResponseEntity(dto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("No se pudo obtener datos de usuario", 99, "No ha iniciado sessión"), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/listaSexos")
    public ResponseEntity<List<Sexo>> listaSexo() {
        try {
            List<Sexo> list = catalogosService.ListaSexos();

            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/listaCargos")
    public ResponseEntity<List<Cargos>> listaCargos() {
        try {
            List<Cargos> list = catalogosService.ListaCargos();

            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/listaUsuarios")
    public ResponseEntity<List<DatosUsuarioDTO>> listaUsuarios() {
        try {
            List<Usuario> list = usuarioService.lista();

            List<DatosUsuarioDTO> usersList = new ArrayList<>();

            for (Usuario usuario : list) {
                DatosUsuarioDTO dto = new DatosUsuarioDTO();
                dto.setUsuario(usuario.getNombreUsuario());
                dto.setNombre(usuario.getNombre());
                dto.setEmail(usuario.getEmail());
                Optional<Cargos> Cargo = cargosRepository.findById(usuario.getId_cargo());
                dto.setCargo(Cargo.get().getDescripcion());
                Optional<Sexo> sexo = sexoRepository.findById(usuario.getId_sexo());
                dto.setSexo(sexo.get().getDescripcion());
                dto.setCelular(usuario.getCelular());
                Set<Rol> roles = usuario.getRoles();
                String roles2;

                if (roles.size() == 2) {
                    roles2 = "ADMINISTRADOR";
                } else {
                    roles2 = "USUARIO";
                }
                dto.setRol(roles2);
                Establecimientos estable = establecimientosServices.establecimiento(usuario.getEstablecimiento());

                dto.setEstablecimiento(estable.getEstablecimiento());

                usersList.add(dto);

            }
            return new ResponseEntity(usersList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/listaTableros")
    public ResponseEntity<List<Tableros>> listaTableros() {
        try {
            List<Tableros> list = tableroService.Listado();

            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    
     @GetMapping("/tablero/{nombre}")
    public ResponseEntity<Tableros> Tablero(@PathVariable String nombre) {
        try {
            Tableros tablero = tableroService.tablero(nombre);

            return new ResponseEntity(tablero, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
