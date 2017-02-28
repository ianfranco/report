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
 * CargoLiquidacion generated by hbm2java
 */
@Entity
@Table(name="cargo_liquidacion"
    ,catalog="sigf_v1"
)
public class CargoLiquidacion  implements java.io.Serializable {


     private Integer idCargoLiquidacion;
     private CargoBus cargoBus;
     private LiquidacionEmpresa liquidacionEmpresa;
     private int montoCargo;

    public CargoLiquidacion() {
    }

    public CargoLiquidacion(CargoBus cargoBus, LiquidacionEmpresa liquidacionEmpresa, int montoCargo) {
       this.cargoBus = cargoBus;
       this.liquidacionEmpresa = liquidacionEmpresa;
       this.montoCargo = montoCargo;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_cargo_liquidacion", unique=true, nullable=false)
    public Integer getIdCargoLiquidacion() {
        return this.idCargoLiquidacion;
    }
    
    public void setIdCargoLiquidacion(Integer idCargoLiquidacion) {
        this.idCargoLiquidacion = idCargoLiquidacion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_cargo_bus", nullable=false)
    public CargoBus getCargoBus() {
        return this.cargoBus;
    }
    
    public void setCargoBus(CargoBus cargoBus) {
        this.cargoBus = cargoBus;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_liquidacion_empresa", nullable=false)
    public LiquidacionEmpresa getLiquidacionEmpresa() {
        return this.liquidacionEmpresa;
    }
    
    public void setLiquidacionEmpresa(LiquidacionEmpresa liquidacionEmpresa) {
        this.liquidacionEmpresa = liquidacionEmpresa;
    }

    
    @Column(name="monto_cargo", nullable=false)
    public int getMontoCargo() {
        return this.montoCargo;
    }
    
    public void setMontoCargo(int montoCargo) {
        this.montoCargo = montoCargo;
    }




}


