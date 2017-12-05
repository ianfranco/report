package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.TipoEstacionalidad;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoEstacionalidadController")
@ViewScoped
public class TipoEstacionalidadController extends AbstractController<TipoEstacionalidad> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoEstacionalidadController() {
        // Inform the Abstract parent controller of the concrete TipoEstacionalidad Entity
        super(TipoEstacionalidad.class);
    }

    /**
     * Sets the "items" attribute with a collection of HorarioServicio entities
     * that are retrieved from TipoEstacionalidad?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for HorarioServicio page
     */
    public String navigateHorarioServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("HorarioServicio_items", this.getSelected().getHorarioServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/horarioServicio/index";
    }

}
