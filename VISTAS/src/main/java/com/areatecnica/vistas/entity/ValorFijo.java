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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "valor_fijo", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ValorFijo.findAll", query = "SELECT v FROM ValorFijo v"),
    @NamedQuery(name = "ValorFijo.findByIdValorFijo", query = "SELECT v FROM ValorFijo v WHERE v.idValorFijo = :idValorFijo"),
    @NamedQuery(name = "ValorFijo.findByNombreValor", query = "SELECT v FROM ValorFijo v WHERE v.nombreValor = :nombreValor"),
    @NamedQuery(name = "ValorFijo.findByMonto", query = "SELECT v FROM ValorFijo v WHERE v.monto = :monto")})
public class ValorFijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_valor_fijo", nullable = false)
    private Integer idValorFijo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_valor", nullable = false, length = 255)
    private String nombreValor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 10, scale = 2)
    private BigDecimal monto;

    public ValorFijo() {
    }

    public ValorFijo(Integer idValorFijo) {
        this.idValorFijo = idValorFijo;
    }

    public ValorFijo(Integer idValorFijo, String nombreValor) {
        this.idValorFijo = idValorFijo;
        this.nombreValor = nombreValor;
    }

    public Integer getIdValorFijo() {
        return idValorFijo;
    }

    public void setIdValorFijo(Integer idValorFijo) {
        this.idValorFijo = idValorFijo;
    }

    public String getNombreValor() {
        return nombreValor;
    }

    public void setNombreValor(String nombreValor) {
        this.nombreValor = nombreValor;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValorFijo != null ? idValorFijo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValorFijo)) {
            return false;
        }
        ValorFijo other = (ValorFijo) object;
        if ((this.idValorFijo == null && other.idValorFijo != null) || (this.idValorFijo != null && !this.idValorFijo.equals(other.idValorFijo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.ValorFijo[ idValorFijo=" + idValorFijo + " ]";
    }
    
}
