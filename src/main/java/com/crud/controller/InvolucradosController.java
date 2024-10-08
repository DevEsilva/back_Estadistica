package com.crud.controller;

import com.crud.dto.ImplicadoDTO;
import com.crud.dto.Mensaje;
import com.crud.entity.Implicado;
import com.crud.service.HistoryChangesService;
import com.crud.service.ImplicadoService;
import com.crud.util.Utils;
import com.crud.util.constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author silvae
 */
@RestController
@RequestMapping("/" + constants.Involucrados)
@Api(tags = constants.Involucrados, description = "Metodos")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class InvolucradosController {

    private final SimpleDateFormat dateFormat2 = new SimpleDateFormat(constants.fecha_hora);

    @Autowired
    private Utils util;

    @Autowired
    private ImplicadoService implicadoService;

    @Autowired
    private HistoryChangesService changesService;

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    @ApiOperation("Creacion de Involucrados")
    public ResponseEntity<?> create(@RequestBody ImplicadoDTO implicadoDTO) {
        try {
            String date = dateFormat2.format(new Date());
            if (!implicadoService.ExitenciaDni(implicadoDTO.getNumeroDocumentoIdentidad())) {
                Implicado impli = new Implicado();
                impli.setFecha_Creacion(dateFormat2.parse(date));
                impli.setNombre_Completo(implicadoDTO.getNombreCompleto());
                impli.setTipo_DocIdent(implicadoDTO.getTipoDocumentoIdentidad());
                impli.setNumDocIdent(implicadoDTO.getNumeroDocumentoIdentidad());
                impli.setTelefono(implicadoDTO.getTelefono());
                impli.setObservacion(implicadoDTO.getObservacion());
                impli.setActivo(0);
                implicadoService.save(impli);

                int implicadoId = impli.getId();

                util.SaveChanges(constants.SeCreo + " " + constants.Involucrado + " " + impli.getNumDocIdent(), new Date(), implicadoId, util.userActivo(), constants.implicado);
                return new ResponseEntity(new Mensaje(constants.SeCreo + " " + constants.Involucrado, 0, constants.CreacionCorrecta + " " + implicadoDTO.getNombreCompleto()), HttpStatus.OK);
            } else {
                util.SaveChanges(constants.Intento_Creacion + " " + constants.Involucrado + implicadoDTO.getNumeroDocumentoIdentidad(), new Date(), 0, util.userActivo(), constants.implicado);
                return new ResponseEntity(new Mensaje(constants.NoSePuede_Crear + " " + constants.Involucrado, 99, constants.Ya_existe + " " + constants.Involucrado), HttpStatus.BAD_REQUEST);
            }
        } catch (ParseException e) {
            util.SaveChanges(constants.Excepcion_Crear + " " + constants.Involucrado + ": " + e.getMessage(), new Date(), 0, util.userActivo(), constants.implicado);
            return new ResponseEntity(new Mensaje(constants.Involucrado + " " + constants.No_Creado, 99, constants.Excepcion + " : " + e.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ImplicadoDTO>> list() {
        try {
            List<Implicado> list = implicadoService.list();
            List<ImplicadoDTO> listFinal = new ArrayList<>();

            list.stream().map((implicado) -> {
                ImplicadoDTO implicadoDto = new ImplicadoDTO();
                implicadoDto.setNombreCompleto(implicado.getNombre_Completo());
                implicadoDto.setNumeroDocumentoIdentidad(implicado.getNumDocIdent());
                implicadoDto.setTelefono(implicado.getTelefono());
                implicadoDto.setTipoDocumentoIdentidad(implicado.getTipo_DocIdent());
                implicadoDto.setObservacion(implicado.getObservacion());
                return implicadoDto;
            }).forEachOrdered((implicadoDto) -> {
                listFinal.add(implicadoDto);
            });
            return new ResponseEntity(listFinal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/involucrado/{dni}")
    public ResponseEntity<ImplicadoDTO> involucradoId(@PathVariable("dni") String dni, HttpServletRequest request) {
        try {
            Implicado involucrado = implicadoService.obtenerImplicados(dni);
            if (involucrado == null) {
                return new ResponseEntity(new Mensaje(constants.ErrorAl_Buscar + " " + constants.Involucrado, 99, constants.No_existe + " " + constants.Involucrado), HttpStatus.NOT_FOUND);
            }
            ImplicadoDTO InvolucradoFinal = new ImplicadoDTO();
            InvolucradoFinal.setNombreCompleto(involucrado.getNombre_Completo());
            InvolucradoFinal.setNumeroDocumentoIdentidad(involucrado.getNumDocIdent());
            InvolucradoFinal.setTelefono(involucrado.getTelefono());
            InvolucradoFinal.setTipoDocumentoIdentidad(involucrado.getTipo_DocIdent());
            InvolucradoFinal.setObservacion(involucrado.getObservacion());

            return new ResponseEntity(InvolucradoFinal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje(constants.Excepcion_Buscar + " " + constants.Involucrado, 0, constants.Excepcion + " " + e.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @PutMapping("/Eliminar/{dni}")
    @ApiOperation("Desactiva el involucrado")
    public ResponseEntity<?> DeleteInvolucrado(@PathVariable("dni") String dni, HttpServletRequest request) {
        try {
            Implicado implicado;
            implicado = implicadoService.getImplicado(dni, 0);
            if (implicado == null) {
                util.SaveChanges(constants.Intento_Eliminacion + " " + constants.Involucrado + " " + dni, new Date(), 0, util.userActivo() + " con ip: " + util.obtenip(request), constants.implicado);
                return new ResponseEntity(new Mensaje(constants.ErrorAl_Eliminar + " " + constants.Involucrado, 99, constants.No_existe + " " + constants.Involucrado), HttpStatus.NOT_FOUND);
            }
            List<String> count = implicadoService.getCountImplicado(implicado.getId());
            if (count.size() > 0) {
                String expediente = "";
                expediente = count.stream().map((valor) -> valor + "-").reduce(expediente, String::concat);

                if (expediente.endsWith("-")) {
                    // Remover el último carácter si es un guion
                    expediente = expediente.substring(0, expediente.length() - 1);
                }
                util.SaveChanges(constants.Intento_Eliminacion + " " + constants.Involucrado + " " + dni, new Date(), implicado.getId(), util.userActivo() + " con ip: " + util.obtenip(request), constants.implicado);
                return new ResponseEntity(new Mensaje(constants.ErrorAl_Eliminar + " " + constants.Involucrado, 99, constants.NoSePuede_Eliminar + " " + constants.Involucrado + "  por que existe referencia con " + constants.Expediente + ": " + expediente), HttpStatus.NOT_FOUND
                );
            }
            //   String date = dateFormat2.format(new Date());
            implicado.setFecha_Actualizacion(new Date());
            implicado.setActivo(1);
            implicadoService.save(implicado);

            util.SaveChanges(constants.SeCreo + " " + constants.Involucrado, new Date(), implicado.getId(), util.userActivo() + " con ip: " + util.obtenip(request), constants.implicado);
            return new ResponseEntity(new Mensaje(constants.EliminacionCorrecta, 0, constants.SeElimino + " " + constants.Involucrado), HttpStatus.OK);
        } catch (Exception e) {
            util.SaveChanges(constants.Excepcion_Eliminar + " " + constants.Involucrado + ": " + e.getMessage(), new Date(), 0, util.userActivo() + " con ip: " + util.obtenip(request), constants.implicado);
            return new ResponseEntity(new Mensaje(constants.Excepcion_Eliminar + " " + constants.Involucrado, 0, constants.Excepcion + " " + e.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/edit")
    @ApiOperation("Edición de Involucrados")
    public ResponseEntity<?> edit(@RequestBody ImplicadoDTO implicadoDTO) {
        try {
            String date = dateFormat2.format(new Date());
            Implicado impli = implicadoService.getImplicado(implicadoDTO.getNumeroDocumentoIdentidad(), 0);
            if (impli != null) {
                impli.setFecha_Actualizacion(dateFormat2.parse(date));
                impli.setNombre_Completo(implicadoDTO.getNombreCompleto());
                impli.setTipo_DocIdent(implicadoDTO.getTipoDocumentoIdentidad());
                impli.setNumDocIdent(implicadoDTO.getNumeroDocumentoIdentidad());
                impli.setTelefono(implicadoDTO.getTelefono());
                impli.setObservacion(implicadoDTO.getObservacion());
                implicadoService.save(impli);

                int implicadoId = impli.getId();

                util.SaveChanges(constants.SeActualizo + " " + constants.Involucrado + " " + impli.getNumDocIdent(),  new Date(), implicadoId, util.userActivo(), constants.implicado);
                return new ResponseEntity(new Mensaje(constants.SeActualizo + " " + constants.Involucrado, 0, constants.ActualizacionCorrecta + " " + implicadoDTO.getNombreCompleto()), HttpStatus.OK);
            } else {
                util.SaveChanges(constants.Intento_Actualizacion + " " + constants.Involucrado, new Date(), 0, util.userActivo(), constants.implicado);
                return new ResponseEntity(new Mensaje(constants.NoSePuede_Actualizar + " " + constants.Involucrado, 99, constants.No_existe + " " + constants.Involucrado), HttpStatus.BAD_REQUEST);
            }
        } catch (ParseException e) {
            util.SaveChanges(constants.Excepcion_Actualizar + " " + constants.Involucrado + ": " + e.getMessage(), new Date(), 0, util.userActivo(), constants.implicado);
            return new ResponseEntity(new Mensaje(constants.Involucrado + " " + constants.No_Actualizado, 99, constants.Excepcion + " : " + e.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    /*
    private void SaveChanges(String descripcion, Date fecha, int idTable, String user, String table) {
        try {
            HistoryChanges hc = new HistoryChanges();
            hc.setActivo(1);
            hc.setDescripcion(descripcion);
            hc.setFechaCreacion(fecha);
            hc.setIdTable(idTable);
            hc.setTable(table);
            hc.setUsuario(user);
            changesService.save(hc);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public String userActivo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return username;
    }

    public String obtenip(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress != null && !ipAddress.isEmpty()) {
            ipAddress = ipAddress.split(",")[0].trim();
        } else {
            // Si el encabezado X-Forwarded-For está vacío o no está presente, obtén la dirección IP remota del cliente
            // Esto es útil si la solicitud no ha pasado por un proxy o un balanceador de carga
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }

     */
}
