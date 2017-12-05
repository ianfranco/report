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
@Table(name = "tipo_movimiento_personal", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMovimientoPersonal.findAll", query = "SELECT t FROM TipoMovimientoPersonal t"),
    @NamedQuery(name = "TipoMovimientoPersonal.findByIdTipoMovimientoPersonal", query = "SELECT t FROM TipoMovimientoPersonal t WHERE t.idTipoMovimientoPersonal = :idTipoMovimientoPersonal"),
    @NamedQuery(name = "TipoMovimientoPersonal.findByNombreTipoMovtoPersonal", query = "SELECT t FROM TipoMovimientoPersonal t WHERE t.nombreTipoMovtoPersonal = :nombreTipoMovtoPersonal")})
public class TipoMovimientoPersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_movimiento_personal", nullable = false)
    private Integer idTipoMovimientoPersonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_tipo_movto_personal", nullable = false, length = 100)
    private String nombreTipoMovtoPersonal;

    public TipoMovimientoPersonal() {
    }

    public TipoMovimientoPersonal(Integer idTipoMovimientoPersonal) {
        this.idTipoMovimientoPersonal = idTipoMovimientoPersonal;
    }

    public TipoMovimientoPersonal(Integer idTipoMovimientoPersonal, String nombreTipoMovtoPersonal) {
        this.idTipoMovimientoPersonal = idTipoMovimientoPersonal;
        this.nombreTipoMovtoPersonal = nombreTipoMovtoPersonal;
    }

    public Integer getIdTipoMovimientoPersonal() {
        return idTipoMovimientoPersonal;
    }

    public void setIdTipoMovimientoPersonal(Integer idTipoMovimientoPersonal) {
        this.idTipoMovimientoPersonal = idTipoMovimientoPersonal;
    }

    public String getNombreTipoMovtoPersonal() {
        return nombreTipoMovtoPersonal;
    }

    public void setNombreTipoMovtoPersonal(String nombreTipoMovtoPersonal) {
        this.nombreTipoMovtoPersonal = nombreTipoMovtoPersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMovimientoPersonal != null ? idTipoMovimientoPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMovimientoPersonal)) {
            return false;
        }
        TipoMovimientoPersonal other = (TipoMovimientoPersonal) object;
        if ((this.idTipoMovimientoPersonal == null && other.idTipoMovimientoPersonal != null) || (this.idTipoMovimientoPersonal != null && !this.idTipoMovimientoPersonal.equals(other.idTipoMovimientoPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TipoMovimientoPersonal[ idTipoMovimientoPersonal=" + idTipoMovimientoPersonal + " ]";
    }
    
}
