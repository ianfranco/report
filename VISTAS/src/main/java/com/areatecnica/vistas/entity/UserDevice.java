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
@Table(name = "user_device", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDevice.findAll", query = "SELECT u FROM UserDevice u"),
    @NamedQuery(name = "UserDevice.findByIdUserDevice", query = "SELECT u FROM UserDevice u WHERE u.idUserDevice = :idUserDevice"),
    @NamedQuery(name = "UserDevice.findByRead", query = "SELECT u FROM UserDevice u WHERE u.read = :read"),
    @NamedQuery(name = "UserDevice.findByWrite", query = "SELECT u FROM UserDevice u WHERE u.write = :write")})
public class UserDevice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user_device", nullable = false)
    private Integer idUserDevice;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean read;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean write;
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "deviceId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Device deviceId;

    public UserDevice() {
    }

    public UserDevice(Integer idUserDevice) {
        this.idUserDevice = idUserDevice;
    }

    public UserDevice(Integer idUserDevice, boolean read, boolean write) {
        this.idUserDevice = idUserDevice;
        this.read = read;
        this.write = write;
    }

    public Integer getIdUserDevice() {
        return idUserDevice;
    }

    public void setIdUserDevice(Integer idUserDevice) {
        this.idUserDevice = idUserDevice;
    }

    public boolean getRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean getWrite() {
        return write;
    }

    public void setWrite(boolean write) {
        this.write = write;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Device getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Device deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserDevice != null ? idUserDevice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDevice)) {
            return false;
        }
        UserDevice other = (UserDevice) object;
        if ((this.idUserDevice == null && other.idUserDevice != null) || (this.idUserDevice != null && !this.idUserDevice.equals(other.idUserDevice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.UserDevice[ idUserDevice=" + idUserDevice + " ]";
    }
    
}
