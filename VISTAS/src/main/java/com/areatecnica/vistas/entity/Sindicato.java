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
    @NamedQuery(name = "Sindicato.findAll", query = "SELECT s FROM Sindicato s"),
    @NamedQuery(name = "Sindicato.findByIdSindicato", query = "SELECT s FROM Sindicato s WHERE s.idSindicato = :idSindicato"),
    @NamedQuery(name = "Sindicato.findByNombreSindicato", query = "SELECT s FROM Sindicato s WHERE s.nombreSindicato = :nombreSindicato"),
    @NamedQuery(name = "Sindicato.findByCuotaSindicato", query = "SELECT s FROM Sindicato s WHERE s.cuotaSindicato = :cuotaSindicato")})
public class Sindicato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sindicato", nullable = false)
    private Integer idSindicato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_sindicato", nullable = false, length = 100)
    private String nombreSindicato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuota_sindicato", nullable = false)
    private int cuotaSindicato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSindicato")
    private List<SindicatoTrabajador> sindicatoTrabajadorList;

    public Sindicato() {
    }

    public Sindicato(Integer idSindicato) {
        this.idSindicato = idSindicato;
    }

    public Sindicato(Integer idSindicato, String nombreSindicato, int cuotaSindicato) {
        this.idSindicato = idSindicato;
        this.nombreSindicato = nombreSindicato;
        this.cuotaSindicato = cuotaSindicato;
    }

    public Integer getIdSindicato() {
        return idSindicato;
    }

    public void setIdSindicato(Integer idSindicato) {
        this.idSindicato = idSindicato;
    }

    public String getNombreSindicato() {
        return nombreSindicato;
    }

    public void setNombreSindicato(String nombreSindicato) {
        this.nombreSindicato = nombreSindicato;
    }

    public int getCuotaSindicato() {
        return cuotaSindicato;
    }

    public void setCuotaSindicato(int cuotaSindicato) {
        this.cuotaSindicato = cuotaSindicato;
    }

    @XmlTransient
    public List<SindicatoTrabajador> getSindicatoTrabajadorList() {
        return sindicatoTrabajadorList;
    }

    public void setSindicatoTrabajadorList(List<SindicatoTrabajador> sindicatoTrabajadorList) {
        this.sindicatoTrabajadorList = sindicatoTrabajadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSindicato != null ? idSindicato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sindicato)) {
            return false;
        }
        Sindicato other = (Sindicato) object;
        if ((this.idSindicato == null && other.idSindicato != null) || (this.idSindicato != null && !this.idSindicato.equals(other.idSindicato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Sindicato[ idSindicato=" + idSindicato + " ]";
    }
    
}
