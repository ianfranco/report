package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.EgresoGuia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "egresoGuiaController")
@ViewScoped
public class EgresoGuiaController extends AbstractController<EgresoGuia> {

    @Inject
    private EgresoServicioController idEgresoServicioController;
    @Inject
    private GuiaController idGuiaController;
    @Inject
    private MobilePageController mobilePageController;

    public EgresoGuiaController() {
        // Inform the Abstract parent controller of the concrete EgresoGuia Entity
        super(EgresoGuia.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEgresoServicioController.setSelected(null);
        idGuiaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the EgresoServicio controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEgresoServicio(ActionEvent event) {
        if (this.getSelected() != null && idEgresoServicioController.getSelected() == null) {
            idEgresoServicioController.setSelected(this.getSelected().getIdEgresoServicio());
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
