/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "periodo_frecuencia", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodoFrecuencia.findAll", query = "SELECT p FROM PeriodoFrecuencia p"),
    @NamedQuery(name = "PeriodoFrecuencia.findByIdPeriodoFrecuencia", query = "SELECT p FROM PeriodoFrecuencia p WHERE p.idPeriodoFrecuencia = :idPeriodoFrecuencia"),
    @NamedQuery(name = "PeriodoFrecuencia.findByDesde", query = "SELECT p FROM PeriodoFrecuencia p WHERE p.desde = :desde"),
    @NamedQuery(name = "PeriodoFrecuencia.findByHasta", query = "SELECT p FROM PeriodoFrecuencia p WHERE p.hasta = :hasta")})
public class PeriodoFrecuencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_periodo_frecuencia", nullable = false)
    private Integer idPeriodoFrecuencia;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date desde;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date hasta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeriodoFrecuencia")
    private List<FrecuenciaServicio> frecuenciaServicioList;

    public PeriodoFrecuencia() {
    }

    public PeriodoFrecuencia(Integer idPeriodoFrecuencia) {
        this.idPeriodoFrecuencia = idPeriodoFrecuencia;
    }

    public PeriodoFrecuencia(Integer idPeriodoFrecuencia, Date desde, Date hasta) {
        this.idPeriodoFrecuencia = idPeriodoFrecuencia;
        this.desde = desde;
        this.hasta = hasta;
    }

    public Integer getIdPeriodoFrecuencia() {
        return idPeriodoFrecuencia;
    }

    public void setIdPeriodoFrecuencia(Integer idPeriodoFrecuencia) {
        this.idPeriodoFrecuencia = idPeriodoFrecuencia;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
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
        hash += (idPeriodoFrecuencia != null ? idPeriodoFrecuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodoFrecuencia)) {
            return false;
        }
        PeriodoFrecuencia other = (PeriodoFrecuencia) object;
        if ((this.idPeriodoFrecuencia == null && other.idPeriodoFrecuencia != null) || (this.idPeriodoFrecuencia != null && !this.idPeriodoFrecuencia.equals(other.idPeriodoFrecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.PeriodoFrecuencia[ idPeriodoFrecuencia=" + idPeriodoFrecuencia + " ]";
    }
    
}
