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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "centro_costo", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroCosto.findAll", query = "SELECT c FROM CentroCosto c"),
    @NamedQuery(name = "CentroCosto.findByIdCentroCosto", query = "SELECT c FROM CentroCosto c WHERE c.idCentroCosto = :idCentroCosto"),
    @NamedQuery(name = "CentroCosto.findByNombreCentroCosto", query = "SELECT c FROM CentroCosto c WHERE c.nombreCentroCosto = :nombreCentroCosto")})
public class CentroCosto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_centro_costo", nullable = false)
    private Integer idCentroCosto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_centro_costo", nullable = false, length = 100)
    private String nombreCentroCosto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCentroCosto")
    private List<CentroCostoTrabajador> centroCostoTrabajadorList;

    public CentroCosto() {
    }

    public CentroCosto(Integer idCentroCosto) {
        this.idCentroCosto = idCentroCosto;
    }

    public CentroCosto(Integer idCentroCosto, String nombreCentroCosto) {
        this.idCentroCosto = idCentroCosto;
        this.nombreCentroCosto = nombreCentroCosto;
    }

    public Integer getIdCentroCosto() {
        return idCentroCosto;
    }

    public void setIdCentroCosto(Integer idCentroCosto) {
        this.idCentroCosto = idCentroCosto;
    }

    public String getNombreCentroCosto() {
        return nombreCentroCosto;
    }

    public void setNombreCentroCosto(String nombreCentroCosto) {
        this.nombreCentroCosto = nombreCentroCosto;
    }

    @XmlTransient
    public List<CentroCostoTrabajador> getCentroCostoTrabajadorList() {
        return centroCostoTrabajadorList;
    }

    public void setCentroCostoTrabajadorList(List<CentroCostoTrabajador> centroCostoTrabajadorList) {
        this.centroCostoTrabajadorList = centroCostoTrabajadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCentroCosto != null ? idCentroCosto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroCosto)) {
            return false;
        }
        CentroCosto other = (CentroCosto) object;
        if ((this.idCentroCosto == null && other.idCentroCosto != null) || (this.idCentroCosto != null && !this.idCentroCosto.equals(other.idCentroCosto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.CentroCosto[ idCentroCosto=" + idCentroCosto + " ]";
    }
    
}
