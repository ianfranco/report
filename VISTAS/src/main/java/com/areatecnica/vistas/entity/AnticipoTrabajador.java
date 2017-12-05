/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "anticipo_trabajador", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnticipoTrabajador.findAll", query = "SELECT a FROM AnticipoTrabajador a"),
    @NamedQuery(name = "AnticipoTrabajador.findByIdAnticipoTrabajador", query = "SELECT a FROM AnticipoTrabajador a WHERE a.idAnticipoTrabajador = :idAnticipoTrabajador"),
    @NamedQuery(name = "AnticipoTrabajador.findByMes", query = "SELECT a FROM AnticipoTrabajador a WHERE a.mes = :mes"),
    @NamedQuery(name = "AnticipoTrabajador.findByA\u00f1o", query = "SELECT a FROM AnticipoTrabajador a WHERE a.a\u00f1o = :a\u00f1o"),
    @NamedQuery(name = "AnticipoTrabajador.findByMonto", query = "SELECT a FROM AnticipoTrabajador a WHERE a.monto = :monto")})
public class AnticipoTrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anticipo_trabajador", nullable = false)
    private Integer idAnticipoTrabajador;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int mes;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int año;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int monto;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;

    public AnticipoTrabajador() {
    }

    public AnticipoTrabajador(Integer idAnticipoTrabajador) {
        this.idAnticipoTrabajador = idAnticipoTrabajador;
    }

    public AnticipoTrabajador(Integer idAnticipoTrabajador, int mes, int año, int monto) {
        this.idAnticipoTrabajador = idAnticipoTrabajador;
        this.mes = mes;
        this.año = año;
        this.monto = monto;
    }

    public Integer getIdAnticipoTrabajador() {
        return idAnticipoTrabajador;
    }

    public void setIdAnticipoTrabajador(Integer idAnticipoTrabajador) {
        this.idAnticipoTrabajador = idAnticipoTrabajador;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
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
        hash += (idAnticipoTrabajador != null ? idAnticipoTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnticipoTrabajador)) {
            return false;
        }
        AnticipoTrabajador other = (AnticipoTrabajador) object;
        if ((this.idAnticipoTrabajador == null && other.idAnticipoTrabajador != null) || (this.idAnticipoTrabajador != null && !this.idAnticipoTrabajador.equals(other.idAnticipoTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.AnticipoTrabajador[ idAnticipoTrabajador=" + idAnticipoTrabajador + " ]";
    }
    
}
