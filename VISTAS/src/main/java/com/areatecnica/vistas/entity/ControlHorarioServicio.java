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
@Table(name = "control_horario_servicio", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlHorarioServicio.findAll", query = "SELECT c FROM ControlHorarioServicio c"),
    @NamedQuery(name = "ControlHorarioServicio.findByIdControlHorarioServicio", query = "SELECT c FROM ControlHorarioServicio c WHERE c.idControlHorarioServicio = :idControlHorarioServicio"),
    @NamedQuery(name = "ControlHorarioServicio.findByTiempo", query = "SELECT c FROM ControlHorarioServicio c WHERE c.tiempo = :tiempo"),
    @NamedQuery(name = "ControlHorarioServicio.findByMulta", query = "SELECT c FROM ControlHorarioServicio c WHERE c.multa = :multa"),
    @NamedQuery(name = "ControlHorarioServicio.findByPeso", query = "SELECT c FROM ControlHorarioServicio c WHERE c.peso = :peso")})
public class ControlHorarioServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_control_horario_servicio", nullable = false)
    private Integer idControlHorarioServicio;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int tiempo;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int multa;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int peso;
    @JoinColumn(name = "id_control_servicio", referencedColumnName = "id_control_servicio", nullable = false)
    @ManyToOne(optional = false)
    private ControlServicio idControlServicio;
    @JoinColumn(name = "id_horario_servicio", referencedColumnName = "id_horario_servicio", nullable = false)
    @ManyToOne(optional = false)
    private HorarioServicio idHorarioServicio;

    public ControlHorarioServicio() {
    }

    public ControlHorarioServicio(Integer idControlHorarioServicio) {
        this.idControlHorarioServicio = idControlHorarioServicio;
    }

    public ControlHorarioServicio(Integer idControlHorarioServicio, int tiempo, int multa, int peso) {
        this.idControlHorarioServicio = idControlHorarioServicio;
        this.tiempo = tiempo;
        this.multa = multa;
        this.peso = peso;
    }

    public Integer getIdControlHorarioServicio() {
        return idControlHorarioServicio;
    }

    public void setIdControlHorarioServicio(Integer idControlHorarioServicio) {
        this.idControlHorarioServicio = idControlHorarioServicio;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public ControlServicio getIdControlServicio() {
        return idControlServicio;
    }

    public void setIdControlServicio(ControlServicio idControlServicio) {
        this.idControlServicio = idControlServicio;
    }

    public HorarioServicio getIdHorarioServicio() {
        return idHorarioServicio;
    }

    public void setIdHorarioServicio(HorarioServicio idHorarioServicio) {
        this.idHorarioServicio = idHorarioServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControlHorarioServicio != null ? idControlHorarioServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlHorarioServicio)) {
            return false;
        }
        ControlHorarioServicio other = (ControlHorarioServicio) object;
        if ((this.idControlHorarioServicio == null && other.idControlHorarioServicio != null) || (this.idControlHorarioServicio != null && !this.idControlHorarioServicio.equals(other.idControlHorarioServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.ControlHorarioServicio[ idControlHorarioServicio=" + idControlHorarioServicio + " ]";
    }
    
}
