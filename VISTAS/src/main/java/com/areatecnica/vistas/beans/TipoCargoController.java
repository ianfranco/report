package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.TipoCargo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoCargoController")
@ViewScoped
public class TipoCargoController extends AbstractController<TipoCargo> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoCargoController() {
        // Inform the Abstract parent controller of the concrete TipoCargo Entity
        super(TipoCargo.class);
    }

    /**
     * Sets the "items" attribute with a collection of CargoBus entities that
     * are retrieved from TipoCargo?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CargoBus page
     */
    public String navigateCargoBusList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CargoBus_items", this.getSelected().getCargoBusList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/cargoBus/index";
    }

}
