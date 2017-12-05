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
@Table(name = "institucion_salud", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstitucionSalud.findAll", query = "SELECT i FROM InstitucionSalud i"),
    @NamedQuery(name = "InstitucionSalud.findByIdInstitucionSalud", query = "SELECT i FROM InstitucionSalud i WHERE i.idInstitucionSalud = :idInstitucionSalud"),
    @NamedQuery(name = "InstitucionSalud.findByNombreInstitucionSalud", query = "SELECT i FROM InstitucionSalud i WHERE i.nombreInstitucionSalud = :nombreInstitucionSalud"),
    @NamedQuery(name = "InstitucionSalud.findByComision", query = "SELECT i FROM InstitucionSalud i WHERE i.comision = :comision"),
    @NamedQuery(name = "InstitucionSalud.findByPorcentajeDescuento", query = "SELECT i FROM InstitucionSalud i WHERE i.porcentajeDescuento = :porcentajeDescuento")})
public class InstitucionSalud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_institucion_salud", nullable = false)
    private Integer idInstitucionSalud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_institucion_salud", nullable = false, length = 255)
    private String nombreInstitucionSalud;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 10, scale = 5)
    private BigDecimal comision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje_descuento", nullable = false, precision = 10, scale = 5)
    private BigDecimal porcentajeDescuento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstitucionSalud")
    private List<Trabajador> trabajadorList;

    public InstitucionSalud() {
    }

    public InstitucionSalud(Integer idInstitucionSalud) {
        this.idInstitucionSalud = idInstitucionSalud;
    }

    public InstitucionSalud(Integer idInstitucionSalud, String nombreInstitucionSalud, BigDecimal porcentajeDescuento) {
        this.idInstitucionSalud = idInstitucionSalud;
        this.nombreInstitucionSalud = nombreInstitucionSalud;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Integer getIdInstitucionSalud() {
        return idInstitucionSalud;
    }

    public void setIdInstitucionSalud(Integer idInstitucionSalud) {
        this.idInstitucionSalud = idInstitucionSalud;
    }

    public String getNombreInstitucionSalud() {
        return nombreInstitucionSalud;
    }

    public void setNombreInstitucionSalud(String nombreInstitucionSalud) {
        this.nombreInstitucionSalud = nombreInstitucionSalud;
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
        hash += (idInstitucionSalud != null ? idInstitucionSalud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitucionSalud)) {
            return false;
        }
        InstitucionSalud other = (InstitucionSalud) object;
        if ((this.idInstitucionSalud == null && other.idInstitucionSalud != null) || (this.idInstitucionSalud != null && !this.idInstitucionSalud.equals(other.idInstitucionSalud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.InstitucionSalud[ idInstitucionSalud=" + idInstitucionSalud + " ]";
    }
    
}
