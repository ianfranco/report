package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Flota;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "flotaController")
@ViewScoped
public class FlotaController extends AbstractController<Flota> {

    @Inject
    private MobilePageController mobilePageController;

    public FlotaController() {
        // Inform the Abstract parent controller of the concrete Flota Entity
        super(Flota.class);
    }

    /**
     * Sets the "items" attribute with a collection of Bus entities that are
     * retrieved from Flota?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Bus page
     */
    public String navigateBusList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Bus_items", this.getSelected().getBusList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/bus/index";
    }

}
