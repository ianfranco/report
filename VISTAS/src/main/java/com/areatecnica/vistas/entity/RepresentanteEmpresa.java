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
@Table(name = "representante_empresa", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepresentanteEmpresa.findAll", query = "SELECT r FROM RepresentanteEmpresa r"),
    @NamedQuery(name = "RepresentanteEmpresa.findByIdRepresentanteEmpresa", query = "SELECT r FROM RepresentanteEmpresa r WHERE r.idRepresentanteEmpresa = :idRepresentanteEmpresa")})
public class RepresentanteEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_representante_empresa", nullable = false)
    private Integer idRepresentanteEmpresa;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa", nullable = false)
    @ManyToOne(optional = false)
    private Empresa idEmpresa;
    @JoinColumn(name = "id_representante_legal", referencedColumnName = "id_representante_legal", nullable = false)
    @ManyToOne(optional = false)
    private RepresentanteLegal idRepresentanteLegal;

    public RepresentanteEmpresa() {
    }

    public RepresentanteEmpresa(Integer idRepresentanteEmpresa) {
        this.idRepresentanteEmpresa = idRepresentanteEmpresa;
    }

    public Integer getIdRepresentanteEmpresa() {
        return idRepresentanteEmpresa;
    }

    public void setIdRepresentanteEmpresa(Integer idRepresentanteEmpresa) {
        this.idRepresentanteEmpresa = idRepresentanteEmpresa;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public RepresentanteLegal getIdRepresentanteLegal() {
        return idRepresentanteLegal;
    }

    public void setIdRepresentanteLegal(RepresentanteLegal idRepresentanteLegal) {
        this.idRepresentanteLegal = idRepresentanteLegal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepresentanteEmpresa != null ? idRepresentanteEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepresentanteEmpresa)) {
            return false;
        }
        RepresentanteEmpresa other = (RepresentanteEmpresa) object;
        if ((this.idRepresentanteEmpresa == null && other.idRepresentanteEmpresa != null) || (this.idRepresentanteEmpresa != null && !this.idRepresentanteEmpresa.equals(other.idRepresentanteEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.RepresentanteEmpresa[ idRepresentanteEmpresa=" + idRepresentanteEmpresa + " ]";
    }
    
}
