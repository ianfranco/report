package entities;
// Generated 26-09-2016 11:01:55 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Traccar generated by hbm2java
 */
@Entity
@Table(name="traccar"
    ,catalog="sigf_v1"
)
public class Traccar  implements java.io.Serializable {


     private Integer version;

    public Traccar() {
    }

   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="version", unique=true, nullable=false)
    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }




}


