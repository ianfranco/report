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
@Table(name = "cargo_bus", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CargoBus.findAll", query = "SELECT c FROM CargoBus c"),
    @NamedQuery(name = "CargoBus.findByIdCargoBus", query = "SELECT c FROM CargoBus c WHERE c.idCargoBus = :idCargoBus"),
    @NamedQuery(name = "CargoBus.findByFechaIngresoCargoBus", query = "SELECT c FROM CargoBus c WHERE c.fechaIngresoCargoBus = :fechaIngresoCargoBus"),
    @NamedQuery(name = "CargoBus.findByFechaInicioCargoBus", query = "SELECT c FROM CargoBus c WHERE c.fechaInicioCargoBus = :fechaInicioCargoBus"),
    @NamedQuery(name = "CargoBus.findByNumeroCuotasCargoBus", query = "SELECT c FROM CargoBus c WHERE c.numeroCuotasCargoBus = :numeroCuotasCargoBus"),
    @NamedQuery(name = "CargoBus.findByMontoCargoBus", query = "SELECT c FROM CargoBus c WHERE c.montoCargoBus = :montoCargoBus"),
    @NamedQuery(name = "CargoBus.findByActivoCargoBus", query = "SELECT c FROM CargoBus c WHERE c.activoCargoBus = :activoCargoBus")})
public class CargoBus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cargo_bus", nullable = false)
    private Integer idCargoBus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso_cargo_bus", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoCargoBus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio_cargo_bus", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicioCargoBus;
    @Column(name = "numero_cuotas_cargo_bus")
    private Integer numeroCuotasCargoBus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_cargo_bus", nullable = false)
    private int montoCargoBus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo_cargo_bus", nullable = false)
    private boolean activoCargoBus;
    @JoinColumn(name = "id_bus", referencedColumnName = "id_bus", nullable = false)
    @ManyToOne(optional = false)
    private Bus idBus;
    @JoinColumn(name = "id_tipo_cargo", referencedColumnName = "id_tipo_cargo", nullable = false)
    @ManyToOne(optional = false)
    private TipoCargo idTipoCargo;

    public CargoBus() {
    }

    public CargoBus(Integer idCargoBus) {
        this.idCargoBus = idCargoBus;
    }

    public CargoBus(Integer idCargoBus, Date fechaIngresoCargoBus, Date fechaInicioCargoBus, int montoCargoBus, boolean activoCargoBus) {
        this.idCargoBus = idCargoBus;
        this.fechaIngresoCargoBus = fechaIngresoCargoBus;
        this.fechaInicioCargoBus = fechaInicioCargoBus;
        this.montoCargoBus = montoCargoBus;
        this.activoCargoBus = activoCargoBus;
    }

    public Integer getIdCargoBus() {
        return idCargoBus;
    }

    public void setIdCargoBus(Integer idCargoBus) {
        this.idCargoBus = idCargoBus;
    }

    public Date getFechaIngresoCargoBus() {
        return fechaIngresoCargoBus;
    }

    public void setFechaIngresoCargoBus(Date fechaIngresoCargoBus) {
        this.fechaIngresoCargoBus = fechaIngresoCargoBus;
    }

    public Date getFechaInicioCargoBus() {
        return fechaInicioCargoBus;
    }

    public void setFechaInicioCargoBus(Date fechaInicioCargoBus) {
        this.fechaInicioCargoBus = fechaInicioCargoBus;
    }

    public Integer getNumeroCuotasCargoBus() {
        return numeroCuotasCargoBus;
    }

    public void setNumeroCuotasCargoBus(Integer numeroCuotasCargoBus) {
        this.numeroCuotasCargoBus = numeroCuotasCargoBus;
    }

    public int getMontoCargoBus() {
        return montoCargoBus;
    }

    public void setMontoCargoBus(int montoCargoBus) {
        this.montoCargoBus = montoCargoBus;
    }

    public boolean getActivoCargoBus() {
        return activoCargoBus;
    }

    public void setActivoCargoBus(boolean activoCargoBus) {
        this.activoCargoBus = activoCargoBus;
    }

    public Bus getIdBus() {
        return idBus;
    }

    public void setIdBus(Bus idBus) {
        this.idBus = idBus;
    }

    public TipoCargo getIdTipoCargo() {
        return idTipoCargo;
    }

    public void setIdTipoCargo(TipoCargo idTipoCargo) {
        this.idTipoCargo = idTipoCargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargoBus != null ? idCargoBus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargoBus)) {
            return false;
        }
        CargoBus other = (CargoBus) object;
        if ((this.idCargoBus == null && other.idCargoBus != null) || (this.idCargoBus != null && !this.idCargoBus.equals(other.idCargoBus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.CargoBus[ idCargoBus=" + idCargoBus + " ]";
    }
    
}
