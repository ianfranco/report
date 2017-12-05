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
@Table(name = "tipo_dia_trabajador", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDiaTrabajador.findAll", query = "SELECT t FROM TipoDiaTrabajador t"),
    @NamedQuery(name = "TipoDiaTrabajador.findByIdTipoDiaTrabajador", query = "SELECT t FROM TipoDiaTrabajador t WHERE t.idTipoDiaTrabajador = :idTipoDiaTrabajador"),
    @NamedQuery(name = "TipoDiaTrabajador.findByNombre", query = "SELECT t FROM TipoDiaTrabajador t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoDiaTrabajador.findBySueldo", query = "SELECT t FROM TipoDiaTrabajador t WHERE t.sueldo = :sueldo")})
public class TipoDiaTrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_dia_trabajador", nullable = false)
    private Integer idTipoDiaTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean sueldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDiaTrabajador")
    private List<DiaTrabajador> diaTrabajadorList;

    public TipoDiaTrabajador() {
    }

    public TipoDiaTrabajador(Integer idTipoDiaTrabajador) {
        this.idTipoDiaTrabajador = idTipoDiaTrabajador;
    }

    public TipoDiaTrabajador(Integer idTipoDiaTrabajador, String nombre, boolean sueldo) {
        this.idTipoDiaTrabajador = idTipoDiaTrabajador;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public Integer getIdTipoDiaTrabajador() {
        return idTipoDiaTrabajador;
    }

    public void setIdTipoDiaTrabajador(Integer idTipoDiaTrabajador) {
        this.idTipoDiaTrabajador = idTipoDiaTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getSueldo() {
        return sueldo;
    }

    public void setSueldo(boolean sueldo) {
        this.sueldo = sueldo;
    }

    @XmlTransient
    public List<DiaTrabajador> getDiaTrabajadorList() {
        return diaTrabajadorList;
    }

    public void setDiaTrabajadorList(List<DiaTrabajador> diaTrabajadorList) {
        this.diaTrabajadorList = diaTrabajadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDiaTrabajador != null ? idTipoDiaTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDiaTrabajador)) {
            return false;
        }
        TipoDiaTrabajador other = (TipoDiaTrabajador) object;
        if ((this.idTipoDiaTrabajador == null && other.idTipoDiaTrabajador != null) || (this.idTipoDiaTrabajador != null && !this.idTipoDiaTrabajador.equals(other.idTipoDiaTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TipoDiaTrabajador[ idTipoDiaTrabajador=" + idTipoDiaTrabajador + " ]";
    }
    
}
