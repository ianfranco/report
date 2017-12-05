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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "liquidacion_empresa", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LiquidacionEmpresa.findAll", query = "SELECT l FROM LiquidacionEmpresa l"),
    @NamedQuery(name = "LiquidacionEmpresa.findByIdLiquidacionEmpresa", query = "SELECT l FROM LiquidacionEmpresa l WHERE l.idLiquidacionEmpresa = :idLiquidacionEmpresa"),
    @NamedQuery(name = "LiquidacionEmpresa.findByMes", query = "SELECT l FROM LiquidacionEmpresa l WHERE l.mes = :mes"),
    @NamedQuery(name = "LiquidacionEmpresa.findByA\u00f1o", query = "SELECT l FROM LiquidacionEmpresa l WHERE l.a\u00f1o = :a\u00f1o"),
    @NamedQuery(name = "LiquidacionEmpresa.findByFechaEmision", query = "SELECT l FROM LiquidacionEmpresa l WHERE l.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "LiquidacionEmpresa.findByFechaPago", query = "SELECT l FROM LiquidacionEmpresa l WHERE l.fechaPago = :fechaPago"),
    @NamedQuery(name = "LiquidacionEmpresa.findByTotalAbonos", query = "SELECT l FROM LiquidacionEmpresa l WHERE l.totalAbonos = :totalAbonos"),
    @NamedQuery(name = "LiquidacionEmpresa.findByTotalCargos", query = "SELECT l FROM LiquidacionEmpresa l WHERE l.totalCargos = :totalCargos"),
    @NamedQuery(name = "LiquidacionEmpresa.findBySaldo", query = "SELECT l FROM LiquidacionEmpresa l WHERE l.saldo = :saldo")})
public class LiquidacionEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_liquidacion_empresa", nullable = false)
    private Integer idLiquidacionEmpresa;
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
    @Column(name = "fecha_emision", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pago", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_abonos", nullable = false)
    private int totalAbonos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_cargos", nullable = false)
    private int totalCargos;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int saldo;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa", nullable = false)
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    public LiquidacionEmpresa() {
    }

    public LiquidacionEmpresa(Integer idLiquidacionEmpresa) {
        this.idLiquidacionEmpresa = idLiquidacionEmpresa;
    }

    public LiquidacionEmpresa(Integer idLiquidacionEmpresa, int mes, int año, Date fechaEmision, Date fechaPago, int totalAbonos, int totalCargos, int saldo) {
        this.idLiquidacionEmpresa = idLiquidacionEmpresa;
        this.mes = mes;
        this.año = año;
        this.fechaEmision = fechaEmision;
        this.fechaPago = fechaPago;
        this.totalAbonos = totalAbonos;
        this.totalCargos = totalCargos;
        this.saldo = saldo;
    }

    public Integer getIdLiquidacionEmpresa() {
        return idLiquidacionEmpresa;
    }

    public void setIdLiquidacionEmpresa(Integer idLiquidacionEmpresa) {
        this.idLiquidacionEmpresa = idLiquidacionEmpresa;
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

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getTotalAbonos() {
        return totalAbonos;
    }

    public void setTotalAbonos(int totalAbonos) {
        this.totalAbonos = totalAbonos;
    }

    public int getTotalCargos() {
        return totalCargos;
    }

    public void setTotalCargos(int totalCargos) {
        this.totalCargos = totalCargos;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLiquidacionEmpresa != null ? idLiquidacionEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LiquidacionEmpresa)) {
            return false;
        }
        LiquidacionEmpresa other = (LiquidacionEmpresa) object;
        if ((this.idLiquidacionEmpresa == null && other.idLiquidacionEmpresa != null) || (this.idLiquidacionEmpresa != null && !this.idLiquidacionEmpresa.equals(other.idLiquidacionEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.LiquidacionEmpresa[ idLiquidacionEmpresa=" + idLiquidacionEmpresa + " ]";
    }
    
}
