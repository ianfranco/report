package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.MarcaBus;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "marcaBusController")
@ViewScoped
public class MarcaBusController extends AbstractController<MarcaBus> {

    @Inject
    private MobilePageController mobilePageController;

    public MarcaBusController() {
        // Inform the Abstract parent controller of the concrete MarcaBus Entity
        super(MarcaBus.class);
    }

    /**
     * Sets the "items" attribute with a collection of ModeloMarcaBus entities
     * that are retrieved from MarcaBus?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ModeloMarcaBus page
     */
    public String navigateModeloMarcaBusList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ModeloMarcaBus_items", this.getSelected().getModeloMarcaBusList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/modeloMarcaBus/index";
    }

}
