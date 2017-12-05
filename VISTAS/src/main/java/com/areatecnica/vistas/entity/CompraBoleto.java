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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "compra_boleto", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompraBoleto.findAll", query = "SELECT c FROM CompraBoleto c"),
    @NamedQuery(name = "CompraBoleto.findByIdCompraBoleto", query = "SELECT c FROM CompraBoleto c WHERE c.idCompraBoleto = :idCompraBoleto"),
    @NamedQuery(name = "CompraBoleto.findByFolioFactura", query = "SELECT c FROM CompraBoleto c WHERE c.folioFactura = :folioFactura"),
    @NamedQuery(name = "CompraBoleto.findByFechaCompraBoleto", query = "SELECT c FROM CompraBoleto c WHERE c.fechaCompraBoleto = :fechaCompraBoleto"),
    @NamedQuery(name = "CompraBoleto.findByTotal", query = "SELECT c FROM CompraBoleto c WHERE c.total = :total")})
public class CompraBoleto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_compra_boleto", nullable = false)
    private Integer idCompraBoleto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "folio_factura", nullable = false)
    private int folioFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_compra_boleto", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCompraBoleto;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompraBoleto")
    private List<DetalleCompraBoleto> detalleCompraBoletoList;

    public CompraBoleto() {
    }

    public CompraBoleto(Integer idCompraBoleto) {
        this.idCompraBoleto = idCompraBoleto;
    }

    public CompraBoleto(Integer idCompraBoleto, int folioFactura, Date fechaCompraBoleto, int total) {
        this.idCompraBoleto = idCompraBoleto;
        this.folioFactura = folioFactura;
        this.fechaCompraBoleto = fechaCompraBoleto;
        this.total = total;
    }

    public Integer getIdCompraBoleto() {
        return idCompraBoleto;
    }

    public void setIdCompraBoleto(Integer idCompraBoleto) {
        this.idCompraBoleto = idCompraBoleto;
    }

    public int getFolioFactura() {
        return folioFactura;
    }

    public void setFolioFactura(int folioFactura) {
        this.folioFactura = folioFactura;
    }

    public Date getFechaCompraBoleto() {
        return fechaCompraBoleto;
    }

    public void setFechaCompraBoleto(Date fechaCompraBoleto) {
        this.fechaCompraBoleto = fechaCompraBoleto;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @XmlTransient
    public List<DetalleCompraBoleto> getDetalleCompraBoletoList() {
        return detalleCompraBoletoList;
    }

    public void setDetalleCompraBoletoList(List<DetalleCompraBoleto> detalleCompraBoletoList) {
        this.detalleCompraBoletoList = detalleCompraBoletoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompraBoleto != null ? idCompraBoleto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraBoleto)) {
            return false;
        }
        CompraBoleto other = (CompraBoleto) object;
        if ((this.idCompraBoleto == null && other.idCompraBoleto != null) || (this.idCompraBoleto != null && !this.idCompraBoleto.equals(other.idCompraBoleto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.CompraBoleto[ idCompraBoleto=" + idCompraBoleto + " ]";
    }
    
}
