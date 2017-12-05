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
@Table(name = "operador_transporte", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperadorTransporte.findAll", query = "SELECT o FROM OperadorTransporte o"),
    @NamedQuery(name = "OperadorTransporte.findByIdOperadorTransporte", query = "SELECT o FROM OperadorTransporte o WHERE o.idOperadorTransporte = :idOperadorTransporte"),
    @NamedQuery(name = "OperadorTransporte.findByRutOperador", query = "SELECT o FROM OperadorTransporte o WHERE o.rutOperador = :rutOperador"),
    @NamedQuery(name = "OperadorTransporte.findByNombreOperador", query = "SELECT o FROM OperadorTransporte o WHERE o.nombreOperador = :nombreOperador")})
public class OperadorTransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operador_transporte", nullable = false)
    private Integer idOperadorTransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "rut_operador", nullable = false, length = 9)
    private String rutOperador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_operador", nullable = false, length = 45)
    private String nombreOperador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperadorTransporte")
    private List<UnidadNegocio> unidadNegocioList;

    public OperadorTransporte() {
    }

    public OperadorTransporte(Integer idOperadorTransporte) {
        this.idOperadorTransporte = idOperadorTransporte;
    }

    public OperadorTransporte(Integer idOperadorTransporte, String rutOperador, String nombreOperador) {
        this.idOperadorTransporte = idOperadorTransporte;
        this.rutOperador = rutOperador;
        this.nombreOperador = nombreOperador;
    }

    public Integer getIdOperadorTransporte() {
        return idOperadorTransporte;
    }

    public void setIdOperadorTransporte(Integer idOperadorTransporte) {
        this.idOperadorTransporte = idOperadorTransporte;
    }

    public String getRutOperador() {
        return rutOperador;
    }

    public void setRutOperador(String rutOperador) {
        this.rutOperador = rutOperador;
    }

    public String getNombreOperador() {
        return nombreOperador;
    }

    public void setNombreOperador(String nombreOperador) {
        this.nombreOperador = nombreOperador;
    }

    @XmlTransient
    public List<UnidadNegocio> getUnidadNegocioList() {
        return unidadNegocioList;
    }

    public void setUnidadNegocioList(List<UnidadNegocio> unidadNegocioList) {
        this.unidadNegocioList = unidadNegocioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperadorTransporte != null ? idOperadorTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperadorTransporte)) {
            return false;
        }
        OperadorTransporte other = (OperadorTransporte) object;
        if ((this.idOperadorTransporte == null && other.idOperadorTransporte != null) || (this.idOperadorTransporte != null && !this.idOperadorTransporte.equals(other.idOperadorTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.OperadorTransporte[ idOperadorTransporte=" + idOperadorTransporte + " ]";
    }
    
}
