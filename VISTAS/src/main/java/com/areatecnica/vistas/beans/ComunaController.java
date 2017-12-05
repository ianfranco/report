package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Comuna;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "comunaController")
@ViewScoped
public class ComunaController extends AbstractController<Comuna> {

    @Inject
    private RegionController idRegionController;
    @Inject
    private MobilePageController mobilePageController;

    public ComunaController() {
        // Inform the Abstract parent controller of the concrete Comuna Entity
        super(Comuna.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idRegionController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Calle entities that are
     * retrieved from Comuna?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Calle page
     */
    public String navigateCalleList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Calle_items", this.getSelected().getCalleList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/calle/index";
    }

    /**
     * Sets the "selected" attribute of the Region controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdRegion(ActionEvent event) {
        if (this.getSelected() != null && idRegionController.getSelected() == null) {
            idRegionController.setSelected(this.getSelected().getIdRegion());
        }
    }
}
