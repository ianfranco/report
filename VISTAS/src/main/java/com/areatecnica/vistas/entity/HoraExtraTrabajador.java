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
@Table(name = "hora_extra_trabajador", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoraExtraTrabajador.findAll", query = "SELECT h FROM HoraExtraTrabajador h"),
    @NamedQuery(name = "HoraExtraTrabajador.findByIdHorasExtrasTrabajador", query = "SELECT h FROM HoraExtraTrabajador h WHERE h.idHorasExtrasTrabajador = :idHorasExtrasTrabajador"),
    @NamedQuery(name = "HoraExtraTrabajador.findByCantidad", query = "SELECT h FROM HoraExtraTrabajador h WHERE h.cantidad = :cantidad"),
    @NamedQuery(name = "HoraExtraTrabajador.findByFecha", query = "SELECT h FROM HoraExtraTrabajador h WHERE h.fecha = :fecha")})
public class HoraExtraTrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_horas_extras_trabajador", nullable = false)
    private Integer idHorasExtrasTrabajador;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int cantidad;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;

    public HoraExtraTrabajador() {
    }

    public HoraExtraTrabajador(Integer idHorasExtrasTrabajador) {
        this.idHorasExtrasTrabajador = idHorasExtrasTrabajador;
    }

    public HoraExtraTrabajador(Integer idHorasExtrasTrabajador, int cantidad) {
        this.idHorasExtrasTrabajador = idHorasExtrasTrabajador;
        this.cantidad = cantidad;
    }

    public Integer getIdHorasExtrasTrabajador() {
        return idHorasExtrasTrabajador;
    }

    public void setIdHorasExtrasTrabajador(Integer idHorasExtrasTrabajador) {
        this.idHorasExtrasTrabajador = idHorasExtrasTrabajador;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (idHorasExtrasTrabajador != null ? idHorasExtrasTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoraExtraTrabajador)) {
            return false;
        }
        HoraExtraTrabajador other = (HoraExtraTrabajador) object;
        if ((this.idHorasExtrasTrabajador == null && other.idHorasExtrasTrabajador != null) || (this.idHorasExtrasTrabajador != null && !this.idHorasExtrasTrabajador.equals(other.idHorasExtrasTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.HoraExtraTrabajador[ idHorasExtrasTrabajador=" + idHorasExtrasTrabajador + " ]";
    }
    
}
