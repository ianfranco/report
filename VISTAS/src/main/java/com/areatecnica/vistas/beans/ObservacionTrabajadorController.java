package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.ObservacionTrabajador;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "observacionTrabajadorController")
@ViewScoped
public class ObservacionTrabajadorController extends AbstractController<ObservacionTrabajador> {

    @Inject
    private TrabajadorController idTrabajadorController;
    @Inject
    private MobilePageController mobilePageController;

    public ObservacionTrabajadorController() {
        // Inform the Abstract parent controller of the concrete ObservacionTrabajador Entity
        super(ObservacionTrabajador.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTrabajadorController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Trabajador controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTrabajador(ActionEvent event) {
        if (this.getSelected() != null && idTrabajadorController.getSelected() == null) {
            idTrabajadorController.setSelected(this.getSelected().getIdTrabajador());
        }
    }
}
