package com.crud.controller;

import com.crud.dto.AvatarDTO;
import com.crud.dto.ContrasenDto;
import com.crud.dto.DatosUsuarioDTO;
import com.crud.dto.Mensaje;
import com.crud.entity.Avatar;
import com.crud.entity.Cargos;
import com.crud.entity.Establecimientos;
import com.crud.entity.Sexo;
import com.crud.repository.CargosRepository;
import com.crud.repository.SexoRepository;
import com.crud.security.dto.JwtDto;
import com.crud.security.dto.LoginUsuario;
import com.crud.security.dto.NuevoUsuario;
import com.crud.security.entity.Rol;
import com.crud.security.entity.Usuario;
import com.crud.security.enums.RolNombre;
import com.crud.security.jwt.JwtProvider;
import com.crud.security.repository.AvatarRepository;
import com.crud.security.service.RolService;
import com.crud.security.service.UsuarioService;
import com.crud.service.EstablecimientosServices;
import com.crud.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

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
    private EstablecimientosServices establecimientosServices;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Error al Crear Usuario", 99, "Campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        }
        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
            return new ResponseEntity(new Mensaje("Error al Crear Usuario", 99, "ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (usuarioService.existsByEmail(nuevoUsuario.getEmail())) {
            return new ResponseEntity(new Mensaje("Error al Crear Usuario", 99, "ese email ya existe"), HttpStatus.BAD_REQUEST);
        }

        Avatar avatar = avatarRepository.findById(7).orElseThrow(() -> new RuntimeException("Avatar no encontrado"));

        int idCargo = cargosRepository.findByCodigo(nuevoUsuario.getCargo()).get().getId();

        int idSexo = sexoRepository.findByCodigo(nuevoUsuario.getSexo()).get().getId();

        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                passwordEncoder.encode(nuevoUsuario.getPassword()), nuevoUsuario.getEstablecimiento(), idSexo, idCargo, nuevoUsuario.getCelular(), avatar);

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if (nuevoUsuario.getRoles().contains("admin")) {
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        }
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("Creado Satisfactoriamente", 0, "Usuario creado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Error al ingresar Usuario", 99, "campos mal puestos"), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Usuario usuario = usuarioService.getByNombreUsuario(loginUsuario.getNombreUsuario());
        AvatarDTO dtoAvatar = new AvatarDTO(usuario.getAvatar().getNombre(), usuario.getAvatar().getRuta().getRuta() + usuario.getAvatar().getNombre() + usuario.getAvatar().getExtension().getExtension(), usuario.getAvatar().getDescripcion());

        Establecimientos estable = establecimientosServices.establecimiento(usuario.getEstablecimiento());
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), usuario.getNombre(), estable.getEstablecimiento(), userDetails.getAuthorities(), dtoAvatar);
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

    @PostMapping("/editar")
    public ResponseEntity<?> editar(@Valid @RequestBody DatosUsuarioDTO edicionUsuario, BindingResult bindingResult) {
        try {
            Usuario userActivo;

            userActivo = usuarioService.getByNombreUsuario(util.userActivo());
            Set<Rol> rolesActivos = userActivo.getRoles();

            if (rolesActivos.size() == 2 || (userActivo.getNombreUsuario().equals(edicionUsuario.getUsuario()))) {
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
                if (rolesActivos.size() == 2) {
                    roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
                } else {
                    return new ResponseEntity(new Mensaje("No se puede editar Rol", 99, "Solo un Administrador puede editar el Rol"), HttpStatus.BAD_GATEWAY);
                }
                usuario.setRoles(roles);

                //passwordEncoder.encode(nuevoUsuario.getPassword()), nuevoUsuario.getEstablecimiento());
                usuarioService.save(usuario);

                usuario.setEstablecimiento(edicionUsuario.getEstablecimiento());

                usuario.setCelular(edicionUsuario.getCelular());
                Optional<Cargos> car = cargosRepository.findByCodigo(edicionUsuario.getCargo());

                if (rolesActivos.size() != 2 && (!car.get().getCodigo().equalsIgnoreCase(edicionUsuario.getCargo()))) {
                    return new ResponseEntity(new Mensaje("No se puede editar Cargo", 99, "Solo un Administrador puede editar el Cargo"), HttpStatus.BAD_GATEWAY);
                }
                usuario.setId_cargo(car.get().getId());

                Optional<Sexo> sex = sexoRepository.findByCodigo(edicionUsuario.getSexo());
                usuario.setId_sexo(sex.get().getId());

                return new ResponseEntity(new Mensaje("Editado Satisfactoriamente", 0, "Usuario editado"), HttpStatus.OK);
            }
            return new ResponseEntity(new Mensaje("No se pudo obtener datos de usuario", 99, "No ha iniciado sessión"), HttpStatus.BAD_GATEWAY);

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("No se pudo obtener datos de usuario", 99, "No ha iniciado sessión"), HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/cambiarContra")
    public ResponseEntity<?> cambiarContrasena(@Valid @RequestBody ContrasenDto contrasena, BindingResult bindingResult) {
        try {
            Usuario userActivo;

            userActivo = usuarioService.getByNombreUsuario(util.userActivo());
            Set<Rol> rolesActivos = userActivo.getRoles();

            if (rolesActivos.size() == 2 || (userActivo.getNombreUsuario().equals(contrasena.getUser()))) {
                if (bindingResult.hasErrors()) {
                    return new ResponseEntity(new Mensaje("Error al cambiar contraseña", 99, "Campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
                }
                if (!contrasena.getNewpassword().equals(contrasena.getRepeatnewpassword())) {
                    return new ResponseEntity(new Mensaje("Error al cambiar contraseña", 99, "Nueva contraseña no coinciden."), HttpStatus.BAD_REQUEST);
                }
                Usuario usuario = usuarioService.getByNombreUsuario(contrasena.getUser());

                if (!passwordEncoder.matches(contrasena.getPassword(), usuario.getPassword())) {
                    return new ResponseEntity(new Mensaje("Error al cambiar contraseña", 99, "La contraseña es incorrecta."), HttpStatus.BAD_REQUEST);
                }

                if (rolesActivos.size() != 2 && !userActivo.getNombreUsuario().equals(contrasena.getUser())) {
                    return new ResponseEntity(new Mensaje("Error al cambiar contraseña", 99, "Solo un Administrador puede cambiar la contraseña."), HttpStatus.BAD_REQUEST);
                }

                usuario.setPassword(passwordEncoder.encode(contrasena.getNewpassword()));

                usuarioService.save(usuario);

                return new ResponseEntity(new Mensaje("Cambio de contraseña Satisfactoria", 0, "Contraseña actualizada"), HttpStatus.OK);
            }
            return new ResponseEntity(new Mensaje("No se pudo obtener datos de usuario", 99, "No ha iniciado sessión"), HttpStatus.BAD_GATEWAY);

        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("No se pudo obtener datos de usuario", 99, "No ha iniciado sessión"), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/health")
    public String checkHealth() {
        return "true"; // Puedes personalizar este mensaje según tus necesidades
    }

}
