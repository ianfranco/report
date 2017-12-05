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
@Table(name = "serie_boleto_guia", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SerieBoletoGuia.findAll", query = "SELECT s FROM SerieBoletoGuia s"),
    @NamedQuery(name = "SerieBoletoGuia.findByIdSerieBoletoGuia", query = "SELECT s FROM SerieBoletoGuia s WHERE s.idSerieBoletoGuia = :idSerieBoletoGuia"),
    @NamedQuery(name = "SerieBoletoGuia.findByValor", query = "SELECT s FROM SerieBoletoGuia s WHERE s.valor = :valor"),
    @NamedQuery(name = "SerieBoletoGuia.findBySerie", query = "SELECT s FROM SerieBoletoGuia s WHERE s.serie = :serie"),
    @NamedQuery(name = "SerieBoletoGuia.findByTermino", query = "SELECT s FROM SerieBoletoGuia s WHERE s.termino = :termino"),
    @NamedQuery(name = "SerieBoletoGuia.findByCantidad", query = "SELECT s FROM SerieBoletoGuia s WHERE s.cantidad = :cantidad"),
    @NamedQuery(name = "SerieBoletoGuia.findByTotal", query = "SELECT s FROM SerieBoletoGuia s WHERE s.total = :total"),
    @NamedQuery(name = "SerieBoletoGuia.findByNuevo", query = "SELECT s FROM SerieBoletoGuia s WHERE s.nuevo = :nuevo")})
public class SerieBoletoGuia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_serie_boleto_guia", nullable = false)
    private Integer idSerieBoletoGuia;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int valor;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int serie;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int termino;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int total;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean nuevo;
    @JoinColumn(name = "id_boleto", referencedColumnName = "id_boleto", nullable = false)
    @ManyToOne(optional = false)
    private Boleto idBoleto;
    @JoinColumn(name = "id_guia", referencedColumnName = "id_guia", nullable = false)
    @ManyToOne(optional = false)
    private Guia idGuia;

    public SerieBoletoGuia() {
    }

    public SerieBoletoGuia(Integer idSerieBoletoGuia) {
        this.idSerieBoletoGuia = idSerieBoletoGuia;
    }

    public SerieBoletoGuia(Integer idSerieBoletoGuia, int valor, int serie, int termino, int cantidad, int total, boolean nuevo) {
        this.idSerieBoletoGuia = idSerieBoletoGuia;
        this.valor = valor;
        this.serie = serie;
        this.termino = termino;
        this.cantidad = cantidad;
        this.total = total;
        this.nuevo = nuevo;
    }

    public Integer getIdSerieBoletoGuia() {
        return idSerieBoletoGuia;
    }

    public void setIdSerieBoletoGuia(Integer idSerieBoletoGuia) {
        this.idSerieBoletoGuia = idSerieBoletoGuia;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getTermino() {
        return termino;
    }

    public void setTermino(int termino) {
        this.termino = termino;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean getNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public Boleto getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Boleto idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Guia getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Guia idGuia) {
        this.idGuia = idGuia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSerieBoletoGuia != null ? idSerieBoletoGuia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SerieBoletoGuia)) {
            return false;
        }
        SerieBoletoGuia other = (SerieBoletoGuia) object;
        if ((this.idSerieBoletoGuia == null && other.idSerieBoletoGuia != null) || (this.idSerieBoletoGuia != null && !this.idSerieBoletoGuia.equals(other.idSerieBoletoGuia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.SerieBoletoGuia[ idSerieBoletoGuia=" + idSerieBoletoGuia + " ]";
    }
    
}
