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
@Table(name = "monto_sindicato_trabajador", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MontoSindicatoTrabajador.findAll", query = "SELECT m FROM MontoSindicatoTrabajador m"),
    @NamedQuery(name = "MontoSindicatoTrabajador.findByIdMontoSindicatoTrabajado", query = "SELECT m FROM MontoSindicatoTrabajador m WHERE m.idMontoSindicatoTrabajado = :idMontoSindicatoTrabajado"),
    @NamedQuery(name = "MontoSindicatoTrabajador.findByMontoSindicatoTrabajador", query = "SELECT m FROM MontoSindicatoTrabajador m WHERE m.montoSindicatoTrabajador = :montoSindicatoTrabajador"),
    @NamedQuery(name = "MontoSindicatoTrabajador.findByMesLiquidacion", query = "SELECT m FROM MontoSindicatoTrabajador m WHERE m.mesLiquidacion = :mesLiquidacion"),
    @NamedQuery(name = "MontoSindicatoTrabajador.findByA\u00f1oLiquidacion", query = "SELECT m FROM MontoSindicatoTrabajador m WHERE m.a\u00f1oLiquidacion = :a\u00f1oLiquidacion")})
public class MontoSindicatoTrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_monto_sindicato_trabajado", nullable = false)
    private Integer idMontoSindicatoTrabajado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_sindicato_trabajador", nullable = false)
    private int montoSindicatoTrabajador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mes_liquidacion", nullable = false)
    private int mesLiquidacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "a\u00f1o_liquidacion", nullable = false)
    private int añoLiquidacion;
    @JoinColumn(name = "id_sindicato_trabajador", referencedColumnName = "id_sindicato_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private SindicatoTrabajador idSindicatoTrabajador;

    public MontoSindicatoTrabajador() {
    }

    public MontoSindicatoTrabajador(Integer idMontoSindicatoTrabajado) {
        this.idMontoSindicatoTrabajado = idMontoSindicatoTrabajado;
    }

    public MontoSindicatoTrabajador(Integer idMontoSindicatoTrabajado, int montoSindicatoTrabajador, int mesLiquidacion, int añoLiquidacion) {
        this.idMontoSindicatoTrabajado = idMontoSindicatoTrabajado;
        this.montoSindicatoTrabajador = montoSindicatoTrabajador;
        this.mesLiquidacion = mesLiquidacion;
        this.añoLiquidacion = añoLiquidacion;
    }

    public Integer getIdMontoSindicatoTrabajado() {
        return idMontoSindicatoTrabajado;
    }

    public void setIdMontoSindicatoTrabajado(Integer idMontoSindicatoTrabajado) {
        this.idMontoSindicatoTrabajado = idMontoSindicatoTrabajado;
    }

    public int getMontoSindicatoTrabajador() {
        return montoSindicatoTrabajador;
    }

    public void setMontoSindicatoTrabajador(int montoSindicatoTrabajador) {
        this.montoSindicatoTrabajador = montoSindicatoTrabajador;
    }

    public int getMesLiquidacion() {
        return mesLiquidacion;
    }

    public void setMesLiquidacion(int mesLiquidacion) {
        this.mesLiquidacion = mesLiquidacion;
    }

    public int getAñoLiquidacion() {
        return añoLiquidacion;
    }

    public void setAñoLiquidacion(int añoLiquidacion) {
        this.añoLiquidacion = añoLiquidacion;
    }

    public SindicatoTrabajador getIdSindicatoTrabajador() {
        return idSindicatoTrabajador;
    }

    public void setIdSindicatoTrabajador(SindicatoTrabajador idSindicatoTrabajador) {
        this.idSindicatoTrabajador = idSindicatoTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMontoSindicatoTrabajado != null ? idMontoSindicatoTrabajado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MontoSindicatoTrabajador)) {
            return false;
        }
        MontoSindicatoTrabajador other = (MontoSindicatoTrabajador) object;
        if ((this.idMontoSindicatoTrabajado == null && other.idMontoSindicatoTrabajado != null) || (this.idMontoSindicatoTrabajado != null && !this.idMontoSindicatoTrabajado.equals(other.idMontoSindicatoTrabajado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.MontoSindicatoTrabajador[ idMontoSindicatoTrabajado=" + idMontoSindicatoTrabajado + " ]";
    }
    
}
