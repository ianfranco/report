package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.HaberTrabajador;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "haberTrabajadorController")
@ViewScoped
public class HaberTrabajadorController extends AbstractController<HaberTrabajador> {

    @Inject
    private TipoHaberController idTipoHaberController;
    @Inject
    private TrabajadorController idTrabajadorController;
    @Inject
    private MobilePageController mobilePageController;

    public HaberTrabajadorController() {
        // Inform the Abstract parent controller of the concrete HaberTrabajador Entity
        super(HaberTrabajador.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoHaberController.setSelected(null);
        idTrabajadorController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoHaber controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoHaber(ActionEvent event) {
        if (this.getSelected() != null && idTipoHaberController.getSelected() == null) {
            idTipoHaberController.setSelected(this.getSelected().getIdTipoHaber());
        }
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
