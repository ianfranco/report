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
@Table(name = "parentesco_carga", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParentescoCarga.findAll", query = "SELECT p FROM ParentescoCarga p"),
    @NamedQuery(name = "ParentescoCarga.findByIdParentescoCarga", query = "SELECT p FROM ParentescoCarga p WHERE p.idParentescoCarga = :idParentescoCarga"),
    @NamedQuery(name = "ParentescoCarga.findByNombreParentescoCarga", query = "SELECT p FROM ParentescoCarga p WHERE p.nombreParentescoCarga = :nombreParentescoCarga")})
public class ParentescoCarga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parentesco_carga", nullable = false)
    private Integer idParentescoCarga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_parentesco_carga", nullable = false, length = 45)
    private String nombreParentescoCarga;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idParentescoCarga")
    private List<CargasTrabajador> cargasTrabajadorList;

    public ParentescoCarga() {
    }

    public ParentescoCarga(Integer idParentescoCarga) {
        this.idParentescoCarga = idParentescoCarga;
    }

    public ParentescoCarga(Integer idParentescoCarga, String nombreParentescoCarga) {
        this.idParentescoCarga = idParentescoCarga;
        this.nombreParentescoCarga = nombreParentescoCarga;
    }

    public Integer getIdParentescoCarga() {
        return idParentescoCarga;
    }

    public void setIdParentescoCarga(Integer idParentescoCarga) {
        this.idParentescoCarga = idParentescoCarga;
    }

    public String getNombreParentescoCarga() {
        return nombreParentescoCarga;
    }

    public void setNombreParentescoCarga(String nombreParentescoCarga) {
        this.nombreParentescoCarga = nombreParentescoCarga;
    }

    @XmlTransient
    public List<CargasTrabajador> getCargasTrabajadorList() {
        return cargasTrabajadorList;
    }

    public void setCargasTrabajadorList(List<CargasTrabajador> cargasTrabajadorList) {
        this.cargasTrabajadorList = cargasTrabajadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParentescoCarga != null ? idParentescoCarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParentescoCarga)) {
            return false;
        }
        ParentescoCarga other = (ParentescoCarga) object;
        if ((this.idParentescoCarga == null && other.idParentescoCarga != null) || (this.idParentescoCarga != null && !this.idParentescoCarga.equals(other.idParentescoCarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.ParentescoCarga[ idParentescoCarga=" + idParentescoCarga + " ]";
    }
    
}
