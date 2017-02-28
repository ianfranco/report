package entities;
// Generated 26-09-2016 11:01:55 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * FrecuenciaServicio generated by hbm2java
 */
@Entity
@Table(name="frecuencia_servicio"
    ,catalog="sigf_v1"
)
public class FrecuenciaServicio  implements java.io.Serializable {


     private Integer idFrecuenciaServicio;
     private PeriodoFrecuencia periodoFrecuencia;
     private Servicio servicio;
     private TipoDemanda tipoDemanda;
     private TipoDiaFrecuencia tipoDiaFrecuencia;
     private int numeroBuses;

    public FrecuenciaServicio() {
    }

    public FrecuenciaServicio(PeriodoFrecuencia periodoFrecuencia, Servicio servicio, TipoDemanda tipoDemanda, TipoDiaFrecuencia tipoDiaFrecuencia, int numeroBuses) {
       this.periodoFrecuencia = periodoFrecuencia;
       this.servicio = servicio;
       this.tipoDemanda = tipoDemanda;
       this.tipoDiaFrecuencia = tipoDiaFrecuencia;
       this.numeroBuses = numeroBuses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_frecuencia_servicio", unique=true, nullable=false)
    public Integer getIdFrecuenciaServicio() {
        return this.idFrecuenciaServicio;
    }
    
    public void setIdFrecuenciaServicio(Integer idFrecuenciaServicio) {
        this.idFrecuenciaServicio = idFrecuenciaServicio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_periodo_frecuencia", nullable=false)
    public PeriodoFrecuencia getPeriodoFrecuencia() {
        return this.periodoFrecuencia;
    }
    
    public void setPeriodoFrecuencia(PeriodoFrecuencia periodoFrecuencia) {
        this.periodoFrecuencia = periodoFrecuencia;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_servicio", nullable=false)
    public Servicio getServicio() {
        return this.servicio;
    }
    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_tipo_demanda", nullable=false)
    public TipoDemanda getTipoDemanda() {
        return this.tipoDemanda;
    }
    
    public void setTipoDemanda(TipoDemanda tipoDemanda) {
        this.tipoDemanda = tipoDemanda;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_tipo_dia_frecuencia", nullable=false)
    public TipoDiaFrecuencia getTipoDiaFrecuencia() {
        return this.tipoDiaFrecuencia;
    }
    
    public void setTipoDiaFrecuencia(TipoDiaFrecuencia tipoDiaFrecuencia) {
        this.tipoDiaFrecuencia = tipoDiaFrecuencia;
    }

    
    @Column(name="numero_buses", nullable=false)
    public int getNumeroBuses() {
        return this.numeroBuses;
    }
    
    public void setNumeroBuses(int numeroBuses) {
        this.numeroBuses = numeroBuses;
    }




}


