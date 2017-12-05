package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.TipoDemanda;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoDemandaController")
@ViewScoped
public class TipoDemandaController extends AbstractController<TipoDemanda> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoDemandaController() {
        // Inform the Abstract parent controller of the concrete TipoDemanda Entity
        super(TipoDemanda.class);
    }

    /**
     * Sets the "items" attribute with a collection of FrecuenciaServicio
     * entities that are retrieved from TipoDemanda?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for FrecuenciaServicio page
     */
    public String navigateFrecuenciaServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FrecuenciaServicio_items", this.getSelected().getFrecuenciaServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/frecuenciaServicio/index";
    }

}
