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
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsario", query = "SELECT u FROM Usuario u WHERE u.idUsario = :idUsario"),
    @NamedQuery(name = "Usuario.findByRut", query = "SELECT u FROM Usuario u WHERE u.rut = :rut"),
    @NamedQuery(name = "Usuario.findByPass", query = "SELECT u FROM Usuario u WHERE u.pass = :pass"),
    @NamedQuery(name = "Usuario.findByNombres", query = "SELECT u FROM Usuario u WHERE u.nombres = :nombres"),
    @NamedQuery(name = "Usuario.findByApellidoPaterno", query = "SELECT u FROM Usuario u WHERE u.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Usuario.findByApellidoMaterno", query = "SELECT u FROM Usuario u WHERE u.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usario", nullable = false)
    private Integer idUsario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(nullable = false, length = 9)
    private String rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String pass;
    @Size(max = 255)
    @Column(length = 255)
    private String nombres;
    @Size(max = 255)
    @Column(name = "apellido_paterno", length = 255)
    private String apellidoPaterno;
    @Size(max = 255)
    @Column(name = "apellido_materno", length = 255)
    private String apellidoMaterno;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(length = 255)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInspector")
    private List<Despacho> despachoList;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)
    @ManyToOne(optional = false)
    private Rol idRol;
    @JoinColumn(name = "id_terminal", referencedColumnName = "id_terminal", nullable = false)
    @ManyToOne(optional = false)
    private Terminal idTerminal;

    public Usuario() {
    }

    public Usuario(Integer idUsario) {
        this.idUsario = idUsario;
    }

    public Usuario(Integer idUsario, String rut, String pass) {
        this.idUsario = idUsario;
        this.rut = rut;
        this.pass = pass;
    }

    public Integer getIdUsario() {
        return idUsario;
    }

    public void setIdUsario(Integer idUsario) {
        this.idUsario = idUsario;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Despacho> getDespachoList() {
        return despachoList;
    }

    public void setDespachoList(List<Despacho> despachoList) {
        this.despachoList = despachoList;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public Terminal getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Terminal idTerminal) {
        this.idTerminal = idTerminal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsario != null ? idUsario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsario == null && other.idUsario != null) || (this.idUsario != null && !this.idUsario.equals(other.idUsario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.Usuario[ idUsario=" + idUsario + " ]";
    }
    
}
