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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "parametro_interpolacion", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParametroInterpolacion.findAll", query = "SELECT p FROM ParametroInterpolacion p"),
    @NamedQuery(name = "ParametroInterpolacion.findByIdParametroInterpolacion", query = "SELECT p FROM ParametroInterpolacion p WHERE p.idParametroInterpolacion = :idParametroInterpolacion"),
    @NamedQuery(name = "ParametroInterpolacion.findByNombreParametro", query = "SELECT p FROM ParametroInterpolacion p WHERE p.nombreParametro = :nombreParametro"),
    @NamedQuery(name = "ParametroInterpolacion.findByValorParametro", query = "SELECT p FROM ParametroInterpolacion p WHERE p.valorParametro = :valorParametro"),
    @NamedQuery(name = "ParametroInterpolacion.findByUnidadParametro", query = "SELECT p FROM ParametroInterpolacion p WHERE p.unidadParametro = :unidadParametro")})
public class ParametroInterpolacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parametro_interpolacion", nullable = false)
    private Integer idParametroInterpolacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_parametro", nullable = false, length = 100)
    private String nombreParametro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_parametro", nullable = false)
    private float valorParametro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "unidad_parametro", nullable = false, length = 45)
    private String unidadParametro;

    public ParametroInterpolacion() {
    }

    public ParametroInterpolacion(Integer idParametroInterpolacion) {
        this.idParametroInterpolacion = idParametroInterpolacion;
    }

    public ParametroInterpolacion(Integer idParametroInterpolacion, String nombreParametro, float valorParametro, String unidadParametro) {
        this.idParametroInterpolacion = idParametroInterpolacion;
        this.nombreParametro = nombreParametro;
        this.valorParametro = valorParametro;
        this.unidadParametro = unidadParametro;
    }

    public Integer getIdParametroInterpolacion() {
        return idParametroInterpolacion;
    }

    public void setIdParametroInterpolacion(Integer idParametroInterpolacion) {
        this.idParametroInterpolacion = idParametroInterpolacion;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

    public float getValorParametro() {
        return valorParametro;
    }

    public void setValorParametro(float valorParametro) {
        this.valorParametro = valorParametro;
    }

    public String getUnidadParametro() {
        return unidadParametro;
    }

    public void setUnidadParametro(String unidadParametro) {
        this.unidadParametro = unidadParametro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametroInterpolacion != null ? idParametroInterpolacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametroInterpolacion)) {
            return false;
        }
        ParametroInterpolacion other = (ParametroInterpolacion) object;
        if ((this.idParametroInterpolacion == null && other.idParametroInterpolacion != null) || (this.idParametroInterpolacion != null && !this.idParametroInterpolacion.equals(other.idParametroInterpolacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.ParametroInterpolacion[ idParametroInterpolacion=" + idParametroInterpolacion + " ]";
    }
    
}
