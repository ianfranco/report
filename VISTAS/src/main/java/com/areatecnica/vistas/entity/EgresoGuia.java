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
@Table(name = "egreso_guia", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EgresoGuia.findAll", query = "SELECT e FROM EgresoGuia e"),
    @NamedQuery(name = "EgresoGuia.findByIdEgresoGuia", query = "SELECT e FROM EgresoGuia e WHERE e.idEgresoGuia = :idEgresoGuia"),
    @NamedQuery(name = "EgresoGuia.findByMonto", query = "SELECT e FROM EgresoGuia e WHERE e.monto = :monto")})
public class EgresoGuia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_egreso_guia", nullable = false)
    private Integer idEgresoGuia;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int monto;
    @JoinColumn(name = "id_egreso_servicio", referencedColumnName = "id_egreso_servicio", nullable = false)
    @ManyToOne(optional = false)
    private EgresoServicio idEgresoServicio;
    @JoinColumn(name = "id_guia", referencedColumnName = "id_guia", nullable = false)
    @ManyToOne(optional = false)
    private Guia idGuia;

    public EgresoGuia() {
    }

    public EgresoGuia(Integer idEgresoGuia) {
        this.idEgresoGuia = idEgresoGuia;
    }

    public EgresoGuia(Integer idEgresoGuia, int monto) {
        this.idEgresoGuia = idEgresoGuia;
        this.monto = monto;
    }

    public Integer getIdEgresoGuia() {
        return idEgresoGuia;
    }

    public void setIdEgresoGuia(Integer idEgresoGuia) {
        this.idEgresoGuia = idEgresoGuia;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public EgresoServicio getIdEgresoServicio() {
        return idEgresoServicio;
    }

    public void setIdEgresoServicio(EgresoServicio idEgresoServicio) {
        this.idEgresoServicio = idEgresoServicio;
    }

    public Guia getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Guia idGuia) {
        this.idGuia = idGuia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEgresoGuia != null ? idEgresoGuia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EgresoGuia)) {
            return false;
        }
        EgresoGuia other = (EgresoGuia) object;
        if ((this.idEgresoGuia == null && other.idEgresoGuia != null) || (this.idEgresoGuia != null && !this.idEgresoGuia.equals(other.idEgresoGuia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.EgresoGuia[ idEgresoGuia=" + idEgresoGuia + " ]";
    }
    
}
