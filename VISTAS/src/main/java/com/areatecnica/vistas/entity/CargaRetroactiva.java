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
@Table(name = "carga_retroactiva", catalog = "sigf_v1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CargaRetroactiva.findAll", query = "SELECT c FROM CargaRetroactiva c"),
    @NamedQuery(name = "CargaRetroactiva.findByIdCargaRetroactiva", query = "SELECT c FROM CargaRetroactiva c WHERE c.idCargaRetroactiva = :idCargaRetroactiva"),
    @NamedQuery(name = "CargaRetroactiva.findByMesLiquidacion", query = "SELECT c FROM CargaRetroactiva c WHERE c.mesLiquidacion = :mesLiquidacion"),
    @NamedQuery(name = "CargaRetroactiva.findByA\u00f1oLiquidacion", query = "SELECT c FROM CargaRetroactiva c WHERE c.a\u00f1oLiquidacion = :a\u00f1oLiquidacion"),
    @NamedQuery(name = "CargaRetroactiva.findByMontoRetroactivo", query = "SELECT c FROM CargaRetroactiva c WHERE c.montoRetroactivo = :montoRetroactivo")})
public class CargaRetroactiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carga_retroactiva", nullable = false)
    private Integer idCargaRetroactiva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mes_liquidacion", nullable = false)
    private int mesLiquidacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "a\u00f1o_liquidacion", nullable = false)
    private int añoLiquidacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_retroactivo", nullable = false)
    private int montoRetroactivo;
    @JoinColumn(name = "id_carga_trabajador", referencedColumnName = "id_cargas_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private CargasTrabajador idCargaTrabajador;
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador", nullable = false)
    @ManyToOne(optional = false)
    private Trabajador idTrabajador;

    public CargaRetroactiva() {
    }

    public CargaRetroactiva(Integer idCargaRetroactiva) {
        this.idCargaRetroactiva = idCargaRetroactiva;
    }

    public CargaRetroactiva(Integer idCargaRetroactiva, int mesLiquidacion, int añoLiquidacion, int montoRetroactivo) {
        this.idCargaRetroactiva = idCargaRetroactiva;
        this.mesLiquidacion = mesLiquidacion;
        this.añoLiquidacion = añoLiquidacion;
        this.montoRetroactivo = montoRetroactivo;
    }

    public Integer getIdCargaRetroactiva() {
        return idCargaRetroactiva;
    }

    public void setIdCargaRetroactiva(Integer idCargaRetroactiva) {
        this.idCargaRetroactiva = idCargaRetroactiva;
    }

    public int getMesLiquidacion() {
        return mesLiquidacion;
    }

    public void setMesLiquidacion(int mesLiquidacion) {
        this.mesLiquidacion = mesLiquidacion;
    }

    public int getAñoLiquidacion() {
        return añoLiquidacion;
    }

    public void setAñoLiquidacion(int añoLiquidacion) {
        this.añoLiquidacion = añoLiquidacion;
    }

    public int getMontoRetroactivo() {
        return montoRetroactivo;
    }

    public void setMontoRetroactivo(int montoRetroactivo) {
        this.montoRetroactivo = montoRetroactivo;
    }

    public CargasTrabajador getIdCargaTrabajador() {
        return idCargaTrabajador;
    }

    public void setIdCargaTrabajador(CargasTrabajador idCargaTrabajador) {
        this.idCargaTrabajador = idCargaTrabajador;
    }

    public Trabajador getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Trabajador idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargaRetroactiva != null ? idCargaRetroactiva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargaRetroactiva)) {
            return false;
        }
        CargaRetroactiva other = (CargaRetroactiva) object;
        if ((this.idCargaRetroactiva == null && other.idCargaRetroactiva != null) || (this.idCargaRetroactiva != null && !this.idCargaRetroactiva.equals(other.idCargaRetroactiva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.areatecnica.vistas.entity.CargaRetroactiva[ idCargaRetroactiva=" + idCargaRetroactiva + " ]";
    }
    
}
