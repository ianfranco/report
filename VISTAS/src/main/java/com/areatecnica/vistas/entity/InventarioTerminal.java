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
@Table(name = "inventario_terminal", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioTerminal.findAll", query = "SELECT i FROM InventarioTerminal i"),
    @NamedQuery(name = "InventarioTerminal.findByIdInventarioTerminal", query = "SELECT i FROM InventarioTerminal i WHERE i.idInventarioTerminal = :idInventarioTerminal"),
    @NamedQuery(name = "InventarioTerminal.findByEstado", query = "SELECT i FROM InventarioTerminal i WHERE i.estado = :estado"),
    @NamedQuery(name = "InventarioTerminal.findBySerie", query = "SELECT i FROM InventarioTerminal i WHERE i.serie = :serie"),
    @NamedQuery(name = "InventarioTerminal.findByIdentificador", query = "SELECT i FROM InventarioTerminal i WHERE i.identificador = :identificador")})
public class InventarioTerminal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inventario_terminal", nullable = false)
    private Integer idInventarioTerminal;
    private Boolean estado;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int serie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(nullable = false, length = 10)
    private String identificador;
    @JoinColumn(name = "id_boleto", referencedColumnName = "id_boleto", nullable = false)
    @ManyToOne(optional = false)
    private Boleto idBoleto;
    @JoinColumn(name = "id_terminal", referencedColumnName = "id_terminal", nullable = false)
    @ManyToOne(optional = false)
    private Terminal idTerminal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInventarioTerminal")
    private List<VentaBoletoGuia> ventaBoletoGuiaList;

    public InventarioTerminal() {
    }

    public InventarioTerminal(Integer idInventarioTerminal) {
        this.idInventarioTerminal = idInventarioTerminal;
    }

    public InventarioTerminal(Integer idInventarioTerminal, int serie, String identificador) {
        this.idInventarioTerminal = idInventarioTerminal;
        this.serie = serie;
        this.identificador = identificador;
    }

    public Integer getIdInventarioTerminal() {
        return idInventarioTerminal;
    }

    public void setIdInventarioTerminal(Integer idInventarioTerminal) {
        this.idInventarioTerminal = idInventarioTerminal;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
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

    public Boleto getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Boleto idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Terminal getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Terminal idTerminal) {
        this.idTerminal = idTerminal;
    }

    @XmlTransient
    public List<VentaBoletoGuia> getVentaBoletoGuiaList() {
        return ventaBoletoGuiaList;
    }

    public void setVentaBoletoGuiaList(List<VentaBoletoGuia> ventaBoletoGuiaList) {
        this.ventaBoletoGuiaList = ventaBoletoGuiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventarioTerminal != null ? idInventarioTerminal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioTerminal)) {
            return false;
        }
        InventarioTerminal other = (InventarioTerminal) object;
        if ((this.idInventarioTerminal == null && other.idInventarioTerminal != null) || (this.idInventarioTerminal != null && !this.idInventarioTerminal.equals(other.idInventarioTerminal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.InventarioTerminal[ idInventarioTerminal=" + idInventarioTerminal + " ]";
    }
    
}
