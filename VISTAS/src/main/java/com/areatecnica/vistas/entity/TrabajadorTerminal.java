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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "trabajador_terminal", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrabajadorTerminal.findAll", query = "SELECT t FROM TrabajadorTerminal t"),
    @NamedQuery(name = "TrabajadorTerminal.findByIdTrabajadorTerminal", query = "SELECT t FROM TrabajadorTerminal t WHERE t.idTrabajadorTerminal = :idTrabajadorTerminal")})
public class TrabajadorTerminal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trabajador_terminal", nullable = false)
    private Integer idTrabajadorTerminal;
    @JoinColumn(name = "id_terminal", referencedColumnName = "id_terminal", nullable = false)
    @ManyToOne(optional = false)
    private Terminal idTerminal;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;

    public TrabajadorTerminal() {
    }

    public TrabajadorTerminal(Integer idTrabajadorTerminal) {
        this.idTrabajadorTerminal = idTrabajadorTerminal;
    }

    public Integer getIdTrabajadorTerminal() {
        return idTrabajadorTerminal;
    }

    public void setIdTrabajadorTerminal(Integer idTrabajadorTerminal) {
        this.idTrabajadorTerminal = idTrabajadorTerminal;
    }

    public Terminal getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Terminal idTerminal) {
        this.idTerminal = idTerminal;
    }

    public Trabajador getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Trabajador idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrabajadorTerminal != null ? idTrabajadorTerminal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabajadorTerminal)) {
            return false;
        }
        TrabajadorTerminal other = (TrabajadorTerminal) object;
        if ((this.idTrabajadorTerminal == null && other.idTrabajadorTerminal != null) || (this.idTrabajadorTerminal != null && !this.idTrabajadorTerminal.equals(other.idTrabajadorTerminal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.TrabajadorTerminal[ idTrabajadorTerminal=" + idTrabajadorTerminal + " ]";
    }
    
}
