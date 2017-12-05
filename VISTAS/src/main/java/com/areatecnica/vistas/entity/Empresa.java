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
@Table(catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Empresa.findByRutEmpresa", query = "SELECT e FROM Empresa e WHERE e.rutEmpresa = :rutEmpresa"),
    @NamedQuery(name = "Empresa.findByNombreEmpresa", query = "SELECT e FROM Empresa e WHERE e.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "Empresa.findByGiro", query = "SELECT e FROM Empresa e WHERE e.giro = :giro"),
    @NamedQuery(name = "Empresa.findByDireccionEmpresa", query = "SELECT e FROM Empresa e WHERE e.direccionEmpresa = :direccionEmpresa"),
    @NamedQuery(name = "Empresa.findByTelefonoEmpresa", query = "SELECT e FROM Empresa e WHERE e.telefonoEmpresa = :telefonoEmpresa"),
    @NamedQuery(name = "Empresa.findByFax", query = "SELECT e FROM Empresa e WHERE e.fax = :fax"),
    @NamedQuery(name = "Empresa.findByEmailEmpresa", query = "SELECT e FROM Empresa e WHERE e.emailEmpresa = :emailEmpresa")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa", nullable = false)
    private Integer idEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "rut_empresa", nullable = false, length = 255)
    private String rutEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_empresa", nullable = false, length = 255)
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String giro;
    @Size(max = 255)
    @Column(name = "direccion_empresa", length = 255)
    private String direccionEmpresa;
    @Size(max = 255)
    @Column(name = "telefono_empresa", length = 255)
    private String telefonoEmpresa;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(length = 255)
    private String fax;
    @Size(max = 255)
    @Column(name = "email_empresa", length = 255)
    private String emailEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<LiquidacionEmpresa> liquidacionEmpresaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<RepresentanteEmpresa> representanteEmpresaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<Bus> busList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<RelacionLaboral> relacionLaboralList;
    @JoinColumn(name = "id_caja_compensacion", referencedColumnName = "id_caja_compensacion", nullable = false)
    @ManyToOne(optional = false)
    private CajaCompensacion idCajaCompensacion;
    @JoinColumn(name = "id_mutual", referencedColumnName = "id_mutual", nullable = false)
    @ManyToOne(optional = false)
    private Mutual idMutual;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(Integer idEmpresa, String rutEmpresa, String nombreEmpresa, String giro) {
        this.idEmpresa = idEmpresa;
        this.rutEmpresa = rutEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.giro = giro;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    @XmlTransient
    public List<LiquidacionEmpresa> getLiquidacionEmpresaList() {
        return liquidacionEmpresaList;
    }

    public void setLiquidacionEmpresaList(List<LiquidacionEmpresa> liquidacionEmpresaList) {
        this.liquidacionEmpresaList = liquidacionEmpresaList;
    }

    @XmlTransient
    public List<RepresentanteEmpresa> getRepresentanteEmpresaList() {
        return representanteEmpresaList;
    }

    public void setRepresentanteEmpresaList(List<RepresentanteEmpresa> representanteEmpresaList) {
        this.representanteEmpresaList = representanteEmpresaList;
    }

    @XmlTransient
    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    @XmlTransient
    public List<RelacionLaboral> getRelacionLaboralList() {
        return relacionLaboralList;
    }

    public void setRelacionLaboralList(List<RelacionLaboral> relacionLaboralList) {
        this.relacionLaboralList = relacionLaboralList;
    }

    public CajaCompensacion getIdCajaCompensacion() {
        return idCajaCompensacion;
    }

    public void setIdCajaCompensacion(CajaCompensacion idCajaCompensacion) {
        this.idCajaCompensacion = idCajaCompensacion;
    }

    public Mutual getIdMutual() {
        return idMutual;
    }

    public void setIdMutual(Mutual idMutual) {
        this.idMutual = idMutual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Empresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
