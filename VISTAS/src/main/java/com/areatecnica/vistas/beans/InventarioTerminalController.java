package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.InventarioTerminal;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "inventarioTerminalController")
@ViewScoped
public class InventarioTerminalController extends AbstractController<InventarioTerminal> {

    @Inject
    private BoletoController idBoletoController;
    @Inject
    private TerminalController idTerminalController;
    @Inject
    private MobilePageController mobilePageController;

    public InventarioTerminalController() {
        // Inform the Abstract parent controller of the concrete InventarioTerminal Entity
        super(InventarioTerminal.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idBoletoController.setSelected(null);
        idTerminalController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Boleto controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdBoleto(ActionEvent event) {
        if (this.getSelected() != null && idBoletoController.getSelected() == null) {
            idBoletoController.setSelected(this.getSelected().getIdBoleto());
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
     * Sets the "items" attribute with a collection of VentaBoletoGuia entities
     * that are retrieved from InventarioTerminal?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for VentaBoletoGuia page
     */
    public String navigateVentaBoletoGuiaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("VentaBoletoGuia_items", this.getSelected().getVentaBoletoGuiaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/ventaBoletoGuia/index";
    }

}
