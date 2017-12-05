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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "tipo_cotizacion_trabajador", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCotizacionTrabajador.findAll", query = "SELECT t FROM TipoCotizacionTrabajador t"),
    @NamedQuery(name = "TipoCotizacionTrabajador.findByIdTipoCotizacionTrabajador", query = "SELECT t FROM TipoCotizacionTrabajador t WHERE t.idTipoCotizacionTrabajador = :idTipoCotizacionTrabajador"),
    @NamedQuery(name = "TipoCotizacionTrabajador.findByNombreTipoCotizacionTrabajador", query = "SELECT t FROM TipoCotizacionTrabajador t WHERE t.nombreTipoCotizacionTrabajador = :nombreTipoCotizacionTrabajador")})
public class TipoCotizacionTrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_cotizacion_trabajador", nullable = false)
    private Integer idTipoCotizacionTrabajador;
    @Size(max = 100)
    @Column(name = "nombre_tipo_cotizacion_trabajador", length = 100)
    private String nombreTipoCotizacionTrabajador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCotizacionTrabajador")
    private List<Trabajador> trabajadorList;

    public TipoCotizacionTrabajador() {
    }

    public TipoCotizacionTrabajador(Integer idTipoCotizacionTrabajador) {
        this.idTipoCotizacionTrabajador = idTipoCotizacionTrabajador;
    }

    public Integer getIdTipoCotizacionTrabajador() {
        return idTipoCotizacionTrabajador;
    }

    public void setIdTipoCotizacionTrabajador(Integer idTipoCotizacionTrabajador) {
        this.idTipoCotizacionTrabajador = idTipoCotizacionTrabajador;
    }

    public String getNombreTipoCotizacionTrabajador() {
        return nombreTipoCotizacionTrabajador;
    }

    public void setNombreTipoCotizacionTrabajador(String nombreTipoCotizacionTrabajador) {
        this.nombreTipoCotizacionTrabajador = nombreTipoCotizacionTrabajador;
    }

    @XmlTransient
    public List<Trabajador> getTrabajadorList() {
        return trabajadorList;
    }

    public void setTrabajadorList(List<Trabajador> trabajadorList) {
        this.trabajadorList = trabajadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCotizacionTrabajador != null ? idTipoCotizacionTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCotizacionTrabajador)) {
            return false;
        }
        TipoCotizacionTrabajador other = (TipoCotizacionTrabajador) object;
        if ((this.idTipoCotizacionTrabajador == null && other.idTipoCotizacionTrabajador != null) || (this.idTipoCotizacionTrabajador != null && !this.idTipoCotizacionTrabajador.equals(other.idTipoCotizacionTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TipoCotizacionTrabajador[ idTipoCotizacionTrabajador=" + idTipoCotizacionTrabajador + " ]";
    }
    
}
