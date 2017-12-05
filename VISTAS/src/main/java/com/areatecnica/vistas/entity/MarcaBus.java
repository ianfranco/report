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
@Table(name = "marca_bus", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaBus.findAll", query = "SELECT m FROM MarcaBus m"),
    @NamedQuery(name = "MarcaBus.findByIdMarcasBus", query = "SELECT m FROM MarcaBus m WHERE m.idMarcasBus = :idMarcasBus"),
    @NamedQuery(name = "MarcaBus.findByNombreMarcaBus", query = "SELECT m FROM MarcaBus m WHERE m.nombreMarcaBus = :nombreMarcaBus")})
public class MarcaBus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_marcas_bus", nullable = false)
    private Integer idMarcasBus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_marca_bus", nullable = false, length = 45)
    private String nombreMarcaBus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarcaBus")
    private List<ModeloMarcaBus> modeloMarcaBusList;

    public MarcaBus() {
    }

    public MarcaBus(Integer idMarcasBus) {
        this.idMarcasBus = idMarcasBus;
    }

    public MarcaBus(Integer idMarcasBus, String nombreMarcaBus) {
        this.idMarcasBus = idMarcasBus;
        this.nombreMarcaBus = nombreMarcaBus;
    }

    public Integer getIdMarcasBus() {
        return idMarcasBus;
    }

    public void setIdMarcasBus(Integer idMarcasBus) {
        this.idMarcasBus = idMarcasBus;
    }

    public String getNombreMarcaBus() {
        return nombreMarcaBus;
    }

    public void setNombreMarcaBus(String nombreMarcaBus) {
        this.nombreMarcaBus = nombreMarcaBus;
    }

    @XmlTransient
    public List<ModeloMarcaBus> getModeloMarcaBusList() {
        return modeloMarcaBusList;
    }

    public void setModeloMarcaBusList(List<ModeloMarcaBus> modeloMarcaBusList) {
        this.modeloMarcaBusList = modeloMarcaBusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarcasBus != null ? idMarcasBus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaBus)) {
            return false;
        }
        MarcaBus other = (MarcaBus) object;
        if ((this.idMarcasBus == null && other.idMarcasBus != null) || (this.idMarcasBus != null && !this.idMarcasBus.equals(other.idMarcasBus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.MarcaBus[ idMarcasBus=" + idMarcasBus + " ]";
    }
    
}
