package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Calle;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "calleController")
@ViewScoped
public class CalleController extends AbstractController<Calle> {

    @Inject
    private ComunaController idComunaController;
    @Inject
    private MobilePageController mobilePageController;

    public CalleController() {
        // Inform the Abstract parent controller of the concrete Calle Entity
        super(Calle.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idComunaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of CalleServicio entities
     * that are retrieved from Calle?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CalleServicio page
     */
    public String navigateCalleServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CalleServicio_items", this.getSelected().getCalleServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/calleServicio/index";
    }

    /**
     * Sets the "selected" attribute of the Comuna controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdComuna(ActionEvent event) {
        if (this.getSelected() != null && idComunaController.getSelected() == null) {
            idComunaController.setSelected(this.getSelected().getIdComuna());
        }
    }
}
