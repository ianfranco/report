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
    @NamedQuery(name = "Flota.findAll", query = "SELECT f FROM Flota f"),
    @NamedQuery(name = "Flota.findByIdFlota", query = "SELECT f FROM Flota f WHERE f.idFlota = :idFlota"),
    @NamedQuery(name = "Flota.findByNombreFlota", query = "SELECT f FROM Flota f WHERE f.nombreFlota = :nombreFlota")})
public class Flota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_flota", nullable = false)
    private Integer idFlota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_flota", nullable = false, length = 45)
    private String nombreFlota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFlota")
    private List<Bus> busList;

    public Flota() {
    }

    public Flota(Integer idFlota) {
        this.idFlota = idFlota;
    }

    public Flota(Integer idFlota, String nombreFlota) {
        this.idFlota = idFlota;
        this.nombreFlota = nombreFlota;
    }

    public Integer getIdFlota() {
        return idFlota;
    }

    public void setIdFlota(Integer idFlota) {
        this.idFlota = idFlota;
    }

    public String getNombreFlota() {
        return nombreFlota;
    }

    public void setNombreFlota(String nombreFlota) {
        this.nombreFlota = nombreFlota;
    }

    @XmlTransient
    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFlota != null ? idFlota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flota)) {
            return false;
        }
        Flota other = (Flota) object;
        if ((this.idFlota == null && other.idFlota != null) || (this.idFlota != null && !this.idFlota.equals(other.idFlota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Flota[ idFlota=" + idFlota + " ]";
    }
    
}
