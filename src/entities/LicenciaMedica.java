package entities;
// Generated 26-09-2016 11:01:55 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LicenciaMedica generated by hbm2java
 */
@Entity
@Table(name="licencia_medica"
    ,catalog="sigf_v1"
)
public class LicenciaMedica  implements java.io.Serializable {


     private Integer idLicenciaMedica;
     private Trabajador trabajador;
     private String numeroLicencia;
     private Date fechaIngresoLicencia;
     private Date fechaRecepcionLicencia;
     private Date fechaEmisionLicencia;
     private Date fechaDesdeReposo;
     private Date fechaHastaReposo;
     private String diagnosticoLicencia;

    public LicenciaMedica() {
    }

	
    public LicenciaMedica(Trabajador trabajador, Date fechaIngresoLicencia, Date fechaRecepcionLicencia, Date fechaEmisionLicencia, Date fechaDesdeReposo, Date fechaHastaReposo) {
        this.trabajador = trabajador;
        this.fechaIngresoLicencia = fechaIngresoLicencia;
        this.fechaRecepcionLicencia = fechaRecepcionLicencia;
        this.fechaEmisionLicencia = fechaEmisionLicencia;
        this.fechaDesdeReposo = fechaDesdeReposo;
        this.fechaHastaReposo = fechaHastaReposo;
    }
    public LicenciaMedica(Trabajador trabajador, String numeroLicencia, Date fechaIngresoLicencia, Date fechaRecepcionLicencia, Date fechaEmisionLicencia, Date fechaDesdeReposo, Date fechaHastaReposo, String diagnosticoLicencia) {
       this.trabajador = trabajador;
       this.numeroLicencia = numeroLicencia;
       this.fechaIngresoLicencia = fechaIngresoLicencia;
       this.fechaRecepcionLicencia = fechaRecepcionLicencia;
       this.fechaEmisionLicencia = fechaEmisionLicencia;
       this.fechaDesdeReposo = fechaDesdeReposo;
       this.fechaHastaReposo = fechaHastaReposo;
       this.diagnosticoLicencia = diagnosticoLicencia;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_licencia_medica", unique=true, nullable=false)
    public Integer getIdLicenciaMedica() {
        return this.idLicenciaMedica;
    }
    
    public void setIdLicenciaMedica(Integer idLicenciaMedica) {
        this.idLicenciaMedica = idLicenciaMedica;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_trabajador", nullable=false)
    public Trabajador getTrabajador() {
        return this.trabajador;
    }
    
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    
    @Column(name="numero_licencia", length=45)
    public String getNumeroLicencia() {
        return this.numeroLicencia;
    }
    
    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_ingreso_licencia", nullable=false, length=19)
    public Date getFechaIngresoLicencia() {
        return this.fechaIngresoLicencia;
    }
    
    public void setFechaIngresoLicencia(Date fechaIngresoLicencia) {
        this.fechaIngresoLicencia = fechaIngresoLicencia;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_recepcion_licencia", nullable=false, length=10)
    public Date getFechaRecepcionLicencia() {
        return this.fechaRecepcionLicencia;
    }
    
    public void setFechaRecepcionLicencia(Date fechaRecepcionLicencia) {
        this.fechaRecepcionLicencia = fechaRecepcionLicencia;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_emision_licencia", nullable=false, length=10)
    public Date getFechaEmisionLicencia() {
        return this.fechaEmisionLicencia;
    }
    
    public void setFechaEmisionLicencia(Date fechaEmisionLicencia) {
        this.fechaEmisionLicencia = fechaEmisionLicencia;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_desde_reposo", nullable=false, length=10)
    public Date getFechaDesdeReposo() {
        return this.fechaDesdeReposo;
    }
    
    public void setFechaDesdeReposo(Date fechaDesdeReposo) {
        this.fechaDesdeReposo = fechaDesdeReposo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_hasta_reposo", nullable=false, length=10)
    public Date getFechaHastaReposo() {
        return this.fechaHastaReposo;
    }
    
    public void setFechaHastaReposo(Date fechaHastaReposo) {
        this.fechaHastaReposo = fechaHastaReposo;
    }

    
    @Column(name="diagnostico_licencia", length=100)
    public String getDiagnosticoLicencia() {
        return this.diagnosticoLicencia;
    }
    
    public void setDiagnosticoLicencia(String diagnosticoLicencia) {
        this.diagnosticoLicencia = diagnosticoLicencia;
    }




}


