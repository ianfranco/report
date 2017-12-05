package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.AbonoBus;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "abonoBusController")
@ViewScoped
public class AbonoBusController extends AbstractController<AbonoBus> {

    @Inject
    private BusController idBusController;
    @Inject
    private TipoAbonoController idTipoAbonoController;
    @Inject
    private MobilePageController mobilePageController;

    public AbonoBusController() {
        // Inform the Abstract parent controller of the concrete AbonoBus Entity
        super(AbonoBus.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idBusController.setSelected(null);
        idTipoAbonoController.setSelected(null);
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
     * Sets the "selected" attribute of the TipoAbono controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoAbono(ActionEvent event) {
        if (this.getSelected() != null && idTipoAbonoController.getSelected() == null) {
            idTipoAbonoController.setSelected(this.getSelected().getIdTipoAbono());
        }
    }
}
