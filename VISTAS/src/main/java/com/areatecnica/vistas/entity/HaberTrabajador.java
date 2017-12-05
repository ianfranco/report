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
@Table(name = "haber_trabajador", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HaberTrabajador.findAll", query = "SELECT h FROM HaberTrabajador h"),
    @NamedQuery(name = "HaberTrabajador.findByIdHaberTrabajador", query = "SELECT h FROM HaberTrabajador h WHERE h.idHaberTrabajador = :idHaberTrabajador"),
    @NamedQuery(name = "HaberTrabajador.findByFechaIngreso", query = "SELECT h FROM HaberTrabajador h WHERE h.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "HaberTrabajador.findByFechaInicio", query = "SELECT h FROM HaberTrabajador h WHERE h.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "HaberTrabajador.findByNumeroCuotas", query = "SELECT h FROM HaberTrabajador h WHERE h.numeroCuotas = :numeroCuotas"),
    @NamedQuery(name = "HaberTrabajador.findByMonto", query = "SELECT h FROM HaberTrabajador h WHERE h.monto = :monto"),
    @NamedQuery(name = "HaberTrabajador.findByActivoHaberTrabajador", query = "SELECT h FROM HaberTrabajador h WHERE h.activoHaberTrabajador = :activoHaberTrabajador")})
public class HaberTrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_haber_trabajador", nullable = false)
    private Integer idHaberTrabajador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "numero_cuotas")
    private Integer numeroCuotas;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo_haber_trabajador", nullable = false)
    private boolean activoHaberTrabajador;
    @JoinColumn(name = "id_tipo_haber", referencedColumnName = "id_tipo_haber", nullable = false)
    @ManyToOne(optional = false)
    private TipoHaber idTipoHaber;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;

    public HaberTrabajador() {
    }

    public HaberTrabajador(Integer idHaberTrabajador) {
        this.idHaberTrabajador = idHaberTrabajador;
    }

    public HaberTrabajador(Integer idHaberTrabajador, Date fechaIngreso, Date fechaInicio, int monto, boolean activoHaberTrabajador) {
        this.idHaberTrabajador = idHaberTrabajador;
        this.fechaIngreso = fechaIngreso;
        this.fechaInicio = fechaInicio;
        this.monto = monto;
        this.activoHaberTrabajador = activoHaberTrabajador;
    }

    public Integer getIdHaberTrabajador() {
        return idHaberTrabajador;
    }

    public void setIdHaberTrabajador(Integer idHaberTrabajador) {
        this.idHaberTrabajador = idHaberTrabajador;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(Integer numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public boolean getActivoHaberTrabajador() {
        return activoHaberTrabajador;
    }

    public void setActivoHaberTrabajador(boolean activoHaberTrabajador) {
        this.activoHaberTrabajador = activoHaberTrabajador;
    }

    public TipoHaber getIdTipoHaber() {
        return idTipoHaber;
    }

    public void setIdTipoHaber(TipoHaber idTipoHaber) {
        this.idTipoHaber = idTipoHaber;
    }

    public Trabajador getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Trabajador idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHaberTrabajador != null ? idHaberTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HaberTrabajador)) {
            return false;
        }
        HaberTrabajador other = (HaberTrabajador) object;
        if ((this.idHaberTrabajador == null && other.idHaberTrabajador != null) || (this.idHaberTrabajador != null && !this.idHaberTrabajador.equals(other.idHaberTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.HaberTrabajador[ idHaberTrabajador=" + idHaberTrabajador + " ]";
    }
    
}
