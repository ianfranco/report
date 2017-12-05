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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Position.findAll", query = "SELECT p FROM Position p"),
    @NamedQuery(name = "Position.findById", query = "SELECT p FROM Position p WHERE p.id = :id"),
    @NamedQuery(name = "Position.findByProtocol", query = "SELECT p FROM Position p WHERE p.protocol = :protocol"),
    @NamedQuery(name = "Position.findByServerTime", query = "SELECT p FROM Position p WHERE p.serverTime = :serverTime"),
    @NamedQuery(name = "Position.findByDeviceTime", query = "SELECT p FROM Position p WHERE p.deviceTime = :deviceTime"),
    @NamedQuery(name = "Position.findByFixTime", query = "SELECT p FROM Position p WHERE p.fixTime = :fixTime"),
    @NamedQuery(name = "Position.findByValid", query = "SELECT p FROM Position p WHERE p.valid = :valid"),
    @NamedQuery(name = "Position.findByLatitude", query = "SELECT p FROM Position p WHERE p.latitude = :latitude"),
    @NamedQuery(name = "Position.findByLongitude", query = "SELECT p FROM Position p WHERE p.longitude = :longitude"),
    @NamedQuery(name = "Position.findByAltitude", query = "SELECT p FROM Position p WHERE p.altitude = :altitude"),
    @NamedQuery(name = "Position.findBySpeed", query = "SELECT p FROM Position p WHERE p.speed = :speed"),
    @NamedQuery(name = "Position.findByCourse", query = "SELECT p FROM Position p WHERE p.course = :course"),
    @NamedQuery(name = "Position.findByAddress", query = "SELECT p FROM Position p WHERE p.address = :address"),
    @NamedQuery(name = "Position.findByAttributes", query = "SELECT p FROM Position p WHERE p.attributes = :attributes")})
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 128)
    @Column(length = 128)
    private String protocol;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date serverTime;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deviceTime;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fixTime;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean valid;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double latitude;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double longitude;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private float altitude;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private float speed;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private float course;
    @Size(max = 512)
    @Column(length = 512)
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4096)
    @Column(nullable = false, length = 4096)
    private String attributes;
    @JoinColumn(name = "deviceId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Device deviceId;

    public Position() {
    }

    public Position(Integer id) {
        this.id = id;
    }

    public Position(Integer id, Date serverTime, Date deviceTime, Date fixTime, boolean valid, double latitude, double longitude, float altitude, float speed, float course, String attributes) {
        this.id = id;
        this.serverTime = serverTime;
        this.deviceTime = deviceTime;
        this.fixTime = fixTime;
        this.valid = valid;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.speed = speed;
        this.course = course;
        this.attributes = attributes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    public Date getDeviceTime() {
        return deviceTime;
    }

    public void setDeviceTime(Date deviceTime) {
        this.deviceTime = deviceTime;
    }

    public Date getFixTime() {
        return fixTime;
    }

    public void setFixTime(Date fixTime) {
        this.fixTime = fixTime;
    }

    public boolean getValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getCourse() {
        return course;
    }

    public void setCourse(float course) {
        this.course = course;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Position)) {
            return false;
        }
        Position other = (Position) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Position[ id=" + id + " ]";
    }
    
}
