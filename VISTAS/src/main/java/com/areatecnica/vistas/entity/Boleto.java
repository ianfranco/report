/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleto.findAll", query = "SELECT b FROM Boleto b"),
    @NamedQuery(name = "Boleto.findByIdBoleto", query = "SELECT b FROM Boleto b WHERE b.idBoleto = :idBoleto"),
    @NamedQuery(name = "Boleto.findByNombreBoleto", query = "SELECT b FROM Boleto b WHERE b.nombreBoleto = :nombreBoleto"),
    @NamedQuery(name = "Boleto.findByActivo", query = "SELECT b FROM Boleto b WHERE b.activo = :activo")})
public class Boleto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_boleto", nullable = false)
    private Integer idBoleto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_boleto", nullable = false, length = 45)
    private String nombreBoleto;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBoleto")
    private List<InventarioTerminal> inventarioTerminalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBoleto")
    private List<SerieBoletoGuia> serieBoletoGuiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBoleto")
    private List<InventarioInterno> inventarioInternoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBoleto")
    private List<DetalleCompraBoleto> detalleCompraBoletoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBoleto")
    private List<TarifaServicio> tarifaServicioList;

    public Boleto() {
    }

    public Boleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Boleto(Integer idBoleto, String nombreBoleto, boolean activo) {
        this.idBoleto = idBoleto;
        this.nombreBoleto = nombreBoleto;
        this.activo = activo;
    }

    public Integer getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
    }

    public String getNombreBoleto() {
        return nombreBoleto;
    }

    public void setNombreBoleto(String nombreBoleto) {
        this.nombreBoleto = nombreBoleto;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<InventarioTerminal> getInventarioTerminalList() {
        return inventarioTerminalList;
    }

    public void setInventarioTerminalList(List<InventarioTerminal> inventarioTerminalList) {
        this.inventarioTerminalList = inventarioTerminalList;
    }

    @XmlTransient
    public List<SerieBoletoGuia> getSerieBoletoGuiaList() {
        return serieBoletoGuiaList;
    }

    public void setSerieBoletoGuiaList(List<SerieBoletoGuia> serieBoletoGuiaList) {
        this.serieBoletoGuiaList = serieBoletoGuiaList;
    }

    @XmlTransient
    public List<InventarioInterno> getInventarioInternoList() {
        return inventarioInternoList;
    }

    public void setInventarioInternoList(List<InventarioInterno> inventarioInternoList) {
        this.inventarioInternoList = inventarioInternoList;
    }

    @XmlTransient
    public List<DetalleCompraBoleto> getDetalleCompraBoletoList() {
        return detalleCompraBoletoList;
    }

    public void setDetalleCompraBoletoList(List<DetalleCompraBoleto> detalleCompraBoletoList) {
        this.detalleCompraBoletoList = detalleCompraBoletoList;
    }

    @XmlTransient
    public List<TarifaServicio> getTarifaServicioList() {
        return tarifaServicioList;
    }

    public void setTarifaServicioList(List<TarifaServicio> tarifaServicioList) {
        this.tarifaServicioList = tarifaServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBoleto != null ? idBoleto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleto)) {
            return false;
        }
        Boleto other = (Boleto) object;
        if ((this.idBoleto == null && other.idBoleto != null) || (this.idBoleto != null && !this.idBoleto.equals(other.idBoleto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Boleto[ idBoleto=" + idBoleto + " ]";
    }
    
}
