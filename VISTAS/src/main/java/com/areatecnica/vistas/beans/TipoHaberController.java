package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.TipoHaber;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoHaberController")
@ViewScoped
public class TipoHaberController extends AbstractController<TipoHaber> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoHaberController() {
        // Inform the Abstract parent controller of the concrete TipoHaber Entity
        super(TipoHaber.class);
    }

    /**
     * Sets the "items" attribute with a collection of HaberTrabajador entities
     * that are retrieved from TipoHaber?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for HaberTrabajador page
     */
    public String navigateHaberTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("HaberTrabajador_items", this.getSelected().getHaberTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/haberTrabajador/index";
    }

}
