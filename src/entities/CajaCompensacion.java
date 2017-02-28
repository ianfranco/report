package entities;
// Generated 26-09-2016 11:01:55 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
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

/**
 * CajaCompensacion generated by hbm2java
 */
@Entity
@Table(name="caja_compensacion"
    ,catalog="sigf_v1"
)
public class CajaCompensacion  implements java.io.Serializable {


     private Integer idCajaCompensacion;
     private String nombreCajaCompensacion;
     private BigDecimal comision;
     private BigDecimal porcentajeDescuento;
     private Set<Empresa> empresas = new HashSet<Empresa>(0);

    public CajaCompensacion() {
    }

	
    public CajaCompensacion(String nombreCajaCompensacion, BigDecimal porcentajeDescuento) {
        this.nombreCajaCompensacion = nombreCajaCompensacion;
        this.porcentajeDescuento = porcentajeDescuento;
    }
    public CajaCompensacion(String nombreCajaCompensacion, BigDecimal comision, BigDecimal porcentajeDescuento, Set<Empresa> empresas) {
       this.nombreCajaCompensacion = nombreCajaCompensacion;
       this.comision = comision;
       this.porcentajeDescuento = porcentajeDescuento;
       this.empresas = empresas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_caja_compensacion", unique=true, nullable=false)
    public Integer getIdCajaCompensacion() {
        return this.idCajaCompensacion;
    }
    
    public void setIdCajaCompensacion(Integer idCajaCompensacion) {
        this.idCajaCompensacion = idCajaCompensacion;
    }

    
    @Column(name="nombre_caja_compensacion", nullable=false)
    public String getNombreCajaCompensacion() {
        return this.nombreCajaCompensacion;
    }
    
    public void setNombreCajaCompensacion(String nombreCajaCompensacion) {
        this.nombreCajaCompensacion = nombreCajaCompensacion;
    }

    
    @Column(name="comision", precision=10, scale=5)
    public BigDecimal getComision() {
        return this.comision;
    }
    
    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    
    @Column(name="porcentaje_descuento", nullable=false, precision=10, scale=5)
    public BigDecimal getPorcentajeDescuento() {
        return this.porcentajeDescuento;
    }
    
    public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cajaCompensacion")
    public Set<Empresa> getEmpresas() {
        return this.empresas;
    }
    
    public void setEmpresas(Set<Empresa> empresas) {
        this.empresas = empresas;
    }




}


