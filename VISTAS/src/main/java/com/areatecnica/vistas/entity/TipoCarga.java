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
@Table(name = "tipo_carga", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCarga.findAll", query = "SELECT t FROM TipoCarga t"),
    @NamedQuery(name = "TipoCarga.findByIdTipoCarga", query = "SELECT t FROM TipoCarga t WHERE t.idTipoCarga = :idTipoCarga"),
    @NamedQuery(name = "TipoCarga.findByNombreTipoCarga", query = "SELECT t FROM TipoCarga t WHERE t.nombreTipoCarga = :nombreTipoCarga")})
public class TipoCarga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_carga", nullable = false)
    private Integer idTipoCarga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_carga", nullable = false, length = 45)
    private String nombreTipoCarga;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCarga")
    private List<CargasTrabajador> cargasTrabajadorList;

    public TipoCarga() {
    }

    public TipoCarga(Integer idTipoCarga) {
        this.idTipoCarga = idTipoCarga;
    }

    public TipoCarga(Integer idTipoCarga, String nombreTipoCarga) {
        this.idTipoCarga = idTipoCarga;
        this.nombreTipoCarga = nombreTipoCarga;
    }

    public Integer getIdTipoCarga() {
        return idTipoCarga;
    }

    public void setIdTipoCarga(Integer idTipoCarga) {
        this.idTipoCarga = idTipoCarga;
    }

    public String getNombreTipoCarga() {
        return nombreTipoCarga;
    }

    public void setNombreTipoCarga(String nombreTipoCarga) {
        this.nombreTipoCarga = nombreTipoCarga;
    }

    @XmlTransient
    public List<CargasTrabajador> getCargasTrabajadorList() {
        return cargasTrabajadorList;
    }

    public void setCargasTrabajadorList(List<CargasTrabajador> cargasTrabajadorList) {
        this.cargasTrabajadorList = cargasTrabajadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCarga != null ? idTipoCarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCarga)) {
            return false;
        }
        TipoCarga other = (TipoCarga) object;
        if ((this.idTipoCarga == null && other.idTipoCarga != null) || (this.idTipoCarga != null && !this.idTipoCarga.equals(other.idTipoCarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TipoCarga[ idTipoCarga=" + idTipoCarga + " ]";
    }
    
}
