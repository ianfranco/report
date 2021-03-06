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
 * DiaTrabajador generated by hbm2java
 */
@Entity
@Table(name="dia_trabajador"
    ,catalog="sigf_v1"
)
public class DiaTrabajador  implements java.io.Serializable {


     private Integer idDiaTrabajador;
     private TipoDiaTrabajador tipoDiaTrabajador;
     private Trabajador trabajador;
     private Date desde;
     private Date hasta;

    public DiaTrabajador() {
    }

    public DiaTrabajador(TipoDiaTrabajador tipoDiaTrabajador, Trabajador trabajador, Date desde, Date hasta) {
       this.tipoDiaTrabajador = tipoDiaTrabajador;
       this.trabajador = trabajador;
       this.desde = desde;
       this.hasta = hasta;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_dia_trabajador", unique=true, nullable=false)
    public Integer getIdDiaTrabajador() {
        return this.idDiaTrabajador;
    }
    
    public void setIdDiaTrabajador(Integer idDiaTrabajador) {
        this.idDiaTrabajador = idDiaTrabajador;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_tipo_dia_trabajador", nullable=false)
    public TipoDiaTrabajador getTipoDiaTrabajador() {
        return this.tipoDiaTrabajador;
    }
    
    public void setTipoDiaTrabajador(TipoDiaTrabajador tipoDiaTrabajador) {
        this.tipoDiaTrabajador = tipoDiaTrabajador;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_trabajador", nullable=false)
    public Trabajador getTrabajador() {
        return this.trabajador;
    }
    
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="desde", nullable=false, length=10)
    public Date getDesde() {
        return this.desde;
    }
    
    public void setDesde(Date desde) {
        this.desde = desde;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="hasta", nullable=false, length=10)
    public Date getHasta() {
        return this.hasta;
    }
    
    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }




}


