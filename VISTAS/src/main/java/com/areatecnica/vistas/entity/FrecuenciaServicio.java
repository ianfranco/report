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
@Table(name = "frecuencia_servicio", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FrecuenciaServicio.findAll", query = "SELECT f FROM FrecuenciaServicio f"),
    @NamedQuery(name = "FrecuenciaServicio.findByIdFrecuenciaServicio", query = "SELECT f FROM FrecuenciaServicio f WHERE f.idFrecuenciaServicio = :idFrecuenciaServicio"),
    @NamedQuery(name = "FrecuenciaServicio.findByNumeroBuses", query = "SELECT f FROM FrecuenciaServicio f WHERE f.numeroBuses = :numeroBuses")})
public class FrecuenciaServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_frecuencia_servicio", nullable = false)
    private Integer idFrecuenciaServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_buses", nullable = false)
    private int numeroBuses;
    @JoinColumn(name = "id_periodo_frecuencia", referencedColumnName = "id_periodo_frecuencia", nullable = false)
    @ManyToOne(optional = false)
    private PeriodoFrecuencia idPeriodoFrecuencia;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", nullable = false)
    @ManyToOne(optional = false)
    private Servicio idServicio;
    @JoinColumn(name = "id_tipo_demanda", referencedColumnName = "id_tipo_demanda", nullable = false)
    @ManyToOne(optional = false)
    private TipoDemanda idTipoDemanda;
    @JoinColumn(name = "id_tipo_dia_frecuencia", referencedColumnName = "id_tipo_dia_frecuencia", nullable = false)
    @ManyToOne(optional = false)
    private TipoDiaFrecuencia idTipoDiaFrecuencia;

    public FrecuenciaServicio() {
    }

    public FrecuenciaServicio(Integer idFrecuenciaServicio) {
        this.idFrecuenciaServicio = idFrecuenciaServicio;
    }

    public FrecuenciaServicio(Integer idFrecuenciaServicio, int numeroBuses) {
        this.idFrecuenciaServicio = idFrecuenciaServicio;
        this.numeroBuses = numeroBuses;
    }

    public Integer getIdFrecuenciaServicio() {
        return idFrecuenciaServicio;
    }

    public void setIdFrecuenciaServicio(Integer idFrecuenciaServicio) {
        this.idFrecuenciaServicio = idFrecuenciaServicio;
    }

    public int getNumeroBuses() {
        return numeroBuses;
    }

    public void setNumeroBuses(int numeroBuses) {
        this.numeroBuses = numeroBuses;
    }

    public PeriodoFrecuencia getIdPeriodoFrecuencia() {
        return idPeriodoFrecuencia;
    }

    public void setIdPeriodoFrecuencia(PeriodoFrecuencia idPeriodoFrecuencia) {
        this.idPeriodoFrecuencia = idPeriodoFrecuencia;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public TipoDemanda getIdTipoDemanda() {
        return idTipoDemanda;
    }

    public void setIdTipoDemanda(TipoDemanda idTipoDemanda) {
        this.idTipoDemanda = idTipoDemanda;
    }

    public TipoDiaFrecuencia getIdTipoDiaFrecuencia() {
        return idTipoDiaFrecuencia;
    }

    public void setIdTipoDiaFrecuencia(TipoDiaFrecuencia idTipoDiaFrecuencia) {
        this.idTipoDiaFrecuencia = idTipoDiaFrecuencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFrecuenciaServicio != null ? idFrecuenciaServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrecuenciaServicio)) {
            return false;
        }
        FrecuenciaServicio other = (FrecuenciaServicio) object;
        if ((this.idFrecuenciaServicio == null && other.idFrecuenciaServicio != null) || (this.idFrecuenciaServicio != null && !this.idFrecuenciaServicio.equals(other.idFrecuenciaServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.FrecuenciaServicio[ idFrecuenciaServicio=" + idFrecuenciaServicio + " ]";
    }
    
}
