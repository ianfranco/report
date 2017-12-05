package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.AsignacionFamiliar;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "asignacionFamiliarController")
@ViewScoped
public class AsignacionFamiliarController extends AbstractController<AsignacionFamiliar> {

    @Inject
    private MobilePageController mobilePageController;

    public AsignacionFamiliarController() {
        // Inform the Abstract parent controller of the concrete AsignacionFamiliar Entity
        super(AsignacionFamiliar.class);
    }

    /**
     * Sets the "items" attribute with a collection of Trabajador entities that
     * are retrieved from AsignacionFamiliar?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Trabajador page
     */
    public String navigateTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Trabajador_items", this.getSelected().getTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/trabajador/index";
    }

}
