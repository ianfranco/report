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
 * Terminal generated by hbm2java
 */
@Entity
@Table(name = "terminal", catalog = "sigf_v1"
)
public class Terminal implements java.io.Serializable {

    private Integer idTerminal;
    private String nombreTerminal;
    private String direccionTerminal;
    private Integer superficie;
    private String telefonoTerminal;
    private String emailTerminal;
    private double ubicacionLongitud;
    private double ubicacionLatitud;
    private Set<InventarioTerminal> inventarioTerminals = new HashSet<InventarioTerminal>(0);
    private Set<Usuario> usuarios = new HashSet<Usuario>(0);
    private Set<VentaBoleto> ventaBoletos = new HashSet<VentaBoleto>(0);
    private Set<Servicio> servicios = new HashSet<Servicio>(0);
    private Set<Bus> buses = new HashSet<Bus>(0);
    private Set<TrabajadorTerminal> trabajadorTerminals = new HashSet<TrabajadorTerminal>(0);

    public Terminal() {
    }

    public Terminal(String nombreTerminal, String direccionTerminal, double ubicacionLongitud, double ubicacionLatitud) {
        this.nombreTerminal = nombreTerminal;
        this.direccionTerminal = direccionTerminal;
        this.ubicacionLongitud = ubicacionLongitud;
        this.ubicacionLatitud = ubicacionLatitud;
    }

    public Terminal(String nombreTerminal, String direccionTerminal, Integer superficie, String telefonoTerminal, String emailTerminal, double ubicacionLongitud, double ubicacionLatitud, Set<InventarioTerminal> inventarioTerminals, Set<Usuario> usuarios, Set<VentaBoleto> ventaBoletos, Set<Servicio> servicios, Set<Bus> buses, Set<TrabajadorTerminal> trabajadorTerminals) {
        this.nombreTerminal = nombreTerminal;
        this.direccionTerminal = direccionTerminal;
        this.superficie = superficie;
        this.telefonoTerminal = telefonoTerminal;
        this.emailTerminal = emailTerminal;
        this.ubicacionLongitud = ubicacionLongitud;
        this.ubicacionLatitud = ubicacionLatitud;
        this.inventarioTerminals = inventarioTerminals;
        this.usuarios = usuarios;
        this.ventaBoletos = ventaBoletos;
        this.servicios = servicios;
        this.buses = buses;
        this.trabajadorTerminals = trabajadorTerminals;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id_terminal", unique = true, nullable = false)
    public Integer getIdTerminal() {
        return this.idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    @Column(name = "nombre_terminal", nullable = false, length = 45)
    public String getNombreTerminal() {
        return this.nombreTerminal;
    }

    public void setNombreTerminal(String nombreTerminal) {
        this.nombreTerminal = nombreTerminal;
    }

    @Column(name = "direccion_terminal", nullable = false, length = 45)
    public String getDireccionTerminal() {
        return this.direccionTerminal;
    }

    public void setDireccionTerminal(String direccionTerminal) {
        this.direccionTerminal = direccionTerminal;
    }

    @Column(name = "superficie")
    public Integer getSuperficie() {
        return this.superficie;
    }

    public void setSuperficie(Integer superficie) {
        this.superficie = superficie;
    }

    @Column(name = "telefono_terminal", length = 45)
    public String getTelefonoTerminal() {
        return this.telefonoTerminal;
    }

    public void setTelefonoTerminal(String telefonoTerminal) {
        this.telefonoTerminal = telefonoTerminal;
    }

    @Column(name = "email_terminal", length = 45)
    public String getEmailTerminal() {
        return this.emailTerminal;
    }

    public void setEmailTerminal(String emailTerminal) {
        this.emailTerminal = emailTerminal;
    }

    @Column(name = "ubicacion_longitud", nullable = false, precision = 10, scale = 6)
    public double getUbicacionLongitud() {
        return this.ubicacionLongitud;
    }

    public void setUbicacionLongitud(double ubicacionLongitud) {
        this.ubicacionLongitud = ubicacionLongitud;
    }

    @Column(name = "ubicacion_latitud", nullable = false, precision = 10, scale = 6)
    public double getUbicacionLatitud() {
        return this.ubicacionLatitud;
    }

    public void setUbicacionLatitud(double ubicacionLatitud) {
        this.ubicacionLatitud = ubicacionLatitud;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "terminal")
    public Set<InventarioTerminal> getInventarioTerminals() {
        return this.inventarioTerminals;
    }

    public void setInventarioTerminals(Set<InventarioTerminal> inventarioTerminals) {
        this.inventarioTerminals = inventarioTerminals;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "terminal")
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "terminal")
    public Set<VentaBoleto> getVentaBoletos() {
        return this.ventaBoletos;
    }

    public void setVentaBoletos(Set<VentaBoleto> ventaBoletos) {
        this.ventaBoletos = ventaBoletos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "terminal")
    public Set<Servicio> getServicios() {
        return this.servicios;
    }

    public void setServicios(Set<Servicio> servicios) {
        this.servicios = servicios;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "terminal")
    public Set<Bus> getBuses() {
        return this.buses;
    }

    public void setBuses(Set<Bus> buses) {
        this.buses = buses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "terminal")
    public Set<TrabajadorTerminal> getTrabajadorTerminals() {
        return this.trabajadorTerminals;
    }

    public void setTrabajadorTerminals(Set<TrabajadorTerminal> trabajadorTerminals) {
        this.trabajadorTerminals = trabajadorTerminals;
    }

    @Override
    public String toString() {
        return nombreTerminal;
    }

}
