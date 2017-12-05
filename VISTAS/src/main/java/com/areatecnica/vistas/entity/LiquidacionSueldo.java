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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "liquidacion_sueldo", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LiquidacionSueldo.findAll", query = "SELECT l FROM LiquidacionSueldo l"),
    @NamedQuery(name = "LiquidacionSueldo.findByIdLiquidacionSueldo", query = "SELECT l FROM LiquidacionSueldo l WHERE l.idLiquidacionSueldo = :idLiquidacionSueldo"),
    @NamedQuery(name = "LiquidacionSueldo.findByMes", query = "SELECT l FROM LiquidacionSueldo l WHERE l.mes = :mes"),
    @NamedQuery(name = "LiquidacionSueldo.findByA\u00f1o", query = "SELECT l FROM LiquidacionSueldo l WHERE l.a\u00f1o = :a\u00f1o"),
    @NamedQuery(name = "LiquidacionSueldo.findByFechaEmision", query = "SELECT l FROM LiquidacionSueldo l WHERE l.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "LiquidacionSueldo.findByFechaPago", query = "SELECT l FROM LiquidacionSueldo l WHERE l.fechaPago = :fechaPago"),
    @NamedQuery(name = "LiquidacionSueldo.findByTotalHaberesImponibles", query = "SELECT l FROM LiquidacionSueldo l WHERE l.totalHaberesImponibles = :totalHaberesImponibles"),
    @NamedQuery(name = "LiquidacionSueldo.findByTotalHaberesNoImponibles", query = "SELECT l FROM LiquidacionSueldo l WHERE l.totalHaberesNoImponibles = :totalHaberesNoImponibles"),
    @NamedQuery(name = "LiquidacionSueldo.findBySaldoAnterior", query = "SELECT l FROM LiquidacionSueldo l WHERE l.saldoAnterior = :saldoAnterior"),
    @NamedQuery(name = "LiquidacionSueldo.findByTotalDescuentos", query = "SELECT l FROM LiquidacionSueldo l WHERE l.totalDescuentos = :totalDescuentos"),
    @NamedQuery(name = "LiquidacionSueldo.findByMontoAnticipo", query = "SELECT l FROM LiquidacionSueldo l WHERE l.montoAnticipo = :montoAnticipo"),
    @NamedQuery(name = "LiquidacionSueldo.findBySaldoMonto", query = "SELECT l FROM LiquidacionSueldo l WHERE l.saldoMonto = :saldoMonto"),
    @NamedQuery(name = "LiquidacionSueldo.findByAlcanceLiquido", query = "SELECT l FROM LiquidacionSueldo l WHERE l.alcanceLiquido = :alcanceLiquido")})
public class LiquidacionSueldo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_liquidacion_sueldo", nullable = false)
    private Integer idLiquidacionSueldo;
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
    @Column(name = "total_haberes_imponibles", nullable = false)
    private int totalHaberesImponibles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "total_haberes_no_imponibles", nullable = false, length = 45)
    private String totalHaberesNoImponibles;
    @Column(name = "saldo_anterior")
    private Integer saldoAnterior;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_descuentos", nullable = false)
    private int totalDescuentos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_anticipo", nullable = false)
    private int montoAnticipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_monto", nullable = false)
    private int saldoMonto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alcance_liquido", nullable = false)
    private int alcanceLiquido;
    @JoinColumn(name = "id_relacion_laboral", referencedColumnName = "id_relacion_laboral", nullable = false)
    @ManyToOne(optional = false)
    private RelacionLaboral idRelacionLaboral;

    public LiquidacionSueldo() {
    }

    public LiquidacionSueldo(Integer idLiquidacionSueldo) {
        this.idLiquidacionSueldo = idLiquidacionSueldo;
    }

    public LiquidacionSueldo(Integer idLiquidacionSueldo, int mes, int año, Date fechaEmision, Date fechaPago, int totalHaberesImponibles, String totalHaberesNoImponibles, int totalDescuentos, int montoAnticipo, int saldoMonto, int alcanceLiquido) {
        this.idLiquidacionSueldo = idLiquidacionSueldo;
        this.mes = mes;
        this.año = año;
        this.fechaEmision = fechaEmision;
        this.fechaPago = fechaPago;
        this.totalHaberesImponibles = totalHaberesImponibles;
        this.totalHaberesNoImponibles = totalHaberesNoImponibles;
        this.totalDescuentos = totalDescuentos;
        this.montoAnticipo = montoAnticipo;
        this.saldoMonto = saldoMonto;
        this.alcanceLiquido = alcanceLiquido;
    }

    public Integer getIdLiquidacionSueldo() {
        return idLiquidacionSueldo;
    }

    public void setIdLiquidacionSueldo(Integer idLiquidacionSueldo) {
        this.idLiquidacionSueldo = idLiquidacionSueldo;
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

    public int getTotalHaberesImponibles() {
        return totalHaberesImponibles;
    }

    public void setTotalHaberesImponibles(int totalHaberesImponibles) {
        this.totalHaberesImponibles = totalHaberesImponibles;
    }

    public String getTotalHaberesNoImponibles() {
        return totalHaberesNoImponibles;
    }

    public void setTotalHaberesNoImponibles(String totalHaberesNoImponibles) {
        this.totalHaberesNoImponibles = totalHaberesNoImponibles;
    }

    public Integer getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(Integer saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public int getTotalDescuentos() {
        return totalDescuentos;
    }

    public void setTotalDescuentos(int totalDescuentos) {
        this.totalDescuentos = totalDescuentos;
    }

    public int getMontoAnticipo() {
        return montoAnticipo;
    }

    public void setMontoAnticipo(int montoAnticipo) {
        this.montoAnticipo = montoAnticipo;
    }

    public int getSaldoMonto() {
        return saldoMonto;
    }

    public void setSaldoMonto(int saldoMonto) {
        this.saldoMonto = saldoMonto;
    }

    public int getAlcanceLiquido() {
        return alcanceLiquido;
    }

    public void setAlcanceLiquido(int alcanceLiquido) {
        this.alcanceLiquido = alcanceLiquido;
    }

    public RelacionLaboral getIdRelacionLaboral() {
        return idRelacionLaboral;
    }

    public void setIdRelacionLaboral(RelacionLaboral idRelacionLaboral) {
        this.idRelacionLaboral = idRelacionLaboral;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLiquidacionSueldo != null ? idLiquidacionSueldo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LiquidacionSueldo)) {
            return false;
        }
        LiquidacionSueldo other = (LiquidacionSueldo) object;
        if ((this.idLiquidacionSueldo == null && other.idLiquidacionSueldo != null) || (this.idLiquidacionSueldo != null && !this.idLiquidacionSueldo.equals(other.idLiquidacionSueldo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.LiquidacionSueldo[ idLiquidacionSueldo=" + idLiquidacionSueldo + " ]";
    }
    
}
