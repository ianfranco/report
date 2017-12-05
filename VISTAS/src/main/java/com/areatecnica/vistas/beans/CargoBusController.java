package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.CargoBus;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cargoBusController")
@ViewScoped
public class CargoBusController extends AbstractController<CargoBus> {

    @Inject
    private BusController idBusController;
    @Inject
    private TipoCargoController idTipoCargoController;
    @Inject
    private MobilePageController mobilePageController;

    public CargoBusController() {
        // Inform the Abstract parent controller of the concrete CargoBus Entity
        super(CargoBus.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idBusController.setSelected(null);
        idTipoCargoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Bus controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdBus(ActionEvent event) {
        if (this.getSelected() != null && idBusController.getSelected() == null) {
            idBusController.setSelected(this.getSelected().getIdBus());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoCargo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoCargo(ActionEvent event) {
        if (this.getSelected() != null && idTipoCargoController.getSelected() == null) {
            idTipoCargoController.setSelected(this.getSelected().getIdTipoCargo());
        }
    }
}
