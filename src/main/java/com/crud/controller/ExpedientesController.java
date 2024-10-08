package com.crud.controller;

import com.crud.Vista.DatosExpedientesV;
import com.crud.dto.DatosPrincipaleDTO;
import com.crud.dto.ImplicadoDTO;
import com.crud.dto.Mensaje;
import com.crud.dto.NotificacionesDTO;
import com.crud.entity.DatosPrincipales;
import com.crud.entity.Implicado;
import com.crud.entity.OrgInstructor;
import com.crud.entity.OrgSancionador;
import com.crud.entity.Stpad;
import com.crud.service.ExpedienteService;
import com.crud.service.ImplicadoService;
import com.crud.service.OrgInstructorService;
import com.crud.service.OrgSancionadorService;
import com.crud.service.StpadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author silvae
 */
@RestController
@RequestMapping("/Expediente")
@Api(tags = "Expedientes", description = "Metodos")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class ExpedientesController {

    @Autowired
    private ExpedienteService expedienteService;

    @Autowired
    private ImplicadoService implicadoService;

    @Autowired
    private StpadService stpadService;

    @Autowired
    private OrgInstructorService instructorService;

    @Autowired
    private OrgSancionadorService orgSancionadorService;

    private final String pattern = "dd-mm-yyyy";

    private final SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

    private final String pattern2 = "dd-mm-yyyy HH:mm:ss";

    private final SimpleDateFormat dateFormat2 = new SimpleDateFormat(pattern2);

    @GetMapping("/lista")
    public ResponseEntity<List<DatosExpedientesV>> list() {
        try {
            List<DatosExpedientesV> list = expedienteService.obtenerListadoDocs();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/notificaciones")
    public ResponseEntity<List<NotificacionesDTO>> notificaciones() {
        try {
            List<NotificacionesDTO> list = expedienteService.notificaciones();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    @ApiOperation("Creacion de Expedientes")
    public ResponseEntity<?> create(@RequestBody DatosPrincipaleDTO datosPrincipaleDTO) {
        DatosPrincipales datosPrincipa = null;

        try {
            if (StringUtils.isBlank(datosPrincipaleDTO.getExpediente())) {
                return new ResponseEntity(new Mensaje("Error al guardar Expediente", 99, "Expediente no valido."), HttpStatus.BAD_REQUEST);
            } else if (datosPrincipaleDTO.getImplicados() == null) {
                return new ResponseEntity(new Mensaje("Error al guardar expediente", 99, "Implicado no valido 2."), HttpStatus.BAD_REQUEST);
            } else {
                int ExisteDatos = expedienteService.validaExpedienteExist(datosPrincipaleDTO.getExpediente(), 0);
                if (ExisteDatos > 0) {
                    return new ResponseEntity(new Mensaje("Expediente no creado", 0, "Expediente: " + datosPrincipaleDTO.getExpediente() + ", Ya existe Expediente: " + datosPrincipaleDTO.getExpediente()), HttpStatus.BAD_REQUEST);
                } else {

                    String date = dateFormat2.format(new Date());
                    datosPrincipa = new DatosPrincipales();
                    datosPrincipa.setExpediente(datosPrincipaleDTO.getExpediente());
                    datosPrincipa.setAnio(datosPrincipaleDTO.getAnio());
                    datosPrincipa.setCodigo_Integridad(datosPrincipaleDTO.getCodigo_Integridad());
                    datosPrincipa.setArea(datosPrincipaleDTO.getArea());
                    datosPrincipa.setCasos_Recibidos(datosPrincipaleDTO.getCasos_Recibidos());
                    datosPrincipa.setAsunto_Materia(datosPrincipaleDTO.getAsunto_Materia());
                    datosPrincipa.setActivo(0);
                    /*Implicados*/
                    List<Implicado> Ilistimpli = new ArrayList<>();
                    Implicado impli;
                    for (ImplicadoDTO implicad : datosPrincipaleDTO.getImplicados()) {

                        impli = implicadoService.getImplicado(implicad.getNumeroDocumentoIdentidad(), 0);


                        /* impli.setFecha_Creacion(dateFormat2.parse(date));
                        impli.setNombre_Completo(implicad.getNombreCompleto());
                        impli.setTipo_DocIdent(implicad.getTipoDocumentoIdentidad());
                        impli.setNumDocIdent(implicad.getNumeroDocumentoIdentidad());
                        impli.setTelefono(implicad.getTelefono());
                        impli.setObservacion(implicad.getObservacion());
                        impli.setActivo(1);
                       
                         implicadoService.save(impli);*/
                         Ilistimpli.add(impli);
                    }

                    datosPrincipa.setImplicados(Ilistimpli);

                    if (datosPrincipaleDTO.getFecha_Hechos() != null) {
                        datosPrincipa.setFecha_Hechos(dateFormat.parse(datosPrincipaleDTO.getFecha_Hechos()));
                    }
                    if (datosPrincipaleDTO.getFecha_Conocimiento_RH() != null) {
                        datosPrincipa.setFecha_Conocimiento_RH(dateFormat.parse(datosPrincipaleDTO.getFecha_Conocimiento_RH()));
                    }
                    if (datosPrincipaleDTO.getFecha_Recep_Stapad() != null) {
                        datosPrincipa.setFecha_Recep_Stapad(dateFormat.parse(datosPrincipaleDTO.getFecha_Recep_Stapad()));
                    }
                    if (datosPrincipaleDTO.getFecha_Prescr_IniciarPad() != null) {
                        datosPrincipa.setFecha_Prescr_IniciarPad(dateFormat.parse(datosPrincipaleDTO.getFecha_Prescr_IniciarPad()));
                    }

                    datosPrincipa.setRec_Impug(datosPrincipaleDTO.getRec_Impug());
                    datosPrincipa.setEstado_Actual(datosPrincipaleDTO.getEstado_Actual());

                    if (datosPrincipaleDTO.getStpad() != null ) {
                        Stpad stpad = new Stpad();
                        stpad.setInfor_PrecaN(datosPrincipaleDTO.getStpad().getInfor_PrecaN());
                        stpad.setFecha(dateFormat.parse(datosPrincipaleDTO.getStpad().getFecha()));
                        stpad.setSancPropta(datosPrincipaleDTO.getStpad().getSancPropta());
                        stpad.setObservacion(datosPrincipaleDTO.getStpad().getObservacion());
                        stpad.setFecha_Creacion(dateFormat2.parse(date));
                        stpad.setActivo(0);
                        stpadService.guardar(stpad);
                        datosPrincipa.setStpad(stpad);
                    }

                    if (datosPrincipaleDTO.getOrgInstructor() != null) {
                        OrgInstructor orgInstr = new OrgInstructor();
                        orgInstr.setArea(datosPrincipaleDTO.getOrgInstructor().getArea());
                        orgInstr.setCarta_InicioPad(datosPrincipaleDTO.getOrgInstructor().getCarta_InicioPad());
                        orgInstr.setFecha_Notificacion_InicioPad(dateFormat.parse(datosPrincipaleDTO.getOrgInstructor().getFecha_Notificacion_InicioPad()));
                        orgInstr.setFecha_PresRIPCAnio(dateFormat.parse(datosPrincipaleDTO.getOrgInstructor().getFecha_PresRIPCAnio()));
                        orgInstr.setFecha_InformeFinal(dateFormat.parse(datosPrincipaleDTO.getOrgInstructor().getFecha_InformeFinal()));
                        orgInstr.setSancion_Propuesta(datosPrincipaleDTO.getOrgInstructor().getSancion_Propuesta());
                        //orgInstr.setFecha_Actualizacion(Fecha_Actualizacion);
                        orgInstr.setObservacion(datosPrincipaleDTO.getOrgInstructor().getObservacion());
                        orgInstr.setFecha_Creacion(dateFormat2.parse(date));
                        orgInstr.setActivo(0);
                        instructorService.guardar(orgInstr);
                        datosPrincipa.setOrgInstructor(orgInstr);
                    }
                    if (datosPrincipaleDTO.getOrgSancionador() != null) {
                        OrgSancionador orgSan = new OrgSancionador();
                        orgSan.setFecha_Notifi_Iniciofs(dateFormat.parse(datosPrincipaleDTO.getOrgSancionador().getFecha_Notifi_Iniciofs()));
                        orgSan.setFecha_InformeOral(dateFormat.parse(datosPrincipaleDTO.getOrgSancionador().getFecha_InformeOral()));
                        orgSan.setNum_Resolucion_Sanc(datosPrincipaleDTO.getOrgSancionador().getNum_Resolucion_Sanc());
                        orgSan.setDecision(datosPrincipaleDTO.getOrgSancionador().getDecision());
                        orgSan.setFecha_Notific_Resolucion(dateFormat.parse(datosPrincipaleDTO.getOrgSancionador().getFecha_Notific_Resolucion()));
                        orgSan.setFecha_Creacion(dateFormat2.parse(date));
                        orgSan.setActivo(0);
                        orgSan.setObservacion(datosPrincipaleDTO.getOrgSancionador().getObservacion());
                        orgSancionadorService.guardar(orgSan);

                        datosPrincipa.setOrgSancionador(orgSan);
                    }

                    expedienteService.guardarDocs(datosPrincipa);
                    return new ResponseEntity(new Mensaje("Expediente creado", 0, "Expediente: " + datosPrincipaleDTO.getExpediente()), HttpStatus.OK);
                }
            }
        } catch (ParseException e) {
            return new ResponseEntity(new Mensaje("Expediente no Creado", 0, "Expediente: " + datosPrincipaleDTO.getExpediente() + " " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
