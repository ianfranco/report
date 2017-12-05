package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.DetalleCompraBoleto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "detalleCompraBoletoController")
@ViewScoped
public class DetalleCompraBoletoController extends AbstractController<DetalleCompraBoleto> {

    @Inject
    private BoletoController idBoletoController;
    @Inject
    private CompraBoletoController idCompraBoletoController;
    @Inject
    private MobilePageController mobilePageController;

    public DetalleCompraBoletoController() {
        // Inform the Abstract parent controller of the concrete DetalleCompraBoleto Entity
        super(DetalleCompraBoleto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idBoletoController.setSelected(null);
        idCompraBoletoController.setSelected(null);
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
     * Sets the "selected" attribute of the CompraBoleto controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCompraBoleto(ActionEvent event) {
        if (this.getSelected() != null && idCompraBoletoController.getSelected() == null) {
            idCompraBoletoController.setSelected(this.getSelected().getIdCompraBoleto());
        }
    }
}
