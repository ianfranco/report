/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "gastos_administracion_mensual", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GastosAdministracionMensual.findAll", query = "SELECT g FROM GastosAdministracionMensual g"),
    @NamedQuery(name = "GastosAdministracionMensual.findByIdGastosAdministracionMensual", query = "SELECT g FROM GastosAdministracionMensual g WHERE g.idGastosAdministracionMensual = :idGastosAdministracionMensual"),
    @NamedQuery(name = "GastosAdministracionMensual.findByMes", query = "SELECT g FROM GastosAdministracionMensual g WHERE g.mes = :mes"),
    @NamedQuery(name = "GastosAdministracionMensual.findByA\u00f1o", query = "SELECT g FROM GastosAdministracionMensual g WHERE g.a\u00f1o = :a\u00f1o"),
    @NamedQuery(name = "GastosAdministracionMensual.findByNumeroFolio", query = "SELECT g FROM GastosAdministracionMensual g WHERE g.numeroFolio = :numeroFolio"),
    @NamedQuery(name = "GastosAdministracionMensual.findByNombreGastoAdministracion", query = "SELECT g FROM GastosAdministracionMensual g WHERE g.nombreGastoAdministracion = :nombreGastoAdministracion"),
    @NamedQuery(name = "GastosAdministracionMensual.findByFechaGastoAdministracion", query = "SELECT g FROM GastosAdministracionMensual g WHERE g.fechaGastoAdministracion = :fechaGastoAdministracion"),
    @NamedQuery(name = "GastosAdministracionMensual.findByFechaIngreso", query = "SELECT g FROM GastosAdministracionMensual g WHERE g.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "GastosAdministracionMensual.findByValor", query = "SELECT g FROM GastosAdministracionMensual g WHERE g.valor = :valor")})
public class GastosAdministracionMensual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gastos_administracion_mensual", nullable = false)
    private Integer idGastosAdministracionMensual;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int mes;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int año;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_folio", nullable = false)
    private int numeroFolio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_gasto_administracion", nullable = false, length = 45)
    private String nombreGastoAdministracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_gasto_administracion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaGastoAdministracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date valor;
    @Lob
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String observacion;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento", nullable = false)
    @ManyToOne(optional = false)
    private Departamento idDepartamento;

    public GastosAdministracionMensual() {
    }

    public GastosAdministracionMensual(Integer idGastosAdministracionMensual) {
        this.idGastosAdministracionMensual = idGastosAdministracionMensual;
    }

    public GastosAdministracionMensual(Integer idGastosAdministracionMensual, int mes, int año, int numeroFolio, String nombreGastoAdministracion, Date fechaGastoAdministracion, Date fechaIngreso, Date valor) {
        this.idGastosAdministracionMensual = idGastosAdministracionMensual;
        this.mes = mes;
        this.año = año;
        this.numeroFolio = numeroFolio;
        this.nombreGastoAdministracion = nombreGastoAdministracion;
        this.fechaGastoAdministracion = fechaGastoAdministracion;
        this.fechaIngreso = fechaIngreso;
        this.valor = valor;
    }

    public Integer getIdGastosAdministracionMensual() {
        return idGastosAdministracionMensual;
    }

    public void setIdGastosAdministracionMensual(Integer idGastosAdministracionMensual) {
        this.idGastosAdministracionMensual = idGastosAdministracionMensual;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getNumeroFolio() {
        return numeroFolio;
    }

    public void setNumeroFolio(int numeroFolio) {
        this.numeroFolio = numeroFolio;
    }

    public String getNombreGastoAdministracion() {
        return nombreGastoAdministracion;
    }

    public void setNombreGastoAdministracion(String nombreGastoAdministracion) {
        this.nombreGastoAdministracion = nombreGastoAdministracion;
    }

    public Date getFechaGastoAdministracion() {
        return fechaGastoAdministracion;
    }

    public void setFechaGastoAdministracion(Date fechaGastoAdministracion) {
        this.fechaGastoAdministracion = fechaGastoAdministracion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getValor() {
        return valor;
    }

    public void setValor(Date valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGastosAdministracionMensual != null ? idGastosAdministracionMensual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastosAdministracionMensual)) {
            return false;
        }
        GastosAdministracionMensual other = (GastosAdministracionMensual) object;
        if ((this.idGastosAdministracionMensual == null && other.idGastosAdministracionMensual != null) || (this.idGastosAdministracionMensual != null && !this.idGastosAdministracionMensual.equals(other.idGastosAdministracionMensual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.GastosAdministracionMensual[ idGastosAdministracionMensual=" + idGastosAdministracionMensual + " ]";
    }
    
}
