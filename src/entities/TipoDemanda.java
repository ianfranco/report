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
 * TipoDemanda generated by hbm2java
 */
@Entity
@Table(name="tipo_demanda"
    ,catalog="sigf_v1"
)
public class TipoDemanda  implements java.io.Serializable {


     private Integer idTipoDemanda;
     private String nombreTipoDemanda;
     private Set<FrecuenciaServicio> frecuenciaServicios = new HashSet<FrecuenciaServicio>(0);

    public TipoDemanda() {
    }

	
    public TipoDemanda(String nombreTipoDemanda) {
        this.nombreTipoDemanda = nombreTipoDemanda;
    }
    public TipoDemanda(String nombreTipoDemanda, Set<FrecuenciaServicio> frecuenciaServicios) {
       this.nombreTipoDemanda = nombreTipoDemanda;
       this.frecuenciaServicios = frecuenciaServicios;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_tipo_demanda", unique=true, nullable=false)
    public Integer getIdTipoDemanda() {
        return this.idTipoDemanda;
    }
    
    public void setIdTipoDemanda(Integer idTipoDemanda) {
        this.idTipoDemanda = idTipoDemanda;
    }

    
    @Column(name="nombre_tipo_demanda", nullable=false, length=45)
    public String getNombreTipoDemanda() {
        return this.nombreTipoDemanda;
    }
    
    public void setNombreTipoDemanda(String nombreTipoDemanda) {
        this.nombreTipoDemanda = nombreTipoDemanda;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tipoDemanda")
    public Set<FrecuenciaServicio> getFrecuenciaServicios() {
        return this.frecuenciaServicios;
    }
    
    public void setFrecuenciaServicios(Set<FrecuenciaServicio> frecuenciaServicios) {
        this.frecuenciaServicios = frecuenciaServicios;
    }




}


