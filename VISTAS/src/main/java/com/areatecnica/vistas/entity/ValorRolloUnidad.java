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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "valor_rollo_unidad", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ValorRolloUnidad.findAll", query = "SELECT v FROM ValorRolloUnidad v"),
    @NamedQuery(name = "ValorRolloUnidad.findByIdValorRolloUnidad", query = "SELECT v FROM ValorRolloUnidad v WHERE v.idValorRolloUnidad = :idValorRolloUnidad"),
    @NamedQuery(name = "ValorRolloUnidad.findByCompra", query = "SELECT v FROM ValorRolloUnidad v WHERE v.compra = :compra"),
    @NamedQuery(name = "ValorRolloUnidad.findByVenta", query = "SELECT v FROM ValorRolloUnidad v WHERE v.venta = :venta")})
public class ValorRolloUnidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_valor_rollo_unidad", nullable = false)
    private Integer idValorRolloUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int compra;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int venta;
    @JoinColumn(name = "id_unidad", referencedColumnName = "id_unidad_negocio", nullable = false)
    @ManyToOne(optional = false)
    private UnidadNegocio idUnidad;

    public ValorRolloUnidad() {
    }

    public ValorRolloUnidad(Integer idValorRolloUnidad) {
        this.idValorRolloUnidad = idValorRolloUnidad;
    }

    public ValorRolloUnidad(Integer idValorRolloUnidad, int compra, int venta) {
        this.idValorRolloUnidad = idValorRolloUnidad;
        this.compra = compra;
        this.venta = venta;
    }

    public Integer getIdValorRolloUnidad() {
        return idValorRolloUnidad;
    }

    public void setIdValorRolloUnidad(Integer idValorRolloUnidad) {
        this.idValorRolloUnidad = idValorRolloUnidad;
    }

    public int getCompra() {
        return compra;
    }

    public void setCompra(int compra) {
        this.compra = compra;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public UnidadNegocio getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(UnidadNegocio idUnidad) {
        this.idUnidad = idUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValorRolloUnidad != null ? idValorRolloUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValorRolloUnidad)) {
            return false;
        }
        ValorRolloUnidad other = (ValorRolloUnidad) object;
        if ((this.idValorRolloUnidad == null && other.idValorRolloUnidad != null) || (this.idValorRolloUnidad != null && !this.idValorRolloUnidad.equals(other.idValorRolloUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.ValorRolloUnidad[ idValorRolloUnidad=" + idValorRolloUnidad + " ]";
    }
    
}
