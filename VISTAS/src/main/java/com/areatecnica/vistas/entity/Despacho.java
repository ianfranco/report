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
@Table(catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Despacho.findAll", query = "SELECT d FROM Despacho d"),
    @NamedQuery(name = "Despacho.findByIdDespacho", query = "SELECT d FROM Despacho d WHERE d.idDespacho = :idDespacho"),
    @NamedQuery(name = "Despacho.findByFecha", query = "SELECT d FROM Despacho d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Despacho.findByHorario", query = "SELECT d FROM Despacho d WHERE d.horario = :horario")})
public class Despacho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_despacho", nullable = false)
    private Integer idDespacho;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horario;
    @JoinColumn(name = "id_bus", referencedColumnName = "id_bus", nullable = false)
    @ManyToOne(optional = false)
    private Bus idBus;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;
    @JoinColumn(name = "id_inspector", referencedColumnName = "id_usario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idInspector;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", nullable = false)
    @ManyToOne(optional = false)
    private Servicio idServicio;

    public Despacho() {
    }

    public Despacho(Integer idDespacho) {
        this.idDespacho = idDespacho;
    }

    public Despacho(Integer idDespacho, Date fecha, Date horario) {
        this.idDespacho = idDespacho;
        this.fecha = fecha;
        this.horario = horario;
    }

    public Integer getIdDespacho() {
        return idDespacho;
    }

    public void setIdDespacho(Integer idDespacho) {
        this.idDespacho = idDespacho;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Bus getIdBus() {
        return idBus;
    }

    public void setIdBus(Bus idBus) {
        this.idBus = idBus;
    }

    public Trabajador getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Trabajador idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Usuario getIdInspector() {
        return idInspector;
    }

    public void setIdInspector(Usuario idInspector) {
        this.idInspector = idInspector;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDespacho != null ? idDespacho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Despacho)) {
            return false;
        }
        Despacho other = (Despacho) object;
        if ((this.idDespacho == null && other.idDespacho != null) || (this.idDespacho != null && !this.idDespacho.equals(other.idDespacho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Despacho[ idDespacho=" + idDespacho + " ]";
    }
    
}
