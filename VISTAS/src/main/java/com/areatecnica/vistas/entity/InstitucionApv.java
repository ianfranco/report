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
@Table(name = "institucion_apv", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstitucionApv.findAll", query = "SELECT i FROM InstitucionApv i"),
    @NamedQuery(name = "InstitucionApv.findByIdInstitucionApv", query = "SELECT i FROM InstitucionApv i WHERE i.idInstitucionApv = :idInstitucionApv"),
    @NamedQuery(name = "InstitucionApv.findByNombreInstitucionApv", query = "SELECT i FROM InstitucionApv i WHERE i.nombreInstitucionApv = :nombreInstitucionApv")})
public class InstitucionApv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_institucion_apv", nullable = false)
    private Integer idInstitucionApv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_institucion_apv", nullable = false, length = 100)
    private String nombreInstitucionApv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstitucionApv")
    private List<Trabajador> trabajadorList;

    public InstitucionApv() {
    }

    public InstitucionApv(Integer idInstitucionApv) {
        this.idInstitucionApv = idInstitucionApv;
    }

    public InstitucionApv(Integer idInstitucionApv, String nombreInstitucionApv) {
        this.idInstitucionApv = idInstitucionApv;
        this.nombreInstitucionApv = nombreInstitucionApv;
    }

    public Integer getIdInstitucionApv() {
        return idInstitucionApv;
    }

    public void setIdInstitucionApv(Integer idInstitucionApv) {
        this.idInstitucionApv = idInstitucionApv;
    }

    public String getNombreInstitucionApv() {
        return nombreInstitucionApv;
    }

    public void setNombreInstitucionApv(String nombreInstitucionApv) {
        this.nombreInstitucionApv = nombreInstitucionApv;
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
        hash += (idInstitucionApv != null ? idInstitucionApv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitucionApv)) {
            return false;
        }
        InstitucionApv other = (InstitucionApv) object;
        if ((this.idInstitucionApv == null && other.idInstitucionApv != null) || (this.idInstitucionApv != null && !this.idInstitucionApv.equals(other.idInstitucionApv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.InstitucionApv[ idInstitucionApv=" + idInstitucionApv + " ]";
    }
    
}
