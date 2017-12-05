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
@Table(name = "tipo_estacionalidad", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEstacionalidad.findAll", query = "SELECT t FROM TipoEstacionalidad t"),
    @NamedQuery(name = "TipoEstacionalidad.findByIdTipoEstacionalidad", query = "SELECT t FROM TipoEstacionalidad t WHERE t.idTipoEstacionalidad = :idTipoEstacionalidad"),
    @NamedQuery(name = "TipoEstacionalidad.findByNombreEstacionalidad", query = "SELECT t FROM TipoEstacionalidad t WHERE t.nombreEstacionalidad = :nombreEstacionalidad")})
public class TipoEstacionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_estacionalidad", nullable = false)
    private Integer idTipoEstacionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_estacionalidad", nullable = false, length = 100)
    private String nombreEstacionalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEstacionalidad")
    private List<HorarioServicio> horarioServicioList;

    public TipoEstacionalidad() {
    }

    public TipoEstacionalidad(Integer idTipoEstacionalidad) {
        this.idTipoEstacionalidad = idTipoEstacionalidad;
    }

    public TipoEstacionalidad(Integer idTipoEstacionalidad, String nombreEstacionalidad) {
        this.idTipoEstacionalidad = idTipoEstacionalidad;
        this.nombreEstacionalidad = nombreEstacionalidad;
    }

    public Integer getIdTipoEstacionalidad() {
        return idTipoEstacionalidad;
    }

    public void setIdTipoEstacionalidad(Integer idTipoEstacionalidad) {
        this.idTipoEstacionalidad = idTipoEstacionalidad;
    }

    public String getNombreEstacionalidad() {
        return nombreEstacionalidad;
    }

    public void setNombreEstacionalidad(String nombreEstacionalidad) {
        this.nombreEstacionalidad = nombreEstacionalidad;
    }

    @XmlTransient
    public List<HorarioServicio> getHorarioServicioList() {
        return horarioServicioList;
    }

    public void setHorarioServicioList(List<HorarioServicio> horarioServicioList) {
        this.horarioServicioList = horarioServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEstacionalidad != null ? idTipoEstacionalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEstacionalidad)) {
            return false;
        }
        TipoEstacionalidad other = (TipoEstacionalidad) object;
        if ((this.idTipoEstacionalidad == null && other.idTipoEstacionalidad != null) || (this.idTipoEstacionalidad != null && !this.idTipoEstacionalidad.equals(other.idTipoEstacionalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TipoEstacionalidad[ idTipoEstacionalidad=" + idTipoEstacionalidad + " ]";
    }
    
}
