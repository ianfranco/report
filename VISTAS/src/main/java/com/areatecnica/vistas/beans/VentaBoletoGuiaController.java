package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.VentaBoletoGuia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ventaBoletoGuiaController")
@ViewScoped
public class VentaBoletoGuiaController extends AbstractController<VentaBoletoGuia> {

    @Inject
    private GuiaController idGuiaController;
    @Inject
    private InventarioTerminalController idInventarioTerminalController;
    @Inject
    private MobilePageController mobilePageController;

    public VentaBoletoGuiaController() {
        // Inform the Abstract parent controller of the concrete VentaBoletoGuia Entity
        super(VentaBoletoGuia.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idGuiaController.setSelected(null);
        idInventarioTerminalController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Guia controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdGuia(ActionEvent event) {
        if (this.getSelected() != null && idGuiaController.getSelected() == null) {
            idGuiaController.setSelected(this.getSelected().getIdGuia());
        }
    }

    /**
     * Sets the "selected" attribute of the InventarioTerminal controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdInventarioTerminal(ActionEvent event) {
        if (this.getSelected() != null && idInventarioTerminalController.getSelected() == null) {
            idInventarioTerminalController.setSelected(this.getSelected().getIdInventarioTerminal());
        }
    }
}
