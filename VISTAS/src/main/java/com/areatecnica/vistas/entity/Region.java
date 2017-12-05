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
@Table(catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"),
    @NamedQuery(name = "Region.findByIdRegion", query = "SELECT r FROM Region r WHERE r.idRegion = :idRegion"),
    @NamedQuery(name = "Region.findByNumeroRegion", query = "SELECT r FROM Region r WHERE r.numeroRegion = :numeroRegion"),
    @NamedQuery(name = "Region.findByNombre", query = "SELECT r FROM Region r WHERE r.nombre = :nombre")})
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_region", nullable = false)
    private Integer idRegion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_region", nullable = false)
    private int numeroRegion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRegion")
    private List<UnidadNegocio> unidadNegocioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRegion")
    private List<Comuna> comunaList;

    public Region() {
    }

    public Region(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public Region(Integer idRegion, int numeroRegion, String nombre) {
        this.idRegion = idRegion;
        this.numeroRegion = numeroRegion;
        this.nombre = nombre;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public int getNumeroRegion() {
        return numeroRegion;
    }

    public void setNumeroRegion(int numeroRegion) {
        this.numeroRegion = numeroRegion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<UnidadNegocio> getUnidadNegocioList() {
        return unidadNegocioList;
    }

    public void setUnidadNegocioList(List<UnidadNegocio> unidadNegocioList) {
        this.unidadNegocioList = unidadNegocioList;
    }

    @XmlTransient
    public List<Comuna> getComunaList() {
        return comunaList;
    }

    public void setComunaList(List<Comuna> comunaList) {
        this.comunaList = comunaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegion != null ? idRegion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.idRegion == null && other.idRegion != null) || (this.idRegion != null && !this.idRegion.equals(other.idRegion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Region[ idRegion=" + idRegion + " ]";
    }
    
}
