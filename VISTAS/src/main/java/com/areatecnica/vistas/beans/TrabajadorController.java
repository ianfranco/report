package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Trabajador;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "trabajadorController")
@ViewScoped
public class TrabajadorController extends AbstractController<Trabajador> {

    @Inject
    private InstitucionApvController idInstitucionApvController;
    @Inject
    private AsignacionFamiliarController idAsignacionFamiliarController;
    @Inject
    private TipoCotizacionTrabajadorController idTipoCotizacionTrabajadorController;
    @Inject
    private MonedaPactadaInstitucionSaludController idMonedaPactadaSaludController;
    @Inject
    private InstitucionPrevisionController idInstitucionPrevisionController;
    @Inject
    private InstitucionSaludController idInstitucionSaludController;
    @Inject
    private MobilePageController mobilePageController;

    public TrabajadorController() {
        // Inform the Abstract parent controller of the concrete Trabajador Entity
        super(Trabajador.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idInstitucionApvController.setSelected(null);
        idAsignacionFamiliarController.setSelected(null);
        idTipoCotizacionTrabajadorController.setSelected(null);
        idMonedaPactadaSaludController.setSelected(null);
        idInstitucionPrevisionController.setSelected(null);
        idInstitucionSaludController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of HaberTrabajador entities
     * that are retrieved from Trabajador?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for HaberTrabajador page
     */
    public String navigateHaberTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("HaberTrabajador_items", this.getSelected().getHaberTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/haberTrabajador/index";
    }

    /**
     * Sets the "items" attribute with a collection of AnticipoTrabajador
     * entities that are retrieved from Trabajador?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for AnticipoTrabajador page
     */
    public String navigateAnticipoTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AnticipoTrabajador_items", this.getSelected().getAnticipoTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/anticipoTrabajador/index";
    }

    /**
     * Sets the "items" attribute with a collection of Despacho entities that
     * are retrieved from Trabajador?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Despacho page
     */
    public String navigateDespachoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Despacho_items", this.getSelected().getDespachoList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/despacho/index";
    }

    /**
     * Sets the "items" attribute with a collection of SindicatoTrabajador
     * entities that are retrieved from Trabajador?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for SindicatoTrabajador page
     */
    public String navigateSindicatoTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SindicatoTrabajador_items", this.getSelected().getSindicatoTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/sindicatoTrabajador/index";
    }

    /**
     * Sets the "items" attribute with a collection of DiaTrabajador entities
     * that are retrieved from Trabajador?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for DiaTrabajador page
     */
    public String navigateDiaTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DiaTrabajador_items", this.getSelected().getDiaTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/diaTrabajador/index";
    }

    /**
     * Sets the "items" attribute with a collection of CargasTrabajador entities
     * that are retrieved from Trabajador?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CargasTrabajador page
     */
    public String navigateCargasTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CargasTrabajador_items", this.getSelected().getCargasTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/cargasTrabajador/index";
    }

    /**
     * Sets the "items" attribute with a collection of CentroCostoTrabajador
     * entities that are retrieved from Trabajador?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CentroCostoTrabajador page
     */
    public String navigateCentroCostoTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CentroCostoTrabajador_items", this.getSelected().getCentroCostoTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/centroCostoTrabajador/index";
    }

    /**
     * Sets the "selected" attribute of the InstitucionApv controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdInstitucionApv(ActionEvent event) {
        if (this.getSelected() != null && idInstitucionApvController.getSelected() == null) {
            idInstitucionApvController.setSelected(this.getSelected().getIdInstitucionApv());
        }
    }

    /**
     * Sets the "selected" attribute of the AsignacionFamiliar controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdAsignacionFamiliar(ActionEvent event) {
        if (this.getSelected() != null && idAsignacionFamiliarController.getSelected() == null) {
            idAsignacionFamiliarController.setSelected(this.getSelected().getIdAsignacionFamiliar());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoCotizacionTrabajador controller
     * in order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoCotizacionTrabajador(ActionEvent event) {
        if (this.getSelected() != null && idTipoCotizacionTrabajadorController.getSelected() == null) {
            idTipoCotizacionTrabajadorController.setSelected(this.getSelected().getIdTipoCotizacionTrabajador());
        }
    }

    /**
     * Sets the "selected" attribute of the MonedaPactadaInstitucionSalud
     * controller in order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMonedaPactadaSalud(ActionEvent event) {
        if (this.getSelected() != null && idMonedaPactadaSaludController.getSelected() == null) {
            idMonedaPactadaSaludController.setSelected(this.getSelected().getIdMonedaPactadaSalud());
        }
    }

    /**
     * Sets the "selected" attribute of the InstitucionPrevision controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdInstitucionPrevision(ActionEvent event) {
        if (this.getSelected() != null && idInstitucionPrevisionController.getSelected() == null) {
            idInstitucionPrevisionController.setSelected(this.getSelected().getIdInstitucionPrevision());
        }
    }

    /**
     * Sets the "selected" attribute of the InstitucionSalud controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdInstitucionSalud(ActionEvent event) {
        if (this.getSelected() != null && idInstitucionSaludController.getSelected() == null) {
            idInstitucionSaludController.setSelected(this.getSelected().getIdInstitucionSalud());
        }
    }

    /**
     * Sets the "items" attribute with a collection of RelacionLaboral entities
     * that are retrieved from Trabajador?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for RelacionLaboral page
     */
    public String navigateRelacionLaboralList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RelacionLaboral_items", this.getSelected().getRelacionLaboralList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/relacionLaboral/index";
    }

    /**
     * Sets the "items" attribute with a collection of CargaRetroactiva entities
     * that are retrieved from Trabajador?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CargaRetroactiva page
     */
    public String navigateCargaRetroactivaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CargaRetroactiva_items", this.getSelected().getCargaRetroactivaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/cargaRetroactiva/index";
    }

    /**
     * Sets the "items" attribute with a collection of HoraExtraTrabajador
     * entities that are retrieved from Trabajador?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for HoraExtraTrabajador page
     */
    public String navigateHoraExtraTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("HoraExtraTrabajador_items", this.getSelected().getHoraExtraTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/horaExtraTrabajador/index";
    }

    /**
     * Sets the "items" attribute with a collection of DescuentoTrabajador
     * entities that are retrieved from Trabajador?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DescuentoTrabajador page
     */
    public String navigateDescuentoTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DescuentoTrabajador_items", this.getSelected().getDescuentoTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/descuentoTrabajador/index";
    }

    /**
     * Sets the "items" attribute with a collection of Guia entities that are
     * retrieved from Trabajador?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Guia page
     */
    public String navigateGuiaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Guia_items", this.getSelected().getGuiaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/guia/index";
    }

    /**
     * Sets the "items" attribute with a collection of ObservacionTrabajador
     * entities that are retrieved from Trabajador?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ObservacionTrabajador page
     */
    public String navigateObservacionTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ObservacionTrabajador_items", this.getSelected().getObservacionTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/observacionTrabajador/index";
    }

    /**
     * Sets the "items" attribute with a collection of TrabajadorTerminal
     * entities that are retrieved from Trabajador?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for TrabajadorTerminal page
     */
    public String navigateTrabajadorTerminalList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TrabajadorTerminal_items", this.getSelected().getTrabajadorTerminalList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/trabajadorTerminal/index";
    }

}
