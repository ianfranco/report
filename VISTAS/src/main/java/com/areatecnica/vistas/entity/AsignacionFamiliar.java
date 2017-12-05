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
@Table(name = "asignacion_familiar", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionFamiliar.findAll", query = "SELECT a FROM AsignacionFamiliar a"),
    @NamedQuery(name = "AsignacionFamiliar.findByIdAsignacionFamiliar", query = "SELECT a FROM AsignacionFamiliar a WHERE a.idAsignacionFamiliar = :idAsignacionFamiliar"),
    @NamedQuery(name = "AsignacionFamiliar.findByCodigoAsignacionFamiliar", query = "SELECT a FROM AsignacionFamiliar a WHERE a.codigoAsignacionFamiliar = :codigoAsignacionFamiliar"),
    @NamedQuery(name = "AsignacionFamiliar.findByTramo", query = "SELECT a FROM AsignacionFamiliar a WHERE a.tramo = :tramo"),
    @NamedQuery(name = "AsignacionFamiliar.findByMonto", query = "SELECT a FROM AsignacionFamiliar a WHERE a.monto = :monto"),
    @NamedQuery(name = "AsignacionFamiliar.findByDesde", query = "SELECT a FROM AsignacionFamiliar a WHERE a.desde = :desde"),
    @NamedQuery(name = "AsignacionFamiliar.findByHasta", query = "SELECT a FROM AsignacionFamiliar a WHERE a.hasta = :hasta")})
public class AsignacionFamiliar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asignacion_familiar", nullable = false)
    private Integer idAsignacionFamiliar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo_asignacion_familiar", nullable = false, length = 45)
    private String codigoAsignacionFamiliar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String tramo;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int monto;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int desde;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int hasta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAsignacionFamiliar")
    private List<Trabajador> trabajadorList;

    public AsignacionFamiliar() {
    }

    public AsignacionFamiliar(Integer idAsignacionFamiliar) {
        this.idAsignacionFamiliar = idAsignacionFamiliar;
    }

    public AsignacionFamiliar(Integer idAsignacionFamiliar, String codigoAsignacionFamiliar, String tramo, int monto, int desde, int hasta) {
        this.idAsignacionFamiliar = idAsignacionFamiliar;
        this.codigoAsignacionFamiliar = codigoAsignacionFamiliar;
        this.tramo = tramo;
        this.monto = monto;
        this.desde = desde;
        this.hasta = hasta;
    }

    public Integer getIdAsignacionFamiliar() {
        return idAsignacionFamiliar;
    }

    public void setIdAsignacionFamiliar(Integer idAsignacionFamiliar) {
        this.idAsignacionFamiliar = idAsignacionFamiliar;
    }

    public String getCodigoAsignacionFamiliar() {
        return codigoAsignacionFamiliar;
    }

    public void setCodigoAsignacionFamiliar(String codigoAsignacionFamiliar) {
        this.codigoAsignacionFamiliar = codigoAsignacionFamiliar;
    }

    public String getTramo() {
        return tramo;
    }

    public void setTramo(String tramo) {
        this.tramo = tramo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getDesde() {
        return desde;
    }

    public void setDesde(int desde) {
        this.desde = desde;
    }

    public int getHasta() {
        return hasta;
    }

    public void setHasta(int hasta) {
        this.hasta = hasta;
    }

    @XmlTransient
    public List<Trabajador> getTrabajadorList() {
        return trabajadorList;
    }

    public void setTrabajadorList(List<Trabajador> trabajadorList) {
        this.trabajadorList = trabajadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacionFamiliar != null ? idAsignacionFamiliar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionFamiliar)) {
            return false;
        }
        AsignacionFamiliar other = (AsignacionFamiliar) object;
        if ((this.idAsignacionFamiliar == null && other.idAsignacionFamiliar != null) || (this.idAsignacionFamiliar != null && !this.idAsignacionFamiliar.equals(other.idAsignacionFamiliar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.AsignacionFamiliar[ idAsignacionFamiliar=" + idAsignacionFamiliar + " ]";
    }
    
}
