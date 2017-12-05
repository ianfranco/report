package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.InstitucionSalud;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "institucionSaludController")
@ViewScoped
public class InstitucionSaludController extends AbstractController<InstitucionSalud> {

    @Inject
    private MobilePageController mobilePageController;

    public InstitucionSaludController() {
        // Inform the Abstract parent controller of the concrete InstitucionSalud Entity
        super(InstitucionSalud.class);
    }

    /**
     * Sets the "items" attribute with a collection of Trabajador entities that
     * are retrieved from InstitucionSalud?cap_first and returns the navigation
     * outcome.
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
