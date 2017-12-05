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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ian Franco
 */
@Entity
@Table(name = "detalle_intervalos_mensual", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleIntervalosMensual.findAll", query = "SELECT d FROM DetalleIntervalosMensual d"),
    @NamedQuery(name = "DetalleIntervalosMensual.findByIdDetalleIntervalosMensual", query = "SELECT d FROM DetalleIntervalosMensual d WHERE d.idDetalleIntervalosMensual = :idDetalleIntervalosMensual"),
    @NamedQuery(name = "DetalleIntervalosMensual.findByNumeroBuses", query = "SELECT d FROM DetalleIntervalosMensual d WHERE d.numeroBuses = :numeroBuses")})
public class DetalleIntervalosMensual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_intervalos_mensual", nullable = false)
    private Integer idDetalleIntervalosMensual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_buses", nullable = false)
    private int numeroBuses;
    @JoinColumn(name = "id_administracion_mensual", referencedColumnName = "id_administracion_mensual", nullable = false)
    @ManyToOne(optional = false)
    private AdministracionMensual idAdministracionMensual;
    @JoinColumn(name = "id_intervalo_administracion", referencedColumnName = "id_intervalos_administracion", nullable = false)
    @ManyToOne(optional = false)
    private IntervalosAdministracion idIntervaloAdministracion;

    public DetalleIntervalosMensual() {
    }

    public DetalleIntervalosMensual(Integer idDetalleIntervalosMensual) {
        this.idDetalleIntervalosMensual = idDetalleIntervalosMensual;
    }

    public DetalleIntervalosMensual(Integer idDetalleIntervalosMensual, int numeroBuses) {
        this.idDetalleIntervalosMensual = idDetalleIntervalosMensual;
        this.numeroBuses = numeroBuses;
    }

    public Integer getIdDetalleIntervalosMensual() {
        return idDetalleIntervalosMensual;
    }

    public void setIdDetalleIntervalosMensual(Integer idDetalleIntervalosMensual) {
        this.idDetalleIntervalosMensual = idDetalleIntervalosMensual;
    }

    public int getNumeroBuses() {
        return numeroBuses;
    }

    public void setNumeroBuses(int numeroBuses) {
        this.numeroBuses = numeroBuses;
    }

    public AdministracionMensual getIdAdministracionMensual() {
        return idAdministracionMensual;
    }

    public void setIdAdministracionMensual(AdministracionMensual idAdministracionMensual) {
        this.idAdministracionMensual = idAdministracionMensual;
    }

    public IntervalosAdministracion getIdIntervaloAdministracion() {
        return idIntervaloAdministracion;
    }

    public void setIdIntervaloAdministracion(IntervalosAdministracion idIntervaloAdministracion) {
        this.idIntervaloAdministracion = idIntervaloAdministracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleIntervalosMensual != null ? idDetalleIntervalosMensual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleIntervalosMensual)) {
            return false;
        }
        DetalleIntervalosMensual other = (DetalleIntervalosMensual) object;
        if ((this.idDetalleIntervalosMensual == null && other.idDetalleIntervalosMensual != null) || (this.idDetalleIntervalosMensual != null && !this.idDetalleIntervalosMensual.equals(other.idDetalleIntervalosMensual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.DetalleIntervalosMensual[ idDetalleIntervalosMensual=" + idDetalleIntervalosMensual + " ]";
    }
    
}
