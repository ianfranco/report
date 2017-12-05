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
@Table(name = "tipo_abono", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAbono.findAll", query = "SELECT t FROM TipoAbono t"),
    @NamedQuery(name = "TipoAbono.findByIdTipoAbono", query = "SELECT t FROM TipoAbono t WHERE t.idTipoAbono = :idTipoAbono"),
    @NamedQuery(name = "TipoAbono.findByNombreTipoAbono", query = "SELECT t FROM TipoAbono t WHERE t.nombreTipoAbono = :nombreTipoAbono"),
    @NamedQuery(name = "TipoAbono.findByFechaIngreso", query = "SELECT t FROM TipoAbono t WHERE t.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "TipoAbono.findByMontoDefecto", query = "SELECT t FROM TipoAbono t WHERE t.montoDefecto = :montoDefecto")})
public class TipoAbono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_abono", nullable = false)
    private Integer idTipoAbono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_abono", nullable = false, length = 45)
    private String nombreTipoAbono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "monto_defecto")
    private Integer montoDefecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoAbono")
    private List<AbonoBus> abonoBusList;

    public TipoAbono() {
    }

    public TipoAbono(Integer idTipoAbono) {
        this.idTipoAbono = idTipoAbono;
    }

    public TipoAbono(Integer idTipoAbono, String nombreTipoAbono, Date fechaIngreso) {
        this.idTipoAbono = idTipoAbono;
        this.nombreTipoAbono = nombreTipoAbono;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdTipoAbono() {
        return idTipoAbono;
    }

    public void setIdTipoAbono(Integer idTipoAbono) {
        this.idTipoAbono = idTipoAbono;
    }

    public String getNombreTipoAbono() {
        return nombreTipoAbono;
    }

    public void setNombreTipoAbono(String nombreTipoAbono) {
        this.nombreTipoAbono = nombreTipoAbono;
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
    public List<AbonoBus> getAbonoBusList() {
        return abonoBusList;
    }

    public void setAbonoBusList(List<AbonoBus> abonoBusList) {
        this.abonoBusList = abonoBusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAbono != null ? idTipoAbono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAbono)) {
            return false;
        }
        TipoAbono other = (TipoAbono) object;
        if ((this.idTipoAbono == null && other.idTipoAbono != null) || (this.idTipoAbono != null && !this.idTipoAbono.equals(other.idTipoAbono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TipoAbono[ idTipoAbono=" + idTipoAbono + " ]";
    }
    
}
