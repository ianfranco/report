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
@Table(name = "tipo_nomina", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoNomina.findAll", query = "SELECT t FROM TipoNomina t"),
    @NamedQuery(name = "TipoNomina.findByIdTipoNomina", query = "SELECT t FROM TipoNomina t WHERE t.idTipoNomina = :idTipoNomina"),
    @NamedQuery(name = "TipoNomina.findByNombreTipoNomina", query = "SELECT t FROM TipoNomina t WHERE t.nombreTipoNomina = :nombreTipoNomina")})
public class TipoNomina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_nomina", nullable = false)
    private Integer idTipoNomina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_nomina", nullable = false, length = 45)
    private String nombreTipoNomina;

    public TipoNomina() {
    }

    public TipoNomina(Integer idTipoNomina) {
        this.idTipoNomina = idTipoNomina;
    }

    public TipoNomina(Integer idTipoNomina, String nombreTipoNomina) {
        this.idTipoNomina = idTipoNomina;
        this.nombreTipoNomina = nombreTipoNomina;
    }

    public Integer getIdTipoNomina() {
        return idTipoNomina;
    }

    public void setIdTipoNomina(Integer idTipoNomina) {
        this.idTipoNomina = idTipoNomina;
    }

    public String getNombreTipoNomina() {
        return nombreTipoNomina;
    }

    public void setNombreTipoNomina(String nombreTipoNomina) {
        this.nombreTipoNomina = nombreTipoNomina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoNomina != null ? idTipoNomina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoNomina)) {
            return false;
        }
        TipoNomina other = (TipoNomina) object;
        if ((this.idTipoNomina == null && other.idTipoNomina != null) || (this.idTipoNomina != null && !this.idTipoNomina.equals(other.idTipoNomina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TipoNomina[ idTipoNomina=" + idTipoNomina + " ]";
    }
    
}
