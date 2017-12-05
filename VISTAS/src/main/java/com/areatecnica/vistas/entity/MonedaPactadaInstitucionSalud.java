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
@Table(name = "moneda_pactada_institucion_salud", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MonedaPactadaInstitucionSalud.findAll", query = "SELECT m FROM MonedaPactadaInstitucionSalud m"),
    @NamedQuery(name = "MonedaPactadaInstitucionSalud.findByIdMonedaSalud", query = "SELECT m FROM MonedaPactadaInstitucionSalud m WHERE m.idMonedaSalud = :idMonedaSalud"),
    @NamedQuery(name = "MonedaPactadaInstitucionSalud.findByNombreMonedaSalud", query = "SELECT m FROM MonedaPactadaInstitucionSalud m WHERE m.nombreMonedaSalud = :nombreMonedaSalud")})
public class MonedaPactadaInstitucionSalud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_moneda_salud", nullable = false)
    private Integer idMonedaSalud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_moneda_salud", nullable = false, length = 45)
    private String nombreMonedaSalud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMonedaPactadaSalud")
    private List<Trabajador> trabajadorList;

    public MonedaPactadaInstitucionSalud() {
    }

    public MonedaPactadaInstitucionSalud(Integer idMonedaSalud) {
        this.idMonedaSalud = idMonedaSalud;
    }

    public MonedaPactadaInstitucionSalud(Integer idMonedaSalud, String nombreMonedaSalud) {
        this.idMonedaSalud = idMonedaSalud;
        this.nombreMonedaSalud = nombreMonedaSalud;
    }

    public Integer getIdMonedaSalud() {
        return idMonedaSalud;
    }

    public void setIdMonedaSalud(Integer idMonedaSalud) {
        this.idMonedaSalud = idMonedaSalud;
    }

    public String getNombreMonedaSalud() {
        return nombreMonedaSalud;
    }

    public void setNombreMonedaSalud(String nombreMonedaSalud) {
        this.nombreMonedaSalud = nombreMonedaSalud;
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
        hash += (idMonedaSalud != null ? idMonedaSalud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonedaPactadaInstitucionSalud)) {
            return false;
        }
        MonedaPactadaInstitucionSalud other = (MonedaPactadaInstitucionSalud) object;
        if ((this.idMonedaSalud == null && other.idMonedaSalud != null) || (this.idMonedaSalud != null && !this.idMonedaSalud.equals(other.idMonedaSalud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.MonedaPactadaInstitucionSalud[ idMonedaSalud=" + idMonedaSalud + " ]";
    }
    
}
