package com.crud.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author silvae
 */
@Entity
@Table(name = "DatosPrincipales")
public class DatosPrincipales implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private String Expediente;
    private String anio;
    private String Codigo_Integridad;
    private String Area;
    private String Casos_Recibidos;
    private String Asunto_Materia;
    @ManyToMany
    @JoinTable(
            name = "datos_principales_implicados",
            joinColumns = @JoinColumn(name = "datos_principales_id"),
            inverseJoinColumns = @JoinColumn(name = "implicados_id")
    )
    private List<Implicado> implicados;
    @Temporal(TemporalType.DATE)
    private Date Fecha_Hechos;
    @Temporal(TemporalType.DATE)
    private Date Fecha_Conocimiento_RH;
    @Temporal(TemporalType.DATE)
    private Date Fecha_Recep_Stapad;
    @Temporal(TemporalType.DATE)
    private Date Fecha_Prescr_IniciarPad;
    private String Rec_Impug;
    private String Estado_Actual;
    @ManyToOne
    private Stpad Stpad;
    @ManyToOne
    private OrgInstructor OrgInstructor;
    @ManyToOne
    private OrgSancionador OrgSancionador;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_ActualizacionDatos;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_CreacionDatos;
    private int Activo;
    private String create_notification;
    private String libre2;

    public DatosPrincipales() {
    }

    public DatosPrincipales(int id, String Expediente, String anio, String Codigo_Integridad, String Area, String Casos_Recibidos, String Asunto_Materia, List<Implicado> implicados, Date Fecha_Hechos, Date Fecha_Conocimiento_RH, Date Fecha_Recep_Stapad, Date Fecha_Prescr_IniciarPad, String Rec_Impug, String Estado_Actual, Stpad Stpad, OrgInstructor OrgInstructor, OrgSancionador OrgSancionador, Date Fecha_ActualizacionDatos, Date Fecha_CreacionDatos, int Activo, String create_notification, String libre2) {
        this.id = id;
        this.Expediente = Expediente;
        this.anio = anio;
        this.Codigo_Integridad = Codigo_Integridad;
        this.Area = Area;
        this.Casos_Recibidos = Casos_Recibidos;
        this.Asunto_Materia = Asunto_Materia;
        this.implicados = implicados;
        this.Fecha_Hechos = Fecha_Hechos;
        this.Fecha_Conocimiento_RH = Fecha_Conocimiento_RH;
        this.Fecha_Recep_Stapad = Fecha_Recep_Stapad;
        this.Fecha_Prescr_IniciarPad = Fecha_Prescr_IniciarPad;
        this.Rec_Impug = Rec_Impug;
        this.Estado_Actual = Estado_Actual;
        this.Stpad = Stpad;
        this.OrgInstructor = OrgInstructor;
        this.OrgSancionador = OrgSancionador;
        this.Fecha_ActualizacionDatos = Fecha_ActualizacionDatos;
        this.Fecha_CreacionDatos = Fecha_CreacionDatos;
        this.Activo = Activo;
        this.create_notification = create_notification;
        this.libre2 = libre2;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpediente() {
        return Expediente;
    }

    public void setExpediente(String Expediente) {
        this.Expediente = Expediente;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getCodigo_Integridad() {
        return Codigo_Integridad;
    }

    public void setCodigo_Integridad(String Codigo_Integridad) {
        this.Codigo_Integridad = Codigo_Integridad;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getCasos_Recibidos() {
        return Casos_Recibidos;
    }

    public void setCasos_Recibidos(String Casos_Recibidos) {
        this.Casos_Recibidos = Casos_Recibidos;
    }

    public String getAsunto_Materia() {
        return Asunto_Materia;
    }

    public void setAsunto_Materia(String Asunto_Materia) {
        this.Asunto_Materia = Asunto_Materia;
    }

    public List<Implicado> getImplicados() {
        return implicados;
    }

    public void setImplicados(List<Implicado> implicados) {
        this.implicados = implicados;
    }

    public Date getFecha_Hechos() {
        return Fecha_Hechos;
    }

    public void setFecha_Hechos(Date Fecha_Hechos) {
        this.Fecha_Hechos = Fecha_Hechos;
    }

    public Date getFecha_Conocimiento_RH() {
        return Fecha_Conocimiento_RH;
    }

    public void setFecha_Conocimiento_RH(Date Fecha_Conocimiento_RH) {
        this.Fecha_Conocimiento_RH = Fecha_Conocimiento_RH;
    }

    public Date getFecha_Recep_Stapad() {
        return Fecha_Recep_Stapad;
    }

    public void setFecha_Recep_Stapad(Date Fecha_Recep_Stapad) {
        this.Fecha_Recep_Stapad = Fecha_Recep_Stapad;
    }

    public Date getFecha_Prescr_IniciarPad() {
        return Fecha_Prescr_IniciarPad;
    }

    public void setFecha_Prescr_IniciarPad(Date Fecha_Prescr_IniciarPad) {
        this.Fecha_Prescr_IniciarPad = Fecha_Prescr_IniciarPad;
    }

    public String getRec_Impug() {
        return Rec_Impug;
    }

    public void setRec_Impug(String Rec_Impug) {
        this.Rec_Impug = Rec_Impug;
    }

    public String getEstado_Actual() {
        return Estado_Actual;
    }

    public void setEstado_Actual(String Estado_Actual) {
        this.Estado_Actual = Estado_Actual;
    }

    public Stpad getStpad() {
        return Stpad;
    }

    public void setStpad(Stpad Stpad) {
        this.Stpad = Stpad;
    }

    public OrgInstructor getOrgInstructor() {
        return OrgInstructor;
    }

    public void setOrgInstructor(OrgInstructor OrgInstructor) {
        this.OrgInstructor = OrgInstructor;
    }

    public OrgSancionador getOrgSancionador() {
        return OrgSancionador;
    }

    public void setOrgSancionador(OrgSancionador OrgSancionador) {
        this.OrgSancionador = OrgSancionador;
    }

    public Date getFecha_ActualizacionDatos() {
        return Fecha_ActualizacionDatos;
    }

    public void setFecha_ActualizacionDatos(Date Fecha_ActualizacionDatos) {
        this.Fecha_ActualizacionDatos = Fecha_ActualizacionDatos;
    }

    public Date getFecha_CreacionDatos() {
        return Fecha_CreacionDatos;
    }

    public void setFecha_CreacionDatos(Date Fecha_CreacionDatos) {
        this.Fecha_CreacionDatos = Fecha_CreacionDatos;
    }

    public int getActivo() {
        return Activo;
    }

    public void setActivo(int Activo) {
        this.Activo = Activo;
    }

    public String getCreate_notification() {
        return create_notification;
    }

    public void setCreate_notification(String create_notification) {
        this.create_notification = create_notification;
    }

    public String getLibre2() {
        return libre2;
    }

    public void setLibre2(String libre2) {
        this.libre2 = libre2;
    }

}
