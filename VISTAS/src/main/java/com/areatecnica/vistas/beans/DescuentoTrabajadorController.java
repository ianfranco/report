package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.DescuentoTrabajador;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "descuentoTrabajadorController")
@ViewScoped
public class DescuentoTrabajadorController extends AbstractController<DescuentoTrabajador> {

    @Inject
    private TipoDescuentoController idTipoDescuentoController;
    @Inject
    private TrabajadorController idTrabajadorController;
    @Inject
    private MobilePageController mobilePageController;

    public DescuentoTrabajadorController() {
        // Inform the Abstract parent controller of the concrete DescuentoTrabajador Entity
        super(DescuentoTrabajador.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoDescuentoController.setSelected(null);
        idTrabajadorController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoDescuento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoDescuento(ActionEvent event) {
        if (this.getSelected() != null && idTipoDescuentoController.getSelected() == null) {
            idTipoDescuentoController.setSelected(this.getSelected().getIdTipoDescuento());
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
