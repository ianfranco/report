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
 * Boleto generated by hbm2java
 */
@Entity
@Table(name="boleto"
    ,catalog="sigf_v1"
)
public class Boleto  implements java.io.Serializable {


     private Integer idBoleto;
     private String nombreBoleto;
     private boolean activo;
     private Set<InventarioInterno> inventarioInternos = new HashSet<InventarioInterno>(0);
     private Set<DetalleCompraBoleto> detalleCompraBoletos = new HashSet<DetalleCompraBoleto>(0);
     private Set<SerieBoletoGuia> serieBoletoGuias = new HashSet<SerieBoletoGuia>(0);
     private Set<InventarioTerminal> inventarioTerminals = new HashSet<InventarioTerminal>(0);
     private Set<TarifaServicio> tarifaServicios = new HashSet<TarifaServicio>(0);

    public Boleto() {
    }

	
    public Boleto(String nombreBoleto, boolean activo) {
        this.nombreBoleto = nombreBoleto;
        this.activo = activo;
    }
    public Boleto(String nombreBoleto, boolean activo, Set<InventarioInterno> inventarioInternos, Set<DetalleCompraBoleto> detalleCompraBoletos, Set<SerieBoletoGuia> serieBoletoGuias, Set<InventarioTerminal> inventarioTerminals, Set<TarifaServicio> tarifaServicios) {
       this.nombreBoleto = nombreBoleto;
       this.activo = activo;
       this.inventarioInternos = inventarioInternos;
       this.detalleCompraBoletos = detalleCompraBoletos;
       this.serieBoletoGuias = serieBoletoGuias;
       this.inventarioTerminals = inventarioTerminals;
       this.tarifaServicios = tarifaServicios;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_boleto", unique=true, nullable=false)
    public Integer getIdBoleto() {
        return this.idBoleto;
    }
    
    public void setIdBoleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
    }

    
    @Column(name="nombre_boleto", nullable=false, length=45)
    public String getNombreBoleto() {
        return this.nombreBoleto;
    }
    
    public void setNombreBoleto(String nombreBoleto) {
        this.nombreBoleto = nombreBoleto;
    }

    
    @Column(name="activo", nullable=false)
    public boolean isActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="boleto")
    public Set<InventarioInterno> getInventarioInternos() {
        return this.inventarioInternos;
    }
    
    public void setInventarioInternos(Set<InventarioInterno> inventarioInternos) {
        this.inventarioInternos = inventarioInternos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="boleto")
    public Set<DetalleCompraBoleto> getDetalleCompraBoletos() {
        return this.detalleCompraBoletos;
    }
    
    public void setDetalleCompraBoletos(Set<DetalleCompraBoleto> detalleCompraBoletos) {
        this.detalleCompraBoletos = detalleCompraBoletos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="boleto")
    public Set<SerieBoletoGuia> getSerieBoletoGuias() {
        return this.serieBoletoGuias;
    }
    
    public void setSerieBoletoGuias(Set<SerieBoletoGuia> serieBoletoGuias) {
        this.serieBoletoGuias = serieBoletoGuias;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="boleto")
    public Set<InventarioTerminal> getInventarioTerminals() {
        return this.inventarioTerminals;
    }
    
    public void setInventarioTerminals(Set<InventarioTerminal> inventarioTerminals) {
        this.inventarioTerminals = inventarioTerminals;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="boleto")
    public Set<TarifaServicio> getTarifaServicios() {
        return this.tarifaServicios;
    }
    
    public void setTarifaServicios(Set<TarifaServicio> tarifaServicios) {
        this.tarifaServicios = tarifaServicios;
    }




}


