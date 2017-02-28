package entities;
// Generated 26-09-2016 11:01:55 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProcesoRecaudacion generated by hbm2java
 */
@Entity
@Table(name="proceso_recaudacion"
    ,catalog="sigf_v1"
)
public class ProcesoRecaudacion  implements java.io.Serializable {


     private Integer idProcesoRecaudacion;
     private String nombreProceso;
     private int idUsuario;
     private Date fechaCreacionProceso;
     private Boolean activo;
     private String nombreGeneral;
     private Integer idGeneral;
     private Set<ServicioProcesoRecaudacion> servicioProcesoRecaudacions = new HashSet<ServicioProcesoRecaudacion>(0);
     private Set<EgresoRecaudacion> egresoRecaudacions = new HashSet<EgresoRecaudacion>(0);
     private Set<Guia> guias = new HashSet<Guia>(0);

    public ProcesoRecaudacion() {
    }

	
    public ProcesoRecaudacion(String nombreProceso, int idUsuario, Date fechaCreacionProceso) {
        this.nombreProceso = nombreProceso;
        this.idUsuario = idUsuario;
        this.fechaCreacionProceso = fechaCreacionProceso;
    }
    public ProcesoRecaudacion(String nombreProceso, int idUsuario, Date fechaCreacionProceso, Boolean activo, String nombreGeneral, Integer idGeneral, Set<ServicioProcesoRecaudacion> servicioProcesoRecaudacions, Set<EgresoRecaudacion> egresoRecaudacions, Set<Guia> guias) {
       this.nombreProceso = nombreProceso;
       this.idUsuario = idUsuario;
       this.fechaCreacionProceso = fechaCreacionProceso;
       this.activo = activo;
       this.nombreGeneral = nombreGeneral;
       this.idGeneral = idGeneral;
       this.servicioProcesoRecaudacions = servicioProcesoRecaudacions;
       this.egresoRecaudacions = egresoRecaudacions;
       this.guias = guias;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_proceso_recaudacion", unique=true, nullable=false)
    public Integer getIdProcesoRecaudacion() {
        return this.idProcesoRecaudacion;
    }
    
    public void setIdProcesoRecaudacion(Integer idProcesoRecaudacion) {
        this.idProcesoRecaudacion = idProcesoRecaudacion;
    }

    
    @Column(name="nombre_proceso", nullable=false, length=45)
    public String getNombreProceso() {
        return this.nombreProceso;
    }
    
    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    
    @Column(name="id_usuario", nullable=false)
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_creacion_proceso", nullable=false, length=19)
    public Date getFechaCreacionProceso() {
        return this.fechaCreacionProceso;
    }
    
    public void setFechaCreacionProceso(Date fechaCreacionProceso) {
        this.fechaCreacionProceso = fechaCreacionProceso;
    }

    
    @Column(name="activo")
    public Boolean getActivo() {
        return this.activo;
    }
    
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    
    @Column(name="nombre_general", length=45)
    public String getNombreGeneral() {
        return this.nombreGeneral;
    }
    
    public void setNombreGeneral(String nombreGeneral) {
        this.nombreGeneral = nombreGeneral;
    }

    
    @Column(name="id_general")
    public Integer getIdGeneral() {
        return this.idGeneral;
    }
    
    public void setIdGeneral(Integer idGeneral) {
        this.idGeneral = idGeneral;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="procesoRecaudacion")
    public Set<ServicioProcesoRecaudacion> getServicioProcesoRecaudacions() {
        return this.servicioProcesoRecaudacions;
    }
    
    public void setServicioProcesoRecaudacions(Set<ServicioProcesoRecaudacion> servicioProcesoRecaudacions) {
        this.servicioProcesoRecaudacions = servicioProcesoRecaudacions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="procesoRecaudacion")
    public Set<EgresoRecaudacion> getEgresoRecaudacions() {
        return this.egresoRecaudacions;
    }
    
    public void setEgresoRecaudacions(Set<EgresoRecaudacion> egresoRecaudacions) {
        this.egresoRecaudacions = egresoRecaudacions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="procesoRecaudacion")
    public Set<Guia> getGuias() {
        return this.guias;
    }
    
    public void setGuias(Set<Guia> guias) {
        this.guias = guias;
    }

    @Override
    public String toString() {
        return nombreProceso;
    }




}


