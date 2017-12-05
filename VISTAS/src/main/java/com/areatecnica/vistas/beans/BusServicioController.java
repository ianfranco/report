package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.BusServicio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "busServicioController")
@ViewScoped
public class BusServicioController extends AbstractController<BusServicio> {

    @Inject
    private BusController idBusController;
    @Inject
    private ServicioController idServicioController;
    @Inject
    private MobilePageController mobilePageController;

    public BusServicioController() {
        // Inform the Abstract parent controller of the concrete BusServicio Entity
        super(BusServicio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idBusController.setSelected(null);
        idServicioController.setSelected(null);
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
     * Sets the "selected" attribute of the Servicio controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdServicio(ActionEvent event) {
        if (this.getSelected() != null && idServicioController.getSelected() == null) {
            idServicioController.setSelected(this.getSelected().getIdServicio());
        }
    }
}
