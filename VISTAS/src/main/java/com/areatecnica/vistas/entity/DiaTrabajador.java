/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.vistas.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "dia_trabajador", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiaTrabajador.findAll", query = "SELECT d FROM DiaTrabajador d"),
    @NamedQuery(name = "DiaTrabajador.findByIdDiaTrabajador", query = "SELECT d FROM DiaTrabajador d WHERE d.idDiaTrabajador = :idDiaTrabajador"),
    @NamedQuery(name = "DiaTrabajador.findByDesde", query = "SELECT d FROM DiaTrabajador d WHERE d.desde = :desde"),
    @NamedQuery(name = "DiaTrabajador.findByHasta", query = "SELECT d FROM DiaTrabajador d WHERE d.hasta = :hasta")})
public class DiaTrabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dia_trabajador", nullable = false)
    private Integer idDiaTrabajador;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date hasta;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;
    @JoinColumn(name = "id_tipo_dia_trabajador", referencedColumnName = "id_tipo_dia_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private TipoDiaTrabajador idTipoDiaTrabajador;

    public DiaTrabajador() {
    }

    public DiaTrabajador(Integer idDiaTrabajador) {
        this.idDiaTrabajador = idDiaTrabajador;
    }

    public DiaTrabajador(Integer idDiaTrabajador, Date desde, Date hasta) {
        this.idDiaTrabajador = idDiaTrabajador;
        this.desde = desde;
        this.hasta = hasta;
    }

    public Integer getIdDiaTrabajador() {
        return idDiaTrabajador;
    }

    public void setIdDiaTrabajador(Integer idDiaTrabajador) {
        this.idDiaTrabajador = idDiaTrabajador;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public Trabajador getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Trabajador idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public TipoDiaTrabajador getIdTipoDiaTrabajador() {
        return idTipoDiaTrabajador;
    }

    public void setIdTipoDiaTrabajador(TipoDiaTrabajador idTipoDiaTrabajador) {
        this.idTipoDiaTrabajador = idTipoDiaTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiaTrabajador != null ? idDiaTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiaTrabajador)) {
            return false;
        }
        DiaTrabajador other = (DiaTrabajador) object;
        if ((this.idDiaTrabajador == null && other.idDiaTrabajador != null) || (this.idDiaTrabajador != null && !this.idDiaTrabajador.equals(other.idDiaTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.DiaTrabajador[ idDiaTrabajador=" + idDiaTrabajador + " ]";
    }
    
}
