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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Calle.findAll", query = "SELECT c FROM Calle c"),
    @NamedQuery(name = "Calle.findByIdCalle", query = "SELECT c FROM Calle c WHERE c.idCalle = :idCalle"),
    @NamedQuery(name = "Calle.findByNombreCalle", query = "SELECT c FROM Calle c WHERE c.nombreCalle = :nombreCalle")})
public class Calle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calle", nullable = false)
    private Integer idCalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_calle", nullable = false, length = 45)
    private String nombreCalle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCalle")
    private List<CalleServicio> calleServicioList;
    @JoinColumn(name = "id_comuna", referencedColumnName = "id_comuna", nullable = false)
    @ManyToOne(optional = false)
    private Comuna idComuna;

    public Calle() {
    }

    public Calle(Integer idCalle) {
        this.idCalle = idCalle;
    }

    public Calle(Integer idCalle, String nombreCalle) {
        this.idCalle = idCalle;
        this.nombreCalle = nombreCalle;
    }

    public Integer getIdCalle() {
        return idCalle;
    }

    public void setIdCalle(Integer idCalle) {
        this.idCalle = idCalle;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    @XmlTransient
    public List<CalleServicio> getCalleServicioList() {
        return calleServicioList;
    }

    public void setCalleServicioList(List<CalleServicio> calleServicioList) {
        this.calleServicioList = calleServicioList;
    }

    public Comuna getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Comuna idComuna) {
        this.idComuna = idComuna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalle != null ? idCalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calle)) {
            return false;
        }
        Calle other = (Calle) object;
        if ((this.idCalle == null && other.idCalle != null) || (this.idCalle != null && !this.idCalle.equals(other.idCalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Calle[ idCalle=" + idCalle + " ]";
    }
    
}
