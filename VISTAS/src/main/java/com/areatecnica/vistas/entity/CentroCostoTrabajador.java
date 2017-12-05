/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "centro_costo_trabajador", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroCostoTrabajador.findAll", query = "SELECT c FROM CentroCostoTrabajador c"),
    @NamedQuery(name = "CentroCostoTrabajador.findByIdCentroCostoTrabajador", query = "SELECT c FROM CentroCostoTrabajador c WHERE c.idCentroCostoTrabajador = :idCentroCostoTrabajador")})
public class CentroCostoTrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_centro_costo_trabajador", nullable = false)
    private Integer idCentroCostoTrabajador;
    @JoinColumn(name = "id_centro_costo", referencedColumnName = "id_centro_costo", nullable = false)
    @ManyToOne(optional = false)
    private CentroCosto idCentroCosto;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;

    public CentroCostoTrabajador() {
    }

    public CentroCostoTrabajador(Integer idCentroCostoTrabajador) {
        this.idCentroCostoTrabajador = idCentroCostoTrabajador;
    }

    public Integer getIdCentroCostoTrabajador() {
        return idCentroCostoTrabajador;
    }

    public void setIdCentroCostoTrabajador(Integer idCentroCostoTrabajador) {
        this.idCentroCostoTrabajador = idCentroCostoTrabajador;
    }

    public CentroCosto getIdCentroCosto() {
        return idCentroCosto;
    }

    public void setIdCentroCosto(CentroCosto idCentroCosto) {
        this.idCentroCosto = idCentroCosto;
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
        hash += (idCentroCostoTrabajador != null ? idCentroCostoTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroCostoTrabajador)) {
            return false;
        }
        CentroCostoTrabajador other = (CentroCostoTrabajador) object;
        if ((this.idCentroCostoTrabajador == null && other.idCentroCostoTrabajador != null) || (this.idCentroCostoTrabajador != null && !this.idCentroCostoTrabajador.equals(other.idCentroCostoTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.CentroCostoTrabajador[ idCentroCostoTrabajador=" + idCentroCostoTrabajador + " ]";
    }
    
}
