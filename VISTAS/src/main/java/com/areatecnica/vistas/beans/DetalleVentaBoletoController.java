package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.DetalleVentaBoleto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "detalleVentaBoletoController")
@ViewScoped
public class DetalleVentaBoletoController extends AbstractController<DetalleVentaBoleto> {

    @Inject
    private InventarioInternoController idInventarioInternoController;
    @Inject
    private VentaBoletoController idVentaBoletoController;
    @Inject
    private MobilePageController mobilePageController;

    public DetalleVentaBoletoController() {
        // Inform the Abstract parent controller of the concrete DetalleVentaBoleto Entity
        super(DetalleVentaBoleto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idInventarioInternoController.setSelected(null);
        idVentaBoletoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the InventarioInterno controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdInventarioInterno(ActionEvent event) {
        if (this.getSelected() != null && idInventarioInternoController.getSelected() == null) {
            idInventarioInternoController.setSelected(this.getSelected().getIdInventarioInterno());
        }
    }

    /**
     * Sets the "selected" attribute of the VentaBoleto controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdVentaBoleto(ActionEvent event) {
        if (this.getSelected() != null && idVentaBoletoController.getSelected() == null) {
            idVentaBoletoController.setSelected(this.getSelected().getIdVentaBoleto());
        }
    }
}
