package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.CentroCosto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "centroCostoController")
@ViewScoped
public class CentroCostoController extends AbstractController<CentroCosto> {

    @Inject
    private MobilePageController mobilePageController;

    public CentroCostoController() {
        // Inform the Abstract parent controller of the concrete CentroCosto Entity
        super(CentroCosto.class);
    }

    /**
     * Sets the "items" attribute with a collection of CentroCostoTrabajador
     * entities that are retrieved from CentroCosto?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CentroCostoTrabajador page
     */
    public String navigateCentroCostoTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CentroCostoTrabajador_items", this.getSelected().getCentroCostoTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/centroCostoTrabajador/index";
    }

}
