package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Servicio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "servicioController")
@ViewScoped
public class ServicioController extends AbstractController<Servicio> {

    @Inject
    private TerminalController idTerminalController;
    @Inject
    private UnidadNegocioController idUnidadController;
    @Inject
    private MobilePageController mobilePageController;

    public ServicioController() {
        // Inform the Abstract parent controller of the concrete Servicio Entity
        super(Servicio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTerminalController.setSelected(null);
        idUnidadController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of CalleServicio entities
     * that are retrieved from Servicio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CalleServicio page
     */
    public String navigateCalleServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CalleServicio_items", this.getSelected().getCalleServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/calleServicio/index";
    }

    /**
     * Sets the "items" attribute with a collection of Despacho entities that
     * are retrieved from Servicio?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of FrecuenciaServicio
     * entities that are retrieved from Servicio?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for FrecuenciaServicio page
     */
    public String navigateFrecuenciaServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FrecuenciaServicio_items", this.getSelected().getFrecuenciaServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/frecuenciaServicio/index";
    }

    /**
     * Sets the "items" attribute with a collection of ControlServicio entities
     * that are retrieved from Servicio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ControlServicio page
     */
    public String navigateControlServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ControlServicio_items", this.getSelected().getControlServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/controlServicio/index";
    }

    /**
     * Sets the "items" attribute with a collection of EgresoServicio entities
     * that are retrieved from Servicio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for EgresoServicio page
     */
    public String navigateEgresoServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EgresoServicio_items", this.getSelected().getEgresoServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/egresoServicio/index";
    }

    /**
     * Sets the "items" attribute with a collection of BusServicio entities that
     * are retrieved from Servicio?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for BusServicio page
     */
    public String navigateBusServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("BusServicio_items", this.getSelected().getBusServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/busServicio/index";
    }

    /**
     * Sets the "items" attribute with a collection of Guia entities that are
     * retrieved from Servicio?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of HorarioServicio entities
     * that are retrieved from Servicio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for HorarioServicio page
     */
    public String navigateHorarioServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("HorarioServicio_items", this.getSelected().getHorarioServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/horarioServicio/index";
    }

    /**
     * Sets the "items" attribute with a collection of TarifaServicio entities
     * that are retrieved from Servicio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TarifaServicio page
     */
    public String navigateTarifaServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TarifaServicio_items", this.getSelected().getTarifaServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/tarifaServicio/index";
    }

    /**
     * Sets the "selected" attribute of the Terminal controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTerminal(ActionEvent event) {
        if (this.getSelected() != null && idTerminalController.getSelected() == null) {
            idTerminalController.setSelected(this.getSelected().getIdTerminal());
        }
    }

    /**
     * Sets the "selected" attribute of the UnidadNegocio controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdUnidad(ActionEvent event) {
        if (this.getSelected() != null && idUnidadController.getSelected() == null) {
            idUnidadController.setSelected(this.getSelected().getIdUnidad());
        }
    }
}
