package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.CentroCostoTrabajador;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "centroCostoTrabajadorController")
@ViewScoped
public class CentroCostoTrabajadorController extends AbstractController<CentroCostoTrabajador> {

    @Inject
    private CentroCostoController idCentroCostoController;
    @Inject
    private TrabajadorController idTrabajadorController;
    @Inject
    private MobilePageController mobilePageController;

    public CentroCostoTrabajadorController() {
        // Inform the Abstract parent controller of the concrete CentroCostoTrabajador Entity
        super(CentroCostoTrabajador.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCentroCostoController.setSelected(null);
        idTrabajadorController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the CentroCosto controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCentroCosto(ActionEvent event) {
        if (this.getSelected() != null && idCentroCostoController.getSelected() == null) {
            idCentroCostoController.setSelected(this.getSelected().getIdCentroCosto());
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
