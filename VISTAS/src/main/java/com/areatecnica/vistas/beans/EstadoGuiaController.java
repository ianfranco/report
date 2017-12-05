package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.EstadoGuia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "estadoGuiaController")
@ViewScoped
public class EstadoGuiaController extends AbstractController<EstadoGuia> {

    @Inject
    private MobilePageController mobilePageController;

    public EstadoGuiaController() {
        // Inform the Abstract parent controller of the concrete EstadoGuia Entity
        super(EstadoGuia.class);
    }

    /**
     * Sets the "items" attribute with a collection of Guia entities that are
     * retrieved from EstadoGuia?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Guia page
     */
    public String navigateGuiaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Guia_items", this.getSelected().getGuiaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/guia/index";
    }

}
