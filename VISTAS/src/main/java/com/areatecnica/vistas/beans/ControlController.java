package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Control;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "controlController")
@ViewScoped
public class ControlController extends AbstractController<Control> {

    @Inject
    private TipoControlController idTipoControlController;
    @Inject
    private MobilePageController mobilePageController;

    public ControlController() {
        // Inform the Abstract parent controller of the concrete Control Entity
        super(Control.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoControlController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of ControlServicio entities
     * that are retrieved from Control?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ControlServicio page
     */
    public String navigateControlServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ControlServicio_items", this.getSelected().getControlServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/controlServicio/index";
    }

    /**
     * Sets the "selected" attribute of the TipoControl controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoControl(ActionEvent event) {
        if (this.getSelected() != null && idTipoControlController.getSelected() == null) {
            idTipoControlController.setSelected(this.getSelected().getIdTipoControl());
        }
    }
}
