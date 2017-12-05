package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.CalleServicio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "calleServicioController")
@ViewScoped
public class CalleServicioController extends AbstractController<CalleServicio> {

    @Inject
    private CalleController idCalleController;
    @Inject
    private ServicioController idServicioController;
    @Inject
    private MobilePageController mobilePageController;

    public CalleServicioController() {
        // Inform the Abstract parent controller of the concrete CalleServicio Entity
        super(CalleServicio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCalleController.setSelected(null);
        idServicioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Calle controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCalle(ActionEvent event) {
        if (this.getSelected() != null && idCalleController.getSelected() == null) {
            idCalleController.setSelected(this.getSelected().getIdCalle());
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
