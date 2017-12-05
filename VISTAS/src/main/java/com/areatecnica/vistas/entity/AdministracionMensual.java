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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "administracion_mensual", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdministracionMensual.findAll", query = "SELECT a FROM AdministracionMensual a"),
    @NamedQuery(name = "AdministracionMensual.findByIdAdministracionMensual", query = "SELECT a FROM AdministracionMensual a WHERE a.idAdministracionMensual = :idAdministracionMensual"),
    @NamedQuery(name = "AdministracionMensual.findByMes", query = "SELECT a FROM AdministracionMensual a WHERE a.mes = :mes"),
    @NamedQuery(name = "AdministracionMensual.findByA\u00f1o", query = "SELECT a FROM AdministracionMensual a WHERE a.a\u00f1o = :a\u00f1o"),
    @NamedQuery(name = "AdministracionMensual.findByValor", query = "SELECT a FROM AdministracionMensual a WHERE a.valor = :valor")})
public class AdministracionMensual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_administracion_mensual", nullable = false)
    private Integer idAdministracionMensual;
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
    private int valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdministracionMensual")
    private List<DetalleIntervalosMensual> detalleIntervalosMensualList;

    public AdministracionMensual() {
    }

    public AdministracionMensual(Integer idAdministracionMensual) {
        this.idAdministracionMensual = idAdministracionMensual;
    }

    public AdministracionMensual(Integer idAdministracionMensual, int mes, int año, int valor) {
        this.idAdministracionMensual = idAdministracionMensual;
        this.mes = mes;
        this.año = año;
        this.valor = valor;
    }

    public Integer getIdAdministracionMensual() {
        return idAdministracionMensual;
    }

    public void setIdAdministracionMensual(Integer idAdministracionMensual) {
        this.idAdministracionMensual = idAdministracionMensual;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @XmlTransient
    public List<DetalleIntervalosMensual> getDetalleIntervalosMensualList() {
        return detalleIntervalosMensualList;
    }

    public void setDetalleIntervalosMensualList(List<DetalleIntervalosMensual> detalleIntervalosMensualList) {
        this.detalleIntervalosMensualList = detalleIntervalosMensualList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdministracionMensual != null ? idAdministracionMensual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdministracionMensual)) {
            return false;
        }
        AdministracionMensual other = (AdministracionMensual) object;
        if ((this.idAdministracionMensual == null && other.idAdministracionMensual != null) || (this.idAdministracionMensual != null && !this.idAdministracionMensual.equals(other.idAdministracionMensual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.AdministracionMensual[ idAdministracionMensual=" + idAdministracionMensual + " ]";
    }
    
}
