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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terminal.findAll", query = "SELECT t FROM Terminal t"),
    @NamedQuery(name = "Terminal.findByIdTerminal", query = "SELECT t FROM Terminal t WHERE t.idTerminal = :idTerminal"),
    @NamedQuery(name = "Terminal.findByNombreTerminal", query = "SELECT t FROM Terminal t WHERE t.nombreTerminal = :nombreTerminal"),
    @NamedQuery(name = "Terminal.findByDireccionTerminal", query = "SELECT t FROM Terminal t WHERE t.direccionTerminal = :direccionTerminal"),
    @NamedQuery(name = "Terminal.findBySuperficie", query = "SELECT t FROM Terminal t WHERE t.superficie = :superficie"),
    @NamedQuery(name = "Terminal.findByTelefonoTerminal", query = "SELECT t FROM Terminal t WHERE t.telefonoTerminal = :telefonoTerminal"),
    @NamedQuery(name = "Terminal.findByEmailTerminal", query = "SELECT t FROM Terminal t WHERE t.emailTerminal = :emailTerminal"),
    @NamedQuery(name = "Terminal.findByUbicacionLongitud", query = "SELECT t FROM Terminal t WHERE t.ubicacionLongitud = :ubicacionLongitud"),
    @NamedQuery(name = "Terminal.findByUbicacionLatitud", query = "SELECT t FROM Terminal t WHERE t.ubicacionLatitud = :ubicacionLatitud")})
public class Terminal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_terminal", nullable = false)
    private Integer idTerminal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_terminal", nullable = false, length = 45)
    private String nombreTerminal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion_terminal", nullable = false, length = 45)
    private String direccionTerminal;
    private Integer superficie;
    @Size(max = 45)
    @Column(name = "telefono_terminal", length = 45)
    private String telefonoTerminal;
    @Size(max = 45)
    @Column(name = "email_terminal", length = 45)
    private String emailTerminal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ubicacion_longitud", nullable = false)
    private double ubicacionLongitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ubicacion_latitud", nullable = false)
    private double ubicacionLatitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTerminal")
    private List<InventarioTerminal> inventarioTerminalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTerminal")
    private List<VentaBoleto> ventaBoletoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTerminal")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTerminal")
    private List<Bus> busList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTerminal")
    private List<Servicio> servicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTerminal")
    private List<TrabajadorTerminal> trabajadorTerminalList;

    public Terminal() {
    }

    public Terminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public Terminal(Integer idTerminal, String nombreTerminal, String direccionTerminal, double ubicacionLongitud, double ubicacionLatitud) {
        this.idTerminal = idTerminal;
        this.nombreTerminal = nombreTerminal;
        this.direccionTerminal = direccionTerminal;
        this.ubicacionLongitud = ubicacionLongitud;
        this.ubicacionLatitud = ubicacionLatitud;
    }

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public String getNombreTerminal() {
        return nombreTerminal;
    }

    public void setNombreTerminal(String nombreTerminal) {
        this.nombreTerminal = nombreTerminal;
    }

    public String getDireccionTerminal() {
        return direccionTerminal;
    }

    public void setDireccionTerminal(String direccionTerminal) {
        this.direccionTerminal = direccionTerminal;
    }

    public Integer getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Integer superficie) {
        this.superficie = superficie;
    }

    public String getTelefonoTerminal() {
        return telefonoTerminal;
    }

    public void setTelefonoTerminal(String telefonoTerminal) {
        this.telefonoTerminal = telefonoTerminal;
    }

    public String getEmailTerminal() {
        return emailTerminal;
    }

    public void setEmailTerminal(String emailTerminal) {
        this.emailTerminal = emailTerminal;
    }

    public double getUbicacionLongitud() {
        return ubicacionLongitud;
    }

    public void setUbicacionLongitud(double ubicacionLongitud) {
        this.ubicacionLongitud = ubicacionLongitud;
    }

    public double getUbicacionLatitud() {
        return ubicacionLatitud;
    }

    public void setUbicacionLatitud(double ubicacionLatitud) {
        this.ubicacionLatitud = ubicacionLatitud;
    }

    @XmlTransient
    public List<InventarioTerminal> getInventarioTerminalList() {
        return inventarioTerminalList;
    }

    public void setInventarioTerminalList(List<InventarioTerminal> inventarioTerminalList) {
        this.inventarioTerminalList = inventarioTerminalList;
    }

    @XmlTransient
    public List<VentaBoleto> getVentaBoletoList() {
        return ventaBoletoList;
    }

    public void setVentaBoletoList(List<VentaBoleto> ventaBoletoList) {
        this.ventaBoletoList = ventaBoletoList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    @XmlTransient
    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

    @XmlTransient
    public List<TrabajadorTerminal> getTrabajadorTerminalList() {
        return trabajadorTerminalList;
    }

    public void setTrabajadorTerminalList(List<TrabajadorTerminal> trabajadorTerminalList) {
        this.trabajadorTerminalList = trabajadorTerminalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTerminal != null ? idTerminal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terminal)) {
            return false;
        }
        Terminal other = (Terminal) object;
        if ((this.idTerminal == null && other.idTerminal != null) || (this.idTerminal != null && !this.idTerminal.equals(other.idTerminal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Terminal[ idTerminal=" + idTerminal + " ]";
    }
    
}
