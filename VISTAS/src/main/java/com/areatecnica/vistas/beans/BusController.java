package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Bus;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "busController")
@ViewScoped
public class BusController extends AbstractController<Bus> {

    @Inject
    private EmpresaController idEmpresaController;
    @Inject
    private FlotaController idFlotaController;
    @Inject
    private ModeloMarcaBusController idModeloController;
    @Inject
    private TerminalController idTerminalController;
    @Inject
    private UnidadNegocioController idUnidadNegocioController;
    @Inject
    private MobilePageController mobilePageController;

    public BusController() {
        // Inform the Abstract parent controller of the concrete Bus Entity
        super(Bus.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEmpresaController.setSelected(null);
        idFlotaController.setSelected(null);
        idModeloController.setSelected(null);
        idTerminalController.setSelected(null);
        idUnidadNegocioController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of AbonoBus entities that
     * are retrieved from Bus?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for AbonoBus page
     */
    public String navigateAbonoBusList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AbonoBus_items", this.getSelected().getAbonoBusList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/abonoBus/index";
    }

    /**
     * Sets the "items" attribute with a collection of CargoBus entities that
     * are retrieved from Bus?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for CargoBus page
     */
    public String navigateCargoBusList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CargoBus_items", this.getSelected().getCargoBusList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/cargoBus/index";
    }

    /**
     * Sets the "items" attribute with a collection of Despacho entities that
     * are retrieved from Bus?cap_first and returns the navigation outcome.
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
     * Sets the "selected" attribute of the Empresa controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEmpresa(ActionEvent event) {
        if (this.getSelected() != null && idEmpresaController.getSelected() == null) {
            idEmpresaController.setSelected(this.getSelected().getIdEmpresa());
        }
    }

    /**
     * Sets the "selected" attribute of the Flota controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdFlota(ActionEvent event) {
        if (this.getSelected() != null && idFlotaController.getSelected() == null) {
            idFlotaController.setSelected(this.getSelected().getIdFlota());
        }
    }

    /**
     * Sets the "selected" attribute of the ModeloMarcaBus controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdModelo(ActionEvent event) {
        if (this.getSelected() != null && idModeloController.getSelected() == null) {
            idModeloController.setSelected(this.getSelected().getIdModelo());
        }
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
    public void prepareIdUnidadNegocio(ActionEvent event) {
        if (this.getSelected() != null && idUnidadNegocioController.getSelected() == null) {
            idUnidadNegocioController.setSelected(this.getSelected().getIdUnidadNegocio());
        }
    }

    /**
     * Sets the "items" attribute with a collection of BusDevice entities that
     * are retrieved from Bus?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for BusDevice page
     */
    public String navigateBusDeviceList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("BusDevice_items", this.getSelected().getBusDeviceList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/busDevice/index";
    }

    /**
     * Sets the "items" attribute with a collection of BusServicio entities that
     * are retrieved from Bus?cap_first and returns the navigation outcome.
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
     * retrieved from Bus?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Guia page
     */
    public String navigateGuiaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Guia_items", this.getSelected().getGuiaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/guia/index";
    }

}
