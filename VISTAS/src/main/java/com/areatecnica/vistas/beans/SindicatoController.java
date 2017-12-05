package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Sindicato;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "sindicatoController")
@ViewScoped
public class SindicatoController extends AbstractController<Sindicato> {

    @Inject
    private MobilePageController mobilePageController;

    public SindicatoController() {
        // Inform the Abstract parent controller of the concrete Sindicato Entity
        super(Sindicato.class);
    }

    /**
     * Sets the "items" attribute with a collection of SindicatoTrabajador
     * entities that are retrieved from Sindicato?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for SindicatoTrabajador page
     */
    public String navigateSindicatoTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SindicatoTrabajador_items", this.getSelected().getSindicatoTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/sindicatoTrabajador/index";
    }

}
