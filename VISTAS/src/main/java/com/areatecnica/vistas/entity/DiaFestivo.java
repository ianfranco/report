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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "dia_festivo", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiaFestivo.findAll", query = "SELECT d FROM DiaFestivo d"),
    @NamedQuery(name = "DiaFestivo.findByIdDiaFestivo", query = "SELECT d FROM DiaFestivo d WHERE d.idDiaFestivo = :idDiaFestivo"),
    @NamedQuery(name = "DiaFestivo.findByNombreDiaFestivo", query = "SELECT d FROM DiaFestivo d WHERE d.nombreDiaFestivo = :nombreDiaFestivo"),
    @NamedQuery(name = "DiaFestivo.findByFecha", query = "SELECT d FROM DiaFestivo d WHERE d.fecha = :fecha")})
public class DiaFestivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dia_festivo", nullable = false)
    private Integer idDiaFestivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_dia_festivo", nullable = false, length = 45)
    private String nombreDiaFestivo;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public DiaFestivo() {
    }

    public DiaFestivo(Integer idDiaFestivo) {
        this.idDiaFestivo = idDiaFestivo;
    }

    public DiaFestivo(Integer idDiaFestivo, String nombreDiaFestivo, Date fecha) {
        this.idDiaFestivo = idDiaFestivo;
        this.nombreDiaFestivo = nombreDiaFestivo;
        this.fecha = fecha;
    }

    public Integer getIdDiaFestivo() {
        return idDiaFestivo;
    }

    public void setIdDiaFestivo(Integer idDiaFestivo) {
        this.idDiaFestivo = idDiaFestivo;
    }

    public String getNombreDiaFestivo() {
        return nombreDiaFestivo;
    }

    public void setNombreDiaFestivo(String nombreDiaFestivo) {
        this.nombreDiaFestivo = nombreDiaFestivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiaFestivo != null ? idDiaFestivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiaFestivo)) {
            return false;
        }
        DiaFestivo other = (DiaFestivo) object;
        if ((this.idDiaFestivo == null && other.idDiaFestivo != null) || (this.idDiaFestivo != null && !this.idDiaFestivo.equals(other.idDiaFestivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.DiaFestivo[ idDiaFestivo=" + idDiaFestivo + " ]";
    }
    
}
