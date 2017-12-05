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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "tipo_cargo", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCargo.findAll", query = "SELECT t FROM TipoCargo t"),
    @NamedQuery(name = "TipoCargo.findByIdTipoCargo", query = "SELECT t FROM TipoCargo t WHERE t.idTipoCargo = :idTipoCargo"),
    @NamedQuery(name = "TipoCargo.findByNombreTipoCargo", query = "SELECT t FROM TipoCargo t WHERE t.nombreTipoCargo = :nombreTipoCargo"),
    @NamedQuery(name = "TipoCargo.findByFechaIngreso", query = "SELECT t FROM TipoCargo t WHERE t.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "TipoCargo.findByMontoDefecto", query = "SELECT t FROM TipoCargo t WHERE t.montoDefecto = :montoDefecto")})
public class TipoCargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_cargo", nullable = false)
    private Integer idTipoCargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_cargo", nullable = false, length = 45)
    private String nombreTipoCargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "monto_defecto")
    private Integer montoDefecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCargo")
    private List<CargoBus> cargoBusList;

    public TipoCargo() {
    }

    public TipoCargo(Integer idTipoCargo) {
        this.idTipoCargo = idTipoCargo;
    }

    public TipoCargo(Integer idTipoCargo, String nombreTipoCargo, Date fechaIngreso) {
        this.idTipoCargo = idTipoCargo;
        this.nombreTipoCargo = nombreTipoCargo;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdTipoCargo() {
        return idTipoCargo;
    }

    public void setIdTipoCargo(Integer idTipoCargo) {
        this.idTipoCargo = idTipoCargo;
    }

    public String getNombreTipoCargo() {
        return nombreTipoCargo;
    }

    public void setNombreTipoCargo(String nombreTipoCargo) {
        this.nombreTipoCargo = nombreTipoCargo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getMontoDefecto() {
        return montoDefecto;
    }

    public void setMontoDefecto(Integer montoDefecto) {
        this.montoDefecto = montoDefecto;
    }

    @XmlTransient
    public List<CargoBus> getCargoBusList() {
        return cargoBusList;
    }

    public void setCargoBusList(List<CargoBus> cargoBusList) {
        this.cargoBusList = cargoBusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCargo != null ? idTipoCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCargo)) {
            return false;
        }
        TipoCargo other = (TipoCargo) object;
        if ((this.idTipoCargo == null && other.idTipoCargo != null) || (this.idTipoCargo != null && !this.idTipoCargo.equals(other.idTipoCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TipoCargo[ idTipoCargo=" + idTipoCargo + " ]";
    }
    
}
