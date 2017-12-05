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
@Table(name = "tarifa_servicio", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarifaServicio.findAll", query = "SELECT t FROM TarifaServicio t"),
    @NamedQuery(name = "TarifaServicio.findByIdTarifaServicio", query = "SELECT t FROM TarifaServicio t WHERE t.idTarifaServicio = :idTarifaServicio"),
    @NamedQuery(name = "TarifaServicio.findByValorTarifa", query = "SELECT t FROM TarifaServicio t WHERE t.valorTarifa = :valorTarifa"),
    @NamedQuery(name = "TarifaServicio.findByMes", query = "SELECT t FROM TarifaServicio t WHERE t.mes = :mes"),
    @NamedQuery(name = "TarifaServicio.findByA\u00f1o", query = "SELECT t FROM TarifaServicio t WHERE t.a\u00f1o = :a\u00f1o"),
    @NamedQuery(name = "TarifaServicio.findByActiva", query = "SELECT t FROM TarifaServicio t WHERE t.activa = :activa")})
public class TarifaServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tarifa_servicio", nullable = false)
    private Integer idTarifaServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_tarifa", nullable = false)
    private int valorTarifa;
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
    @Column(nullable = false)
    private boolean activa;
    @JoinColumn(name = "id_boleto", referencedColumnName = "id_boleto", nullable = false)
    @ManyToOne(optional = false)
    private Boleto idBoleto;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", nullable = false)
    @ManyToOne(optional = false)
    private Servicio idServicio;

    public TarifaServicio() {
    }

    public TarifaServicio(Integer idTarifaServicio) {
        this.idTarifaServicio = idTarifaServicio;
    }

    public TarifaServicio(Integer idTarifaServicio, int valorTarifa, int mes, int año, boolean activa) {
        this.idTarifaServicio = idTarifaServicio;
        this.valorTarifa = valorTarifa;
        this.mes = mes;
        this.año = año;
        this.activa = activa;
    }

    public Integer getIdTarifaServicio() {
        return idTarifaServicio;
    }

    public void setIdTarifaServicio(Integer idTarifaServicio) {
        this.idTarifaServicio = idTarifaServicio;
    }

    public int getValorTarifa() {
        return valorTarifa;
    }

    public void setValorTarifa(int valorTarifa) {
        this.valorTarifa = valorTarifa;
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

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Boleto getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Boleto idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarifaServicio != null ? idTarifaServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarifaServicio)) {
            return false;
        }
        TarifaServicio other = (TarifaServicio) object;
        if ((this.idTarifaServicio == null && other.idTarifaServicio != null) || (this.idTarifaServicio != null && !this.idTarifaServicio.equals(other.idTarifaServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TarifaServicio[ idTarifaServicio=" + idTarifaServicio + " ]";
    }
    
}
