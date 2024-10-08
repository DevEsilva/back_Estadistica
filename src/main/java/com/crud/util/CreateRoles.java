package com.crud.util;

import com.crud.entity.Avatar;
import com.crud.entity.Cargos;
import com.crud.entity.Extension;
import com.crud.entity.Rutas;
import com.crud.entity.Sexo;
import com.crud.security.entity.Rol;
import com.crud.security.enums.RolNombre;
import com.crud.security.service.AvatarService;
import com.crud.security.service.ExtensionService;
import com.crud.security.service.RolService;
import com.crud.security.service.RutasService;
import com.crud.service.CargosService;
import com.crud.service.SexoService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO IMPORTAR
 * ESTABLECIMIENTOS DESDE OTRA BASE DE DATOS CON DBEAVER
 */
@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Autowired
    AvatarService avatarService;

    @Autowired
    RutasService rutasService;

    @Autowired
    ExtensionService extensionService;

    @Autowired
    SexoService sexoService;

    @Autowired
    CargosService cargosService;

    @Override
    public void run(String... args) throws Exception {
        /*Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);

        Rutas rutaAvatars = new Rutas("../assets/Avatars/", "Avatars", 0, new Date());
        rutasService.save(rutaAvatars);

        Extension png = new Extension(".png", 0, "png", new Date());
        Extension jpe = new Extension(".jpg", 0, "jpg", new Date());
        Extension web = new Extension(".webp", 0, "web", new Date());
        extensionService.save(web);
        extensionService.save(jpe);
        extensionService.save(png);
        //  rutaAvatars = rutasService.ruta(rutaAvatars.getNombre());

        Cargos c = new Cargos("ADM", "ADMINISTRADOR", 1);
        Cargos cMJ = new Cargos("MDCJ", "MEDICO JEFÉ", 2);
        Cargos cM = new Cargos("MDC", "MEDICO", 3);

        cargosService.save(c);
        cargosService.save(cMJ);
        cargosService.save(cM);

        Sexo sM = new Sexo("M", "MASCULINO");
        Sexo sF = new Sexo("F", "FEMENINO");

        sexoService.save(sM);
        sexoService.save(sF);

        Avatar avatargey = new Avatar("gey", rutaAvatars, png, 0, "Sin Genero", new Date());
        Avatar avatarSenorMale = new Avatar("SenorMale", rutaAvatars, web, 0, "Señor", new Date());
        Avatar JovenFamele = new Avatar("JovenFamele", rutaAvatars, png, 0, "Joven", new Date());
        Avatar MorenaFamele = new Avatar("MorenaFamele", rutaAvatars, png, 0, "Morena", new Date());
        Avatar MorenoMale = new Avatar("MorenoMale", rutaAvatars, png, 0, "Moreno", new Date());
        Avatar RamdonFamele = new Avatar("RamdonFamele", rutaAvatars, png, 0, "Mujer", new Date());
        Avatar RamdonMale = new Avatar("RamdonMale", rutaAvatars, png, 0, "Hombre", new Date());
        Avatar SenoraFamele = new Avatar("SenoraFamele", rutaAvatars, png, 0, "Señora", new Date());

        avatarService.save(avatargey);
        avatarService.save(avatarSenorMale);
        avatarService.save(JovenFamele);
        avatarService.save(MorenaFamele);
        avatarService.save(MorenoMale);
        avatarService.save(RamdonFamele);
        avatarService.save(RamdonMale);
        avatarService.save(SenoraFamele);*/

    }
}
