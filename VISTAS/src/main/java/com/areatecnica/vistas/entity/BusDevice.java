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
@Table(name = "bus_device", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BusDevice.findAll", query = "SELECT b FROM BusDevice b"),
    @NamedQuery(name = "BusDevice.findByIdBusDevice", query = "SELECT b FROM BusDevice b WHERE b.idBusDevice = :idBusDevice"),
    @NamedQuery(name = "BusDevice.findByFechaRegistro", query = "SELECT b FROM BusDevice b WHERE b.fechaRegistro = :fechaRegistro")})
public class BusDevice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bus_device", nullable = false)
    private Integer idBusDevice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @JoinColumn(name = "id_bus", referencedColumnName = "id_bus", nullable = false)
    @ManyToOne(optional = false)
    private Bus idBus;
    @JoinColumn(name = "id_device", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Device idDevice;

    public BusDevice() {
    }

    public BusDevice(Integer idBusDevice) {
        this.idBusDevice = idBusDevice;
    }

    public BusDevice(Integer idBusDevice, Date fechaRegistro) {
        this.idBusDevice = idBusDevice;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdBusDevice() {
        return idBusDevice;
    }

    public void setIdBusDevice(Integer idBusDevice) {
        this.idBusDevice = idBusDevice;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Bus getIdBus() {
        return idBus;
    }

    public void setIdBus(Bus idBus) {
        this.idBus = idBus;
    }

    public Device getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(Device idDevice) {
        this.idDevice = idDevice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBusDevice != null ? idBusDevice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusDevice)) {
            return false;
        }
        BusDevice other = (BusDevice) object;
        if ((this.idBusDevice == null && other.idBusDevice != null) || (this.idBusDevice != null && !this.idBusDevice.equals(other.idBusDevice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.BusDevice[ idBusDevice=" + idBusDevice + " ]";
    }
    
}
