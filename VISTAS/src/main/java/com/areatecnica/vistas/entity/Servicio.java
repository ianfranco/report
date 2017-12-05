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
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s"),
    @NamedQuery(name = "Servicio.findByIdServicio", query = "SELECT s FROM Servicio s WHERE s.idServicio = :idServicio"),
    @NamedQuery(name = "Servicio.findByNumeroServicio", query = "SELECT s FROM Servicio s WHERE s.numeroServicio = :numeroServicio"),
    @NamedQuery(name = "Servicio.findByLongitud", query = "SELECT s FROM Servicio s WHERE s.longitud = :longitud"),
    @NamedQuery(name = "Servicio.findByNombreServicio", query = "SELECT s FROM Servicio s WHERE s.nombreServicio = :nombreServicio"),
    @NamedQuery(name = "Servicio.findByOrigenServicio", query = "SELECT s FROM Servicio s WHERE s.origenServicio = :origenServicio"),
    @NamedQuery(name = "Servicio.findByDestinoServicio", query = "SELECT s FROM Servicio s WHERE s.destinoServicio = :destinoServicio")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_servicio", nullable = false)
    private Integer idServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_servicio", nullable = false)
    private int numeroServicio;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int longitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_servicio", nullable = false, length = 45)
    private String nombreServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "origen_servicio", nullable = false, length = 45)
    private String origenServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "destino_servicio", nullable = false, length = 45)
    private String destinoServicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio")
    private List<CalleServicio> calleServicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio")
    private List<Despacho> despachoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio")
    private List<FrecuenciaServicio> frecuenciaServicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio")
    private List<ControlServicio> controlServicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio")
    private List<EgresoServicio> egresoServicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio")
    private List<BusServicio> busServicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio")
    private List<Guia> guiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio")
    private List<HorarioServicio> horarioServicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio")
    private List<TarifaServicio> tarifaServicioList;
    @JoinColumn(name = "id_terminal", referencedColumnName = "id_terminal", nullable = false)
    @ManyToOne(optional = false)
    private Terminal idTerminal;
    @JoinColumn(name = "id_unidad", referencedColumnName = "id_unidad_negocio", nullable = false)
    @ManyToOne(optional = false)
    private UnidadNegocio idUnidad;

    public Servicio() {
    }

    public Servicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Servicio(Integer idServicio, int numeroServicio, int longitud, String nombreServicio, String origenServicio, String destinoServicio) {
        this.idServicio = idServicio;
        this.numeroServicio = numeroServicio;
        this.longitud = longitud;
        this.nombreServicio = nombreServicio;
        this.origenServicio = origenServicio;
        this.destinoServicio = destinoServicio;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public int getNumeroServicio() {
        return numeroServicio;
    }

    public void setNumeroServicio(int numeroServicio) {
        this.numeroServicio = numeroServicio;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getOrigenServicio() {
        return origenServicio;
    }

    public void setOrigenServicio(String origenServicio) {
        this.origenServicio = origenServicio;
    }

    public String getDestinoServicio() {
        return destinoServicio;
    }

    public void setDestinoServicio(String destinoServicio) {
        this.destinoServicio = destinoServicio;
    }

    @XmlTransient
    public List<CalleServicio> getCalleServicioList() {
        return calleServicioList;
    }

    public void setCalleServicioList(List<CalleServicio> calleServicioList) {
        this.calleServicioList = calleServicioList;
    }

    @XmlTransient
    public List<Despacho> getDespachoList() {
        return despachoList;
    }

    public void setDespachoList(List<Despacho> despachoList) {
        this.despachoList = despachoList;
    }

    @XmlTransient
    public List<FrecuenciaServicio> getFrecuenciaServicioList() {
        return frecuenciaServicioList;
    }

    public void setFrecuenciaServicioList(List<FrecuenciaServicio> frecuenciaServicioList) {
        this.frecuenciaServicioList = frecuenciaServicioList;
    }

    @XmlTransient
    public List<ControlServicio> getControlServicioList() {
        return controlServicioList;
    }

    public void setControlServicioList(List<ControlServicio> controlServicioList) {
        this.controlServicioList = controlServicioList;
    }

    @XmlTransient
    public List<EgresoServicio> getEgresoServicioList() {
        return egresoServicioList;
    }

    public void setEgresoServicioList(List<EgresoServicio> egresoServicioList) {
        this.egresoServicioList = egresoServicioList;
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

    @XmlTransient
    public List<HorarioServicio> getHorarioServicioList() {
        return horarioServicioList;
    }

    public void setHorarioServicioList(List<HorarioServicio> horarioServicioList) {
        this.horarioServicioList = horarioServicioList;
    }

    @XmlTransient
    public List<TarifaServicio> getTarifaServicioList() {
        return tarifaServicioList;
    }

    public void setTarifaServicioList(List<TarifaServicio> tarifaServicioList) {
        this.tarifaServicioList = tarifaServicioList;
    }

    public Terminal getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Terminal idTerminal) {
        this.idTerminal = idTerminal;
    }

    public UnidadNegocio getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(UnidadNegocio idUnidad) {
        this.idUnidad = idUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Servicio[ idServicio=" + idServicio + " ]";
    }
    
}
