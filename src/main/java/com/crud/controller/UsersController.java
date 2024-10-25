package com.crud.controller;

import com.crud.dto.DatosUsuarioDTO;
import com.crud.dto.HistoryChangesDto;
import com.crud.dto.Mensaje;
import com.crud.entity.Cargos;
import com.crud.entity.HistoryChanges;
import com.crud.entity.Sexo;
import com.crud.repository.CargosRepository;
import com.crud.repository.SexoRepository;
import com.crud.security.entity.Rol;
import com.crud.security.entity.Usuario;
import com.crud.security.enums.RolNombre;
import com.crud.security.jwt.JwtProvider;
import com.crud.security.repository.AvatarRepository;
import com.crud.security.service.RolService;
import com.crud.security.service.UsuarioService;
import com.crud.service.HistoryChangesService;
import com.crud.util.Utils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author esilva
 */
@RestController
@RequestMapping("/Users")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class UsersController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    private Utils util;

    @Autowired
    private AvatarRepository avatarRepository;

    @Autowired
    private CargosRepository cargosRepository;

    @Autowired
    private SexoRepository sexoRepository;

    @Autowired
    private HistoryChangesService historyChangesService;

    @PostMapping("/editar")
    public ResponseEntity<?> editar(@Valid @RequestBody DatosUsuarioDTO edicionUsuario, BindingResult bindingResult, HttpServletRequest request) {
        try {
            Usuario userActivo;

            userActivo = usuarioService.getByNombreUsuario(util.userActivo());

            if (bindingResult.hasErrors()) {
                return new ResponseEntity(new Mensaje("Error al editar Usuario", 99, "Campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
            }
            Usuario usuario = usuarioService.getByNombreUsuario(edicionUsuario.getUsuario());

            if (!edicionUsuario.getEmail().equals(usuario.getEmail())) {
                if (usuarioService.existsByEmail(edicionUsuario.getEmail())) {
                    return new ResponseEntity(new Mensaje("Error al editar Usuario", 99, "ese email ya existe asociado a un usuario"), HttpStatus.BAD_REQUEST);
                }
            }

            usuario.setNombre(edicionUsuario.getNombre());
            usuario.setEmail(edicionUsuario.getEmail());

            Set<Rol> roles = new HashSet<>();
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

            if (edicionUsuario.getRol().contains("admin")) {
                roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
            }

            usuario.setRoles(roles);

            //passwordEncoder.encode(nuevoUsuario.getPassword()), nuevoUsuario.getEstablecimiento());
            usuario.setEstablecimiento(edicionUsuario.getEstablecimiento());

            usuario.setCelular(edicionUsuario.getCelular());
            Optional<Cargos> car = cargosRepository.findByCodigo(edicionUsuario.getCargo());

            usuario.setId_cargo(car.get().getId());

            Optional<Sexo> sex = sexoRepository.findByCodigo(edicionUsuario.getSexo());
            usuario.setId_sexo(sex.get().getId());

            usuarioService.save(usuario);
            util.ActualizacionChanges("Usuario", usuario.getNombre(), usuario.getId(), 0);

            return new ResponseEntity(new Mensaje("Editado Satisfactoriamente", 0, "Usuario editado"), HttpStatus.OK);

        } catch (Exception e) {
            util.ActualizacionChanges("Usuario", edicionUsuario.getNombre(), 0, 2);

            return new ResponseEntity(new Mensaje("No se pudo obtener datos del usuario", 99, "Datos no encontrados"), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/Historia/{user}")
    public ResponseEntity<List<HistoryChanges>> historia(@PathVariable String user) {
        try {
            List<HistoryChanges> list = historyChangesService.Historias(user);

            List<HistoryChangesDto> ListhistoryChangesDto = new ArrayList<>();

            for (HistoryChanges historyChanges : list) {

                HistoryChangesDto historyChangesDto = new HistoryChangesDto();
                historyChangesDto.setDescripcion(historyChanges.getDescripcion());
                historyChangesDto.setFechaCreacion(String.valueOf(historyChanges.getFechaCreacion()));
                historyChangesDto.setTable(historyChanges.getTable());
                historyChangesDto.setIdAfectado(String.valueOf(historyChanges.getId()));
                historyChangesDto.setUsuario(historyChanges.getUsuario());
                ListhistoryChangesDto.add(historyChangesDto);
            }

            return new ResponseEntity(ListhistoryChangesDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
