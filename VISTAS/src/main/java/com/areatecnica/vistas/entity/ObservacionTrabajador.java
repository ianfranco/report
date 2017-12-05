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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "observacion_trabajador", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObservacionTrabajador.findAll", query = "SELECT o FROM ObservacionTrabajador o"),
    @NamedQuery(name = "ObservacionTrabajador.findByIdObservacionTrabajador", query = "SELECT o FROM ObservacionTrabajador o WHERE o.idObservacionTrabajador = :idObservacionTrabajador"),
    @NamedQuery(name = "ObservacionTrabajador.findByFecha", query = "SELECT o FROM ObservacionTrabajador o WHERE o.fecha = :fecha"),
    @NamedQuery(name = "ObservacionTrabajador.findByFechaIngreso", query = "SELECT o FROM ObservacionTrabajador o WHERE o.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "ObservacionTrabajador.findByDetalle", query = "SELECT o FROM ObservacionTrabajador o WHERE o.detalle = :detalle")})
public class ObservacionTrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_observacion_trabajador", nullable = false)
    private Integer idObservacionTrabajador;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(nullable = false, length = 65535)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String detalle;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;

    public ObservacionTrabajador() {
    }

    public ObservacionTrabajador(Integer idObservacionTrabajador) {
        this.idObservacionTrabajador = idObservacionTrabajador;
    }

    public ObservacionTrabajador(Integer idObservacionTrabajador, Date fecha, Date fechaIngreso, String descripcion, String detalle) {
        this.idObservacionTrabajador = idObservacionTrabajador;
        this.fecha = fecha;
        this.fechaIngreso = fechaIngreso;
        this.descripcion = descripcion;
        this.detalle = detalle;
    }

    public Integer getIdObservacionTrabajador() {
        return idObservacionTrabajador;
    }

    public void setIdObservacionTrabajador(Integer idObservacionTrabajador) {
        this.idObservacionTrabajador = idObservacionTrabajador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Trabajador getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Trabajador idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObservacionTrabajador != null ? idObservacionTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservacionTrabajador)) {
            return false;
        }
        ObservacionTrabajador other = (ObservacionTrabajador) object;
        if ((this.idObservacionTrabajador == null && other.idObservacionTrabajador != null) || (this.idObservacionTrabajador != null && !this.idObservacionTrabajador.equals(other.idObservacionTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.ObservacionTrabajador[ idObservacionTrabajador=" + idObservacionTrabajador + " ]";
    }
    
}
