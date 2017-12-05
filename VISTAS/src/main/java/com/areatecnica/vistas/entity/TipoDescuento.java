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
@Table(name = "tipo_descuento", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDescuento.findAll", query = "SELECT t FROM TipoDescuento t"),
    @NamedQuery(name = "TipoDescuento.findByIdTipoDescuento", query = "SELECT t FROM TipoDescuento t WHERE t.idTipoDescuento = :idTipoDescuento"),
    @NamedQuery(name = "TipoDescuento.findByNombreTipoDescuento", query = "SELECT t FROM TipoDescuento t WHERE t.nombreTipoDescuento = :nombreTipoDescuento"),
    @NamedQuery(name = "TipoDescuento.findByFechaIngreso", query = "SELECT t FROM TipoDescuento t WHERE t.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "TipoDescuento.findByMontoDefecto", query = "SELECT t FROM TipoDescuento t WHERE t.montoDefecto = :montoDefecto")})
public class TipoDescuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_descuento", nullable = false)
    private Integer idTipoDescuento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_tipo_descuento", nullable = false, length = 255)
    private String nombreTipoDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "monto_defecto")
    private Integer montoDefecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDescuento")
    private List<DescuentoTrabajador> descuentoTrabajadorList;

    public TipoDescuento() {
    }

    public TipoDescuento(Integer idTipoDescuento) {
        this.idTipoDescuento = idTipoDescuento;
    }

    public TipoDescuento(Integer idTipoDescuento, String nombreTipoDescuento, Date fechaIngreso) {
        this.idTipoDescuento = idTipoDescuento;
        this.nombreTipoDescuento = nombreTipoDescuento;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdTipoDescuento() {
        return idTipoDescuento;
    }

    public void setIdTipoDescuento(Integer idTipoDescuento) {
        this.idTipoDescuento = idTipoDescuento;
    }

    public String getNombreTipoDescuento() {
        return nombreTipoDescuento;
    }

    public void setNombreTipoDescuento(String nombreTipoDescuento) {
        this.nombreTipoDescuento = nombreTipoDescuento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getMontoDefecto() {
        return montoDefecto;
    }

    public void setMontoDefecto(Integer montoDefecto) {
        this.montoDefecto = montoDefecto;
    }

    @XmlTransient
    public List<DescuentoTrabajador> getDescuentoTrabajadorList() {
        return descuentoTrabajadorList;
    }

    public void setDescuentoTrabajadorList(List<DescuentoTrabajador> descuentoTrabajadorList) {
        this.descuentoTrabajadorList = descuentoTrabajadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDescuento != null ? idTipoDescuento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDescuento)) {
            return false;
        }
        TipoDescuento other = (TipoDescuento) object;
        if ((this.idTipoDescuento == null && other.idTipoDescuento != null) || (this.idTipoDescuento != null && !this.idTipoDescuento.equals(other.idTipoDescuento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TipoDescuento[ idTipoDescuento=" + idTipoDescuento + " ]";
    }
    
}
