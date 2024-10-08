package com.crud.service;

import com.crud.Vista.DatosImplicadosV;
import com.crud.Vista.DatosExpedientesV;
import com.crud.dto.NotificacionesDTO;
import com.crud.entity.DatosPrincipales;
import com.crud.repository.DatosInvolucradosRepositoryVista;
import com.crud.repository.DatosPrincipalesRepositoryVista;
import com.crud.repository.ExpedientesRepository;
import com.crud.repository.NotificacionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author silvae
 */
@Service
@Transactional
public class ExpedienteService {

    @Autowired
    ExpedientesRepository expedientesRepository;

    @Autowired
    DatosInvolucradosRepositoryVista datosInvolucradosRepositoryVista;
    
    @Autowired
    NotificacionesRepository notificacionesRepository;

    @Autowired
    DatosPrincipalesRepositoryVista datosPrincipalesRepositoryVista;

    public List<DatosExpedientesV> obtenerListadoDocs() {
        List<DatosExpedientesV> Listdpv = datosPrincipalesRepositoryVista.ConsultaDatosPrincpales(0);
        for (DatosExpedientesV datosPrincipalesV : Listdpv) {
            List<DatosImplicadosV> ListImp = datosInvolucradosRepositoryVista.ConsultaDatosImplicados(datosPrincipalesV.getId());
            datosPrincipalesV.setImplicados(ListImp);     
        }
        return Listdpv;
    }

    public DatosPrincipales guardarDocs(DatosPrincipales datosPrincipales) {
        return expedientesRepository.save(datosPrincipales);
    }

    public int validaExpedienteExist(String Expediente, int estado) {
        return expedientesRepository.existeExpediente(Expediente, estado);
    }

    public List<NotificacionesDTO> notificaciones() {
        return notificacionesRepository.Notificaciones(0);
    }

}
