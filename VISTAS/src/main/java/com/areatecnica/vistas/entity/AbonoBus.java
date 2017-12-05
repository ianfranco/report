/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "abono_bus", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AbonoBus.findAll", query = "SELECT a FROM AbonoBus a"),
    @NamedQuery(name = "AbonoBus.findByIdAbonoBus", query = "SELECT a FROM AbonoBus a WHERE a.idAbonoBus = :idAbonoBus"),
    @NamedQuery(name = "AbonoBus.findByFechaIngresoAbonoBus", query = "SELECT a FROM AbonoBus a WHERE a.fechaIngresoAbonoBus = :fechaIngresoAbonoBus"),
    @NamedQuery(name = "AbonoBus.findByFechaInicioAbonoBus", query = "SELECT a FROM AbonoBus a WHERE a.fechaInicioAbonoBus = :fechaInicioAbonoBus"),
    @NamedQuery(name = "AbonoBus.findByNumeroCuotasAbonoBus", query = "SELECT a FROM AbonoBus a WHERE a.numeroCuotasAbonoBus = :numeroCuotasAbonoBus"),
    @NamedQuery(name = "AbonoBus.findByMontoAbonoBus", query = "SELECT a FROM AbonoBus a WHERE a.montoAbonoBus = :montoAbonoBus"),
    @NamedQuery(name = "AbonoBus.findByActivoAbonoBus", query = "SELECT a FROM AbonoBus a WHERE a.activoAbonoBus = :activoAbonoBus")})
public class AbonoBus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_abono_bus", nullable = false)
    private Integer idAbonoBus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso_abono_bus", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoAbonoBus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio_abono_bus", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicioAbonoBus;
    @Column(name = "numero_cuotas_abono_bus")
    private Integer numeroCuotasAbonoBus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_abono_bus", nullable = false)
    private int montoAbonoBus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo_abono_bus", nullable = false)
    private boolean activoAbonoBus;
    @JoinColumn(name = "id_bus", referencedColumnName = "id_bus", nullable = false)
    @ManyToOne(optional = false)
    private Bus idBus;
    @JoinColumn(name = "id_tipo_abono", referencedColumnName = "id_tipo_abono", nullable = false)
    @ManyToOne(optional = false)
    private TipoAbono idTipoAbono;

    public AbonoBus() {
    }

    public AbonoBus(Integer idAbonoBus) {
        this.idAbonoBus = idAbonoBus;
    }

    public AbonoBus(Integer idAbonoBus, Date fechaIngresoAbonoBus, Date fechaInicioAbonoBus, int montoAbonoBus, boolean activoAbonoBus) {
        this.idAbonoBus = idAbonoBus;
        this.fechaIngresoAbonoBus = fechaIngresoAbonoBus;
        this.fechaInicioAbonoBus = fechaInicioAbonoBus;
        this.montoAbonoBus = montoAbonoBus;
        this.activoAbonoBus = activoAbonoBus;
    }

    public Integer getIdAbonoBus() {
        return idAbonoBus;
    }

    public void setIdAbonoBus(Integer idAbonoBus) {
        this.idAbonoBus = idAbonoBus;
    }

    public Date getFechaIngresoAbonoBus() {
        return fechaIngresoAbonoBus;
    }

    public void setFechaIngresoAbonoBus(Date fechaIngresoAbonoBus) {
        this.fechaIngresoAbonoBus = fechaIngresoAbonoBus;
    }

    public Date getFechaInicioAbonoBus() {
        return fechaInicioAbonoBus;
    }

    public void setFechaInicioAbonoBus(Date fechaInicioAbonoBus) {
        this.fechaInicioAbonoBus = fechaInicioAbonoBus;
    }

    public Integer getNumeroCuotasAbonoBus() {
        return numeroCuotasAbonoBus;
    }

    public void setNumeroCuotasAbonoBus(Integer numeroCuotasAbonoBus) {
        this.numeroCuotasAbonoBus = numeroCuotasAbonoBus;
    }

    public int getMontoAbonoBus() {
        return montoAbonoBus;
    }

    public void setMontoAbonoBus(int montoAbonoBus) {
        this.montoAbonoBus = montoAbonoBus;
    }

    public boolean getActivoAbonoBus() {
        return activoAbonoBus;
    }

    public void setActivoAbonoBus(boolean activoAbonoBus) {
        this.activoAbonoBus = activoAbonoBus;
    }

    public Bus getIdBus() {
        return idBus;
    }

    public void setIdBus(Bus idBus) {
        this.idBus = idBus;
    }

    public TipoAbono getIdTipoAbono() {
        return idTipoAbono;
    }

    public void setIdTipoAbono(TipoAbono idTipoAbono) {
        this.idTipoAbono = idTipoAbono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAbonoBus != null ? idAbonoBus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AbonoBus)) {
            return false;
        }
        AbonoBus other = (AbonoBus) object;
        if ((this.idAbonoBus == null && other.idAbonoBus != null) || (this.idAbonoBus != null && !this.idAbonoBus.equals(other.idAbonoBus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.AbonoBus[ idAbonoBus=" + idAbonoBus + " ]";
    }
    
}
