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
@Table(name = "calle_servicio", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalleServicio.findAll", query = "SELECT c FROM CalleServicio c"),
    @NamedQuery(name = "CalleServicio.findByIdCalleServicio", query = "SELECT c FROM CalleServicio c WHERE c.idCalleServicio = :idCalleServicio"),
    @NamedQuery(name = "CalleServicio.findByNumeroOrden", query = "SELECT c FROM CalleServicio c WHERE c.numeroOrden = :numeroOrden"),
    @NamedQuery(name = "CalleServicio.findBySentido", query = "SELECT c FROM CalleServicio c WHERE c.sentido = :sentido")})
public class CalleServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calle_servicio", nullable = false)
    private Integer idCalleServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_orden", nullable = false)
    private int numeroOrden;
    private Boolean sentido;
    @JoinColumn(name = "id_calle", referencedColumnName = "id_calle", nullable = false)
    @ManyToOne(optional = false)
    private Calle idCalle;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", nullable = false)
    @ManyToOne(optional = false)
    private Servicio idServicio;

    public CalleServicio() {
    }

    public CalleServicio(Integer idCalleServicio) {
        this.idCalleServicio = idCalleServicio;
    }

    public CalleServicio(Integer idCalleServicio, int numeroOrden) {
        this.idCalleServicio = idCalleServicio;
        this.numeroOrden = numeroOrden;
    }

    public Integer getIdCalleServicio() {
        return idCalleServicio;
    }

    public void setIdCalleServicio(Integer idCalleServicio) {
        this.idCalleServicio = idCalleServicio;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Boolean getSentido() {
        return sentido;
    }

    public void setSentido(Boolean sentido) {
        this.sentido = sentido;
    }

    public Calle getIdCalle() {
        return idCalle;
    }

    public void setIdCalle(Calle idCalle) {
        this.idCalle = idCalle;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalleServicio != null ? idCalleServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalleServicio)) {
            return false;
        }
        CalleServicio other = (CalleServicio) object;
        if ((this.idCalleServicio == null && other.idCalleServicio != null) || (this.idCalleServicio != null && !this.idCalleServicio.equals(other.idCalleServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.CalleServicio[ idCalleServicio=" + idCalleServicio + " ]";
    }
    
}
