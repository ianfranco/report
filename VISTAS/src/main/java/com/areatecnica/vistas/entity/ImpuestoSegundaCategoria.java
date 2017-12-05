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
@Table(name = "impuesto_segunda_categoria", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImpuestoSegundaCategoria.findAll", query = "SELECT i FROM ImpuestoSegundaCategoria i"),
    @NamedQuery(name = "ImpuestoSegundaCategoria.findByIdImpuestaSegundaCategoria", query = "SELECT i FROM ImpuestoSegundaCategoria i WHERE i.idImpuestaSegundaCategoria = :idImpuestaSegundaCategoria"),
    @NamedQuery(name = "ImpuestoSegundaCategoria.findByDesde", query = "SELECT i FROM ImpuestoSegundaCategoria i WHERE i.desde = :desde"),
    @NamedQuery(name = "ImpuestoSegundaCategoria.findByHasta", query = "SELECT i FROM ImpuestoSegundaCategoria i WHERE i.hasta = :hasta"),
    @NamedQuery(name = "ImpuestoSegundaCategoria.findByFactor", query = "SELECT i FROM ImpuestoSegundaCategoria i WHERE i.factor = :factor"),
    @NamedQuery(name = "ImpuestoSegundaCategoria.findByRebaja", query = "SELECT i FROM ImpuestoSegundaCategoria i WHERE i.rebaja = :rebaja")})
public class ImpuestoSegundaCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_impuesta_segunda_categoria", nullable = false)
    private Integer idImpuestaSegundaCategoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal desde;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal hasta;
    @Column(precision = 10, scale = 3)
    private BigDecimal factor;
    @Column(precision = 10, scale = 3)
    private BigDecimal rebaja;

    public ImpuestoSegundaCategoria() {
    }

    public ImpuestoSegundaCategoria(Integer idImpuestaSegundaCategoria) {
        this.idImpuestaSegundaCategoria = idImpuestaSegundaCategoria;
    }

    public ImpuestoSegundaCategoria(Integer idImpuestaSegundaCategoria, BigDecimal desde, BigDecimal hasta) {
        this.idImpuestaSegundaCategoria = idImpuestaSegundaCategoria;
        this.desde = desde;
        this.hasta = hasta;
    }

    public Integer getIdImpuestaSegundaCategoria() {
        return idImpuestaSegundaCategoria;
    }

    public void setIdImpuestaSegundaCategoria(Integer idImpuestaSegundaCategoria) {
        this.idImpuestaSegundaCategoria = idImpuestaSegundaCategoria;
    }

    public BigDecimal getDesde() {
        return desde;
    }

    public void setDesde(BigDecimal desde) {
        this.desde = desde;
    }

    public BigDecimal getHasta() {
        return hasta;
    }

    public void setHasta(BigDecimal hasta) {
        this.hasta = hasta;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }

    public BigDecimal getRebaja() {
        return rebaja;
    }

    public void setRebaja(BigDecimal rebaja) {
        this.rebaja = rebaja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImpuestaSegundaCategoria != null ? idImpuestaSegundaCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImpuestoSegundaCategoria)) {
            return false;
        }
        ImpuestoSegundaCategoria other = (ImpuestoSegundaCategoria) object;
        if ((this.idImpuestaSegundaCategoria == null && other.idImpuestaSegundaCategoria != null) || (this.idImpuestaSegundaCategoria != null && !this.idImpuestaSegundaCategoria.equals(other.idImpuestaSegundaCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.ImpuestoSegundaCategoria[ idImpuestaSegundaCategoria=" + idImpuestaSegundaCategoria + " ]";
    }
    
}
