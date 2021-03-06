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
 * MonedaPactadaInstitucionSalud generated by hbm2java
 */
@Entity
@Table(name="moneda_pactada_institucion_salud"
    ,catalog="sigf_v1"
)
public class MonedaPactadaInstitucionSalud  implements java.io.Serializable {


     private Integer idMonedaSalud;
     private String nombreMonedaSalud;
     private Set<Trabajador> trabajadors = new HashSet<Trabajador>(0);

    public MonedaPactadaInstitucionSalud() {
    }

	
    public MonedaPactadaInstitucionSalud(String nombreMonedaSalud) {
        this.nombreMonedaSalud = nombreMonedaSalud;
    }
    public MonedaPactadaInstitucionSalud(String nombreMonedaSalud, Set<Trabajador> trabajadors) {
       this.nombreMonedaSalud = nombreMonedaSalud;
       this.trabajadors = trabajadors;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_moneda_salud", unique=true, nullable=false)
    public Integer getIdMonedaSalud() {
        return this.idMonedaSalud;
    }
    
    public void setIdMonedaSalud(Integer idMonedaSalud) {
        this.idMonedaSalud = idMonedaSalud;
    }

    
    @Column(name="nombre_moneda_salud", nullable=false, length=45)
    public String getNombreMonedaSalud() {
        return this.nombreMonedaSalud;
    }
    
    public void setNombreMonedaSalud(String nombreMonedaSalud) {
        this.nombreMonedaSalud = nombreMonedaSalud;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="monedaPactadaInstitucionSalud")
    public Set<Trabajador> getTrabajadors() {
        return this.trabajadors;
    }
    
    public void setTrabajadors(Set<Trabajador> trabajadors) {
        this.trabajadors = trabajadors;
    }




}


