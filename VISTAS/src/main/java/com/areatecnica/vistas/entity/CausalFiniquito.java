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
@Table(name = "causal_finiquito", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CausalFiniquito.findAll", query = "SELECT c FROM CausalFiniquito c"),
    @NamedQuery(name = "CausalFiniquito.findByIdCausalFiniquito", query = "SELECT c FROM CausalFiniquito c WHERE c.idCausalFiniquito = :idCausalFiniquito"),
    @NamedQuery(name = "CausalFiniquito.findByCodigoCausalFiniquito", query = "SELECT c FROM CausalFiniquito c WHERE c.codigoCausalFiniquito = :codigoCausalFiniquito"),
    @NamedQuery(name = "CausalFiniquito.findByDescripcionCausalFiniquito", query = "SELECT c FROM CausalFiniquito c WHERE c.descripcionCausalFiniquito = :descripcionCausalFiniquito")})
public class CausalFiniquito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_causal_finiquito", nullable = false)
    private Integer idCausalFiniquito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo_causal_finiquito", nullable = false, length = 45)
    private String codigoCausalFiniquito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descripcion_causal_finiquito", nullable = false, length = 150)
    private String descripcionCausalFiniquito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCausalFiniquito")
    private List<FiniquitoRelacionLaboral> finiquitoRelacionLaboralList;

    public CausalFiniquito() {
    }

    public CausalFiniquito(Integer idCausalFiniquito) {
        this.idCausalFiniquito = idCausalFiniquito;
    }

    public CausalFiniquito(Integer idCausalFiniquito, String codigoCausalFiniquito, String descripcionCausalFiniquito) {
        this.idCausalFiniquito = idCausalFiniquito;
        this.codigoCausalFiniquito = codigoCausalFiniquito;
        this.descripcionCausalFiniquito = descripcionCausalFiniquito;
    }

    public Integer getIdCausalFiniquito() {
        return idCausalFiniquito;
    }

    public void setIdCausalFiniquito(Integer idCausalFiniquito) {
        this.idCausalFiniquito = idCausalFiniquito;
    }

    public String getCodigoCausalFiniquito() {
        return codigoCausalFiniquito;
    }

    public void setCodigoCausalFiniquito(String codigoCausalFiniquito) {
        this.codigoCausalFiniquito = codigoCausalFiniquito;
    }

    public String getDescripcionCausalFiniquito() {
        return descripcionCausalFiniquito;
    }

    public void setDescripcionCausalFiniquito(String descripcionCausalFiniquito) {
        this.descripcionCausalFiniquito = descripcionCausalFiniquito;
    }

    @XmlTransient
    public List<FiniquitoRelacionLaboral> getFiniquitoRelacionLaboralList() {
        return finiquitoRelacionLaboralList;
    }

    public void setFiniquitoRelacionLaboralList(List<FiniquitoRelacionLaboral> finiquitoRelacionLaboralList) {
        this.finiquitoRelacionLaboralList = finiquitoRelacionLaboralList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCausalFiniquito != null ? idCausalFiniquito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CausalFiniquito)) {
            return false;
        }
        CausalFiniquito other = (CausalFiniquito) object;
        if ((this.idCausalFiniquito == null && other.idCausalFiniquito != null) || (this.idCausalFiniquito != null && !this.idCausalFiniquito.equals(other.idCausalFiniquito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.CausalFiniquito[ idCausalFiniquito=" + idCausalFiniquito + " ]";
    }
    
}
