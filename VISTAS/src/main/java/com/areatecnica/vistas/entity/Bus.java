/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bus.findAll", query = "SELECT b FROM Bus b"),
    @NamedQuery(name = "Bus.findByIdBus", query = "SELECT b FROM Bus b WHERE b.idBus = :idBus"),
    @NamedQuery(name = "Bus.findByNumeroBus", query = "SELECT b FROM Bus b WHERE b.numeroBus = :numeroBus"),
    @NamedQuery(name = "Bus.findByPatente", query = "SELECT b FROM Bus b WHERE b.patente = :patente"),
    @NamedQuery(name = "Bus.findByA\u00f1o", query = "SELECT b FROM Bus b WHERE b.a\u00f1o = :a\u00f1o"),
    @NamedQuery(name = "Bus.findByNumeroMotor", query = "SELECT b FROM Bus b WHERE b.numeroMotor = :numeroMotor"),
    @NamedQuery(name = "Bus.findByNumeroChasis", query = "SELECT b FROM Bus b WHERE b.numeroChasis = :numeroChasis"),
    @NamedQuery(name = "Bus.findByCarroceria", query = "SELECT b FROM Bus b WHERE b.carroceria = :carroceria")})
public class Bus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bus", nullable = false)
    private Integer idBus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_bus", nullable = false)
    private int numeroBus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String patente;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int año;
    @Size(max = 45)
    @Column(name = "numero_motor", length = 45)
    private String numeroMotor;
    @Size(max = 45)
    @Column(name = "numero_chasis", length = 45)
    private String numeroChasis;
    @Size(max = 45)
    @Column(length = 45)
    private String carroceria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBus")
    private List<AbonoBus> abonoBusList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBus")
    private List<CargoBus> cargoBusList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBus")
    private List<Despacho> despachoList;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa", nullable = false)
    @ManyToOne(optional = false)
    private Empresa idEmpresa;
    @JoinColumn(name = "id_flota", referencedColumnName = "id_flota", nullable = false)
    @ManyToOne(optional = false)
    private Flota idFlota;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo_marca_bus", nullable = false)
    @ManyToOne(optional = false)
    private ModeloMarcaBus idModelo;
    @JoinColumn(name = "id_terminal", referencedColumnName = "id_terminal", nullable = false)
    @ManyToOne(optional = false)
    private Terminal idTerminal;
    @JoinColumn(name = "id_unidad_negocio", referencedColumnName = "id_unidad_negocio", nullable = false)
    @ManyToOne(optional = false)
    private UnidadNegocio idUnidadNegocio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBus")
    private List<BusDevice> busDeviceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBus")
    private List<BusServicio> busServicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBus")
    private List<Guia> guiaList;

    public Bus() {
    }

    public Bus(Integer idBus) {
        this.idBus = idBus;
    }

    public Bus(Integer idBus, int numeroBus, String patente, int año) {
        this.idBus = idBus;
        this.numeroBus = numeroBus;
        this.patente = patente;
        this.año = año;
    }

    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public int getNumeroBus() {
        return numeroBus;
    }

    public void setNumeroBus(int numeroBus) {
        this.numeroBus = numeroBus;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    @XmlTransient
    public List<AbonoBus> getAbonoBusList() {
        return abonoBusList;
    }

    public void setAbonoBusList(List<AbonoBus> abonoBusList) {
        this.abonoBusList = abonoBusList;
    }

    @XmlTransient
    public List<CargoBus> getCargoBusList() {
        return cargoBusList;
    }

    public void setCargoBusList(List<CargoBus> cargoBusList) {
        this.cargoBusList = cargoBusList;
    }

    @XmlTransient
    public List<Despacho> getDespachoList() {
        return despachoList;
    }

    public void setDespachoList(List<Despacho> despachoList) {
        this.despachoList = despachoList;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Flota getIdFlota() {
        return idFlota;
    }

    public void setIdFlota(Flota idFlota) {
        this.idFlota = idFlota;
    }

    public ModeloMarcaBus getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(ModeloMarcaBus idModelo) {
        this.idModelo = idModelo;
    }

    public Terminal getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Terminal idTerminal) {
        this.idTerminal = idTerminal;
    }

    public UnidadNegocio getIdUnidadNegocio() {
        return idUnidadNegocio;
    }

    public void setIdUnidadNegocio(UnidadNegocio idUnidadNegocio) {
        this.idUnidadNegocio = idUnidadNegocio;
    }

    @XmlTransient
    public List<BusDevice> getBusDeviceList() {
        return busDeviceList;
    }

    public void setBusDeviceList(List<BusDevice> busDeviceList) {
        this.busDeviceList = busDeviceList;
    }

    @XmlTransient
    public List<BusServicio> getBusServicioList() {
        return busServicioList;
    }

    public void setBusServicioList(List<BusServicio> busServicioList) {
        this.busServicioList = busServicioList;
    }

    @XmlTransient
    public List<Guia> getGuiaList() {
        return guiaList;
    }

    public void setGuiaList(List<Guia> guiaList) {
        this.guiaList = guiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBus != null ? idBus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bus)) {
            return false;
        }
        Bus other = (Bus) object;
        if ((this.idBus == null && other.idBus != null) || (this.idBus != null && !this.idBus.equals(other.idBus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Bus[ idBus=" + idBus + " ]";
    }
    
}
