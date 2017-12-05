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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "horario_servicio", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioServicio.findAll", query = "SELECT h FROM HorarioServicio h"),
    @NamedQuery(name = "HorarioServicio.findByIdHorarioServicio", query = "SELECT h FROM HorarioServicio h WHERE h.idHorarioServicio = :idHorarioServicio"),
    @NamedQuery(name = "HorarioServicio.findByNombre", query = "SELECT h FROM HorarioServicio h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "HorarioServicio.findByDesde", query = "SELECT h FROM HorarioServicio h WHERE h.desde = :desde"),
    @NamedQuery(name = "HorarioServicio.findByHasta", query = "SELECT h FROM HorarioServicio h WHERE h.hasta = :hasta"),
    @NamedQuery(name = "HorarioServicio.findByLunes", query = "SELECT h FROM HorarioServicio h WHERE h.lunes = :lunes"),
    @NamedQuery(name = "HorarioServicio.findByMartes", query = "SELECT h FROM HorarioServicio h WHERE h.martes = :martes"),
    @NamedQuery(name = "HorarioServicio.findByMiercoles", query = "SELECT h FROM HorarioServicio h WHERE h.miercoles = :miercoles"),
    @NamedQuery(name = "HorarioServicio.findByJueves", query = "SELECT h FROM HorarioServicio h WHERE h.jueves = :jueves"),
    @NamedQuery(name = "HorarioServicio.findByViernes", query = "SELECT h FROM HorarioServicio h WHERE h.viernes = :viernes"),
    @NamedQuery(name = "HorarioServicio.findBySabado", query = "SELECT h FROM HorarioServicio h WHERE h.sabado = :sabado"),
    @NamedQuery(name = "HorarioServicio.findByDomingo", query = "SELECT h FROM HorarioServicio h WHERE h.domingo = :domingo")})
public class HorarioServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_horario_servicio", nullable = false)
    private Integer idHorarioServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date desde;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date hasta;
    private Boolean lunes;
    private Boolean martes;
    private Boolean miercoles;
    private Boolean jueves;
    private Boolean viernes;
    private Boolean sabado;
    private Boolean domingo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHorarioServicio")
    private List<ControlHorarioServicio> controlHorarioServicioList;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", nullable = false)
    @ManyToOne(optional = false)
    private Servicio idServicio;
    @JoinColumn(name = "id_tipo_estacionalidad", referencedColumnName = "id_tipo_estacionalidad", nullable = false)
    @ManyToOne(optional = false)
    private TipoEstacionalidad idTipoEstacionalidad;

    public HorarioServicio() {
    }

    public HorarioServicio(Integer idHorarioServicio) {
        this.idHorarioServicio = idHorarioServicio;
    }

    public HorarioServicio(Integer idHorarioServicio, String nombre, Date desde, Date hasta) {
        this.idHorarioServicio = idHorarioServicio;
        this.nombre = nombre;
        this.desde = desde;
        this.hasta = hasta;
    }

    public Integer getIdHorarioServicio() {
        return idHorarioServicio;
    }

    public void setIdHorarioServicio(Integer idHorarioServicio) {
        this.idHorarioServicio = idHorarioServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public Boolean getLunes() {
        return lunes;
    }

    public void setLunes(Boolean lunes) {
        this.lunes = lunes;
    }

    public Boolean getMartes() {
        return martes;
    }

    public void setMartes(Boolean martes) {
        this.martes = martes;
    }

    public Boolean getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(Boolean miercoles) {
        this.miercoles = miercoles;
    }

    public Boolean getJueves() {
        return jueves;
    }

    public void setJueves(Boolean jueves) {
        this.jueves = jueves;
    }

    public Boolean getViernes() {
        return viernes;
    }

    public void setViernes(Boolean viernes) {
        this.viernes = viernes;
    }

    public Boolean getSabado() {
        return sabado;
    }

    public void setSabado(Boolean sabado) {
        this.sabado = sabado;
    }

    public Boolean getDomingo() {
        return domingo;
    }

    public void setDomingo(Boolean domingo) {
        this.domingo = domingo;
    }

    @XmlTransient
    public List<ControlHorarioServicio> getControlHorarioServicioList() {
        return controlHorarioServicioList;
    }

    public void setControlHorarioServicioList(List<ControlHorarioServicio> controlHorarioServicioList) {
        this.controlHorarioServicioList = controlHorarioServicioList;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public TipoEstacionalidad getIdTipoEstacionalidad() {
        return idTipoEstacionalidad;
    }

    public void setIdTipoEstacionalidad(TipoEstacionalidad idTipoEstacionalidad) {
        this.idTipoEstacionalidad = idTipoEstacionalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorarioServicio != null ? idHorarioServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioServicio)) {
            return false;
        }
        HorarioServicio other = (HorarioServicio) object;
        if ((this.idHorarioServicio == null && other.idHorarioServicio != null) || (this.idHorarioServicio != null && !this.idHorarioServicio.equals(other.idHorarioServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.HorarioServicio[ idHorarioServicio=" + idHorarioServicio + " ]";
    }
    
}
