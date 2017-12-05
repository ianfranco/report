package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.ControlHorarioServicio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "controlHorarioServicioController")
@ViewScoped
public class ControlHorarioServicioController extends AbstractController<ControlHorarioServicio> {

    @Inject
    private ControlServicioController idControlServicioController;
    @Inject
    private HorarioServicioController idHorarioServicioController;
    @Inject
    private MobilePageController mobilePageController;

    public ControlHorarioServicioController() {
        // Inform the Abstract parent controller of the concrete ControlHorarioServicio Entity
        super(ControlHorarioServicio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idControlServicioController.setSelected(null);
        idHorarioServicioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the ControlServicio controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdControlServicio(ActionEvent event) {
        if (this.getSelected() != null && idControlServicioController.getSelected() == null) {
            idControlServicioController.setSelected(this.getSelected().getIdControlServicio());
        }
    }

    /**
     * Sets the "selected" attribute of the HorarioServicio controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdHorarioServicio(ActionEvent event) {
        if (this.getSelected() != null && idHorarioServicioController.getSelected() == null) {
            idHorarioServicioController.setSelected(this.getSelected().getIdHorarioServicio());
        }
    }
}
