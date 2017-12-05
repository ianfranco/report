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
@Table(name = "representante_legal", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepresentanteLegal.findAll", query = "SELECT r FROM RepresentanteLegal r"),
    @NamedQuery(name = "RepresentanteLegal.findByIdRepresentanteLegal", query = "SELECT r FROM RepresentanteLegal r WHERE r.idRepresentanteLegal = :idRepresentanteLegal"),
    @NamedQuery(name = "RepresentanteLegal.findByNombreRepresentanteLegal", query = "SELECT r FROM RepresentanteLegal r WHERE r.nombreRepresentanteLegal = :nombreRepresentanteLegal"),
    @NamedQuery(name = "RepresentanteLegal.findByRutRepresentanteLegal", query = "SELECT r FROM RepresentanteLegal r WHERE r.rutRepresentanteLegal = :rutRepresentanteLegal"),
    @NamedQuery(name = "RepresentanteLegal.findByDireccionRepresentanteLegal", query = "SELECT r FROM RepresentanteLegal r WHERE r.direccionRepresentanteLegal = :direccionRepresentanteLegal"),
    @NamedQuery(name = "RepresentanteLegal.findByTelefonoRepresentanteLegal", query = "SELECT r FROM RepresentanteLegal r WHERE r.telefonoRepresentanteLegal = :telefonoRepresentanteLegal"),
    @NamedQuery(name = "RepresentanteLegal.findByEmailRepresentanteLegal", query = "SELECT r FROM RepresentanteLegal r WHERE r.emailRepresentanteLegal = :emailRepresentanteLegal")})
public class RepresentanteLegal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_representante_legal", nullable = false)
    private Integer idRepresentanteLegal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_representante_legal", nullable = false, length = 45)
    private String nombreRepresentanteLegal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rut_representante_legal", nullable = false, length = 45)
    private String rutRepresentanteLegal;
    @Size(max = 45)
    @Column(name = "direccion_representante_legal", length = 45)
    private String direccionRepresentanteLegal;
    @Size(max = 45)
    @Column(name = "telefono_representante_legal", length = 45)
    private String telefonoRepresentanteLegal;
    @Size(max = 45)
    @Column(name = "email_representante_legal", length = 45)
    private String emailRepresentanteLegal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRepresentanteLegal")
    private List<RepresentanteEmpresa> representanteEmpresaList;

    public RepresentanteLegal() {
    }

    public RepresentanteLegal(Integer idRepresentanteLegal) {
        this.idRepresentanteLegal = idRepresentanteLegal;
    }

    public RepresentanteLegal(Integer idRepresentanteLegal, String nombreRepresentanteLegal, String rutRepresentanteLegal) {
        this.idRepresentanteLegal = idRepresentanteLegal;
        this.nombreRepresentanteLegal = nombreRepresentanteLegal;
        this.rutRepresentanteLegal = rutRepresentanteLegal;
    }

    public Integer getIdRepresentanteLegal() {
        return idRepresentanteLegal;
    }

    public void setIdRepresentanteLegal(Integer idRepresentanteLegal) {
        this.idRepresentanteLegal = idRepresentanteLegal;
    }

    public String getNombreRepresentanteLegal() {
        return nombreRepresentanteLegal;
    }

    public void setNombreRepresentanteLegal(String nombreRepresentanteLegal) {
        this.nombreRepresentanteLegal = nombreRepresentanteLegal;
    }

    public String getRutRepresentanteLegal() {
        return rutRepresentanteLegal;
    }

    public void setRutRepresentanteLegal(String rutRepresentanteLegal) {
        this.rutRepresentanteLegal = rutRepresentanteLegal;
    }

    public String getDireccionRepresentanteLegal() {
        return direccionRepresentanteLegal;
    }

    public void setDireccionRepresentanteLegal(String direccionRepresentanteLegal) {
        this.direccionRepresentanteLegal = direccionRepresentanteLegal;
    }

    public String getTelefonoRepresentanteLegal() {
        return telefonoRepresentanteLegal;
    }

    public void setTelefonoRepresentanteLegal(String telefonoRepresentanteLegal) {
        this.telefonoRepresentanteLegal = telefonoRepresentanteLegal;
    }

    public String getEmailRepresentanteLegal() {
        return emailRepresentanteLegal;
    }

    public void setEmailRepresentanteLegal(String emailRepresentanteLegal) {
        this.emailRepresentanteLegal = emailRepresentanteLegal;
    }

    @XmlTransient
    public List<RepresentanteEmpresa> getRepresentanteEmpresaList() {
        return representanteEmpresaList;
    }

    public void setRepresentanteEmpresaList(List<RepresentanteEmpresa> representanteEmpresaList) {
        this.representanteEmpresaList = representanteEmpresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepresentanteLegal != null ? idRepresentanteLegal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepresentanteLegal)) {
            return false;
        }
        RepresentanteLegal other = (RepresentanteLegal) object;
        if ((this.idRepresentanteLegal == null && other.idRepresentanteLegal != null) || (this.idRepresentanteLegal != null && !this.idRepresentanteLegal.equals(other.idRepresentanteLegal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.RepresentanteLegal[ idRepresentanteLegal=" + idRepresentanteLegal + " ]";
    }
    
}
