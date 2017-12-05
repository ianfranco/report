package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.MontoSindicatoTrabajador;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "montoSindicatoTrabajadorController")
@ViewScoped
public class MontoSindicatoTrabajadorController extends AbstractController<MontoSindicatoTrabajador> {

    @Inject
    private SindicatoTrabajadorController idSindicatoTrabajadorController;
    @Inject
    private MobilePageController mobilePageController;

    public MontoSindicatoTrabajadorController() {
        // Inform the Abstract parent controller of the concrete MontoSindicatoTrabajador Entity
        super(MontoSindicatoTrabajador.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idSindicatoTrabajadorController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the SindicatoTrabajador controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdSindicatoTrabajador(ActionEvent event) {
        if (this.getSelected() != null && idSindicatoTrabajadorController.getSelected() == null) {
            idSindicatoTrabajadorController.setSelected(this.getSelected().getIdSindicatoTrabajador());
        }
    }
}
