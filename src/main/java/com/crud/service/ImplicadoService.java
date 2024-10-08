package com.crud.service;

import com.crud.entity.Implicado;
import com.crud.repository.ImplicadosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author silvae
 */
@Service
@Transactional
public class ImplicadoService {

    @Autowired
    ImplicadosRepository implicadosRepository;

    public Implicado obtenerImplicados(String numDoc) {
        return implicadosRepository.ImplicadoporNumDoc(numDoc,0);
    }

    public Implicado save(Implicado implicado) {
        return implicadosRepository.save(implicado);
    }

    public boolean ExitenciaDni(String dni) {
        return implicadosRepository.existsBynumDocIdentAndActivo(dni, 0);
    }

    public List<Implicado> list() {
        return implicadosRepository.findAllByActivo(0);
    }

    public Implicado getImplicado(String dni, int state) {
        return implicadosRepository.findByNumDocIdentAndActivo(dni, state);
    }

    public List<String> getCountImplicado(int id) {
        return implicadosRepository.countIdImplicado(id);
    }
}
