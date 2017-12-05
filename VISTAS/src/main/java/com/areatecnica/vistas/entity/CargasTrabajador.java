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
@Table(name = "cargas_trabajador", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CargasTrabajador.findAll", query = "SELECT c FROM CargasTrabajador c"),
    @NamedQuery(name = "CargasTrabajador.findByIdCargasTrabajador", query = "SELECT c FROM CargasTrabajador c WHERE c.idCargasTrabajador = :idCargasTrabajador"),
    @NamedQuery(name = "CargasTrabajador.findByApellidoCargaTrabajador", query = "SELECT c FROM CargasTrabajador c WHERE c.apellidoCargaTrabajador = :apellidoCargaTrabajador"),
    @NamedQuery(name = "CargasTrabajador.findByNombreCargaTrabajador", query = "SELECT c FROM CargasTrabajador c WHERE c.nombreCargaTrabajador = :nombreCargaTrabajador"),
    @NamedQuery(name = "CargasTrabajador.findByRut", query = "SELECT c FROM CargasTrabajador c WHERE c.rut = :rut"),
    @NamedQuery(name = "CargasTrabajador.findByFechaNacimiento", query = "SELECT c FROM CargasTrabajador c WHERE c.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "CargasTrabajador.findByFechaIngreso", query = "SELECT c FROM CargasTrabajador c WHERE c.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "CargasTrabajador.findByActiva", query = "SELECT c FROM CargasTrabajador c WHERE c.activa = :activa")})
public class CargasTrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cargas_trabajador", nullable = false)
    private Integer idCargasTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido_carga_trabajador", nullable = false, length = 45)
    private String apellidoCargaTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_carga_trabajador", nullable = false, length = 45)
    private String nombreCargaTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String rut;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean activa;
    @JoinColumn(name = "id_parentesco_carga", referencedColumnName = "id_parentesco_carga", nullable = false)
    @ManyToOne(optional = false)
    private ParentescoCarga idParentescoCarga;
    @JoinColumn(name = "id_tipo_carga", referencedColumnName = "id_tipo_carga", nullable = false)
    @ManyToOne(optional = false)
    private TipoCarga idTipoCarga;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargaTrabajador")
    private List<CargaRetroactiva> cargaRetroactivaList;

    public CargasTrabajador() {
    }

    public CargasTrabajador(Integer idCargasTrabajador) {
        this.idCargasTrabajador = idCargasTrabajador;
    }

    public CargasTrabajador(Integer idCargasTrabajador, String apellidoCargaTrabajador, String nombreCargaTrabajador, String rut, Date fechaIngreso, boolean activa) {
        this.idCargasTrabajador = idCargasTrabajador;
        this.apellidoCargaTrabajador = apellidoCargaTrabajador;
        this.nombreCargaTrabajador = nombreCargaTrabajador;
        this.rut = rut;
        this.fechaIngreso = fechaIngreso;
        this.activa = activa;
    }

    public Integer getIdCargasTrabajador() {
        return idCargasTrabajador;
    }

    public void setIdCargasTrabajador(Integer idCargasTrabajador) {
        this.idCargasTrabajador = idCargasTrabajador;
    }

    public String getApellidoCargaTrabajador() {
        return apellidoCargaTrabajador;
    }

    public void setApellidoCargaTrabajador(String apellidoCargaTrabajador) {
        this.apellidoCargaTrabajador = apellidoCargaTrabajador;
    }

    public String getNombreCargaTrabajador() {
        return nombreCargaTrabajador;
    }

    public void setNombreCargaTrabajador(String nombreCargaTrabajador) {
        this.nombreCargaTrabajador = nombreCargaTrabajador;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public ParentescoCarga getIdParentescoCarga() {
        return idParentescoCarga;
    }

    public void setIdParentescoCarga(ParentescoCarga idParentescoCarga) {
        this.idParentescoCarga = idParentescoCarga;
    }

    public TipoCarga getIdTipoCarga() {
        return idTipoCarga;
    }

    public void setIdTipoCarga(TipoCarga idTipoCarga) {
        this.idTipoCarga = idTipoCarga;
    }

    public Trabajador getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Trabajador idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @XmlTransient
    public List<CargaRetroactiva> getCargaRetroactivaList() {
        return cargaRetroactivaList;
    }

    public void setCargaRetroactivaList(List<CargaRetroactiva> cargaRetroactivaList) {
        this.cargaRetroactivaList = cargaRetroactivaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargasTrabajador != null ? idCargasTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargasTrabajador)) {
            return false;
        }
        CargasTrabajador other = (CargasTrabajador) object;
        if ((this.idCargasTrabajador == null && other.idCargasTrabajador != null) || (this.idCargasTrabajador != null && !this.idCargasTrabajador.equals(other.idCargasTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.CargasTrabajador[ idCargasTrabajador=" + idCargasTrabajador + " ]";
    }
    
}
