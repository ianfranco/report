/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
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
    @UniqueConstraint(columnNames = {"email"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByHashedPassword", query = "SELECT u FROM User u WHERE u.hashedPassword = :hashedPassword"),
    @NamedQuery(name = "User.findBySalt", query = "SELECT u FROM User u WHERE u.salt = :salt"),
    @NamedQuery(name = "User.findByReadonly", query = "SELECT u FROM User u WHERE u.readonly = :readonly"),
    @NamedQuery(name = "User.findByAdmin", query = "SELECT u FROM User u WHERE u.admin = :admin"),
    @NamedQuery(name = "User.findByMap", query = "SELECT u FROM User u WHERE u.map = :map"),
    @NamedQuery(name = "User.findByLanguage", query = "SELECT u FROM User u WHERE u.language = :language"),
    @NamedQuery(name = "User.findByDistanceUnit", query = "SELECT u FROM User u WHERE u.distanceUnit = :distanceUnit"),
    @NamedQuery(name = "User.findBySpeedUnit", query = "SELECT u FROM User u WHERE u.speedUnit = :speedUnit"),
    @NamedQuery(name = "User.findByLatitude", query = "SELECT u FROM User u WHERE u.latitude = :latitude"),
    @NamedQuery(name = "User.findByLongitude", query = "SELECT u FROM User u WHERE u.longitude = :longitude"),
    @NamedQuery(name = "User.findByZoom", query = "SELECT u FROM User u WHERE u.zoom = :zoom")})
public class User implements Serializable {

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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(nullable = false, length = 128)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(nullable = false, length = 128)
    private String hashedPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(nullable = false, length = 128)
    private String salt;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean readonly;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean admin;
    @Size(max = 128)
    @Column(length = 128)
    private String map;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<UserDevice> userDeviceList;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String name, String email, String hashedPassword, String salt, boolean readonly, boolean admin, double latitude, double longitude, int zoom) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
        this.readonly = readonly;
        this.admin = admin;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean getReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.User[ id=" + id + " ]";
    }
    
}
