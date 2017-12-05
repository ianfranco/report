/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
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
@Table(name = "tipo_trabajador", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTrabajador.findAll", query = "SELECT t FROM TipoTrabajador t"),
    @NamedQuery(name = "TipoTrabajador.findByIdTipoTrabajador", query = "SELECT t FROM TipoTrabajador t WHERE t.idTipoTrabajador = :idTipoTrabajador"),
    @NamedQuery(name = "TipoTrabajador.findByNombreTipoTrabajador", query = "SELECT t FROM TipoTrabajador t WHERE t.nombreTipoTrabajador = :nombreTipoTrabajador")})
public class TipoTrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_trabajador", nullable = false)
    private Integer idTipoTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_trabajador", nullable = false, length = 45)
    private String nombreTipoTrabajador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoTrabajador")
    private List<RelacionLaboral> relacionLaboralList;

    public TipoTrabajador() {
    }

    public TipoTrabajador(Integer idTipoTrabajador) {
        this.idTipoTrabajador = idTipoTrabajador;
    }

    public TipoTrabajador(Integer idTipoTrabajador, String nombreTipoTrabajador) {
        this.idTipoTrabajador = idTipoTrabajador;
        this.nombreTipoTrabajador = nombreTipoTrabajador;
    }

    public Integer getIdTipoTrabajador() {
        return idTipoTrabajador;
    }

    public void setIdTipoTrabajador(Integer idTipoTrabajador) {
        this.idTipoTrabajador = idTipoTrabajador;
    }

    public String getNombreTipoTrabajador() {
        return nombreTipoTrabajador;
    }

    public void setNombreTipoTrabajador(String nombreTipoTrabajador) {
        this.nombreTipoTrabajador = nombreTipoTrabajador;
    }

    @XmlTransient
    public List<RelacionLaboral> getRelacionLaboralList() {
        return relacionLaboralList;
    }

    public void setRelacionLaboralList(List<RelacionLaboral> relacionLaboralList) {
        this.relacionLaboralList = relacionLaboralList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTrabajador != null ? idTipoTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTrabajador)) {
            return false;
        }
        TipoTrabajador other = (TipoTrabajador) object;
        if ((this.idTipoTrabajador == null && other.idTipoTrabajador != null) || (this.idTipoTrabajador != null && !this.idTipoTrabajador.equals(other.idTipoTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TipoTrabajador[ idTipoTrabajador=" + idTipoTrabajador + " ]";
    }
    
}
