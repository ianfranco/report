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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LiquidacionSueldo generated by hbm2java
 */
@Entity
@Table(name="liquidacion_sueldo"
    ,catalog="sigf_v1"
)
public class LiquidacionSueldo  implements java.io.Serializable {


     private Integer idLiquidacionSueldo;
     private RelacionLaboral relacionLaboral;
     private int mes;
     private int anio;
     private Date fechaEmision;
     private Date fechaPago;
     private int totalHaberesImponibles;
     private int totalHaberesNoImponibles;
     private Integer saldoAnterior;
     private int totalDescuentos;
     private int montoAnticipo;
     private int saldoMonto;
     private int alcanceLiquido;
     private Set<HaberLiquidacion> haberLiquidacions = new HashSet<HaberLiquidacion>(0);
     private Set<DescuentoLiquidacion> descuentoLiquidacions = new HashSet<DescuentoLiquidacion>(0);

    public LiquidacionSueldo() {
    }

	
    public LiquidacionSueldo(RelacionLaboral relacionLaboral, int mes, int anio, Date fechaEmision, Date fechaPago, int totalHaberesImponibles, int totalHaberesNoImponibles, int totalDescuentos, int montoAnticipo, int saldoMonto, int alcanceLiquido) {
        this.relacionLaboral = relacionLaboral;
        this.mes = mes;
        this.anio = anio;
        this.fechaEmision = fechaEmision;
        this.fechaPago = fechaPago;
        this.totalHaberesImponibles = totalHaberesImponibles;
        this.totalHaberesNoImponibles = totalHaberesNoImponibles;
        this.totalDescuentos = totalDescuentos;
        this.montoAnticipo = montoAnticipo;
        this.saldoMonto = saldoMonto;
        this.alcanceLiquido = alcanceLiquido;
    }
    public LiquidacionSueldo(RelacionLaboral relacionLaboral, int mes, int anio, Date fechaEmision, Date fechaPago, int totalHaberesImponibles, int totalHaberesNoImponibles, Integer saldoAnterior, int totalDescuentos, int montoAnticipo, int saldoMonto, int alcanceLiquido, Set<HaberLiquidacion> haberLiquidacions, Set<DescuentoLiquidacion> descuentoLiquidacions) {
       this.relacionLaboral = relacionLaboral;
       this.mes = mes;
       this.anio = anio;
       this.fechaEmision = fechaEmision;
       this.fechaPago = fechaPago;
       this.totalHaberesImponibles = totalHaberesImponibles;
       this.totalHaberesNoImponibles = totalHaberesNoImponibles;
       this.saldoAnterior = saldoAnterior;
       this.totalDescuentos = totalDescuentos;
       this.montoAnticipo = montoAnticipo;
       this.saldoMonto = saldoMonto;
       this.alcanceLiquido = alcanceLiquido;
       this.haberLiquidacions = haberLiquidacions;
       this.descuentoLiquidacions = descuentoLiquidacions;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_liquidacion_sueldo", unique=true, nullable=false)
    public Integer getIdLiquidacionSueldo() {
        return this.idLiquidacionSueldo;
    }
    
    public void setIdLiquidacionSueldo(Integer idLiquidacionSueldo) {
        this.idLiquidacionSueldo = idLiquidacionSueldo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_relacion_laboral", nullable=false)
    public RelacionLaboral getRelacionLaboral() {
        return this.relacionLaboral;
    }
    
    public void setRelacionLaboral(RelacionLaboral relacionLaboral) {
        this.relacionLaboral = relacionLaboral;
    }

    
    @Column(name="mes", nullable=false)
    public int getMes() {
        return this.mes;
    }
    
    public void setMes(int mes) {
        this.mes = mes;
    }

    
    @Column(name="anio", nullable=false)
    public int getAnio() {
        return this.anio;
    }
    
    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_emision", nullable=false, length=10)
    public Date getFechaEmision() {
        return this.fechaEmision;
    }
    
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_pago", nullable=false, length=10)
    public Date getFechaPago() {
        return this.fechaPago;
    }
    
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    
    @Column(name="total_haberes_imponibles", nullable=false)
    public int getTotalHaberesImponibles() {
        return this.totalHaberesImponibles;
    }
    
    public void setTotalHaberesImponibles(int totalHaberesImponibles) {
        this.totalHaberesImponibles = totalHaberesImponibles;
    }

    
    @Column(name="total_haberes_no_imponibles", nullable=false)
    public int getTotalHaberesNoImponibles() {
        return this.totalHaberesNoImponibles;
    }
    
    public void setTotalHaberesNoImponibles(int totalHaberesNoImponibles) {
        this.totalHaberesNoImponibles = totalHaberesNoImponibles;
    }

    
    @Column(name="saldo_anterior")
    public Integer getSaldoAnterior() {
        return this.saldoAnterior;
    }
    
    public void setSaldoAnterior(Integer saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    
    @Column(name="total_descuentos", nullable=false)
    public int getTotalDescuentos() {
        return this.totalDescuentos;
    }
    
    public void setTotalDescuentos(int totalDescuentos) {
        this.totalDescuentos = totalDescuentos;
    }

    
    @Column(name="monto_anticipo", nullable=false)
    public int getMontoAnticipo() {
        return this.montoAnticipo;
    }
    
    public void setMontoAnticipo(int montoAnticipo) {
        this.montoAnticipo = montoAnticipo;
    }

    
    @Column(name="saldo_monto", nullable=false)
    public int getSaldoMonto() {
        return this.saldoMonto;
    }
    
    public void setSaldoMonto(int saldoMonto) {
        this.saldoMonto = saldoMonto;
    }

    
    @Column(name="alcance_liquido", nullable=false)
    public int getAlcanceLiquido() {
        return this.alcanceLiquido;
    }
    
    public void setAlcanceLiquido(int alcanceLiquido) {
        this.alcanceLiquido = alcanceLiquido;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="liquidacionSueldo")
    public Set<HaberLiquidacion> getHaberLiquidacions() {
        return this.haberLiquidacions;
    }
    
    public void setHaberLiquidacions(Set<HaberLiquidacion> haberLiquidacions) {
        this.haberLiquidacions = haberLiquidacions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="liquidacionSueldo")
    public Set<DescuentoLiquidacion> getDescuentoLiquidacions() {
        return this.descuentoLiquidacions;
    }
    
    public void setDescuentoLiquidacions(Set<DescuentoLiquidacion> descuentoLiquidacions) {
        this.descuentoLiquidacions = descuentoLiquidacions;
    }




}


