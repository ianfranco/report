package entities;
// Generated 26-09-2016 11:01:55 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DiaFestivo generated by hbm2java
 */
@Entity
@Table(name="dia_festivo"
    ,catalog="sigf_v1"
)
public class DiaFestivo  implements java.io.Serializable {


     private Integer idDiaFestivo;
     private String nombreDiaFestivo;
     private Date fecha;

    public DiaFestivo() {
    }

    public DiaFestivo(String nombreDiaFestivo, Date fecha) {
       this.nombreDiaFestivo = nombreDiaFestivo;
       this.fecha = fecha;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_dia_festivo", unique=true, nullable=false)
    public Integer getIdDiaFestivo() {
        return this.idDiaFestivo;
    }
    
    public void setIdDiaFestivo(Integer idDiaFestivo) {
        this.idDiaFestivo = idDiaFestivo;
    }

    
    @Column(name="nombre_dia_festivo", nullable=false, length=45)
    public String getNombreDiaFestivo() {
        return this.nombreDiaFestivo;
    }
    
    public void setNombreDiaFestivo(String nombreDiaFestivo) {
        this.nombreDiaFestivo = nombreDiaFestivo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", nullable=false, length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


