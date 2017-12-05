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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Control.findAll", query = "SELECT c FROM Control c"),
    @NamedQuery(name = "Control.findByIdControl", query = "SELECT c FROM Control c WHERE c.idControl = :idControl"),
    @NamedQuery(name = "Control.findByNombreControl", query = "SELECT c FROM Control c WHERE c.nombreControl = :nombreControl"),
    @NamedQuery(name = "Control.findByLatitud", query = "SELECT c FROM Control c WHERE c.latitud = :latitud"),
    @NamedQuery(name = "Control.findByLongitud", query = "SELECT c FROM Control c WHERE c.longitud = :longitud"),
    @NamedQuery(name = "Control.findByRadio", query = "SELECT c FROM Control c WHERE c.radio = :radio")})
public class Control implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_control", nullable = false)
    private Integer idControl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_control", nullable = false, length = 45)
    private String nombreControl;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double latitud;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double longitud;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int radio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idControl")
    private List<ControlServicio> controlServicioList;
    @JoinColumn(name = "id_tipo_control", referencedColumnName = "id_tipo_control", nullable = false)
    @ManyToOne(optional = false)
    private TipoControl idTipoControl;

    public Control() {
    }

    public Control(Integer idControl) {
        this.idControl = idControl;
    }

    public Control(Integer idControl, String nombreControl, double latitud, double longitud, int radio) {
        this.idControl = idControl;
        this.nombreControl = nombreControl;
        this.latitud = latitud;
        this.longitud = longitud;
        this.radio = radio;
    }

    public Integer getIdControl() {
        return idControl;
    }

    public void setIdControl(Integer idControl) {
        this.idControl = idControl;
    }

    public String getNombreControl() {
        return nombreControl;
    }

    public void setNombreControl(String nombreControl) {
        this.nombreControl = nombreControl;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    @XmlTransient
    public List<ControlServicio> getControlServicioList() {
        return controlServicioList;
    }

    public void setControlServicioList(List<ControlServicio> controlServicioList) {
        this.controlServicioList = controlServicioList;
    }

    public TipoControl getIdTipoControl() {
        return idTipoControl;
    }

    public void setIdTipoControl(TipoControl idTipoControl) {
        this.idTipoControl = idTipoControl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControl != null ? idControl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Control)) {
            return false;
        }
        Control other = (Control) object;
        if ((this.idControl == null && other.idControl != null) || (this.idControl != null && !this.idControl.equals(other.idControl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Control[ idControl=" + idControl + " ]";
    }
    
}
