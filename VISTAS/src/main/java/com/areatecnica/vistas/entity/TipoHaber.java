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
@Table(name = "tipo_haber", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoHaber.findAll", query = "SELECT t FROM TipoHaber t"),
    @NamedQuery(name = "TipoHaber.findByIdTipoHaber", query = "SELECT t FROM TipoHaber t WHERE t.idTipoHaber = :idTipoHaber"),
    @NamedQuery(name = "TipoHaber.findByNombreTipoHaber", query = "SELECT t FROM TipoHaber t WHERE t.nombreTipoHaber = :nombreTipoHaber"),
    @NamedQuery(name = "TipoHaber.findByFechaIngreso", query = "SELECT t FROM TipoHaber t WHERE t.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "TipoHaber.findByMontoDefecto", query = "SELECT t FROM TipoHaber t WHERE t.montoDefecto = :montoDefecto"),
    @NamedQuery(name = "TipoHaber.findByImponible", query = "SELECT t FROM TipoHaber t WHERE t.imponible = :imponible")})
public class TipoHaber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_haber", nullable = false)
    private Integer idTipoHaber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_tipo_haber", nullable = false, length = 255)
    private String nombreTipoHaber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "monto_defecto")
    private Integer montoDefecto;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean imponible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoHaber")
    private List<HaberTrabajador> haberTrabajadorList;

    public TipoHaber() {
    }

    public TipoHaber(Integer idTipoHaber) {
        this.idTipoHaber = idTipoHaber;
    }

    public TipoHaber(Integer idTipoHaber, String nombreTipoHaber, Date fechaIngreso, boolean imponible) {
        this.idTipoHaber = idTipoHaber;
        this.nombreTipoHaber = nombreTipoHaber;
        this.fechaIngreso = fechaIngreso;
        this.imponible = imponible;
    }

    public Integer getIdTipoHaber() {
        return idTipoHaber;
    }

    public void setIdTipoHaber(Integer idTipoHaber) {
        this.idTipoHaber = idTipoHaber;
    }

    public String getNombreTipoHaber() {
        return nombreTipoHaber;
    }

    public void setNombreTipoHaber(String nombreTipoHaber) {
        this.nombreTipoHaber = nombreTipoHaber;
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

    public boolean getImponible() {
        return imponible;
    }

    public void setImponible(boolean imponible) {
        this.imponible = imponible;
    }

    @XmlTransient
    public List<HaberTrabajador> getHaberTrabajadorList() {
        return haberTrabajadorList;
    }

    public void setHaberTrabajadorList(List<HaberTrabajador> haberTrabajadorList) {
        this.haberTrabajadorList = haberTrabajadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoHaber != null ? idTipoHaber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoHaber)) {
            return false;
        }
        TipoHaber other = (TipoHaber) object;
        if ((this.idTipoHaber == null && other.idTipoHaber != null) || (this.idTipoHaber != null && !this.idTipoHaber.equals(other.idTipoHaber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TipoHaber[ idTipoHaber=" + idTipoHaber + " ]";
    }
    
}
