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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(catalog = "sigf_v1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"uniqueId"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d"),
    @NamedQuery(name = "Device.findById", query = "SELECT d FROM Device d WHERE d.id = :id"),
    @NamedQuery(name = "Device.findByName", query = "SELECT d FROM Device d WHERE d.name = :name"),
    @NamedQuery(name = "Device.findByUniqueId", query = "SELECT d FROM Device d WHERE d.uniqueId = :uniqueId"),
    @NamedQuery(name = "Device.findByStatus", query = "SELECT d FROM Device d WHERE d.status = :status"),
    @NamedQuery(name = "Device.findByLastUpdate", query = "SELECT d FROM Device d WHERE d.lastUpdate = :lastUpdate"),
    @NamedQuery(name = "Device.findByPositionId", query = "SELECT d FROM Device d WHERE d.positionId = :positionId")})
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(nullable = false, length = 128)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(nullable = false, length = 128)
    private String uniqueId;
    @Size(max = 128)
    @Column(length = 128)
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    private Integer positionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDevice")
    private List<BusDevice> busDeviceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceId")
    private List<Position> positionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceId")
    private List<UserDevice> userDeviceList;

    public Device() {
    }

    public Device(Integer id) {
        this.id = id;
    }

    public Device(Integer id, String name, String uniqueId, Date lastUpdate) {
        this.id = id;
        this.name = name;
        this.uniqueId = uniqueId;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    @XmlTransient
    public List<BusDevice> getBusDeviceList() {
        return busDeviceList;
    }

    public void setBusDeviceList(List<BusDevice> busDeviceList) {
        this.busDeviceList = busDeviceList;
    }

    @XmlTransient
    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    @XmlTransient
    public List<UserDevice> getUserDeviceList() {
        return userDeviceList;
    }

    public void setUserDeviceList(List<UserDevice> userDeviceList) {
        this.userDeviceList = userDeviceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Device[ id=" + id + " ]";
    }
    
}
