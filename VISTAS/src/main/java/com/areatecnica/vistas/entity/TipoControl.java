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
@Table(name = "tipo_control", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoControl.findAll", query = "SELECT t FROM TipoControl t"),
    @NamedQuery(name = "TipoControl.findByIdTipoControl", query = "SELECT t FROM TipoControl t WHERE t.idTipoControl = :idTipoControl"),
    @NamedQuery(name = "TipoControl.findByNombreTipoControl", query = "SELECT t FROM TipoControl t WHERE t.nombreTipoControl = :nombreTipoControl"),
    @NamedQuery(name = "TipoControl.findByClasificacion", query = "SELECT t FROM TipoControl t WHERE t.clasificacion = :clasificacion")})
public class TipoControl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_control", nullable = false)
    private Integer idTipoControl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_control", nullable = false, length = 45)
    private String nombreTipoControl;
    @Size(max = 45)
    @Column(length = 45)
    private String clasificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoControl")
    private List<Control> controlList;

    public TipoControl() {
    }

    public TipoControl(Integer idTipoControl) {
        this.idTipoControl = idTipoControl;
    }

    public TipoControl(Integer idTipoControl, String nombreTipoControl) {
        this.idTipoControl = idTipoControl;
        this.nombreTipoControl = nombreTipoControl;
    }

    public Integer getIdTipoControl() {
        return idTipoControl;
    }

    public void setIdTipoControl(Integer idTipoControl) {
        this.idTipoControl = idTipoControl;
    }

    public String getNombreTipoControl() {
        return nombreTipoControl;
    }

    public void setNombreTipoControl(String nombreTipoControl) {
        this.nombreTipoControl = nombreTipoControl;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    @XmlTransient
    public List<Control> getControlList() {
        return controlList;
    }

    public void setControlList(List<Control> controlList) {
        this.controlList = controlList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoControl != null ? idTipoControl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoControl)) {
            return false;
        }
        TipoControl other = (TipoControl) object;
        if ((this.idTipoControl == null && other.idTipoControl != null) || (this.idTipoControl != null && !this.idTipoControl.equals(other.idTipoControl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TipoControl[ idTipoControl=" + idTipoControl + " ]";
    }
    
}
