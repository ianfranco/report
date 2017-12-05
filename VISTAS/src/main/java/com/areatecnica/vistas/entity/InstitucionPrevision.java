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
@Table(name = "institucion_prevision", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstitucionPrevision.findAll", query = "SELECT i FROM InstitucionPrevision i"),
    @NamedQuery(name = "InstitucionPrevision.findByIdInstitucionPrevision", query = "SELECT i FROM InstitucionPrevision i WHERE i.idInstitucionPrevision = :idInstitucionPrevision"),
    @NamedQuery(name = "InstitucionPrevision.findByNombreInstitucionPrevision", query = "SELECT i FROM InstitucionPrevision i WHERE i.nombreInstitucionPrevision = :nombreInstitucionPrevision"),
    @NamedQuery(name = "InstitucionPrevision.findByComision", query = "SELECT i FROM InstitucionPrevision i WHERE i.comision = :comision"),
    @NamedQuery(name = "InstitucionPrevision.findByPorcentajeDescuento", query = "SELECT i FROM InstitucionPrevision i WHERE i.porcentajeDescuento = :porcentajeDescuento")})
public class InstitucionPrevision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_institucion_prevision", nullable = false)
    private Integer idInstitucionPrevision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_institucion_prevision", nullable = false, length = 255)
    private String nombreInstitucionPrevision;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 10, scale = 5)
    private BigDecimal comision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje_descuento", nullable = false, precision = 10, scale = 5)
    private BigDecimal porcentajeDescuento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstitucionPrevision")
    private List<Trabajador> trabajadorList;

    public InstitucionPrevision() {
    }

    public InstitucionPrevision(Integer idInstitucionPrevision) {
        this.idInstitucionPrevision = idInstitucionPrevision;
    }

    public InstitucionPrevision(Integer idInstitucionPrevision, String nombreInstitucionPrevision, BigDecimal porcentajeDescuento) {
        this.idInstitucionPrevision = idInstitucionPrevision;
        this.nombreInstitucionPrevision = nombreInstitucionPrevision;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Integer getIdInstitucionPrevision() {
        return idInstitucionPrevision;
    }

    public void setIdInstitucionPrevision(Integer idInstitucionPrevision) {
        this.idInstitucionPrevision = idInstitucionPrevision;
    }

    public String getNombreInstitucionPrevision() {
        return nombreInstitucionPrevision;
    }

    public void setNombreInstitucionPrevision(String nombreInstitucionPrevision) {
        this.nombreInstitucionPrevision = nombreInstitucionPrevision;
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
    public List<Trabajador> getTrabajadorList() {
        return trabajadorList;
    }

    public void setTrabajadorList(List<Trabajador> trabajadorList) {
        this.trabajadorList = trabajadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstitucionPrevision != null ? idInstitucionPrevision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitucionPrevision)) {
            return false;
        }
        InstitucionPrevision other = (InstitucionPrevision) object;
        if ((this.idInstitucionPrevision == null && other.idInstitucionPrevision != null) || (this.idInstitucionPrevision != null && !this.idInstitucionPrevision.equals(other.idInstitucionPrevision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.InstitucionPrevision[ idInstitucionPrevision=" + idInstitucionPrevision + " ]";
    }
    
}
