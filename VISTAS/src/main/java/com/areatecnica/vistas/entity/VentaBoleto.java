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
@Table(name = "venta_boleto", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaBoleto.findAll", query = "SELECT v FROM VentaBoleto v"),
    @NamedQuery(name = "VentaBoleto.findByIdVentaBoleto", query = "SELECT v FROM VentaBoleto v WHERE v.idVentaBoleto = :idVentaBoleto"),
    @NamedQuery(name = "VentaBoleto.findByFechaVenta", query = "SELECT v FROM VentaBoleto v WHERE v.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "VentaBoleto.findByNombreComprador", query = "SELECT v FROM VentaBoleto v WHERE v.nombreComprador = :nombreComprador"),
    @NamedQuery(name = "VentaBoleto.findByTotalCompra", query = "SELECT v FROM VentaBoleto v WHERE v.totalCompra = :totalCompra")})
public class VentaBoleto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_venta_boleto", nullable = false)
    private Integer idVentaBoleto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_comprador", nullable = false, length = 45)
    private String nombreComprador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_compra", nullable = false)
    private int totalCompra;
    @JoinColumn(name = "id_terminal", referencedColumnName = "id_terminal", nullable = false)
    @ManyToOne(optional = false)
    private Terminal idTerminal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVentaBoleto")
    private List<DetalleVentaBoleto> detalleVentaBoletoList;

    public VentaBoleto() {
    }

    public VentaBoleto(Integer idVentaBoleto) {
        this.idVentaBoleto = idVentaBoleto;
    }

    public VentaBoleto(Integer idVentaBoleto, Date fechaVenta, String nombreComprador, int totalCompra) {
        this.idVentaBoleto = idVentaBoleto;
        this.fechaVenta = fechaVenta;
        this.nombreComprador = nombreComprador;
        this.totalCompra = totalCompra;
    }

    public Integer getIdVentaBoleto() {
        return idVentaBoleto;
    }

    public void setIdVentaBoleto(Integer idVentaBoleto) {
        this.idVentaBoleto = idVentaBoleto;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public int getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(int totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Terminal getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Terminal idTerminal) {
        this.idTerminal = idTerminal;
    }

    @XmlTransient
    public List<DetalleVentaBoleto> getDetalleVentaBoletoList() {
        return detalleVentaBoletoList;
    }

    public void setDetalleVentaBoletoList(List<DetalleVentaBoleto> detalleVentaBoletoList) {
        this.detalleVentaBoletoList = detalleVentaBoletoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentaBoleto != null ? idVentaBoleto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaBoleto)) {
            return false;
        }
        VentaBoleto other = (VentaBoleto) object;
        if ((this.idVentaBoleto == null && other.idVentaBoleto != null) || (this.idVentaBoleto != null && !this.idVentaBoleto.equals(other.idVentaBoleto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.VentaBoleto[ idVentaBoleto=" + idVentaBoleto + " ]";
    }
    
}
