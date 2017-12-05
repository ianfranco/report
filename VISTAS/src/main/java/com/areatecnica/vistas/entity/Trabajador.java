/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(catalog = "sigf_v1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"rut_trabajador"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t"),
    @NamedQuery(name = "Trabajador.findByIdTrabajador", query = "SELECT t FROM Trabajador t WHERE t.idTrabajador = :idTrabajador"),
    @NamedQuery(name = "Trabajador.findByRutTrabajador", query = "SELECT t FROM Trabajador t WHERE t.rutTrabajador = :rutTrabajador"),
    @NamedQuery(name = "Trabajador.findByNombreTrabajador", query = "SELECT t FROM Trabajador t WHERE t.nombreTrabajador = :nombreTrabajador"),
    @NamedQuery(name = "Trabajador.findByApellidoPaternoTrabajador", query = "SELECT t FROM Trabajador t WHERE t.apellidoPaternoTrabajador = :apellidoPaternoTrabajador"),
    @NamedQuery(name = "Trabajador.findByApellidoMaternoTrabajador", query = "SELECT t FROM Trabajador t WHERE t.apellidoMaternoTrabajador = :apellidoMaternoTrabajador"),
    @NamedQuery(name = "Trabajador.findByFechaNacimientoTrabajador", query = "SELECT t FROM Trabajador t WHERE t.fechaNacimientoTrabajador = :fechaNacimientoTrabajador"),
    @NamedQuery(name = "Trabajador.findByNacionalidad", query = "SELECT t FROM Trabajador t WHERE t.nacionalidad = :nacionalidad"),
    @NamedQuery(name = "Trabajador.findBySexo", query = "SELECT t FROM Trabajador t WHERE t.sexo = :sexo"),
    @NamedQuery(name = "Trabajador.findByDireccionTrabajador", query = "SELECT t FROM Trabajador t WHERE t.direccionTrabajador = :direccionTrabajador"),
    @NamedQuery(name = "Trabajador.findByTelefonoFijoTrabajador", query = "SELECT t FROM Trabajador t WHERE t.telefonoFijoTrabajador = :telefonoFijoTrabajador"),
    @NamedQuery(name = "Trabajador.findByCelularTrabajador", query = "SELECT t FROM Trabajador t WHERE t.celularTrabajador = :celularTrabajador"),
    @NamedQuery(name = "Trabajador.findByEmailTrabajador", query = "SELECT t FROM Trabajador t WHERE t.emailTrabajador = :emailTrabajador"),
    @NamedQuery(name = "Trabajador.findByNumeroCargas", query = "SELECT t FROM Trabajador t WHERE t.numeroCargas = :numeroCargas"),
    @NamedQuery(name = "Trabajador.findByMontoSalud", query = "SELECT t FROM Trabajador t WHERE t.montoSalud = :montoSalud"),
    @NamedQuery(name = "Trabajador.findByFormaPagoApv", query = "SELECT t FROM Trabajador t WHERE t.formaPagoApv = :formaPagoApv"),
    @NamedQuery(name = "Trabajador.findBySubsidioJoven", query = "SELECT t FROM Trabajador t WHERE t.subsidioJoven = :subsidioJoven")})
public class Trabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trabajador", nullable = false)
    private Integer idTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "rut_trabajador", nullable = false, length = 9)
    private String rutTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_trabajador", nullable = false, length = 255)
    private String nombreTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "apellido_paterno_trabajador", nullable = false, length = 255)
    private String apellidoPaternoTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "apellido_materno_trabajador", nullable = false, length = 255)
    private String apellidoMaternoTrabajador;
    @Column(name = "fecha_nacimiento_trabajador")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimientoTrabajador;
    private Boolean nacionalidad;
    private Boolean sexo;
    @Size(max = 255)
    @Column(name = "direccion_trabajador", length = 255)
    private String direccionTrabajador;
    @Size(max = 255)
    @Column(name = "telefono_fijo_trabajador", length = 255)
    private String telefonoFijoTrabajador;
    @Size(max = 255)
    @Column(name = "celular_trabajador", length = 255)
    private String celularTrabajador;
    @Size(max = 255)
    @Column(name = "email_trabajador", length = 255)
    private String emailTrabajador;
    @Column(name = "numero_cargas")
    private Integer numeroCargas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_salud", precision = 6, scale = 2)
    private BigDecimal montoSalud;
    @Column(name = "forma_pago_apv")
    private Boolean formaPagoApv;
    @Column(name = "subsidio_joven")
    private Boolean subsidioJoven;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<HaberTrabajador> haberTrabajadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<AnticipoTrabajador> anticipoTrabajadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<Despacho> despachoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<SindicatoTrabajador> sindicatoTrabajadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<DiaTrabajador> diaTrabajadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<CargasTrabajador> cargasTrabajadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<CentroCostoTrabajador> centroCostoTrabajadorList;
    @JoinColumn(name = "id_institucion_apv", referencedColumnName = "id_institucion_apv", nullable = false)
    @ManyToOne(optional = false)
    private InstitucionApv idInstitucionApv;
    @JoinColumn(name = "id_asignacion_familiar", referencedColumnName = "id_asignacion_familiar", nullable = false)
    @ManyToOne(optional = false)
    private AsignacionFamiliar idAsignacionFamiliar;
    @JoinColumn(name = "id_tipo_cotizacion_trabajador", referencedColumnName = "id_tipo_cotizacion_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private TipoCotizacionTrabajador idTipoCotizacionTrabajador;
    @JoinColumn(name = "id_moneda_pactada_salud", referencedColumnName = "id_moneda_salud", nullable = false)
    @ManyToOne(optional = false)
    private MonedaPactadaInstitucionSalud idMonedaPactadaSalud;
    @JoinColumn(name = "id_institucion_prevision", referencedColumnName = "id_institucion_prevision", nullable = false)
    @ManyToOne(optional = false)
    private InstitucionPrevision idInstitucionPrevision;
    @JoinColumn(name = "id_institucion_salud", referencedColumnName = "id_institucion_salud", nullable = false)
    @ManyToOne(optional = false)
    private InstitucionSalud idInstitucionSalud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<RelacionLaboral> relacionLaboralList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<CargaRetroactiva> cargaRetroactivaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<HoraExtraTrabajador> horaExtraTrabajadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<DescuentoTrabajador> descuentoTrabajadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<Guia> guiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<ObservacionTrabajador> observacionTrabajadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajador")
    private List<TrabajadorTerminal> trabajadorTerminalList;

    public Trabajador() {
    }

    public Trabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Trabajador(Integer idTrabajador, String rutTrabajador, String nombreTrabajador, String apellidoPaternoTrabajador, String apellidoMaternoTrabajador) {
        this.idTrabajador = idTrabajador;
        this.rutTrabajador = rutTrabajador;
        this.nombreTrabajador = nombreTrabajador;
        this.apellidoPaternoTrabajador = apellidoPaternoTrabajador;
        this.apellidoMaternoTrabajador = apellidoMaternoTrabajador;
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getRutTrabajador() {
        return rutTrabajador;
    }

    public void setRutTrabajador(String rutTrabajador) {
        this.rutTrabajador = rutTrabajador;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getApellidoPaternoTrabajador() {
        return apellidoPaternoTrabajador;
    }

    public void setApellidoPaternoTrabajador(String apellidoPaternoTrabajador) {
        this.apellidoPaternoTrabajador = apellidoPaternoTrabajador;
    }

    public String getApellidoMaternoTrabajador() {
        return apellidoMaternoTrabajador;
    }

    public void setApellidoMaternoTrabajador(String apellidoMaternoTrabajador) {
        this.apellidoMaternoTrabajador = apellidoMaternoTrabajador;
    }

    public Date getFechaNacimientoTrabajador() {
        return fechaNacimientoTrabajador;
    }

    public void setFechaNacimientoTrabajador(Date fechaNacimientoTrabajador) {
        this.fechaNacimientoTrabajador = fechaNacimientoTrabajador;
    }

    public Boolean getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Boolean nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    public String getDireccionTrabajador() {
        return direccionTrabajador;
    }

    public void setDireccionTrabajador(String direccionTrabajador) {
        this.direccionTrabajador = direccionTrabajador;
    }

    public String getTelefonoFijoTrabajador() {
        return telefonoFijoTrabajador;
    }

    public void setTelefonoFijoTrabajador(String telefonoFijoTrabajador) {
        this.telefonoFijoTrabajador = telefonoFijoTrabajador;
    }

    public String getCelularTrabajador() {
        return celularTrabajador;
    }

    public void setCelularTrabajador(String celularTrabajador) {
        this.celularTrabajador = celularTrabajador;
    }

    public String getEmailTrabajador() {
        return emailTrabajador;
    }

    public void setEmailTrabajador(String emailTrabajador) {
        this.emailTrabajador = emailTrabajador;
    }

    public Integer getNumeroCargas() {
        return numeroCargas;
    }

    public void setNumeroCargas(Integer numeroCargas) {
        this.numeroCargas = numeroCargas;
    }

    public BigDecimal getMontoSalud() {
        return montoSalud;
    }

    public void setMontoSalud(BigDecimal montoSalud) {
        this.montoSalud = montoSalud;
    }

    public Boolean getFormaPagoApv() {
        return formaPagoApv;
    }

    public void setFormaPagoApv(Boolean formaPagoApv) {
        this.formaPagoApv = formaPagoApv;
    }

    public Boolean getSubsidioJoven() {
        return subsidioJoven;
    }

    public void setSubsidioJoven(Boolean subsidioJoven) {
        this.subsidioJoven = subsidioJoven;
    }

    @XmlTransient
    public List<HaberTrabajador> getHaberTrabajadorList() {
        return haberTrabajadorList;
    }

    public void setHaberTrabajadorList(List<HaberTrabajador> haberTrabajadorList) {
        this.haberTrabajadorList = haberTrabajadorList;
    }

    @XmlTransient
    public List<AnticipoTrabajador> getAnticipoTrabajadorList() {
        return anticipoTrabajadorList;
    }

    public void setAnticipoTrabajadorList(List<AnticipoTrabajador> anticipoTrabajadorList) {
        this.anticipoTrabajadorList = anticipoTrabajadorList;
    }

    @XmlTransient
    public List<Despacho> getDespachoList() {
        return despachoList;
    }

    public void setDespachoList(List<Despacho> despachoList) {
        this.despachoList = despachoList;
    }

    @XmlTransient
    public List<SindicatoTrabajador> getSindicatoTrabajadorList() {
        return sindicatoTrabajadorList;
    }

    public void setSindicatoTrabajadorList(List<SindicatoTrabajador> sindicatoTrabajadorList) {
        this.sindicatoTrabajadorList = sindicatoTrabajadorList;
    }

    @XmlTransient
    public List<DiaTrabajador> getDiaTrabajadorList() {
        return diaTrabajadorList;
    }

    public void setDiaTrabajadorList(List<DiaTrabajador> diaTrabajadorList) {
        this.diaTrabajadorList = diaTrabajadorList;
    }

    @XmlTransient
    public List<CargasTrabajador> getCargasTrabajadorList() {
        return cargasTrabajadorList;
    }

    public void setCargasTrabajadorList(List<CargasTrabajador> cargasTrabajadorList) {
        this.cargasTrabajadorList = cargasTrabajadorList;
    }

    @XmlTransient
    public List<CentroCostoTrabajador> getCentroCostoTrabajadorList() {
        return centroCostoTrabajadorList;
    }

    public void setCentroCostoTrabajadorList(List<CentroCostoTrabajador> centroCostoTrabajadorList) {
        this.centroCostoTrabajadorList = centroCostoTrabajadorList;
    }

    public InstitucionApv getIdInstitucionApv() {
        return idInstitucionApv;
    }

    public void setIdInstitucionApv(InstitucionApv idInstitucionApv) {
        this.idInstitucionApv = idInstitucionApv;
    }

    public AsignacionFamiliar getIdAsignacionFamiliar() {
        return idAsignacionFamiliar;
    }

    public void setIdAsignacionFamiliar(AsignacionFamiliar idAsignacionFamiliar) {
        this.idAsignacionFamiliar = idAsignacionFamiliar;
    }

    public TipoCotizacionTrabajador getIdTipoCotizacionTrabajador() {
        return idTipoCotizacionTrabajador;
    }

    public void setIdTipoCotizacionTrabajador(TipoCotizacionTrabajador idTipoCotizacionTrabajador) {
        this.idTipoCotizacionTrabajador = idTipoCotizacionTrabajador;
    }

    public MonedaPactadaInstitucionSalud getIdMonedaPactadaSalud() {
        return idMonedaPactadaSalud;
    }

    public void setIdMonedaPactadaSalud(MonedaPactadaInstitucionSalud idMonedaPactadaSalud) {
        this.idMonedaPactadaSalud = idMonedaPactadaSalud;
    }

    public InstitucionPrevision getIdInstitucionPrevision() {
        return idInstitucionPrevision;
    }

    public void setIdInstitucionPrevision(InstitucionPrevision idInstitucionPrevision) {
        this.idInstitucionPrevision = idInstitucionPrevision;
    }

    public InstitucionSalud getIdInstitucionSalud() {
        return idInstitucionSalud;
    }

    public void setIdInstitucionSalud(InstitucionSalud idInstitucionSalud) {
        this.idInstitucionSalud = idInstitucionSalud;
    }

    @XmlTransient
    public List<RelacionLaboral> getRelacionLaboralList() {
        return relacionLaboralList;
    }

    public void setRelacionLaboralList(List<RelacionLaboral> relacionLaboralList) {
        this.relacionLaboralList = relacionLaboralList;
    }

    @XmlTransient
    public List<CargaRetroactiva> getCargaRetroactivaList() {
        return cargaRetroactivaList;
    }

    public void setCargaRetroactivaList(List<CargaRetroactiva> cargaRetroactivaList) {
        this.cargaRetroactivaList = cargaRetroactivaList;
    }

    @XmlTransient
    public List<HoraExtraTrabajador> getHoraExtraTrabajadorList() {
        return horaExtraTrabajadorList;
    }

    public void setHoraExtraTrabajadorList(List<HoraExtraTrabajador> horaExtraTrabajadorList) {
        this.horaExtraTrabajadorList = horaExtraTrabajadorList;
    }

    @XmlTransient
    public List<DescuentoTrabajador> getDescuentoTrabajadorList() {
        return descuentoTrabajadorList;
    }

    public void setDescuentoTrabajadorList(List<DescuentoTrabajador> descuentoTrabajadorList) {
        this.descuentoTrabajadorList = descuentoTrabajadorList;
    }

    @XmlTransient
    public List<Guia> getGuiaList() {
        return guiaList;
    }

    public void setGuiaList(List<Guia> guiaList) {
        this.guiaList = guiaList;
    }

    @XmlTransient
    public List<ObservacionTrabajador> getObservacionTrabajadorList() {
        return observacionTrabajadorList;
    }

    public void setObservacionTrabajadorList(List<ObservacionTrabajador> observacionTrabajadorList) {
        this.observacionTrabajadorList = observacionTrabajadorList;
    }

    @XmlTransient
    public List<TrabajadorTerminal> getTrabajadorTerminalList() {
        return trabajadorTerminalList;
    }

    public void setTrabajadorTerminalList(List<TrabajadorTerminal> trabajadorTerminalList) {
        this.trabajadorTerminalList = trabajadorTerminalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrabajador != null ? idTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.idTrabajador == null && other.idTrabajador != null) || (this.idTrabajador != null && !this.idTrabajador.equals(other.idTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Trabajador[ idTrabajador=" + idTrabajador + " ]";
    }
    
}
