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
@Table(name = "intervalos_administracion", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IntervalosAdministracion.findAll", query = "SELECT i FROM IntervalosAdministracion i"),
    @NamedQuery(name = "IntervalosAdministracion.findByIdIntervalosAdministracion", query = "SELECT i FROM IntervalosAdministracion i WHERE i.idIntervalosAdministracion = :idIntervalosAdministracion"),
    @NamedQuery(name = "IntervalosAdministracion.findByNombreIntervaloAdministracion", query = "SELECT i FROM IntervalosAdministracion i WHERE i.nombreIntervaloAdministracion = :nombreIntervaloAdministracion"),
    @NamedQuery(name = "IntervalosAdministracion.findByDesde", query = "SELECT i FROM IntervalosAdministracion i WHERE i.desde = :desde"),
    @NamedQuery(name = "IntervalosAdministracion.findByHasta", query = "SELECT i FROM IntervalosAdministracion i WHERE i.hasta = :hasta")})
public class IntervalosAdministracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_intervalos_administracion", nullable = false)
    private Integer idIntervalosAdministracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_intervalo_administracion", nullable = false, length = 45)
    private String nombreIntervaloAdministracion;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int desde;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int hasta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIntervaloAdministracion")
    private List<DetalleIntervalosMensual> detalleIntervalosMensualList;

    public IntervalosAdministracion() {
    }

    public IntervalosAdministracion(Integer idIntervalosAdministracion) {
        this.idIntervalosAdministracion = idIntervalosAdministracion;
    }

    public IntervalosAdministracion(Integer idIntervalosAdministracion, String nombreIntervaloAdministracion, int desde, int hasta) {
        this.idIntervalosAdministracion = idIntervalosAdministracion;
        this.nombreIntervaloAdministracion = nombreIntervaloAdministracion;
        this.desde = desde;
        this.hasta = hasta;
    }

    public Integer getIdIntervalosAdministracion() {
        return idIntervalosAdministracion;
    }

    public void setIdIntervalosAdministracion(Integer idIntervalosAdministracion) {
        this.idIntervalosAdministracion = idIntervalosAdministracion;
    }

    public String getNombreIntervaloAdministracion() {
        return nombreIntervaloAdministracion;
    }

    public void setNombreIntervaloAdministracion(String nombreIntervaloAdministracion) {
        this.nombreIntervaloAdministracion = nombreIntervaloAdministracion;
    }

    public int getDesde() {
        return desde;
    }

    public void setDesde(int desde) {
        this.desde = desde;
    }

    public int getHasta() {
        return hasta;
    }

    public void setHasta(int hasta) {
        this.hasta = hasta;
    }

    @XmlTransient
    public List<DetalleIntervalosMensual> getDetalleIntervalosMensualList() {
        return detalleIntervalosMensualList;
    }

    public void setDetalleIntervalosMensualList(List<DetalleIntervalosMensual> detalleIntervalosMensualList) {
        this.detalleIntervalosMensualList = detalleIntervalosMensualList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIntervalosAdministracion != null ? idIntervalosAdministracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntervalosAdministracion)) {
            return false;
        }
        IntervalosAdministracion other = (IntervalosAdministracion) object;
        if ((this.idIntervalosAdministracion == null && other.idIntervalosAdministracion != null) || (this.idIntervalosAdministracion != null && !this.idIntervalosAdministracion.equals(other.idIntervalosAdministracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.IntervalosAdministracion[ idIntervalosAdministracion=" + idIntervalosAdministracion + " ]";
    }
    
}
