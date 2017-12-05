/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
    @NamedQuery(name = "Mutual.findAll", query = "SELECT m FROM Mutual m"),
    @NamedQuery(name = "Mutual.findByIdMutual", query = "SELECT m FROM Mutual m WHERE m.idMutual = :idMutual"),
    @NamedQuery(name = "Mutual.findByNombreMutual", query = "SELECT m FROM Mutual m WHERE m.nombreMutual = :nombreMutual"),
    @NamedQuery(name = "Mutual.findByComision", query = "SELECT m FROM Mutual m WHERE m.comision = :comision"),
    @NamedQuery(name = "Mutual.findByPorcentajeDescuento", query = "SELECT m FROM Mutual m WHERE m.porcentajeDescuento = :porcentajeDescuento")})
public class Mutual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mutual", nullable = false)
    private Integer idMutual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_mutual", nullable = false, length = 255)
    private String nombreMutual;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 10, scale = 5)
    private BigDecimal comision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje_descuento", nullable = false, precision = 10, scale = 5)
    private BigDecimal porcentajeDescuento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMutual")
    private List<Empresa> empresaList;

    public Mutual() {
    }

    public Mutual(Integer idMutual) {
        this.idMutual = idMutual;
    }

    public Mutual(Integer idMutual, String nombreMutual, BigDecimal porcentajeDescuento) {
        this.idMutual = idMutual;
        this.nombreMutual = nombreMutual;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Integer getIdMutual() {
        return idMutual;
    }

    public void setIdMutual(Integer idMutual) {
        this.idMutual = idMutual;
    }

    public String getNombreMutual() {
        return nombreMutual;
    }

    public void setNombreMutual(String nombreMutual) {
        this.nombreMutual = nombreMutual;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public BigDecimal getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMutual != null ? idMutual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mutual)) {
            return false;
        }
        Mutual other = (Mutual) object;
        if ((this.idMutual == null && other.idMutual != null) || (this.idMutual != null && !this.idMutual.equals(other.idMutual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Mutual[ idMutual=" + idMutual + " ]";
    }
    
}
