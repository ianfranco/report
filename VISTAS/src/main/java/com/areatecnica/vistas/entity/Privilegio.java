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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilegio.findAll", query = "SELECT p FROM Privilegio p"),
    @NamedQuery(name = "Privilegio.findByIdPrivilegio", query = "SELECT p FROM Privilegio p WHERE p.idPrivilegio = :idPrivilegio"),
    @NamedQuery(name = "Privilegio.findByNombrePrivilegio", query = "SELECT p FROM Privilegio p WHERE p.nombrePrivilegio = :nombrePrivilegio"),
    @NamedQuery(name = "Privilegio.findByDescripcion", query = "SELECT p FROM Privilegio p WHERE p.descripcion = :descripcion")})
public class Privilegio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_privilegio", nullable = false)
    private Integer idPrivilegio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_privilegio", nullable = false, length = 255)
    private String nombrePrivilegio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String descripcion;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)
    @ManyToOne(optional = false)
    private Rol idRol;

    public Privilegio() {
    }

    public Privilegio(Integer idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    public Privilegio(Integer idPrivilegio, String nombrePrivilegio, String descripcion) {
        this.idPrivilegio = idPrivilegio;
        this.nombrePrivilegio = nombrePrivilegio;
        this.descripcion = descripcion;
    }

    public Integer getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(Integer idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    public String getNombrePrivilegio() {
        return nombrePrivilegio;
    }

    public void setNombrePrivilegio(String nombrePrivilegio) {
        this.nombrePrivilegio = nombrePrivilegio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrivilegio != null ? idPrivilegio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilegio)) {
            return false;
        }
        Privilegio other = (Privilegio) object;
        if ((this.idPrivilegio == null && other.idPrivilegio != null) || (this.idPrivilegio != null && !this.idPrivilegio.equals(other.idPrivilegio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Privilegio[ idPrivilegio=" + idPrivilegio + " ]";
    }
    
}
