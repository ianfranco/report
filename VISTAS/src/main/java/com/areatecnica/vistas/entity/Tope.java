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
@Table(catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tope.findAll", query = "SELECT t FROM Tope t"),
    @NamedQuery(name = "Tope.findByIdTope", query = "SELECT t FROM Tope t WHERE t.idTope = :idTope"),
    @NamedQuery(name = "Tope.findByNombreTope", query = "SELECT t FROM Tope t WHERE t.nombreTope = :nombreTope"),
    @NamedQuery(name = "Tope.findByMontoUf", query = "SELECT t FROM Tope t WHERE t.montoUf = :montoUf")})
public class Tope implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tope", nullable = false)
    private Integer idTope;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_tope", nullable = false, length = 255)
    private String nombreTope;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_uf", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoUf;

    public Tope() {
    }

    public Tope(Integer idTope) {
        this.idTope = idTope;
    }

    public Tope(Integer idTope, String nombreTope, BigDecimal montoUf) {
        this.idTope = idTope;
        this.nombreTope = nombreTope;
        this.montoUf = montoUf;
    }

    public Integer getIdTope() {
        return idTope;
    }

    public void setIdTope(Integer idTope) {
        this.idTope = idTope;
    }

    public String getNombreTope() {
        return nombreTope;
    }

    public void setNombreTope(String nombreTope) {
        this.nombreTope = nombreTope;
    }

    public BigDecimal getMontoUf() {
        return montoUf;
    }

    public void setMontoUf(BigDecimal montoUf) {
        this.montoUf = montoUf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTope != null ? idTope.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tope)) {
            return false;
        }
        Tope other = (Tope) object;
        if ((this.idTope == null && other.idTope != null) || (this.idTope != null && !this.idTope.equals(other.idTope))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Tope[ idTope=" + idTope + " ]";
    }
    
}
