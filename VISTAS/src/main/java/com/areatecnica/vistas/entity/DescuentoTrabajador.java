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
@Table(name = "descuento_trabajador", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescuentoTrabajador.findAll", query = "SELECT d FROM DescuentoTrabajador d"),
    @NamedQuery(name = "DescuentoTrabajador.findByIdDescuentoTrabajador", query = "SELECT d FROM DescuentoTrabajador d WHERE d.idDescuentoTrabajador = :idDescuentoTrabajador"),
    @NamedQuery(name = "DescuentoTrabajador.findByFechaIngreso", query = "SELECT d FROM DescuentoTrabajador d WHERE d.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "DescuentoTrabajador.findByFechaInicio", query = "SELECT d FROM DescuentoTrabajador d WHERE d.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "DescuentoTrabajador.findByNumeroCuotas", query = "SELECT d FROM DescuentoTrabajador d WHERE d.numeroCuotas = :numeroCuotas"),
    @NamedQuery(name = "DescuentoTrabajador.findByMonto", query = "SELECT d FROM DescuentoTrabajador d WHERE d.monto = :monto"),
    @NamedQuery(name = "DescuentoTrabajador.findByActivoDescuentoTrabajador", query = "SELECT d FROM DescuentoTrabajador d WHERE d.activoDescuentoTrabajador = :activoDescuentoTrabajador")})
public class DescuentoTrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_descuento_trabajador", nullable = false)
    private Integer idDescuentoTrabajador;
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
    @Column(name = "activo_descuento_trabajador", nullable = false)
    private boolean activoDescuentoTrabajador;
    @JoinColumn(name = "id_tipo_descuento", referencedColumnName = "id_tipo_descuento", nullable = false)
    @ManyToOne(optional = false)
    private TipoDescuento idTipoDescuento;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;

    public DescuentoTrabajador() {
    }

    public DescuentoTrabajador(Integer idDescuentoTrabajador) {
        this.idDescuentoTrabajador = idDescuentoTrabajador;
    }

    public DescuentoTrabajador(Integer idDescuentoTrabajador, Date fechaIngreso, Date fechaInicio, int monto, boolean activoDescuentoTrabajador) {
        this.idDescuentoTrabajador = idDescuentoTrabajador;
        this.fechaIngreso = fechaIngreso;
        this.fechaInicio = fechaInicio;
        this.monto = monto;
        this.activoDescuentoTrabajador = activoDescuentoTrabajador;
    }

    public Integer getIdDescuentoTrabajador() {
        return idDescuentoTrabajador;
    }

    public void setIdDescuentoTrabajador(Integer idDescuentoTrabajador) {
        this.idDescuentoTrabajador = idDescuentoTrabajador;
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

    public boolean getActivoDescuentoTrabajador() {
        return activoDescuentoTrabajador;
    }

    public void setActivoDescuentoTrabajador(boolean activoDescuentoTrabajador) {
        this.activoDescuentoTrabajador = activoDescuentoTrabajador;
    }

    public TipoDescuento getIdTipoDescuento() {
        return idTipoDescuento;
    }

    public void setIdTipoDescuento(TipoDescuento idTipoDescuento) {
        this.idTipoDescuento = idTipoDescuento;
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
        hash += (idDescuentoTrabajador != null ? idDescuentoTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescuentoTrabajador)) {
            return false;
        }
        DescuentoTrabajador other = (DescuentoTrabajador) object;
        if ((this.idDescuentoTrabajador == null && other.idDescuentoTrabajador != null) || (this.idDescuentoTrabajador != null && !this.idDescuentoTrabajador.equals(other.idDescuentoTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.DescuentoTrabajador[ idDescuentoTrabajador=" + idDescuentoTrabajador + " ]";
    }
    
}
