package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.DiaTrabajador;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "diaTrabajadorController")
@ViewScoped
public class DiaTrabajadorController extends AbstractController<DiaTrabajador> {

    @Inject
    private TrabajadorController idTrabajadorController;
    @Inject
    private TipoDiaTrabajadorController idTipoDiaTrabajadorController;
    @Inject
    private MobilePageController mobilePageController;

    public DiaTrabajadorController() {
        // Inform the Abstract parent controller of the concrete DiaTrabajador Entity
        super(DiaTrabajador.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTrabajadorController.setSelected(null);
        idTipoDiaTrabajadorController.setSelected(null);
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

    /**
     * Sets the "selected" attribute of the TipoDiaTrabajador controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoDiaTrabajador(ActionEvent event) {
        if (this.getSelected() != null && idTipoDiaTrabajadorController.getSelected() == null) {
            idTipoDiaTrabajadorController.setSelected(this.getSelected().getIdTipoDiaTrabajador());
        }
    }
}
