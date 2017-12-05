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
@Table(name = "tipo_dia_frecuencia", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDiaFrecuencia.findAll", query = "SELECT t FROM TipoDiaFrecuencia t"),
    @NamedQuery(name = "TipoDiaFrecuencia.findByIdTipoDiaFrecuencia", query = "SELECT t FROM TipoDiaFrecuencia t WHERE t.idTipoDiaFrecuencia = :idTipoDiaFrecuencia"),
    @NamedQuery(name = "TipoDiaFrecuencia.findByNombreTipoDiaFrecuencia", query = "SELECT t FROM TipoDiaFrecuencia t WHERE t.nombreTipoDiaFrecuencia = :nombreTipoDiaFrecuencia"),
    @NamedQuery(name = "TipoDiaFrecuencia.findByActivo", query = "SELECT t FROM TipoDiaFrecuencia t WHERE t.activo = :activo")})
public class TipoDiaFrecuencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_dia_frecuencia", nullable = false)
    private Integer idTipoDiaFrecuencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_dia_frecuencia", nullable = false, length = 45)
    private String nombreTipoDiaFrecuencia;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDiaFrecuencia")
    private List<FrecuenciaServicio> frecuenciaServicioList;

    public TipoDiaFrecuencia() {
    }

    public TipoDiaFrecuencia(Integer idTipoDiaFrecuencia) {
        this.idTipoDiaFrecuencia = idTipoDiaFrecuencia;
    }

    public TipoDiaFrecuencia(Integer idTipoDiaFrecuencia, String nombreTipoDiaFrecuencia, boolean activo) {
        this.idTipoDiaFrecuencia = idTipoDiaFrecuencia;
        this.nombreTipoDiaFrecuencia = nombreTipoDiaFrecuencia;
        this.activo = activo;
    }

    public Integer getIdTipoDiaFrecuencia() {
        return idTipoDiaFrecuencia;
    }

    public void setIdTipoDiaFrecuencia(Integer idTipoDiaFrecuencia) {
        this.idTipoDiaFrecuencia = idTipoDiaFrecuencia;
    }

    public String getNombreTipoDiaFrecuencia() {
        return nombreTipoDiaFrecuencia;
    }

    public void setNombreTipoDiaFrecuencia(String nombreTipoDiaFrecuencia) {
        this.nombreTipoDiaFrecuencia = nombreTipoDiaFrecuencia;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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
        hash += (idTipoDiaFrecuencia != null ? idTipoDiaFrecuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDiaFrecuencia)) {
            return false;
        }
        TipoDiaFrecuencia other = (TipoDiaFrecuencia) object;
        if ((this.idTipoDiaFrecuencia == null && other.idTipoDiaFrecuencia != null) || (this.idTipoDiaFrecuencia != null && !this.idTipoDiaFrecuencia.equals(other.idTipoDiaFrecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TipoDiaFrecuencia[ idTipoDiaFrecuencia=" + idTipoDiaFrecuencia + " ]";
    }
    
}
