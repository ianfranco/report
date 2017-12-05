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
@Table(name = "caja_compensacion", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CajaCompensacion.findAll", query = "SELECT c FROM CajaCompensacion c"),
    @NamedQuery(name = "CajaCompensacion.findByIdCajaCompensacion", query = "SELECT c FROM CajaCompensacion c WHERE c.idCajaCompensacion = :idCajaCompensacion"),
    @NamedQuery(name = "CajaCompensacion.findByNombreCajaCompensacion", query = "SELECT c FROM CajaCompensacion c WHERE c.nombreCajaCompensacion = :nombreCajaCompensacion"),
    @NamedQuery(name = "CajaCompensacion.findByComision", query = "SELECT c FROM CajaCompensacion c WHERE c.comision = :comision"),
    @NamedQuery(name = "CajaCompensacion.findByPorcentajeDescuento", query = "SELECT c FROM CajaCompensacion c WHERE c.porcentajeDescuento = :porcentajeDescuento")})
public class CajaCompensacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caja_compensacion", nullable = false)
    private Integer idCajaCompensacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_caja_compensacion", nullable = false, length = 255)
    private String nombreCajaCompensacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 10, scale = 5)
    private BigDecimal comision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje_descuento", nullable = false, precision = 10, scale = 5)
    private BigDecimal porcentajeDescuento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCajaCompensacion")
    private List<Empresa> empresaList;

    public CajaCompensacion() {
    }

    public CajaCompensacion(Integer idCajaCompensacion) {
        this.idCajaCompensacion = idCajaCompensacion;
    }

    public CajaCompensacion(Integer idCajaCompensacion, String nombreCajaCompensacion, BigDecimal porcentajeDescuento) {
        this.idCajaCompensacion = idCajaCompensacion;
        this.nombreCajaCompensacion = nombreCajaCompensacion;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Integer getIdCajaCompensacion() {
        return idCajaCompensacion;
    }

    public void setIdCajaCompensacion(Integer idCajaCompensacion) {
        this.idCajaCompensacion = idCajaCompensacion;
    }

    public String getNombreCajaCompensacion() {
        return nombreCajaCompensacion;
    }

    public void setNombreCajaCompensacion(String nombreCajaCompensacion) {
        this.nombreCajaCompensacion = nombreCajaCompensacion;
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
        hash += (idCajaCompensacion != null ? idCajaCompensacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CajaCompensacion)) {
            return false;
        }
        CajaCompensacion other = (CajaCompensacion) object;
        if ((this.idCajaCompensacion == null && other.idCajaCompensacion != null) || (this.idCajaCompensacion != null && !this.idCajaCompensacion.equals(other.idCajaCompensacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.CajaCompensacion[ idCajaCompensacion=" + idCajaCompensacion + " ]";
    }
    
}
