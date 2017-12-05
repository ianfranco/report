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
    @NamedQuery(name = "Egreso.findAll", query = "SELECT e FROM Egreso e"),
    @NamedQuery(name = "Egreso.findByIdEgreso", query = "SELECT e FROM Egreso e WHERE e.idEgreso = :idEgreso"),
    @NamedQuery(name = "Egreso.findByNombreEgreso", query = "SELECT e FROM Egreso e WHERE e.nombreEgreso = :nombreEgreso"),
    @NamedQuery(name = "Egreso.findByActivo", query = "SELECT e FROM Egreso e WHERE e.activo = :activo")})
public class Egreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_egreso", nullable = false)
    private Integer idEgreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_egreso", nullable = false, length = 45)
    private String nombreEgreso;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEgreso")
    private List<EgresoServicio> egresoServicioList;

    public Egreso() {
    }

    public Egreso(Integer idEgreso) {
        this.idEgreso = idEgreso;
    }

    public Egreso(Integer idEgreso, String nombreEgreso, boolean activo) {
        this.idEgreso = idEgreso;
        this.nombreEgreso = nombreEgreso;
        this.activo = activo;
    }

    public Integer getIdEgreso() {
        return idEgreso;
    }

    public void setIdEgreso(Integer idEgreso) {
        this.idEgreso = idEgreso;
    }

    public String getNombreEgreso() {
        return nombreEgreso;
    }

    public void setNombreEgreso(String nombreEgreso) {
        this.nombreEgreso = nombreEgreso;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<EgresoServicio> getEgresoServicioList() {
        return egresoServicioList;
    }

    public void setEgresoServicioList(List<EgresoServicio> egresoServicioList) {
        this.egresoServicioList = egresoServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEgreso != null ? idEgreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Egreso)) {
            return false;
        }
        Egreso other = (Egreso) object;
        if ((this.idEgreso == null && other.idEgreso != null) || (this.idEgreso != null && !this.idEgreso.equals(other.idEgreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Egreso[ idEgreso=" + idEgreso + " ]";
    }
    
}
