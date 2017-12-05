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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "contrato_unidad", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContratoUnidad.findAll", query = "SELECT c FROM ContratoUnidad c"),
    @NamedQuery(name = "ContratoUnidad.findByIdContratoUnidad", query = "SELECT c FROM ContratoUnidad c WHERE c.idContratoUnidad = :idContratoUnidad"),
    @NamedQuery(name = "ContratoUnidad.findByIdentificadorContratoUnidad", query = "SELECT c FROM ContratoUnidad c WHERE c.identificadorContratoUnidad = :identificadorContratoUnidad"),
    @NamedQuery(name = "ContratoUnidad.findByDesdeContratoUnidad", query = "SELECT c FROM ContratoUnidad c WHERE c.desdeContratoUnidad = :desdeContratoUnidad"),
    @NamedQuery(name = "ContratoUnidad.findByHastaContratoUnidad", query = "SELECT c FROM ContratoUnidad c WHERE c.hastaContratoUnidad = :hastaContratoUnidad"),
    @NamedQuery(name = "ContratoUnidad.findByNombreContratoUnidad", query = "SELECT c FROM ContratoUnidad c WHERE c.nombreContratoUnidad = :nombreContratoUnidad"),
    @NamedQuery(name = "ContratoUnidad.findByDescripcionContratoUnidad", query = "SELECT c FROM ContratoUnidad c WHERE c.descripcionContratoUnidad = :descripcionContratoUnidad")})
public class ContratoUnidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contrato_unidad", nullable = false)
    private Integer idContratoUnidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "identificador_contrato_unidad", nullable = false, length = 45)
    private String identificadorContratoUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desde_contrato_unidad", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date desdeContratoUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hasta_contrato_unidad", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date hastaContratoUnidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_contrato_unidad", nullable = false, length = 100)
    private String nombreContratoUnidad;
    @Size(max = 400)
    @Column(name = "descripcion_contrato_unidad", length = 400)
    private String descripcionContratoUnidad;
    @JoinColumn(name = "id_unidad_negocio", referencedColumnName = "id_unidad_negocio", nullable = false)
    @ManyToOne(optional = false)
    private UnidadNegocio idUnidadNegocio;

    public ContratoUnidad() {
    }

    public ContratoUnidad(Integer idContratoUnidad) {
        this.idContratoUnidad = idContratoUnidad;
    }

    public ContratoUnidad(Integer idContratoUnidad, String identificadorContratoUnidad, Date desdeContratoUnidad, Date hastaContratoUnidad, String nombreContratoUnidad) {
        this.idContratoUnidad = idContratoUnidad;
        this.identificadorContratoUnidad = identificadorContratoUnidad;
        this.desdeContratoUnidad = desdeContratoUnidad;
        this.hastaContratoUnidad = hastaContratoUnidad;
        this.nombreContratoUnidad = nombreContratoUnidad;
    }

    public Integer getIdContratoUnidad() {
        return idContratoUnidad;
    }

    public void setIdContratoUnidad(Integer idContratoUnidad) {
        this.idContratoUnidad = idContratoUnidad;
    }

    public String getIdentificadorContratoUnidad() {
        return identificadorContratoUnidad;
    }

    public void setIdentificadorContratoUnidad(String identificadorContratoUnidad) {
        this.identificadorContratoUnidad = identificadorContratoUnidad;
    }

    public Date getDesdeContratoUnidad() {
        return desdeContratoUnidad;
    }

    public void setDesdeContratoUnidad(Date desdeContratoUnidad) {
        this.desdeContratoUnidad = desdeContratoUnidad;
    }

    public Date getHastaContratoUnidad() {
        return hastaContratoUnidad;
    }

    public void setHastaContratoUnidad(Date hastaContratoUnidad) {
        this.hastaContratoUnidad = hastaContratoUnidad;
    }

    public String getNombreContratoUnidad() {
        return nombreContratoUnidad;
    }

    public void setNombreContratoUnidad(String nombreContratoUnidad) {
        this.nombreContratoUnidad = nombreContratoUnidad;
    }

    public String getDescripcionContratoUnidad() {
        return descripcionContratoUnidad;
    }

    public void setDescripcionContratoUnidad(String descripcionContratoUnidad) {
        this.descripcionContratoUnidad = descripcionContratoUnidad;
    }

    public UnidadNegocio getIdUnidadNegocio() {
        return idUnidadNegocio;
    }

    public void setIdUnidadNegocio(UnidadNegocio idUnidadNegocio) {
        this.idUnidadNegocio = idUnidadNegocio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContratoUnidad != null ? idContratoUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContratoUnidad)) {
            return false;
        }
        ContratoUnidad other = (ContratoUnidad) object;
        if ((this.idContratoUnidad == null && other.idContratoUnidad != null) || (this.idContratoUnidad != null && !this.idContratoUnidad.equals(other.idContratoUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.ContratoUnidad[ idContratoUnidad=" + idContratoUnidad + " ]";
    }
    
}
