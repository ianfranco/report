/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "egreso_servicio", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EgresoServicio.findAll", query = "SELECT e FROM EgresoServicio e"),
    @NamedQuery(name = "EgresoServicio.findByIdEgresoServicio", query = "SELECT e FROM EgresoServicio e WHERE e.idEgresoServicio = :idEgresoServicio"),
    @NamedQuery(name = "EgresoServicio.findByValorDefectoEgreso", query = "SELECT e FROM EgresoServicio e WHERE e.valorDefectoEgreso = :valorDefectoEgreso"),
    @NamedQuery(name = "EgresoServicio.findByPorcentaje", query = "SELECT e FROM EgresoServicio e WHERE e.porcentaje = :porcentaje"),
    @NamedQuery(name = "EgresoServicio.findByNumeroOrdenEgreso", query = "SELECT e FROM EgresoServicio e WHERE e.numeroOrdenEgreso = :numeroOrdenEgreso"),
    @NamedQuery(name = "EgresoServicio.findByActivo", query = "SELECT e FROM EgresoServicio e WHERE e.activo = :activo")})
public class EgresoServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_egreso_servicio", nullable = false)
    private Integer idEgresoServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_defecto_egreso", nullable = false)
    private int valorDefectoEgreso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal porcentaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_orden_egreso", nullable = false)
    private int numeroOrdenEgreso;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean activo;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", nullable = false)
    @ManyToOne(optional = false)
    private Servicio idServicio;
    @JoinColumn(name = "id_egreso", referencedColumnName = "id_egreso", nullable = false)
    @ManyToOne(optional = false)
    private Egreso idEgreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEgresoServicio")
    private List<EgresoGuia> egresoGuiaList;

    public EgresoServicio() {
    }

    public EgresoServicio(Integer idEgresoServicio) {
        this.idEgresoServicio = idEgresoServicio;
    }

    public EgresoServicio(Integer idEgresoServicio, int valorDefectoEgreso, BigDecimal porcentaje, int numeroOrdenEgreso, boolean activo) {
        this.idEgresoServicio = idEgresoServicio;
        this.valorDefectoEgreso = valorDefectoEgreso;
        this.porcentaje = porcentaje;
        this.numeroOrdenEgreso = numeroOrdenEgreso;
        this.activo = activo;
    }

    public Integer getIdEgresoServicio() {
        return idEgresoServicio;
    }

    public void setIdEgresoServicio(Integer idEgresoServicio) {
        this.idEgresoServicio = idEgresoServicio;
    }

    public int getValorDefectoEgreso() {
        return valorDefectoEgreso;
    }

    public void setValorDefectoEgreso(int valorDefectoEgreso) {
        this.valorDefectoEgreso = valorDefectoEgreso;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getNumeroOrdenEgreso() {
        return numeroOrdenEgreso;
    }

    public void setNumeroOrdenEgreso(int numeroOrdenEgreso) {
        this.numeroOrdenEgreso = numeroOrdenEgreso;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public Egreso getIdEgreso() {
        return idEgreso;
    }

    public void setIdEgreso(Egreso idEgreso) {
        this.idEgreso = idEgreso;
    }

    @XmlTransient
    public List<EgresoGuia> getEgresoGuiaList() {
        return egresoGuiaList;
    }

    public void setEgresoGuiaList(List<EgresoGuia> egresoGuiaList) {
        this.egresoGuiaList = egresoGuiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEgresoServicio != null ? idEgresoServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EgresoServicio)) {
            return false;
        }
        EgresoServicio other = (EgresoServicio) object;
        if ((this.idEgresoServicio == null && other.idEgresoServicio != null) || (this.idEgresoServicio != null && !this.idEgresoServicio.equals(other.idEgresoServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.EgresoServicio[ idEgresoServicio=" + idEgresoServicio + " ]";
    }
    
}
