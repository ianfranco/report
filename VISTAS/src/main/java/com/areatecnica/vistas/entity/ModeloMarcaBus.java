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
@Table(name = "modelo_marca_bus", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModeloMarcaBus.findAll", query = "SELECT m FROM ModeloMarcaBus m"),
    @NamedQuery(name = "ModeloMarcaBus.findByIdModeloMarcaBus", query = "SELECT m FROM ModeloMarcaBus m WHERE m.idModeloMarcaBus = :idModeloMarcaBus"),
    @NamedQuery(name = "ModeloMarcaBus.findByNombreModeloMarcaBus", query = "SELECT m FROM ModeloMarcaBus m WHERE m.nombreModeloMarcaBus = :nombreModeloMarcaBus")})
public class ModeloMarcaBus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_modelo_marca_bus", nullable = false)
    private Integer idModeloMarcaBus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_modelo_marca_bus", nullable = false, length = 45)
    private String nombreModeloMarcaBus;
    @JoinColumn(name = "id_marca_bus", referencedColumnName = "id_marcas_bus", nullable = false)
    @ManyToOne(optional = false)
    private MarcaBus idMarcaBus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModelo")
    private List<Bus> busList;

    public ModeloMarcaBus() {
    }

    public ModeloMarcaBus(Integer idModeloMarcaBus) {
        this.idModeloMarcaBus = idModeloMarcaBus;
    }

    public ModeloMarcaBus(Integer idModeloMarcaBus, String nombreModeloMarcaBus) {
        this.idModeloMarcaBus = idModeloMarcaBus;
        this.nombreModeloMarcaBus = nombreModeloMarcaBus;
    }

    public Integer getIdModeloMarcaBus() {
        return idModeloMarcaBus;
    }

    public void setIdModeloMarcaBus(Integer idModeloMarcaBus) {
        this.idModeloMarcaBus = idModeloMarcaBus;
    }

    public String getNombreModeloMarcaBus() {
        return nombreModeloMarcaBus;
    }

    public void setNombreModeloMarcaBus(String nombreModeloMarcaBus) {
        this.nombreModeloMarcaBus = nombreModeloMarcaBus;
    }

    public MarcaBus getIdMarcaBus() {
        return idMarcaBus;
    }

    public void setIdMarcaBus(MarcaBus idMarcaBus) {
        this.idMarcaBus = idMarcaBus;
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
        hash += (idModeloMarcaBus != null ? idModeloMarcaBus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModeloMarcaBus)) {
            return false;
        }
        ModeloMarcaBus other = (ModeloMarcaBus) object;
        if ((this.idModeloMarcaBus == null && other.idModeloMarcaBus != null) || (this.idModeloMarcaBus != null && !this.idModeloMarcaBus.equals(other.idModeloMarcaBus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.ModeloMarcaBus[ idModeloMarcaBus=" + idModeloMarcaBus + " ]";
    }
    
}
