/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
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
    @NamedQuery(name = "Guia.findAll", query = "SELECT g FROM Guia g"),
    @NamedQuery(name = "Guia.findByIdGuia", query = "SELECT g FROM Guia g WHERE g.idGuia = :idGuia"),
    @NamedQuery(name = "Guia.findByFolio", query = "SELECT g FROM Guia g WHERE g.folio = :folio"),
    @NamedQuery(name = "Guia.findByFechaRecaudacion", query = "SELECT g FROM Guia g WHERE g.fechaRecaudacion = :fechaRecaudacion"),
    @NamedQuery(name = "Guia.findByFecha", query = "SELECT g FROM Guia g WHERE g.fecha = :fecha"),
    @NamedQuery(name = "Guia.findByTotalIngresos", query = "SELECT g FROM Guia g WHERE g.totalIngresos = :totalIngresos"),
    @NamedQuery(name = "Guia.findByTotalEgresos", query = "SELECT g FROM Guia g WHERE g.totalEgresos = :totalEgresos"),
    @NamedQuery(name = "Guia.findByViajeEspecial", query = "SELECT g FROM Guia g WHERE g.viajeEspecial = :viajeEspecial"),
    @NamedQuery(name = "Guia.findByOtrosIngresos", query = "SELECT g FROM Guia g WHERE g.otrosIngresos = :otrosIngresos"),
    @NamedQuery(name = "Guia.findBySaldo", query = "SELECT g FROM Guia g WHERE g.saldo = :saldo"),
    @NamedQuery(name = "Guia.findByNumeroVueltas", query = "SELECT g FROM Guia g WHERE g.numeroVueltas = :numeroVueltas"),
    @NamedQuery(name = "Guia.findByTurno", query = "SELECT g FROM Guia g WHERE g.turno = :turno"),
    @NamedQuery(name = "Guia.findByObservacion", query = "SELECT g FROM Guia g WHERE g.observacion = :observacion"),
    @NamedQuery(name = "Guia.findByRecaudada", query = "SELECT g FROM Guia g WHERE g.recaudada = :recaudada")})
public class Guia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_guia", nullable = false)
    private Integer idGuia;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int folio;
    @Column(name = "fecha_recaudacion")
    @Temporal(TemporalType.DATE)
    private Date fechaRecaudacion;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "total_ingresos")
    private Integer totalIngresos;
    @Column(name = "total_egresos")
    private Integer totalEgresos;
    @Column(name = "viaje_especial")
    private Integer viajeEspecial;
    @Column(name = "otros_ingresos")
    private Integer otrosIngresos;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int saldo;
    @Column(name = "numero_vueltas")
    private Integer numeroVueltas;
    private Integer turno;
    @Size(max = 100)
    @Column(length = 100)
    private String observacion;
    private Boolean recaudada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGuia")
    private List<SerieBoletoGuia> serieBoletoGuiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGuia")
    private List<VentaBoletoGuia> ventaBoletoGuiaList;
    @JoinColumn(name = "id_bus", referencedColumnName = "id_bus", nullable = false)
    @ManyToOne(optional = false)
    private Bus idBus;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado_guia", nullable = false)
    @ManyToOne(optional = false)
    private EstadoGuia idEstado;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", nullable = false)
    @ManyToOne(optional = false)
    private Servicio idServicio;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGuia")
    private List<EgresoGuia> egresoGuiaList;

    public Guia() {
    }

    public Guia(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public Guia(Integer idGuia, int folio, Date fecha, int saldo) {
        this.idGuia = idGuia;
        this.folio = folio;
        this.fecha = fecha;
        this.saldo = saldo;
    }

    public Integer getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public Date getFechaRecaudacion() {
        return fechaRecaudacion;
    }

    public void setFechaRecaudacion(Date fechaRecaudacion) {
        this.fechaRecaudacion = fechaRecaudacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(Integer totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public Integer getTotalEgresos() {
        return totalEgresos;
    }

    public void setTotalEgresos(Integer totalEgresos) {
        this.totalEgresos = totalEgresos;
    }

    public Integer getViajeEspecial() {
        return viajeEspecial;
    }

    public void setViajeEspecial(Integer viajeEspecial) {
        this.viajeEspecial = viajeEspecial;
    }

    public Integer getOtrosIngresos() {
        return otrosIngresos;
    }

    public void setOtrosIngresos(Integer otrosIngresos) {
        this.otrosIngresos = otrosIngresos;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Integer getNumeroVueltas() {
        return numeroVueltas;
    }

    public void setNumeroVueltas(Integer numeroVueltas) {
        this.numeroVueltas = numeroVueltas;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getRecaudada() {
        return recaudada;
    }

    public void setRecaudada(Boolean recaudada) {
        this.recaudada = recaudada;
    }

    @XmlTransient
    public List<SerieBoletoGuia> getSerieBoletoGuiaList() {
        return serieBoletoGuiaList;
    }

    public void setSerieBoletoGuiaList(List<SerieBoletoGuia> serieBoletoGuiaList) {
        this.serieBoletoGuiaList = serieBoletoGuiaList;
    }

    @XmlTransient
    public List<VentaBoletoGuia> getVentaBoletoGuiaList() {
        return ventaBoletoGuiaList;
    }

    public void setVentaBoletoGuiaList(List<VentaBoletoGuia> ventaBoletoGuiaList) {
        this.ventaBoletoGuiaList = ventaBoletoGuiaList;
    }

    public Bus getIdBus() {
        return idBus;
    }

    public void setIdBus(Bus idBus) {
        this.idBus = idBus;
    }

    public EstadoGuia getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoGuia idEstado) {
        this.idEstado = idEstado;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public Trabajador getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Trabajador idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @XmlTransient
    public List<EgresoGuia> getEgresoGuiaList() {
        return egresoGuiaList;
    }

    public void setEgresoGuiaList(List<EgresoGuia> egresoGuiaList) {
        this.egresoGuiaList = egresoGuiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGuia != null ? idGuia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guia)) {
            return false;
        }
        Guia other = (Guia) object;
        if ((this.idGuia == null && other.idGuia != null) || (this.idGuia != null && !this.idGuia.equals(other.idGuia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Guia[ idGuia=" + idGuia + " ]";
    }
    
}
