package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.TipoCarga;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoCargaController")
@ViewScoped
public class TipoCargaController extends AbstractController<TipoCarga> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoCargaController() {
        // Inform the Abstract parent controller of the concrete TipoCarga Entity
        super(TipoCarga.class);
    }

    /**
     * Sets the "items" attribute with a collection of CargasTrabajador entities
     * that are retrieved from TipoCarga?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CargasTrabajador page
     */
    public String navigateCargasTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CargasTrabajador_items", this.getSelected().getCargasTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/cargasTrabajador/index";
    }

}
