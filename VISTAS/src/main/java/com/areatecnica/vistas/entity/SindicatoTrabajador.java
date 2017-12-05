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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sindicato_trabajador", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SindicatoTrabajador.findAll", query = "SELECT s FROM SindicatoTrabajador s"),
    @NamedQuery(name = "SindicatoTrabajador.findByIdSindicatoTrabajador", query = "SELECT s FROM SindicatoTrabajador s WHERE s.idSindicatoTrabajador = :idSindicatoTrabajador"),
    @NamedQuery(name = "SindicatoTrabajador.findByFechaIngreso", query = "SELECT s FROM SindicatoTrabajador s WHERE s.fechaIngreso = :fechaIngreso")})
public class SindicatoTrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sindicato_trabajador", nullable = false)
    private Integer idSindicatoTrabajador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @JoinColumn(name = "id_sindicato", referencedColumnName = "id_sindicato", nullable = false)
    @ManyToOne(optional = false)
    private Sindicato idSindicato;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSindicatoTrabajador")
    private List<MontoSindicatoTrabajador> montoSindicatoTrabajadorList;

    public SindicatoTrabajador() {
    }

    public SindicatoTrabajador(Integer idSindicatoTrabajador) {
        this.idSindicatoTrabajador = idSindicatoTrabajador;
    }

    public SindicatoTrabajador(Integer idSindicatoTrabajador, Date fechaIngreso) {
        this.idSindicatoTrabajador = idSindicatoTrabajador;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdSindicatoTrabajador() {
        return idSindicatoTrabajador;
    }

    public void setIdSindicatoTrabajador(Integer idSindicatoTrabajador) {
        this.idSindicatoTrabajador = idSindicatoTrabajador;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Sindicato getIdSindicato() {
        return idSindicato;
    }

    public void setIdSindicato(Sindicato idSindicato) {
        this.idSindicato = idSindicato;
    }

    public Trabajador getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Trabajador idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @XmlTransient
    public List<MontoSindicatoTrabajador> getMontoSindicatoTrabajadorList() {
        return montoSindicatoTrabajadorList;
    }

    public void setMontoSindicatoTrabajadorList(List<MontoSindicatoTrabajador> montoSindicatoTrabajadorList) {
        this.montoSindicatoTrabajadorList = montoSindicatoTrabajadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSindicatoTrabajador != null ? idSindicatoTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SindicatoTrabajador)) {
            return false;
        }
        SindicatoTrabajador other = (SindicatoTrabajador) object;
        if ((this.idSindicatoTrabajador == null && other.idSindicatoTrabajador != null) || (this.idSindicatoTrabajador != null && !this.idSindicatoTrabajador.equals(other.idSindicatoTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.SindicatoTrabajador[ idSindicatoTrabajador=" + idSindicatoTrabajador + " ]";
    }
    
}
