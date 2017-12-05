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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "inventario_interno", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioInterno.findAll", query = "SELECT i FROM InventarioInterno i"),
    @NamedQuery(name = "InventarioInterno.findByIdInventarioInterno", query = "SELECT i FROM InventarioInterno i WHERE i.idInventarioInterno = :idInventarioInterno"),
    @NamedQuery(name = "InventarioInterno.findBySerie", query = "SELECT i FROM InventarioInterno i WHERE i.serie = :serie"),
    @NamedQuery(name = "InventarioInterno.findByIdentificador", query = "SELECT i FROM InventarioInterno i WHERE i.identificador = :identificador"),
    @NamedQuery(name = "InventarioInterno.findByCantidadRollos", query = "SELECT i FROM InventarioInterno i WHERE i.cantidadRollos = :cantidadRollos"),
    @NamedQuery(name = "InventarioInterno.findByEstado", query = "SELECT i FROM InventarioInterno i WHERE i.estado = :estado")})
public class InventarioInterno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inventario_interno", nullable = false)
    private Integer idInventarioInterno;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int serie;
    @Size(max = 45)
    @Column(length = 45)
    private String identificador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_rollos", nullable = false)
    private int cantidadRollos;
    private Boolean estado;
    @JoinColumn(name = "id_boleto", referencedColumnName = "id_boleto", nullable = false)
    @ManyToOne(optional = false)
    private Boleto idBoleto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInventarioInterno")
    private List<DetalleVentaBoleto> detalleVentaBoletoList;

    public InventarioInterno() {
    }

    public InventarioInterno(Integer idInventarioInterno) {
        this.idInventarioInterno = idInventarioInterno;
    }

    public InventarioInterno(Integer idInventarioInterno, int serie, int cantidadRollos) {
        this.idInventarioInterno = idInventarioInterno;
        this.serie = serie;
        this.cantidadRollos = cantidadRollos;
    }

    public Integer getIdInventarioInterno() {
        return idInventarioInterno;
    }

    public void setIdInventarioInterno(Integer idInventarioInterno) {
        this.idInventarioInterno = idInventarioInterno;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getCantidadRollos() {
        return cantidadRollos;
    }

    public void setCantidadRollos(int cantidadRollos) {
        this.cantidadRollos = cantidadRollos;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boleto getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Boleto idBoleto) {
        this.idBoleto = idBoleto;
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
        hash += (idInventarioInterno != null ? idInventarioInterno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioInterno)) {
            return false;
        }
        InventarioInterno other = (InventarioInterno) object;
        if ((this.idInventarioInterno == null && other.idInventarioInterno != null) || (this.idInventarioInterno != null && !this.idInventarioInterno.equals(other.idInventarioInterno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.InventarioInterno[ idInventarioInterno=" + idInventarioInterno + " ]";
    }
    
}
