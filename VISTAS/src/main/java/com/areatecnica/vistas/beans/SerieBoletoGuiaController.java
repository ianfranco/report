package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.SerieBoletoGuia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "serieBoletoGuiaController")
@ViewScoped
public class SerieBoletoGuiaController extends AbstractController<SerieBoletoGuia> {

    @Inject
    private BoletoController idBoletoController;
    @Inject
    private GuiaController idGuiaController;
    @Inject
    private MobilePageController mobilePageController;

    public SerieBoletoGuiaController() {
        // Inform the Abstract parent controller of the concrete SerieBoletoGuia Entity
        super(SerieBoletoGuia.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idBoletoController.setSelected(null);
        idGuiaController.setSelected(null);
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
}
