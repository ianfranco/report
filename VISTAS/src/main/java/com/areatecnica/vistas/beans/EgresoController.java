package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Egreso;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "egresoController")
@ViewScoped
public class EgresoController extends AbstractController<Egreso> {

    @Inject
    private MobilePageController mobilePageController;

    public EgresoController() {
        // Inform the Abstract parent controller of the concrete Egreso Entity
        super(Egreso.class);
    }

    /**
     * Sets the "items" attribute with a collection of EgresoServicio entities
     * that are retrieved from Egreso?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for EgresoServicio page
     */
    public String navigateEgresoServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EgresoServicio_items", this.getSelected().getEgresoServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/egresoServicio/index";
    }

}
