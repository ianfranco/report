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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "bus_servicio", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BusServicio.findAll", query = "SELECT b FROM BusServicio b"),
    @NamedQuery(name = "BusServicio.findByIdBusServicio", query = "SELECT b FROM BusServicio b WHERE b.idBusServicio = :idBusServicio")})
public class BusServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bus_servicio", nullable = false)
    private Integer idBusServicio;
    @JoinColumn(name = "id_bus", referencedColumnName = "id_bus", nullable = false)
    @ManyToOne(optional = false)
    private Bus idBus;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", nullable = false)
    @ManyToOne(optional = false)
    private Servicio idServicio;

    public BusServicio() {
    }

    public BusServicio(Integer idBusServicio) {
        this.idBusServicio = idBusServicio;
    }

    public Integer getIdBusServicio() {
        return idBusServicio;
    }

    public void setIdBusServicio(Integer idBusServicio) {
        this.idBusServicio = idBusServicio;
    }

    public Bus getIdBus() {
        return idBus;
    }

    public void setIdBus(Bus idBus) {
        this.idBus = idBus;
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
        hash += (idBusServicio != null ? idBusServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusServicio)) {
            return false;
        }
        BusServicio other = (BusServicio) object;
        if ((this.idBusServicio == null && other.idBusServicio != null) || (this.idBusServicio != null && !this.idBusServicio.equals(other.idBusServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.BusServicio[ idBusServicio=" + idBusServicio + " ]";
    }
    
}
