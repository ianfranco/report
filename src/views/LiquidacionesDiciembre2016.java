/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author ianfr
 */
@Entity
@Table(name = "liquidaciones_diciembre_2016", catalog = "sigf_v1", schema = "")
@NamedQueries({
    @NamedQuery(name = "LiquidacionesDiciembre2016.findAll", query = "SELECT l FROM LiquidacionesDiciembre2016 l")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findById", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.id = :id")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByIdRelacionLaboral", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.idRelacionLaboral = :idRelacionLaboral")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByFecha", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.fecha = :fecha")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByRutTrabajador", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.rutTrabajador = :rutTrabajador")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByIdTrabajador", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.idTrabajador = :idTrabajador")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByCodigoTrabajador", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.codigoTrabajador = :codigoTrabajador")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByNombreTrabajador", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.nombreTrabajador = :nombreTrabajador")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByRutEmpleador", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.rutEmpleador = :rutEmpleador")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByCodigoEmpleador", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.codigoEmpleador = :codigoEmpleador")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByNombreEmpresario", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.nombreEmpresario = :nombreEmpresario")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByCodigoTerminal", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.codigoTerminal = :codigoTerminal")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByNombreTerminal", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.nombreTerminal = :nombreTerminal")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByTipoContrato", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.tipoContrato = :tipoContrato")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByBruto", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.bruto = :bruto")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByImponible", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.imponible = :imponible")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByCincoPorcientoTotal", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.cincoPorcientoTotal = :cincoPorcientoTotal")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByCincoPorciento", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.cincoPorciento = :cincoPorciento")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByAhorroGuia", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.ahorroGuia = :ahorroGuia")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByAbonos", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.abonos = :abonos")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByTotalHaberes", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.totalHaberes = :totalHaberes")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByBase", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.base = :base")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByCuatroPorciento", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.cuatroPorciento = :cuatroPorciento")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByUnoPorciento", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.unoPorciento = :unoPorciento")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByUnoComaDosPorciento", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.unoComaDosPorciento = :unoComaDosPorciento")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByCeroComaOchoPorciento", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.ceroComaOchoPorciento = :ceroComaOchoPorciento")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByDosPorciento", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.dosPorciento = :dosPorciento")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByTotalPorcentajes", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.totalPorcentajes = :totalPorcentajes")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByAjusteComisionAuxiliar", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.ajusteComisionAuxiliar = :ajusteComisionAuxiliar")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByAjusteComision", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.ajusteComision = :ajusteComision")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByNumeroCargas", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.numeroCargas = :numeroCargas")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoCargas", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoCargas = :montoCargas")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoFeriado", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoFeriado = :montoFeriado")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByNombreAfp", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.nombreAfp = :nombreAfp")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByPorcentajeAfp", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.porcentajeAfp = :porcentajeAfp")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoAfp", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoAfp = :montoAfp")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByCesantiaTrabajador", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.cesantiaTrabajador = :cesantiaTrabajador")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByCesantiaEmpleador", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.cesantiaEmpleador = :cesantiaEmpleador")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByCesantiaTotal", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.cesantiaTotal = :cesantiaTotal")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByAhorroVoluntario", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.ahorroVoluntario = :ahorroVoluntario")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoSIS", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoSIS = :montoSIS")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByNombreIsapre", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.nombreIsapre = :nombreIsapre")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoIsapre", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoIsapre = :montoIsapre")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByPorcentajeCaja", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.porcentajeCaja = :porcentajeCaja")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoCaja", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoCaja = :montoCaja")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByPorcentajeInp", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.porcentajeInp = :porcentajeInp")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoInp", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoInp = :montoInp")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByObservacion", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.observacion = :observacion")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByDiasTrabajados", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.diasTrabajados = :diasTrabajados")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByDiasVacaciones", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.diasVacaciones = :diasVacaciones")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByDiasLicencias", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.diasLicencias = :diasLicencias")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByDiasDescanso", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.diasDescanso = :diasDescanso")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByDiasGuias", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.diasGuias = :diasGuias")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByDiasLimpios", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.diasLimpios = :diasLimpios")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByTotalDias", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.totalDias = :totalDias")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByFechaDesdeContrato", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.fechaDesdeContrato = :fechaDesdeContrato")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByFechaHastaContrato", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.fechaHastaContrato = :fechaHastaContrato")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByFechaDesdeFeriado", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.fechaDesdeFeriado = :fechaDesdeFeriado")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByFechaHastaFeriado", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.fechaHastaFeriado = :fechaHastaFeriado")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByFechaDesdeLicencias", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.fechaDesdeLicencias = :fechaDesdeLicencias")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByFechaHastaLicencias", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.fechaHastaLicencias = :fechaHastaLicencias")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByCodigoEMP", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.codigoEMP = :codigoEMP")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByTotalFila", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.totalFila = :totalFila")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoSaldoAnterior", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoSaldoAnterior = :montoSaldoAnterior")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoRetencionJudicial", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoRetencionJudicial = :montoRetencionJudicial")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoCreditoCaja", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoCreditoCaja = :montoCreditoCaja")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoReconocimientoDeuda", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoReconocimientoDeuda = :montoReconocimientoDeuda")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoCreditoSalud", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoCreditoSalud = :montoCreditoSalud")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoSeguro", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoSeguro = :montoSeguro")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoDentista", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoDentista = :montoDentista")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoOtrosDcto", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoOtrosDcto = :montoOtrosDcto")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByMontoSindicato", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.montoSindicato = :montoSindicato")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByTotalDescuentosLegales", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.totalDescuentosLegales = :totalDescuentosLegales")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByTotalDescuentos", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.totalDescuentos = :totalDescuentos")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByTotalFinalDescuentos", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.totalFinalDescuentos = :totalFinalDescuentos")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findBySaldoFinal", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.saldoFinal = :saldoFinal")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findBySaldoReal", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.saldoReal = :saldoReal")
    , @NamedQuery(name = "LiquidacionesDiciembre2016.findByBaseLiquidacion", query = "SELECT l FROM LiquidacionesDiciembre2016 l WHERE l.baseLiquidacion = :baseLiquidacion")})
public class LiquidacionesDiciembre2016 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_relacion_laboral")
    private Integer idRelacionLaboral;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "rutTrabajador")
    private String rutTrabajador;
    @Column(name = "id_trabajador")
    private Integer idTrabajador;
    @Column(name = "codigoTrabajador")
    private Integer codigoTrabajador;
    @Column(name = "nombreTrabajador")
    private String nombreTrabajador;
    @Column(name = "rutEmpleador")
    private String rutEmpleador;
    @Column(name = "codigoEmpleador")
    private Integer codigoEmpleador;
    @Column(name = "NombreEmpresario")
    private String nombreEmpresario;
    @Column(name = "codigoTerminal")
    private Integer codigoTerminal;
    @Column(name = "nombreTerminal")
    private String nombreTerminal;
    @Column(name = "tipoContrato")
    private Integer tipoContrato;
    @Column(name = "bruto")
    private Integer bruto;
    @Column(name = "imponible")
    private Integer imponible;
    @Column(name = "cincoPorcientoTotal")
    private Integer cincoPorcientoTotal;
    @Column(name = "cincoPorciento")
    private Integer cincoPorciento;
    @Column(name = "ahorroGuia")
    private Integer ahorroGuia;
    @Column(name = "abonos")
    private Integer abonos;
    @Column(name = "totalHaberes")
    private Integer totalHaberes;
    @Column(name = "base")
    private Integer base;
    @Column(name = "cuatroPorciento")
    private Integer cuatroPorciento;
    @Column(name = "unoPorciento")
    private Integer unoPorciento;
    @Column(name = "unoComaDosPorciento")
    private Integer unoComaDosPorciento;
    @Column(name = "ceroComaOchoPorciento")
    private Integer ceroComaOchoPorciento;
    @Column(name = "dosPorciento")
    private Integer dosPorciento;
    @Column(name = "totalPorcentajes")
    private Integer totalPorcentajes;
    @Column(name = "ajusteComisionAuxiliar")
    private Integer ajusteComisionAuxiliar;
    @Column(name = "ajusteComision")
    private Integer ajusteComision;
    @Column(name = "numeroCargas")
    private Integer numeroCargas;
    @Column(name = "montoCargas")
    private Integer montoCargas;
    @Column(name = "montoFeriado")
    private Integer montoFeriado;
    @Column(name = "nombreAfp")
    private String nombreAfp;
    @Column(name = "porcentajeAfp")
    private String porcentajeAfp;
    @Column(name = "montoAfp")
    private Integer montoAfp;
    @Column(name = "cesantiaTrabajador")
    private Integer cesantiaTrabajador;
    @Column(name = "cesantiaEmpleador")
    private Integer cesantiaEmpleador;
    @Column(name = "cesantiaTotal")
    private Integer cesantiaTotal;
    @Column(name = "ahorroVoluntario")
    private Integer ahorroVoluntario;
    @Column(name = "montoSIS")
    private Integer montoSIS;
    @Column(name = "nombreIsapre")
    private String nombreIsapre;
    @Column(name = "montoIsapre")
    private Integer montoIsapre;
    @Column(name = "porcentajeCaja")
    private String porcentajeCaja;
    @Column(name = "montoCaja")
    private Integer montoCaja;
    @Column(name = "porcentajeInp")
    private String porcentajeInp;
    @Column(name = "montoInp")
    private Integer montoInp;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "diasTrabajados")
    private Integer diasTrabajados;
    @Column(name = "diasVacaciones")
    private Integer diasVacaciones;
    @Column(name = "diasLicencias")
    private Integer diasLicencias;
    @Column(name = "diasDescanso")
    private Integer diasDescanso;
    @Column(name = "diasGuias")
    private Integer diasGuias;
    @Column(name = "diasLimpios")
    private Integer diasLimpios;
    @Column(name = "totalDias")
    private Integer totalDias;
    @Column(name = "fechaDesdeContrato")
    @Temporal(TemporalType.DATE)
    private Date fechaDesdeContrato;
    @Column(name = "fechaHastaContrato")
    @Temporal(TemporalType.DATE)
    private Date fechaHastaContrato;
    @Column(name = "fechaDesdeFeriado")
    @Temporal(TemporalType.DATE)
    private Date fechaDesdeFeriado;
    @Column(name = "fechaHastaFeriado")
    @Temporal(TemporalType.DATE)
    private Date fechaHastaFeriado;
    @Column(name = "fechaDesdeLicencias")
    @Temporal(TemporalType.DATE)
    private Date fechaDesdeLicencias;
    @Column(name = "fechaHastaLicencias")
    @Temporal(TemporalType.DATE)
    private Date fechaHastaLicencias;
    @Column(name = "codigoEMP")
    private Integer codigoEMP;
    @Column(name = "totalFila")
    private Integer totalFila;
    @Column(name = "montoSaldoAnterior")
    private Integer montoSaldoAnterior;
    @Column(name = "montoRetencionJudicial")
    private Integer montoRetencionJudicial;
    @Column(name = "montoCreditoCaja")
    private Integer montoCreditoCaja;
    @Column(name = "montoReconocimientoDeuda")
    private Integer montoReconocimientoDeuda;
    @Column(name = "montoCreditoSalud")
    private Integer montoCreditoSalud;
    @Column(name = "montoSeguro")
    private Integer montoSeguro;
    @Column(name = "montoDentista")
    private Integer montoDentista;
    @Column(name = "montoOtrosDcto")
    private Integer montoOtrosDcto;
    @Column(name = "montoSindicato")
    private Integer montoSindicato;
    @Column(name = "totalDescuentosLegales")
    private Integer totalDescuentosLegales;
    @Column(name = "totalDescuentos")
    private Integer totalDescuentos;
    @Column(name = "totalFinalDescuentos")
    private Integer totalFinalDescuentos;
    @Column(name = "saldoFinal")
    private Integer saldoFinal;
    @Column(name = "saldoReal")
    private Integer saldoReal;
    @Column(name = "baseLiquidacion")
    private Integer baseLiquidacion;

    public LiquidacionesDiciembre2016() {
    }

    public LiquidacionesDiciembre2016(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Integer getIdRelacionLaboral() {
        return idRelacionLaboral;
    }

    public void setIdRelacionLaboral(Integer idRelacionLaboral) {
        Integer oldIdRelacionLaboral = this.idRelacionLaboral;
        this.idRelacionLaboral = idRelacionLaboral;
        changeSupport.firePropertyChange("idRelacionLaboral", oldIdRelacionLaboral, idRelacionLaboral);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public String getRutTrabajador() {
        return rutTrabajador;
    }

    public void setRutTrabajador(String rutTrabajador) {
        String oldRutTrabajador = this.rutTrabajador;
        this.rutTrabajador = rutTrabajador;
        changeSupport.firePropertyChange("rutTrabajador", oldRutTrabajador, rutTrabajador);
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        Integer oldIdTrabajador = this.idTrabajador;
        this.idTrabajador = idTrabajador;
        changeSupport.firePropertyChange("idTrabajador", oldIdTrabajador, idTrabajador);
    }

    public Integer getCodigoTrabajador() {
        return codigoTrabajador;
    }

    public void setCodigoTrabajador(Integer codigoTrabajador) {
        Integer oldCodigoTrabajador = this.codigoTrabajador;
        this.codigoTrabajador = codigoTrabajador;
        changeSupport.firePropertyChange("codigoTrabajador", oldCodigoTrabajador, codigoTrabajador);
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        String oldNombreTrabajador = this.nombreTrabajador;
        this.nombreTrabajador = nombreTrabajador;
        changeSupport.firePropertyChange("nombreTrabajador", oldNombreTrabajador, nombreTrabajador);
    }

    public String getRutEmpleador() {
        return rutEmpleador;
    }

    public void setRutEmpleador(String rutEmpleador) {
        String oldRutEmpleador = this.rutEmpleador;
        this.rutEmpleador = rutEmpleador;
        changeSupport.firePropertyChange("rutEmpleador", oldRutEmpleador, rutEmpleador);
    }

    public Integer getCodigoEmpleador() {
        return codigoEmpleador;
    }

    public void setCodigoEmpleador(Integer codigoEmpleador) {
        Integer oldCodigoEmpleador = this.codigoEmpleador;
        this.codigoEmpleador = codigoEmpleador;
        changeSupport.firePropertyChange("codigoEmpleador", oldCodigoEmpleador, codigoEmpleador);
    }

    public String getNombreEmpresario() {
        return nombreEmpresario;
    }

    public void setNombreEmpresario(String nombreEmpresario) {
        String oldNombreEmpresario = this.nombreEmpresario;
        this.nombreEmpresario = nombreEmpresario;
        changeSupport.firePropertyChange("nombreEmpresario", oldNombreEmpresario, nombreEmpresario);
    }

    public Integer getCodigoTerminal() {
        return codigoTerminal;
    }

    public void setCodigoTerminal(Integer codigoTerminal) {
        Integer oldCodigoTerminal = this.codigoTerminal;
        this.codigoTerminal = codigoTerminal;
        changeSupport.firePropertyChange("codigoTerminal", oldCodigoTerminal, codigoTerminal);
    }

    public String getNombreTerminal() {
        return nombreTerminal;
    }

    public void setNombreTerminal(String nombreTerminal) {
        String oldNombreTerminal = this.nombreTerminal;
        this.nombreTerminal = nombreTerminal;
        changeSupport.firePropertyChange("nombreTerminal", oldNombreTerminal, nombreTerminal);
    }

    public Integer getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(Integer tipoContrato) {
        Integer oldTipoContrato = this.tipoContrato;
        this.tipoContrato = tipoContrato;
        changeSupport.firePropertyChange("tipoContrato", oldTipoContrato, tipoContrato);
    }

    public Integer getBruto() {
        return bruto;
    }

    public void setBruto(Integer bruto) {
        Integer oldBruto = this.bruto;
        this.bruto = bruto;
        changeSupport.firePropertyChange("bruto", oldBruto, bruto);
    }

    public Integer getImponible() {
        return imponible;
    }

    public void setImponible(Integer imponible) {
        Integer oldImponible = this.imponible;
        this.imponible = imponible;
        changeSupport.firePropertyChange("imponible", oldImponible, imponible);
    }

    public Integer getCincoPorcientoTotal() {
        return cincoPorcientoTotal;
    }

    public void setCincoPorcientoTotal(Integer cincoPorcientoTotal) {
        Integer oldCincoPorcientoTotal = this.cincoPorcientoTotal;
        this.cincoPorcientoTotal = cincoPorcientoTotal;
        changeSupport.firePropertyChange("cincoPorcientoTotal", oldCincoPorcientoTotal, cincoPorcientoTotal);
    }

    public Integer getCincoPorciento() {
        return cincoPorciento;
    }

    public void setCincoPorciento(Integer cincoPorciento) {
        Integer oldCincoPorciento = this.cincoPorciento;
        this.cincoPorciento = cincoPorciento;
        changeSupport.firePropertyChange("cincoPorciento", oldCincoPorciento, cincoPorciento);
    }

    public Integer getAhorroGuia() {
        return ahorroGuia;
    }

    public void setAhorroGuia(Integer ahorroGuia) {
        Integer oldAhorroGuia = this.ahorroGuia;
        this.ahorroGuia = ahorroGuia;
        changeSupport.firePropertyChange("ahorroGuia", oldAhorroGuia, ahorroGuia);
    }

    public Integer getAbonos() {
        return abonos;
    }

    public void setAbonos(Integer abonos) {
        Integer oldAbonos = this.abonos;
        this.abonos = abonos;
        changeSupport.firePropertyChange("abonos", oldAbonos, abonos);
    }

    public Integer getTotalHaberes() {
        return totalHaberes;
    }

    public void setTotalHaberes(Integer totalHaberes) {
        Integer oldTotalHaberes = this.totalHaberes;
        this.totalHaberes = totalHaberes;
        changeSupport.firePropertyChange("totalHaberes", oldTotalHaberes, totalHaberes);
    }

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        Integer oldBase = this.base;
        this.base = base;
        changeSupport.firePropertyChange("base", oldBase, base);
    }

    public Integer getCuatroPorciento() {
        return cuatroPorciento;
    }

    public void setCuatroPorciento(Integer cuatroPorciento) {
        Integer oldCuatroPorciento = this.cuatroPorciento;
        this.cuatroPorciento = cuatroPorciento;
        changeSupport.firePropertyChange("cuatroPorciento", oldCuatroPorciento, cuatroPorciento);
    }

    public Integer getUnoPorciento() {
        return unoPorciento;
    }

    public void setUnoPorciento(Integer unoPorciento) {
        Integer oldUnoPorciento = this.unoPorciento;
        this.unoPorciento = unoPorciento;
        changeSupport.firePropertyChange("unoPorciento", oldUnoPorciento, unoPorciento);
    }

    public Integer getUnoComaDosPorciento() {
        return unoComaDosPorciento;
    }

    public void setUnoComaDosPorciento(Integer unoComaDosPorciento) {
        Integer oldUnoComaDosPorciento = this.unoComaDosPorciento;
        this.unoComaDosPorciento = unoComaDosPorciento;
        changeSupport.firePropertyChange("unoComaDosPorciento", oldUnoComaDosPorciento, unoComaDosPorciento);
    }

    public Integer getCeroComaOchoPorciento() {
        return ceroComaOchoPorciento;
    }

    public void setCeroComaOchoPorciento(Integer ceroComaOchoPorciento) {
        Integer oldCeroComaOchoPorciento = this.ceroComaOchoPorciento;
        this.ceroComaOchoPorciento = ceroComaOchoPorciento;
        changeSupport.firePropertyChange("ceroComaOchoPorciento", oldCeroComaOchoPorciento, ceroComaOchoPorciento);
    }

    public Integer getDosPorciento() {
        return dosPorciento;
    }

    public void setDosPorciento(Integer dosPorciento) {
        Integer oldDosPorciento = this.dosPorciento;
        this.dosPorciento = dosPorciento;
        changeSupport.firePropertyChange("dosPorciento", oldDosPorciento, dosPorciento);
    }

    public Integer getTotalPorcentajes() {
        return totalPorcentajes;
    }

    public void setTotalPorcentajes(Integer totalPorcentajes) {
        Integer oldTotalPorcentajes = this.totalPorcentajes;
        this.totalPorcentajes = totalPorcentajes;
        changeSupport.firePropertyChange("totalPorcentajes", oldTotalPorcentajes, totalPorcentajes);
    }

    public Integer getAjusteComisionAuxiliar() {
        return ajusteComisionAuxiliar;
    }

    public void setAjusteComisionAuxiliar(Integer ajusteComisionAuxiliar) {
        Integer oldAjusteComisionAuxiliar = this.ajusteComisionAuxiliar;
        this.ajusteComisionAuxiliar = ajusteComisionAuxiliar;
        changeSupport.firePropertyChange("ajusteComisionAuxiliar", oldAjusteComisionAuxiliar, ajusteComisionAuxiliar);
    }

    public Integer getAjusteComision() {
        return ajusteComision;
    }

    public void setAjusteComision(Integer ajusteComision) {
        Integer oldAjusteComision = this.ajusteComision;
        this.ajusteComision = ajusteComision;
        changeSupport.firePropertyChange("ajusteComision", oldAjusteComision, ajusteComision);
    }

    public Integer getNumeroCargas() {
        return numeroCargas;
    }

    public void setNumeroCargas(Integer numeroCargas) {
        Integer oldNumeroCargas = this.numeroCargas;
        this.numeroCargas = numeroCargas;
        changeSupport.firePropertyChange("numeroCargas", oldNumeroCargas, numeroCargas);
    }

    public Integer getMontoCargas() {
        return montoCargas;
    }

    public void setMontoCargas(Integer montoCargas) {
        Integer oldMontoCargas = this.montoCargas;
        this.montoCargas = montoCargas;
        changeSupport.firePropertyChange("montoCargas", oldMontoCargas, montoCargas);
    }

    public Integer getMontoFeriado() {
        return montoFeriado;
    }

    public void setMontoFeriado(Integer montoFeriado) {
        Integer oldMontoFeriado = this.montoFeriado;
        this.montoFeriado = montoFeriado;
        changeSupport.firePropertyChange("montoFeriado", oldMontoFeriado, montoFeriado);
    }

    public String getNombreAfp() {
        return nombreAfp;
    }

    public void setNombreAfp(String nombreAfp) {
        String oldNombreAfp = this.nombreAfp;
        this.nombreAfp = nombreAfp;
        changeSupport.firePropertyChange("nombreAfp", oldNombreAfp, nombreAfp);
    }

    public String getPorcentajeAfp() {
        return porcentajeAfp;
    }

    public void setPorcentajeAfp(String porcentajeAfp) {
        String oldPorcentajeAfp = this.porcentajeAfp;
        this.porcentajeAfp = porcentajeAfp;
        changeSupport.firePropertyChange("porcentajeAfp", oldPorcentajeAfp, porcentajeAfp);
    }

    public Integer getMontoAfp() {
        return montoAfp;
    }

    public void setMontoAfp(Integer montoAfp) {
        Integer oldMontoAfp = this.montoAfp;
        this.montoAfp = montoAfp;
        changeSupport.firePropertyChange("montoAfp", oldMontoAfp, montoAfp);
    }

    public Integer getCesantiaTrabajador() {
        return cesantiaTrabajador;
    }

    public void setCesantiaTrabajador(Integer cesantiaTrabajador) {
        Integer oldCesantiaTrabajador = this.cesantiaTrabajador;
        this.cesantiaTrabajador = cesantiaTrabajador;
        changeSupport.firePropertyChange("cesantiaTrabajador", oldCesantiaTrabajador, cesantiaTrabajador);
    }

    public Integer getCesantiaEmpleador() {
        return cesantiaEmpleador;
    }

    public void setCesantiaEmpleador(Integer cesantiaEmpleador) {
        Integer oldCesantiaEmpleador = this.cesantiaEmpleador;
        this.cesantiaEmpleador = cesantiaEmpleador;
        changeSupport.firePropertyChange("cesantiaEmpleador", oldCesantiaEmpleador, cesantiaEmpleador);
    }

    public Integer getCesantiaTotal() {
        return cesantiaTotal;
    }

    public void setCesantiaTotal(Integer cesantiaTotal) {
        Integer oldCesantiaTotal = this.cesantiaTotal;
        this.cesantiaTotal = cesantiaTotal;
        changeSupport.firePropertyChange("cesantiaTotal", oldCesantiaTotal, cesantiaTotal);
    }

    public Integer getAhorroVoluntario() {
        return ahorroVoluntario;
    }

    public void setAhorroVoluntario(Integer ahorroVoluntario) {
        Integer oldAhorroVoluntario = this.ahorroVoluntario;
        this.ahorroVoluntario = ahorroVoluntario;
        changeSupport.firePropertyChange("ahorroVoluntario", oldAhorroVoluntario, ahorroVoluntario);
    }

    public Integer getMontoSIS() {
        return montoSIS;
    }

    public void setMontoSIS(Integer montoSIS) {
        Integer oldMontoSIS = this.montoSIS;
        this.montoSIS = montoSIS;
        changeSupport.firePropertyChange("montoSIS", oldMontoSIS, montoSIS);
    }

    public String getNombreIsapre() {
        return nombreIsapre;
    }

    public void setNombreIsapre(String nombreIsapre) {
        String oldNombreIsapre = this.nombreIsapre;
        this.nombreIsapre = nombreIsapre;
        changeSupport.firePropertyChange("nombreIsapre", oldNombreIsapre, nombreIsapre);
    }

    public Integer getMontoIsapre() {
        return montoIsapre;
    }

    public void setMontoIsapre(Integer montoIsapre) {
        Integer oldMontoIsapre = this.montoIsapre;
        this.montoIsapre = montoIsapre;
        changeSupport.firePropertyChange("montoIsapre", oldMontoIsapre, montoIsapre);
    }

    public String getPorcentajeCaja() {
        return porcentajeCaja;
    }

    public void setPorcentajeCaja(String porcentajeCaja) {
        String oldPorcentajeCaja = this.porcentajeCaja;
        this.porcentajeCaja = porcentajeCaja;
        changeSupport.firePropertyChange("porcentajeCaja", oldPorcentajeCaja, porcentajeCaja);
    }

    public Integer getMontoCaja() {
        return montoCaja;
    }

    public void setMontoCaja(Integer montoCaja) {
        Integer oldMontoCaja = this.montoCaja;
        this.montoCaja = montoCaja;
        changeSupport.firePropertyChange("montoCaja", oldMontoCaja, montoCaja);
    }

    public String getPorcentajeInp() {
        return porcentajeInp;
    }

    public void setPorcentajeInp(String porcentajeInp) {
        String oldPorcentajeInp = this.porcentajeInp;
        this.porcentajeInp = porcentajeInp;
        changeSupport.firePropertyChange("porcentajeInp", oldPorcentajeInp, porcentajeInp);
    }

    public Integer getMontoInp() {
        return montoInp;
    }

    public void setMontoInp(Integer montoInp) {
        Integer oldMontoInp = this.montoInp;
        this.montoInp = montoInp;
        changeSupport.firePropertyChange("montoInp", oldMontoInp, montoInp);
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        String oldObservacion = this.observacion;
        this.observacion = observacion;
        changeSupport.firePropertyChange("observacion", oldObservacion, observacion);
    }

    public Integer getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(Integer diasTrabajados) {
        Integer oldDiasTrabajados = this.diasTrabajados;
        this.diasTrabajados = diasTrabajados;
        changeSupport.firePropertyChange("diasTrabajados", oldDiasTrabajados, diasTrabajados);
    }

    public Integer getDiasVacaciones() {
        return diasVacaciones;
    }

    public void setDiasVacaciones(Integer diasVacaciones) {
        Integer oldDiasVacaciones = this.diasVacaciones;
        this.diasVacaciones = diasVacaciones;
        changeSupport.firePropertyChange("diasVacaciones", oldDiasVacaciones, diasVacaciones);
    }

    public Integer getDiasLicencias() {
        return diasLicencias;
    }

    public void setDiasLicencias(Integer diasLicencias) {
        Integer oldDiasLicencias = this.diasLicencias;
        this.diasLicencias = diasLicencias;
        changeSupport.firePropertyChange("diasLicencias", oldDiasLicencias, diasLicencias);
    }

    public Integer getDiasDescanso() {
        return diasDescanso;
    }

    public void setDiasDescanso(Integer diasDescanso) {
        Integer oldDiasDescanso = this.diasDescanso;
        this.diasDescanso = diasDescanso;
        changeSupport.firePropertyChange("diasDescanso", oldDiasDescanso, diasDescanso);
    }

    public Integer getDiasGuias() {
        return diasGuias;
    }

    public void setDiasGuias(Integer diasGuias) {
        Integer oldDiasGuias = this.diasGuias;
        this.diasGuias = diasGuias;
        changeSupport.firePropertyChange("diasGuias", oldDiasGuias, diasGuias);
    }

    public Integer getDiasLimpios() {
        return diasLimpios;
    }

    public void setDiasLimpios(Integer diasLimpios) {
        Integer oldDiasLimpios = this.diasLimpios;
        this.diasLimpios = diasLimpios;
        changeSupport.firePropertyChange("diasLimpios", oldDiasLimpios, diasLimpios);
    }

    public Integer getTotalDias() {
        return totalDias;
    }

    public void setTotalDias(Integer totalDias) {
        Integer oldTotalDias = this.totalDias;
        this.totalDias = totalDias;
        changeSupport.firePropertyChange("totalDias", oldTotalDias, totalDias);
    }

    public Date getFechaDesdeContrato() {
        return fechaDesdeContrato;
    }

    public void setFechaDesdeContrato(Date fechaDesdeContrato) {
        Date oldFechaDesdeContrato = this.fechaDesdeContrato;
        this.fechaDesdeContrato = fechaDesdeContrato;
        changeSupport.firePropertyChange("fechaDesdeContrato", oldFechaDesdeContrato, fechaDesdeContrato);
    }

    public Date getFechaHastaContrato() {
        return fechaHastaContrato;
    }

    public void setFechaHastaContrato(Date fechaHastaContrato) {
        Date oldFechaHastaContrato = this.fechaHastaContrato;
        this.fechaHastaContrato = fechaHastaContrato;
        changeSupport.firePropertyChange("fechaHastaContrato", oldFechaHastaContrato, fechaHastaContrato);
    }

    public Date getFechaDesdeFeriado() {
        return fechaDesdeFeriado;
    }

    public void setFechaDesdeFeriado(Date fechaDesdeFeriado) {
        Date oldFechaDesdeFeriado = this.fechaDesdeFeriado;
        this.fechaDesdeFeriado = fechaDesdeFeriado;
        changeSupport.firePropertyChange("fechaDesdeFeriado", oldFechaDesdeFeriado, fechaDesdeFeriado);
    }

    public Date getFechaHastaFeriado() {
        return fechaHastaFeriado;
    }

    public void setFechaHastaFeriado(Date fechaHastaFeriado) {
        Date oldFechaHastaFeriado = this.fechaHastaFeriado;
        this.fechaHastaFeriado = fechaHastaFeriado;
        changeSupport.firePropertyChange("fechaHastaFeriado", oldFechaHastaFeriado, fechaHastaFeriado);
    }

    public Date getFechaDesdeLicencias() {
        return fechaDesdeLicencias;
    }

    public void setFechaDesdeLicencias(Date fechaDesdeLicencias) {
        Date oldFechaDesdeLicencias = this.fechaDesdeLicencias;
        this.fechaDesdeLicencias = fechaDesdeLicencias;
        changeSupport.firePropertyChange("fechaDesdeLicencias", oldFechaDesdeLicencias, fechaDesdeLicencias);
    }

    public Date getFechaHastaLicencias() {
        return fechaHastaLicencias;
    }

    public void setFechaHastaLicencias(Date fechaHastaLicencias) {
        Date oldFechaHastaLicencias = this.fechaHastaLicencias;
        this.fechaHastaLicencias = fechaHastaLicencias;
        changeSupport.firePropertyChange("fechaHastaLicencias", oldFechaHastaLicencias, fechaHastaLicencias);
    }

    public Integer getCodigoEMP() {
        return codigoEMP;
    }

    public void setCodigoEMP(Integer codigoEMP) {
        Integer oldCodigoEMP = this.codigoEMP;
        this.codigoEMP = codigoEMP;
        changeSupport.firePropertyChange("codigoEMP", oldCodigoEMP, codigoEMP);
    }

    public Integer getTotalFila() {
        return totalFila;
    }

    public void setTotalFila(Integer totalFila) {
        Integer oldTotalFila = this.totalFila;
        this.totalFila = totalFila;
        changeSupport.firePropertyChange("totalFila", oldTotalFila, totalFila);
    }

    public Integer getMontoSaldoAnterior() {
        return montoSaldoAnterior;
    }

    public void setMontoSaldoAnterior(Integer montoSaldoAnterior) {
        Integer oldMontoSaldoAnterior = this.montoSaldoAnterior;
        this.montoSaldoAnterior = montoSaldoAnterior;
        changeSupport.firePropertyChange("montoSaldoAnterior", oldMontoSaldoAnterior, montoSaldoAnterior);
    }

    public Integer getMontoRetencionJudicial() {
        return montoRetencionJudicial;
    }

    public void setMontoRetencionJudicial(Integer montoRetencionJudicial) {
        Integer oldMontoRetencionJudicial = this.montoRetencionJudicial;
        this.montoRetencionJudicial = montoRetencionJudicial;
        changeSupport.firePropertyChange("montoRetencionJudicial", oldMontoRetencionJudicial, montoRetencionJudicial);
    }

    public Integer getMontoCreditoCaja() {
        return montoCreditoCaja;
    }

    public void setMontoCreditoCaja(Integer montoCreditoCaja) {
        Integer oldMontoCreditoCaja = this.montoCreditoCaja;
        this.montoCreditoCaja = montoCreditoCaja;
        changeSupport.firePropertyChange("montoCreditoCaja", oldMontoCreditoCaja, montoCreditoCaja);
    }

    public Integer getMontoReconocimientoDeuda() {
        return montoReconocimientoDeuda;
    }

    public void setMontoReconocimientoDeuda(Integer montoReconocimientoDeuda) {
        Integer oldMontoReconocimientoDeuda = this.montoReconocimientoDeuda;
        this.montoReconocimientoDeuda = montoReconocimientoDeuda;
        changeSupport.firePropertyChange("montoReconocimientoDeuda", oldMontoReconocimientoDeuda, montoReconocimientoDeuda);
    }

    public Integer getMontoCreditoSalud() {
        return montoCreditoSalud;
    }

    public void setMontoCreditoSalud(Integer montoCreditoSalud) {
        Integer oldMontoCreditoSalud = this.montoCreditoSalud;
        this.montoCreditoSalud = montoCreditoSalud;
        changeSupport.firePropertyChange("montoCreditoSalud", oldMontoCreditoSalud, montoCreditoSalud);
    }

    public Integer getMontoSeguro() {
        return montoSeguro;
    }

    public void setMontoSeguro(Integer montoSeguro) {
        Integer oldMontoSeguro = this.montoSeguro;
        this.montoSeguro = montoSeguro;
        changeSupport.firePropertyChange("montoSeguro", oldMontoSeguro, montoSeguro);
    }

    public Integer getMontoDentista() {
        return montoDentista;
    }

    public void setMontoDentista(Integer montoDentista) {
        Integer oldMontoDentista = this.montoDentista;
        this.montoDentista = montoDentista;
        changeSupport.firePropertyChange("montoDentista", oldMontoDentista, montoDentista);
    }

    public Integer getMontoOtrosDcto() {
        return montoOtrosDcto;
    }

    public void setMontoOtrosDcto(Integer montoOtrosDcto) {
        Integer oldMontoOtrosDcto = this.montoOtrosDcto;
        this.montoOtrosDcto = montoOtrosDcto;
        changeSupport.firePropertyChange("montoOtrosDcto", oldMontoOtrosDcto, montoOtrosDcto);
    }

    public Integer getMontoSindicato() {
        return montoSindicato;
    }

    public void setMontoSindicato(Integer montoSindicato) {
        Integer oldMontoSindicato = this.montoSindicato;
        this.montoSindicato = montoSindicato;
        changeSupport.firePropertyChange("montoSindicato", oldMontoSindicato, montoSindicato);
    }

    public Integer getTotalDescuentosLegales() {
        return totalDescuentosLegales;
    }

    public void setTotalDescuentosLegales(Integer totalDescuentosLegales) {
        Integer oldTotalDescuentosLegales = this.totalDescuentosLegales;
        this.totalDescuentosLegales = totalDescuentosLegales;
        changeSupport.firePropertyChange("totalDescuentosLegales", oldTotalDescuentosLegales, totalDescuentosLegales);
    }

    public Integer getTotalDescuentos() {
        return totalDescuentos;
    }

    public void setTotalDescuentos(Integer totalDescuentos) {
        Integer oldTotalDescuentos = this.totalDescuentos;
        this.totalDescuentos = totalDescuentos;
        changeSupport.firePropertyChange("totalDescuentos", oldTotalDescuentos, totalDescuentos);
    }

    public Integer getTotalFinalDescuentos() {
        return totalFinalDescuentos;
    }

    public void setTotalFinalDescuentos(Integer totalFinalDescuentos) {
        Integer oldTotalFinalDescuentos = this.totalFinalDescuentos;
        this.totalFinalDescuentos = totalFinalDescuentos;
        changeSupport.firePropertyChange("totalFinalDescuentos", oldTotalFinalDescuentos, totalFinalDescuentos);
    }

    public Integer getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Integer saldoFinal) {
        Integer oldSaldoFinal = this.saldoFinal;
        this.saldoFinal = saldoFinal;
        changeSupport.firePropertyChange("saldoFinal", oldSaldoFinal, saldoFinal);
    }

    public Integer getSaldoReal() {
        return saldoReal;
    }

    public void setSaldoReal(Integer saldoReal) {
        Integer oldSaldoReal = this.saldoReal;
        this.saldoReal = saldoReal;
        changeSupport.firePropertyChange("saldoReal", oldSaldoReal, saldoReal);
    }

    public Integer getBaseLiquidacion() {
        return baseLiquidacion;
    }

    public void setBaseLiquidacion(Integer baseLiquidacion) {
        Integer oldBaseLiquidacion = this.baseLiquidacion;
        this.baseLiquidacion = baseLiquidacion;
        changeSupport.firePropertyChange("baseLiquidacion", oldBaseLiquidacion, baseLiquidacion);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LiquidacionesDiciembre2016)) {
            return false;
        }
        LiquidacionesDiciembre2016 other = (LiquidacionesDiciembre2016) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "views.LiquidacionesDiciembre2016[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
