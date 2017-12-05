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
@Table(name = "venta_boleto_guia", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaBoletoGuia.findAll", query = "SELECT v FROM VentaBoletoGuia v"),
    @NamedQuery(name = "VentaBoletoGuia.findByIdVentaBoletoGuia", query = "SELECT v FROM VentaBoletoGuia v WHERE v.idVentaBoletoGuia = :idVentaBoletoGuia"),
    @NamedQuery(name = "VentaBoletoGuia.findByValor", query = "SELECT v FROM VentaBoletoGuia v WHERE v.valor = :valor"),
    @NamedQuery(name = "VentaBoletoGuia.findByRecaudado", query = "SELECT v FROM VentaBoletoGuia v WHERE v.recaudado = :recaudado")})
public class VentaBoletoGuia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_venta_boleto_guia", nullable = false)
    private Integer idVentaBoletoGuia;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int valor;
    private Boolean recaudado;
    @JoinColumn(name = "id_guia", referencedColumnName = "id_guia", nullable = false)
    @ManyToOne(optional = false)
    private Guia idGuia;
    @JoinColumn(name = "id_inventario_terminal", referencedColumnName = "id_inventario_terminal", nullable = false)
    @ManyToOne(optional = false)
    private InventarioTerminal idInventarioTerminal;

    public VentaBoletoGuia() {
    }

    public VentaBoletoGuia(Integer idVentaBoletoGuia) {
        this.idVentaBoletoGuia = idVentaBoletoGuia;
    }

    public VentaBoletoGuia(Integer idVentaBoletoGuia, int valor) {
        this.idVentaBoletoGuia = idVentaBoletoGuia;
        this.valor = valor;
    }

    public Integer getIdVentaBoletoGuia() {
        return idVentaBoletoGuia;
    }

    public void setIdVentaBoletoGuia(Integer idVentaBoletoGuia) {
        this.idVentaBoletoGuia = idVentaBoletoGuia;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Boolean getRecaudado() {
        return recaudado;
    }

    public void setRecaudado(Boolean recaudado) {
        this.recaudado = recaudado;
    }

    public Guia getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Guia idGuia) {
        this.idGuia = idGuia;
    }

    public InventarioTerminal getIdInventarioTerminal() {
        return idInventarioTerminal;
    }

    public void setIdInventarioTerminal(InventarioTerminal idInventarioTerminal) {
        this.idInventarioTerminal = idInventarioTerminal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentaBoletoGuia != null ? idVentaBoletoGuia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaBoletoGuia)) {
            return false;
        }
        VentaBoletoGuia other = (VentaBoletoGuia) object;
        if ((this.idVentaBoletoGuia == null && other.idVentaBoletoGuia != null) || (this.idVentaBoletoGuia != null && !this.idVentaBoletoGuia.equals(other.idVentaBoletoGuia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.VentaBoletoGuia[ idVentaBoletoGuia=" + idVentaBoletoGuia + " ]";
    }
    
}
