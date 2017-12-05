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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "detalle_compra_boleto", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCompraBoleto.findAll", query = "SELECT d FROM DetalleCompraBoleto d"),
    @NamedQuery(name = "DetalleCompraBoleto.findByIdDetalleCompraBoleto", query = "SELECT d FROM DetalleCompraBoleto d WHERE d.idDetalleCompraBoleto = :idDetalleCompraBoleto"),
    @NamedQuery(name = "DetalleCompraBoleto.findByCantidadRollos", query = "SELECT d FROM DetalleCompraBoleto d WHERE d.cantidadRollos = :cantidadRollos"),
    @NamedQuery(name = "DetalleCompraBoleto.findBySerie", query = "SELECT d FROM DetalleCompraBoleto d WHERE d.serie = :serie"),
    @NamedQuery(name = "DetalleCompraBoleto.findByTotal", query = "SELECT d FROM DetalleCompraBoleto d WHERE d.total = :total")})
public class DetalleCompraBoleto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_compra_boleto", nullable = false)
    private Integer idDetalleCompraBoleto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_rollos", nullable = false)
    private int cantidadRollos;
    @Size(max = 45)
    @Column(length = 45)
    private String serie;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int total;
    @JoinColumn(name = "id_boleto", referencedColumnName = "id_boleto", nullable = false)
    @ManyToOne(optional = false)
    private Boleto idBoleto;
    @JoinColumn(name = "id_compra_boleto", referencedColumnName = "id_compra_boleto", nullable = false)
    @ManyToOne(optional = false)
    private CompraBoleto idCompraBoleto;

    public DetalleCompraBoleto() {
    }

    public DetalleCompraBoleto(Integer idDetalleCompraBoleto) {
        this.idDetalleCompraBoleto = idDetalleCompraBoleto;
    }

    public DetalleCompraBoleto(Integer idDetalleCompraBoleto, int cantidadRollos, int total) {
        this.idDetalleCompraBoleto = idDetalleCompraBoleto;
        this.cantidadRollos = cantidadRollos;
        this.total = total;
    }

    public Integer getIdDetalleCompraBoleto() {
        return idDetalleCompraBoleto;
    }

    public void setIdDetalleCompraBoleto(Integer idDetalleCompraBoleto) {
        this.idDetalleCompraBoleto = idDetalleCompraBoleto;
    }

    public int getCantidadRollos() {
        return cantidadRollos;
    }

    public void setCantidadRollos(int cantidadRollos) {
        this.cantidadRollos = cantidadRollos;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Boleto getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Boleto idBoleto) {
        this.idBoleto = idBoleto;
    }

    public CompraBoleto getIdCompraBoleto() {
        return idCompraBoleto;
    }

    public void setIdCompraBoleto(CompraBoleto idCompraBoleto) {
        this.idCompraBoleto = idCompraBoleto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCompraBoleto != null ? idDetalleCompraBoleto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCompraBoleto)) {
            return false;
        }
        DetalleCompraBoleto other = (DetalleCompraBoleto) object;
        if ((this.idDetalleCompraBoleto == null && other.idDetalleCompraBoleto != null) || (this.idDetalleCompraBoleto != null && !this.idDetalleCompraBoleto.equals(other.idDetalleCompraBoleto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.DetalleCompraBoleto[ idDetalleCompraBoleto=" + idDetalleCompraBoleto + " ]";
    }
    
}
