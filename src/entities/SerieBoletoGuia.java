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
 * SerieBoletoGuia generated by hbm2java
 */
@Entity
@Table(name="serie_boleto_guia"
    ,catalog="sigf_v1"
)
public class SerieBoletoGuia  implements java.io.Serializable {


     private Integer idSerieBoletoGuia;
     private Boleto boleto;
     private Guia guia;
     private int valor;
     private int serie;
     private int termino;
     private int cantidad;
     private int total;
     private boolean nuevo;

    public SerieBoletoGuia() {
    }

    public SerieBoletoGuia(Boleto boleto, Guia guia, int valor, int serie, int termino, int cantidad, int total, boolean nuevo) {
       this.boleto = boleto;
       this.guia = guia;
       this.valor = valor;
       this.serie = serie;
       this.termino = termino;
       this.cantidad = cantidad;
       this.total = total;
       this.nuevo = nuevo;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_serie_boleto_guia", unique=true, nullable=false)
    public Integer getIdSerieBoletoGuia() {
        return this.idSerieBoletoGuia;
    }
    
    public void setIdSerieBoletoGuia(Integer idSerieBoletoGuia) {
        this.idSerieBoletoGuia = idSerieBoletoGuia;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_boleto", nullable=false)
    public Boleto getBoleto() {
        return this.boleto;
    }
    
    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_guia", nullable=false)
    public Guia getGuia() {
        return this.guia;
    }
    
    public void setGuia(Guia guia) {
        this.guia = guia;
    }

    
    @Column(name="valor", nullable=false)
    public int getValor() {
        return this.valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }

    
    @Column(name="serie", nullable=false)
    public int getSerie() {
        return this.serie;
    }
    
    public void setSerie(int serie) {
        this.serie = serie;
    }

    
    @Column(name="termino", nullable=false)
    public int getTermino() {
        return this.termino;
    }
    
    public void setTermino(int termino) {
        this.termino = termino;
    }

    
    @Column(name="cantidad", nullable=false)
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    @Column(name="total", nullable=false)
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }

    
    @Column(name="nuevo", nullable=false)
    public boolean isNuevo() {
        return this.nuevo;
    }
    
    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }




}


