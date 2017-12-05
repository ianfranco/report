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
@Table(name = "detalle_venta_boleto", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVentaBoleto.findAll", query = "SELECT d FROM DetalleVentaBoleto d"),
    @NamedQuery(name = "DetalleVentaBoleto.findByIdDetalleVentaBoleto", query = "SELECT d FROM DetalleVentaBoleto d WHERE d.idDetalleVentaBoleto = :idDetalleVentaBoleto"),
    @NamedQuery(name = "DetalleVentaBoleto.findByTotal", query = "SELECT d FROM DetalleVentaBoleto d WHERE d.total = :total")})
public class DetalleVentaBoleto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_venta_boleto", nullable = false)
    private Integer idDetalleVentaBoleto;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int total;
    @JoinColumn(name = "id_inventario_interno", referencedColumnName = "id_inventario_interno", nullable = false)
    @ManyToOne(optional = false)
    private InventarioInterno idInventarioInterno;
    @JoinColumn(name = "id_venta_boleto", referencedColumnName = "id_venta_boleto", nullable = false)
    @ManyToOne(optional = false)
    private VentaBoleto idVentaBoleto;

    public DetalleVentaBoleto() {
    }

    public DetalleVentaBoleto(Integer idDetalleVentaBoleto) {
        this.idDetalleVentaBoleto = idDetalleVentaBoleto;
    }

    public DetalleVentaBoleto(Integer idDetalleVentaBoleto, int total) {
        this.idDetalleVentaBoleto = idDetalleVentaBoleto;
        this.total = total;
    }

    public Integer getIdDetalleVentaBoleto() {
        return idDetalleVentaBoleto;
    }

    public void setIdDetalleVentaBoleto(Integer idDetalleVentaBoleto) {
        this.idDetalleVentaBoleto = idDetalleVentaBoleto;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public InventarioInterno getIdInventarioInterno() {
        return idInventarioInterno;
    }

    public void setIdInventarioInterno(InventarioInterno idInventarioInterno) {
        this.idInventarioInterno = idInventarioInterno;
    }

    public VentaBoleto getIdVentaBoleto() {
        return idVentaBoleto;
    }

    public void setIdVentaBoleto(VentaBoleto idVentaBoleto) {
        this.idVentaBoleto = idVentaBoleto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleVentaBoleto != null ? idDetalleVentaBoleto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVentaBoleto)) {
            return false;
        }
        DetalleVentaBoleto other = (DetalleVentaBoleto) object;
        if ((this.idDetalleVentaBoleto == null && other.idDetalleVentaBoleto != null) || (this.idDetalleVentaBoleto != null && !this.idDetalleVentaBoleto.equals(other.idDetalleVentaBoleto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.DetalleVentaBoleto[ idDetalleVentaBoleto=" + idDetalleVentaBoleto + " ]";
    }
    
}
