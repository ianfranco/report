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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "unidad_negocio", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadNegocio.findAll", query = "SELECT u FROM UnidadNegocio u"),
    @NamedQuery(name = "UnidadNegocio.findByIdUnidadNegocio", query = "SELECT u FROM UnidadNegocio u WHERE u.idUnidadNegocio = :idUnidadNegocio"),
    @NamedQuery(name = "UnidadNegocio.findByNumeroUnidadNegocio", query = "SELECT u FROM UnidadNegocio u WHERE u.numeroUnidadNegocio = :numeroUnidadNegocio"),
    @NamedQuery(name = "UnidadNegocio.findByNombreUnidadNegocio", query = "SELECT u FROM UnidadNegocio u WHERE u.nombreUnidadNegocio = :nombreUnidadNegocio")})
public class UnidadNegocio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unidad_negocio", nullable = false)
    private Integer idUnidadNegocio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_unidad_negocio", nullable = false)
    private int numeroUnidadNegocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_unidad_negocio", nullable = false, length = 45)
    private String nombreUnidadNegocio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadNegocio")
    private List<ContratoUnidad> contratoUnidadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadNegocio")
    private List<Bus> busList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidad")
    private List<ValorRolloUnidad> valorRolloUnidadList;
    @JoinColumn(name = "id_operador_transporte", referencedColumnName = "id_operador_transporte", nullable = false)
    @ManyToOne(optional = false)
    private OperadorTransporte idOperadorTransporte;
    @JoinColumn(name = "id_region", referencedColumnName = "id_region", nullable = false)
    @ManyToOne(optional = false)
    private Region idRegion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidad")
    private List<Servicio> servicioList;

    public UnidadNegocio() {
    }

    public UnidadNegocio(Integer idUnidadNegocio) {
        this.idUnidadNegocio = idUnidadNegocio;
    }

    public UnidadNegocio(Integer idUnidadNegocio, int numeroUnidadNegocio, String nombreUnidadNegocio) {
        this.idUnidadNegocio = idUnidadNegocio;
        this.numeroUnidadNegocio = numeroUnidadNegocio;
        this.nombreUnidadNegocio = nombreUnidadNegocio;
    }

    public Integer getIdUnidadNegocio() {
        return idUnidadNegocio;
    }

    public void setIdUnidadNegocio(Integer idUnidadNegocio) {
        this.idUnidadNegocio = idUnidadNegocio;
    }

    public int getNumeroUnidadNegocio() {
        return numeroUnidadNegocio;
    }

    public void setNumeroUnidadNegocio(int numeroUnidadNegocio) {
        this.numeroUnidadNegocio = numeroUnidadNegocio;
    }

    public String getNombreUnidadNegocio() {
        return nombreUnidadNegocio;
    }

    public void setNombreUnidadNegocio(String nombreUnidadNegocio) {
        this.nombreUnidadNegocio = nombreUnidadNegocio;
    }

    @XmlTransient
    public List<ContratoUnidad> getContratoUnidadList() {
        return contratoUnidadList;
    }

    public void setContratoUnidadList(List<ContratoUnidad> contratoUnidadList) {
        this.contratoUnidadList = contratoUnidadList;
    }

    @XmlTransient
    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    @XmlTransient
    public List<ValorRolloUnidad> getValorRolloUnidadList() {
        return valorRolloUnidadList;
    }

    public void setValorRolloUnidadList(List<ValorRolloUnidad> valorRolloUnidadList) {
        this.valorRolloUnidadList = valorRolloUnidadList;
    }

    public OperadorTransporte getIdOperadorTransporte() {
        return idOperadorTransporte;
    }

    public void setIdOperadorTransporte(OperadorTransporte idOperadorTransporte) {
        this.idOperadorTransporte = idOperadorTransporte;
    }

    public Region getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Region idRegion) {
        this.idRegion = idRegion;
    }

    @XmlTransient
    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadNegocio != null ? idUnidadNegocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadNegocio)) {
            return false;
        }
        UnidadNegocio other = (UnidadNegocio) object;
        if ((this.idUnidadNegocio == null && other.idUnidadNegocio != null) || (this.idUnidadNegocio != null && !this.idUnidadNegocio.equals(other.idUnidadNegocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.UnidadNegocio[ idUnidadNegocio=" + idUnidadNegocio + " ]";
    }

}
