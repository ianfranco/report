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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "Server.findAll", query = "SELECT s FROM Server s"),
    @NamedQuery(name = "Server.findById", query = "SELECT s FROM Server s WHERE s.id = :id"),
    @NamedQuery(name = "Server.findByRegistration", query = "SELECT s FROM Server s WHERE s.registration = :registration"),
    @NamedQuery(name = "Server.findByMap", query = "SELECT s FROM Server s WHERE s.map = :map"),
    @NamedQuery(name = "Server.findByBingKey", query = "SELECT s FROM Server s WHERE s.bingKey = :bingKey"),
    @NamedQuery(name = "Server.findByMapUrl", query = "SELECT s FROM Server s WHERE s.mapUrl = :mapUrl"),
    @NamedQuery(name = "Server.findByLanguage", query = "SELECT s FROM Server s WHERE s.language = :language"),
    @NamedQuery(name = "Server.findByDistanceUnit", query = "SELECT s FROM Server s WHERE s.distanceUnit = :distanceUnit"),
    @NamedQuery(name = "Server.findBySpeedUnit", query = "SELECT s FROM Server s WHERE s.speedUnit = :speedUnit"),
    @NamedQuery(name = "Server.findByLatitude", query = "SELECT s FROM Server s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "Server.findByLongitude", query = "SELECT s FROM Server s WHERE s.longitude = :longitude"),
    @NamedQuery(name = "Server.findByZoom", query = "SELECT s FROM Server s WHERE s.zoom = :zoom")})
public class Server implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean registration;
    @Size(max = 128)
    @Column(length = 128)
    private String map;
    @Size(max = 128)
    @Column(length = 128)
    private String bingKey;
    @Size(max = 128)
    @Column(length = 128)
    private String mapUrl;
    @Size(max = 128)
    @Column(length = 128)
    private String language;
    @Size(max = 128)
    @Column(length = 128)
    private String distanceUnit;
    @Size(max = 128)
    @Column(length = 128)
    private String speedUnit;
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
    private int zoom;

    public Server() {
    }

    public Server(Integer id) {
        this.id = id;
    }

    public Server(Integer id, boolean registration, double latitude, double longitude, int zoom) {
        this.id = id;
        this.registration = registration;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zoom = zoom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getBingKey() {
        return bingKey;
    }

    public void setBingKey(String bingKey) {
        this.bingKey = bingKey;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public String getSpeedUnit() {
        return speedUnit;
    }

    public void setSpeedUnit(String speedUnit) {
        this.speedUnit = speedUnit;
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

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
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
        if (!(object instanceof Server)) {
            return false;
        }
        Server other = (Server) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Server[ id=" + id + " ]";
    }
    
}
