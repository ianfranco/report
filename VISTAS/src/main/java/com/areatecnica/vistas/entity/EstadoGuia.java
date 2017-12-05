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
@Table(name = "estado_guia", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoGuia.findAll", query = "SELECT e FROM EstadoGuia e"),
    @NamedQuery(name = "EstadoGuia.findByIdEstadoGuia", query = "SELECT e FROM EstadoGuia e WHERE e.idEstadoGuia = :idEstadoGuia"),
    @NamedQuery(name = "EstadoGuia.findByNombreEstado", query = "SELECT e FROM EstadoGuia e WHERE e.nombreEstado = :nombreEstado"),
    @NamedQuery(name = "EstadoGuia.findByActivo", query = "SELECT e FROM EstadoGuia e WHERE e.activo = :activo")})
public class EstadoGuia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_guia", nullable = false)
    private Integer idEstadoGuia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_estado", nullable = false, length = 45)
    private String nombreEstado;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<Guia> guiaList;

    public EstadoGuia() {
    }

    public EstadoGuia(Integer idEstadoGuia) {
        this.idEstadoGuia = idEstadoGuia;
    }

    public EstadoGuia(Integer idEstadoGuia, String nombreEstado, boolean activo) {
        this.idEstadoGuia = idEstadoGuia;
        this.nombreEstado = nombreEstado;
        this.activo = activo;
    }

    public Integer getIdEstadoGuia() {
        return idEstadoGuia;
    }

    public void setIdEstadoGuia(Integer idEstadoGuia) {
        this.idEstadoGuia = idEstadoGuia;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<Guia> getGuiaList() {
        return guiaList;
    }

    public void setGuiaList(List<Guia> guiaList) {
        this.guiaList = guiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoGuia != null ? idEstadoGuia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoGuia)) {
            return false;
        }
        EstadoGuia other = (EstadoGuia) object;
        if ((this.idEstadoGuia == null && other.idEstadoGuia != null) || (this.idEstadoGuia != null && !this.idEstadoGuia.equals(other.idEstadoGuia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.EstadoGuia[ idEstadoGuia=" + idEstadoGuia + " ]";
    }
    
}
