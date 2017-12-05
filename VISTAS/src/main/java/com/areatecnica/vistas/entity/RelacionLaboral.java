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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "relacion_laboral", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelacionLaboral.findAll", query = "SELECT r FROM RelacionLaboral r"),
    @NamedQuery(name = "RelacionLaboral.findByIdRelacionLaboral", query = "SELECT r FROM RelacionLaboral r WHERE r.idRelacionLaboral = :idRelacionLaboral"),
    @NamedQuery(name = "RelacionLaboral.findByFechaInicio", query = "SELECT r FROM RelacionLaboral r WHERE r.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "RelacionLaboral.findByFechaFin", query = "SELECT r FROM RelacionLaboral r WHERE r.fechaFin = :fechaFin"),
    @NamedQuery(name = "RelacionLaboral.findByTipoContrato", query = "SELECT r FROM RelacionLaboral r WHERE r.tipoContrato = :tipoContrato"),
    @NamedQuery(name = "RelacionLaboral.findBySueldoBase", query = "SELECT r FROM RelacionLaboral r WHERE r.sueldoBase = :sueldoBase"),
    @NamedQuery(name = "RelacionLaboral.findByRutaArchivoRespaldo", query = "SELECT r FROM RelacionLaboral r WHERE r.rutaArchivoRespaldo = :rutaArchivoRespaldo"),
    @NamedQuery(name = "RelacionLaboral.findByEstado", query = "SELECT r FROM RelacionLaboral r WHERE r.estado = :estado")})
public class RelacionLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_relacion_laboral", nullable = false)
    private Integer idRelacionLaboral;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 255)
    @Column(name = "tipo_contrato", length = 255)
    private String tipoContrato;
    @Column(name = "sueldo_base")
    private Integer sueldoBase;
    @Size(max = 255)
    @Column(name = "ruta_archivo_respaldo", length = 255)
    private String rutaArchivoRespaldo;
    private Boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRelacionLaboral")
    private List<LiquidacionSueldo> liquidacionSueldoList;
    @JoinColumn(name = "id_tipo_contrato", referencedColumnName = "id_tipo_contrato", nullable = false)
    @ManyToOne(optional = false)
    private TipoContrato idTipoContrato;
    @JoinColumn(name = "id_tipo_trabajador", referencedColumnName = "id_tipo_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private TipoTrabajador idTipoTrabajador;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa", nullable = false)
    @ManyToOne(optional = false)
    private Empresa idEmpresa;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRelacionLaboral")
    private List<FiniquitoRelacionLaboral> finiquitoRelacionLaboralList;

    public RelacionLaboral() {
    }

    public RelacionLaboral(Integer idRelacionLaboral) {
        this.idRelacionLaboral = idRelacionLaboral;
    }

    public Integer getIdRelacionLaboral() {
        return idRelacionLaboral;
    }

    public void setIdRelacionLaboral(Integer idRelacionLaboral) {
        this.idRelacionLaboral = idRelacionLaboral;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Integer getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(Integer sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public String getRutaArchivoRespaldo() {
        return rutaArchivoRespaldo;
    }

    public void setRutaArchivoRespaldo(String rutaArchivoRespaldo) {
        this.rutaArchivoRespaldo = rutaArchivoRespaldo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<LiquidacionSueldo> getLiquidacionSueldoList() {
        return liquidacionSueldoList;
    }

    public void setLiquidacionSueldoList(List<LiquidacionSueldo> liquidacionSueldoList) {
        this.liquidacionSueldoList = liquidacionSueldoList;
    }

    public TipoContrato getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(TipoContrato idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public TipoTrabajador getIdTipoTrabajador() {
        return idTipoTrabajador;
    }

    public void setIdTipoTrabajador(TipoTrabajador idTipoTrabajador) {
        this.idTipoTrabajador = idTipoTrabajador;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Trabajador getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Trabajador idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @XmlTransient
    public List<FiniquitoRelacionLaboral> getFiniquitoRelacionLaboralList() {
        return finiquitoRelacionLaboralList;
    }

    public void setFiniquitoRelacionLaboralList(List<FiniquitoRelacionLaboral> finiquitoRelacionLaboralList) {
        this.finiquitoRelacionLaboralList = finiquitoRelacionLaboralList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRelacionLaboral != null ? idRelacionLaboral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelacionLaboral)) {
            return false;
        }
        RelacionLaboral other = (RelacionLaboral) object;
        if ((this.idRelacionLaboral == null && other.idRelacionLaboral != null) || (this.idRelacionLaboral != null && !this.idRelacionLaboral.equals(other.idRelacionLaboral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.RelacionLaboral[ idRelacionLaboral=" + idRelacionLaboral + " ]";
    }
    
}
