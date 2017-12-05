package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.PeriodoFrecuencia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "periodoFrecuenciaController")
@ViewScoped
public class PeriodoFrecuenciaController extends AbstractController<PeriodoFrecuencia> {

    @Inject
    private MobilePageController mobilePageController;

    public PeriodoFrecuenciaController() {
        // Inform the Abstract parent controller of the concrete PeriodoFrecuencia Entity
        super(PeriodoFrecuencia.class);
    }

    /**
     * Sets the "items" attribute with a collection of FrecuenciaServicio
     * entities that are retrieved from PeriodoFrecuencia?cap_first and returns
     * the navigation outcome.
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
