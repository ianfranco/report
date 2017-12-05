/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "parametro_cesantia", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParametroCesantia.findAll", query = "SELECT p FROM ParametroCesantia p"),
    @NamedQuery(name = "ParametroCesantia.findByIdParametroCesantia", query = "SELECT p FROM ParametroCesantia p WHERE p.idParametroCesantia = :idParametroCesantia"),
    @NamedQuery(name = "ParametroCesantia.findByEmpleador", query = "SELECT p FROM ParametroCesantia p WHERE p.empleador = :empleador"),
    @NamedQuery(name = "ParametroCesantia.findByTrabajador", query = "SELECT p FROM ParametroCesantia p WHERE p.trabajador = :trabajador")})
public class ParametroCesantia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parametro_cesantia", nullable = false)
    private Integer idParametroCesantia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal empleador;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal trabajador;

    public ParametroCesantia() {
    }

    public ParametroCesantia(Integer idParametroCesantia) {
        this.idParametroCesantia = idParametroCesantia;
    }

    public ParametroCesantia(Integer idParametroCesantia, BigDecimal empleador, BigDecimal trabajador) {
        this.idParametroCesantia = idParametroCesantia;
        this.empleador = empleador;
        this.trabajador = trabajador;
    }

    public Integer getIdParametroCesantia() {
        return idParametroCesantia;
    }

    public void setIdParametroCesantia(Integer idParametroCesantia) {
        this.idParametroCesantia = idParametroCesantia;
    }

    public BigDecimal getEmpleador() {
        return empleador;
    }

    public void setEmpleador(BigDecimal empleador) {
        this.empleador = empleador;
    }

    public BigDecimal getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(BigDecimal trabajador) {
        this.trabajador = trabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametroCesantia != null ? idParametroCesantia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametroCesantia)) {
            return false;
        }
        ParametroCesantia other = (ParametroCesantia) object;
        if ((this.idParametroCesantia == null && other.idParametroCesantia != null) || (this.idParametroCesantia != null && !this.idParametroCesantia.equals(other.idParametroCesantia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.ParametroCesantia[ idParametroCesantia=" + idParametroCesantia + " ]";
    }
    
}
