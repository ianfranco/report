package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.MonedaPactadaInstitucionSalud;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "monedaPactadaInstitucionSaludController")
@ViewScoped
public class MonedaPactadaInstitucionSaludController extends AbstractController<MonedaPactadaInstitucionSalud> {

    @Inject
    private MobilePageController mobilePageController;

    public MonedaPactadaInstitucionSaludController() {
        // Inform the Abstract parent controller of the concrete MonedaPactadaInstitucionSalud Entity
        super(MonedaPactadaInstitucionSalud.class);
    }

    /**
     * Sets the "items" attribute with a collection of Trabajador entities that
     * are retrieved from MonedaPactadaInstitucionSalud?cap_first and returns
     * the navigation outcome.
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
