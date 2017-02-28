package entities;
// Generated 26-09-2016 11:01:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * JornadaLaboral generated by hbm2java
 */
@Entity
@Table(name="jornada_laboral"
    ,catalog="sigf_v1"
)
public class JornadaLaboral  implements java.io.Serializable {


     private int idJornadaLaboral;
     private HorarioJornada horarioJornada;
     private String nombreJornadaLaboral;
     private Boolean lunes;
     private Boolean martes;
     private Boolean miercoles;
     private Boolean jueves;
     private Boolean viernes;
     private Boolean sabado;
     private Boolean domingo;
     private Set<JornadaTrabajador> jornadaTrabajadors = new HashSet<JornadaTrabajador>(0);

    public JornadaLaboral() {
    }

	
    public JornadaLaboral(int idJornadaLaboral, HorarioJornada horarioJornada, String nombreJornadaLaboral) {
        this.idJornadaLaboral = idJornadaLaboral;
        this.horarioJornada = horarioJornada;
        this.nombreJornadaLaboral = nombreJornadaLaboral;
    }
    public JornadaLaboral(int idJornadaLaboral, HorarioJornada horarioJornada, String nombreJornadaLaboral, Boolean lunes, Boolean martes, Boolean miercoles, Boolean jueves, Boolean viernes, Boolean sabado, Boolean domingo, Set<JornadaTrabajador> jornadaTrabajadors) {
       this.idJornadaLaboral = idJornadaLaboral;
       this.horarioJornada = horarioJornada;
       this.nombreJornadaLaboral = nombreJornadaLaboral;
       this.lunes = lunes;
       this.martes = martes;
       this.miercoles = miercoles;
       this.jueves = jueves;
       this.viernes = viernes;
       this.sabado = sabado;
       this.domingo = domingo;
       this.jornadaTrabajadors = jornadaTrabajadors;
    }
   
     @Id 

    
    @Column(name="id_jornada_laboral", unique=true, nullable=false)
    public int getIdJornadaLaboral() {
        return this.idJornadaLaboral;
    }
    
    public void setIdJornadaLaboral(int idJornadaLaboral) {
        this.idJornadaLaboral = idJornadaLaboral;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_horario_jornada", nullable=false)
    public HorarioJornada getHorarioJornada() {
        return this.horarioJornada;
    }
    
    public void setHorarioJornada(HorarioJornada horarioJornada) {
        this.horarioJornada = horarioJornada;
    }

    
    @Column(name="nombre_jornada_laboral", nullable=false, length=60)
    public String getNombreJornadaLaboral() {
        return this.nombreJornadaLaboral;
    }
    
    public void setNombreJornadaLaboral(String nombreJornadaLaboral) {
        this.nombreJornadaLaboral = nombreJornadaLaboral;
    }

    
    @Column(name="lunes")
    public Boolean getLunes() {
        return this.lunes;
    }
    
    public void setLunes(Boolean lunes) {
        this.lunes = lunes;
    }

    
    @Column(name="martes")
    public Boolean getMartes() {
        return this.martes;
    }
    
    public void setMartes(Boolean martes) {
        this.martes = martes;
    }

    
    @Column(name="miercoles")
    public Boolean getMiercoles() {
        return this.miercoles;
    }
    
    public void setMiercoles(Boolean miercoles) {
        this.miercoles = miercoles;
    }

    
    @Column(name="jueves")
    public Boolean getJueves() {
        return this.jueves;
    }
    
    public void setJueves(Boolean jueves) {
        this.jueves = jueves;
    }

    
    @Column(name="viernes")
    public Boolean getViernes() {
        return this.viernes;
    }
    
    public void setViernes(Boolean viernes) {
        this.viernes = viernes;
    }

    
    @Column(name="sabado")
    public Boolean getSabado() {
        return this.sabado;
    }
    
    public void setSabado(Boolean sabado) {
        this.sabado = sabado;
    }

    
    @Column(name="domingo")
    public Boolean getDomingo() {
        return this.domingo;
    }
    
    public void setDomingo(Boolean domingo) {
        this.domingo = domingo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="jornadaLaboral")
    public Set<JornadaTrabajador> getJornadaTrabajadors() {
        return this.jornadaTrabajadors;
    }
    
    public void setJornadaTrabajadors(Set<JornadaTrabajador> jornadaTrabajadors) {
        this.jornadaTrabajadors = jornadaTrabajadors;
    }




}


