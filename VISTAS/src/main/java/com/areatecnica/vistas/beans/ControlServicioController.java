package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.ControlServicio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "controlServicioController")
@ViewScoped
public class ControlServicioController extends AbstractController<ControlServicio> {

    @Inject
    private ControlController idControlController;
    @Inject
    private ServicioController idServicioController;
    @Inject
    private MobilePageController mobilePageController;

    public ControlServicioController() {
        // Inform the Abstract parent controller of the concrete ControlServicio Entity
        super(ControlServicio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idControlController.setSelected(null);
        idServicioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Control controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdControl(ActionEvent event) {
        if (this.getSelected() != null && idControlController.getSelected() == null) {
            idControlController.setSelected(this.getSelected().getIdControl());
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

    /**
     * Sets the "items" attribute with a collection of ControlHorarioServicio
     * entities that are retrieved from ControlServicio?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for ControlHorarioServicio page
     */
    public String navigateControlHorarioServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ControlHorarioServicio_items", this.getSelected().getControlHorarioServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/controlHorarioServicio/index";
    }

}
