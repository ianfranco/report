package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.CausalFiniquito;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "causalFiniquitoController")
@ViewScoped
public class CausalFiniquitoController extends AbstractController<CausalFiniquito> {

    @Inject
    private MobilePageController mobilePageController;

    public CausalFiniquitoController() {
        // Inform the Abstract parent controller of the concrete CausalFiniquito Entity
        super(CausalFiniquito.class);
    }

    /**
     * Sets the "items" attribute with a collection of FiniquitoRelacionLaboral
     * entities that are retrieved from CausalFiniquito?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for FiniquitoRelacionLaboral page
     */
    public String navigateFiniquitoRelacionLaboralList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FiniquitoRelacionLaboral_items", this.getSelected().getFiniquitoRelacionLaboralList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/finiquitoRelacionLaboral/index";
    }

}
