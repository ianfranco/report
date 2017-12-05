/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "finiquito_relacion_laboral", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FiniquitoRelacionLaboral.findAll", query = "SELECT f FROM FiniquitoRelacionLaboral f"),
    @NamedQuery(name = "FiniquitoRelacionLaboral.findByIdFiniquitoRelacionLaboral", query = "SELECT f FROM FiniquitoRelacionLaboral f WHERE f.idFiniquitoRelacionLaboral = :idFiniquitoRelacionLaboral"),
    @NamedQuery(name = "FiniquitoRelacionLaboral.findByFechaFiniquito", query = "SELECT f FROM FiniquitoRelacionLaboral f WHERE f.fechaFiniquito = :fechaFiniquito"),
    @NamedQuery(name = "FiniquitoRelacionLaboral.findByMontoFiniquito", query = "SELECT f FROM FiniquitoRelacionLaboral f WHERE f.montoFiniquito = :montoFiniquito")})
public class FiniquitoRelacionLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_finiquito_relacion_laboral", nullable = false)
    private Integer idFiniquitoRelacionLaboral;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_finiquito", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFiniquito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_finiquito", nullable = false)
    private int montoFiniquito;
    @JoinColumn(name = "id_causal_finiquito", referencedColumnName = "id_causal_finiquito", nullable = false)
    @ManyToOne(optional = false)
    private CausalFiniquito idCausalFiniquito;
    @JoinColumn(name = "id_relacion_laboral", referencedColumnName = "id_relacion_laboral", nullable = false)
    @ManyToOne(optional = false)
    private RelacionLaboral idRelacionLaboral;

    public FiniquitoRelacionLaboral() {
    }

    public FiniquitoRelacionLaboral(Integer idFiniquitoRelacionLaboral) {
        this.idFiniquitoRelacionLaboral = idFiniquitoRelacionLaboral;
    }

    public FiniquitoRelacionLaboral(Integer idFiniquitoRelacionLaboral, Date fechaFiniquito, int montoFiniquito) {
        this.idFiniquitoRelacionLaboral = idFiniquitoRelacionLaboral;
        this.fechaFiniquito = fechaFiniquito;
        this.montoFiniquito = montoFiniquito;
    }

    public Integer getIdFiniquitoRelacionLaboral() {
        return idFiniquitoRelacionLaboral;
    }

    public void setIdFiniquitoRelacionLaboral(Integer idFiniquitoRelacionLaboral) {
        this.idFiniquitoRelacionLaboral = idFiniquitoRelacionLaboral;
    }

    public Date getFechaFiniquito() {
        return fechaFiniquito;
    }

    public void setFechaFiniquito(Date fechaFiniquito) {
        this.fechaFiniquito = fechaFiniquito;
    }

    public int getMontoFiniquito() {
        return montoFiniquito;
    }

    public void setMontoFiniquito(int montoFiniquito) {
        this.montoFiniquito = montoFiniquito;
    }

    public CausalFiniquito getIdCausalFiniquito() {
        return idCausalFiniquito;
    }

    public void setIdCausalFiniquito(CausalFiniquito idCausalFiniquito) {
        this.idCausalFiniquito = idCausalFiniquito;
    }

    public RelacionLaboral getIdRelacionLaboral() {
        return idRelacionLaboral;
    }

    public void setIdRelacionLaboral(RelacionLaboral idRelacionLaboral) {
        this.idRelacionLaboral = idRelacionLaboral;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFiniquitoRelacionLaboral != null ? idFiniquitoRelacionLaboral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FiniquitoRelacionLaboral)) {
            return false;
        }
        FiniquitoRelacionLaboral other = (FiniquitoRelacionLaboral) object;
        if ((this.idFiniquitoRelacionLaboral == null && other.idFiniquitoRelacionLaboral != null) || (this.idFiniquitoRelacionLaboral != null && !this.idFiniquitoRelacionLaboral.equals(other.idFiniquitoRelacionLaboral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.FiniquitoRelacionLaboral[ idFiniquitoRelacionLaboral=" + idFiniquitoRelacionLaboral + " ]";
    }
    
}
