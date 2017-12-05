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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "control_servicio", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlServicio.findAll", query = "SELECT c FROM ControlServicio c"),
    @NamedQuery(name = "ControlServicio.findByIdControlServicio", query = "SELECT c FROM ControlServicio c WHERE c.idControlServicio = :idControlServicio"),
    @NamedQuery(name = "ControlServicio.findByTiempo", query = "SELECT c FROM ControlServicio c WHERE c.tiempo = :tiempo"),
    @NamedQuery(name = "ControlServicio.findByNumeroOrden", query = "SELECT c FROM ControlServicio c WHERE c.numeroOrden = :numeroOrden")})
public class ControlServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_control_servicio", nullable = false)
    private Integer idControlServicio;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date tiempo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_orden", nullable = false)
    private int numeroOrden;
    @JoinColumn(name = "id_control", referencedColumnName = "id_control", nullable = false)
    @ManyToOne(optional = false)
    private Control idControl;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", nullable = false)
    @ManyToOne(optional = false)
    private Servicio idServicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idControlServicio")
    private List<ControlHorarioServicio> controlHorarioServicioList;

    public ControlServicio() {
    }

    public ControlServicio(Integer idControlServicio) {
        this.idControlServicio = idControlServicio;
    }

    public ControlServicio(Integer idControlServicio, Date tiempo, int numeroOrden) {
        this.idControlServicio = idControlServicio;
        this.tiempo = tiempo;
        this.numeroOrden = numeroOrden;
    }

    public Integer getIdControlServicio() {
        return idControlServicio;
    }

    public void setIdControlServicio(Integer idControlServicio) {
        this.idControlServicio = idControlServicio;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Control getIdControl() {
        return idControl;
    }

    public void setIdControl(Control idControl) {
        this.idControl = idControl;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    @XmlTransient
    public List<ControlHorarioServicio> getControlHorarioServicioList() {
        return controlHorarioServicioList;
    }

    public void setControlHorarioServicioList(List<ControlHorarioServicio> controlHorarioServicioList) {
        this.controlHorarioServicioList = controlHorarioServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControlServicio != null ? idControlServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlServicio)) {
            return false;
        }
        ControlServicio other = (ControlServicio) object;
        if ((this.idControlServicio == null && other.idControlServicio != null) || (this.idControlServicio != null && !this.idControlServicio.equals(other.idControlServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.ControlServicio[ idControlServicio=" + idControlServicio + " ]";
    }
    
}
