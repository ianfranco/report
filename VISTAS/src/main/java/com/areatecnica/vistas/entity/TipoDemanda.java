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
@Table(name = "tipo_demanda", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDemanda.findAll", query = "SELECT t FROM TipoDemanda t"),
    @NamedQuery(name = "TipoDemanda.findByIdTipoDemanda", query = "SELECT t FROM TipoDemanda t WHERE t.idTipoDemanda = :idTipoDemanda"),
    @NamedQuery(name = "TipoDemanda.findByNombreTipoDemanda", query = "SELECT t FROM TipoDemanda t WHERE t.nombreTipoDemanda = :nombreTipoDemanda")})
public class TipoDemanda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_demanda", nullable = false)
    private Integer idTipoDemanda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_demanda", nullable = false, length = 45)
    private String nombreTipoDemanda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDemanda")
    private List<FrecuenciaServicio> frecuenciaServicioList;

    public TipoDemanda() {
    }

    public TipoDemanda(Integer idTipoDemanda) {
        this.idTipoDemanda = idTipoDemanda;
    }

    public TipoDemanda(Integer idTipoDemanda, String nombreTipoDemanda) {
        this.idTipoDemanda = idTipoDemanda;
        this.nombreTipoDemanda = nombreTipoDemanda;
    }

    public Integer getIdTipoDemanda() {
        return idTipoDemanda;
    }

    public void setIdTipoDemanda(Integer idTipoDemanda) {
        this.idTipoDemanda = idTipoDemanda;
    }

    public String getNombreTipoDemanda() {
        return nombreTipoDemanda;
    }

    public void setNombreTipoDemanda(String nombreTipoDemanda) {
        this.nombreTipoDemanda = nombreTipoDemanda;
    }

    @XmlTransient
    public List<FrecuenciaServicio> getFrecuenciaServicioList() {
        return frecuenciaServicioList;
    }

    public void setFrecuenciaServicioList(List<FrecuenciaServicio> frecuenciaServicioList) {
        this.frecuenciaServicioList = frecuenciaServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDemanda != null ? idTipoDemanda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDemanda)) {
            return false;
        }
        TipoDemanda other = (TipoDemanda) object;
        if ((this.idTipoDemanda == null && other.idTipoDemanda != null) || (this.idTipoDemanda != null && !this.idTipoDemanda.equals(other.idTipoDemanda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TipoDemanda[ idTipoDemanda=" + idTipoDemanda + " ]";
    }
    
}
