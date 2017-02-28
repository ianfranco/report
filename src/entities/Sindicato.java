package entities;
// Generated 26-09-2016 11:01:55 by Hibernate Tools 4.3.1


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
 * Sindicato generated by hbm2java
 */
@Entity
@Table(name="sindicato"
    ,catalog="sigf_v1"
)
public class Sindicato  implements java.io.Serializable {


     private Integer idSindicato;
     private String nombreSindicato;
     private int cuotaSindicato;
     private Set<SindicatoTrabajador> sindicatoTrabajadors = new HashSet<SindicatoTrabajador>(0);

    public Sindicato() {
    }

	
    public Sindicato(String nombreSindicato, int cuotaSindicato) {
        this.nombreSindicato = nombreSindicato;
        this.cuotaSindicato = cuotaSindicato;
    }
    public Sindicato(String nombreSindicato, int cuotaSindicato, Set<SindicatoTrabajador> sindicatoTrabajadors) {
       this.nombreSindicato = nombreSindicato;
       this.cuotaSindicato = cuotaSindicato;
       this.sindicatoTrabajadors = sindicatoTrabajadors;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_sindicato", unique=true, nullable=false)
    public Integer getIdSindicato() {
        return this.idSindicato;
    }
    
    public void setIdSindicato(Integer idSindicato) {
        this.idSindicato = idSindicato;
    }

    
    @Column(name="nombre_sindicato", nullable=false, length=100)
    public String getNombreSindicato() {
        return this.nombreSindicato;
    }
    
    public void setNombreSindicato(String nombreSindicato) {
        this.nombreSindicato = nombreSindicato;
    }

    
    @Column(name="cuota_sindicato", nullable=false)
    public int getCuotaSindicato() {
        return this.cuotaSindicato;
    }
    
    public void setCuotaSindicato(int cuotaSindicato) {
        this.cuotaSindicato = cuotaSindicato;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="sindicato")
    public Set<SindicatoTrabajador> getSindicatoTrabajadors() {
        return this.sindicatoTrabajadors;
    }
    
    public void setSindicatoTrabajadors(Set<SindicatoTrabajador> sindicatoTrabajadors) {
        this.sindicatoTrabajadors = sindicatoTrabajadors;
    }




}


