package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Mutual;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "mutualController")
@ViewScoped
public class MutualController extends AbstractController<Mutual> {

    @Inject
    private MobilePageController mobilePageController;

    public MutualController() {
        // Inform the Abstract parent controller of the concrete Mutual Entity
        super(Mutual.class);
    }

    /**
     * Sets the "items" attribute with a collection of Empresa entities that are
     * retrieved from Mutual?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Empresa page
     */
    public String navigateEmpresaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Empresa_items", this.getSelected().getEmpresaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/empresa/index";
    }

}
