
package com.crud.entity;

import static com.crud.util.constants.Expediente;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author silvae
 */
public class DatosPrincipalesImplicados {

    @ManyToOne
    @JoinColumn(name = "datos_principles_id")
    private DatosPrincipales datosPrincipales;

    @ManyToOne
    @JoinColumn(name = "implicados_id")
    private Implicado implicado;

}
