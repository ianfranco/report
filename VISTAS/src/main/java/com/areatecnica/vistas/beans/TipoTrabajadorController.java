package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.TipoTrabajador;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoTrabajadorController")
@ViewScoped
public class TipoTrabajadorController extends AbstractController<TipoTrabajador> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoTrabajadorController() {
        // Inform the Abstract parent controller of the concrete TipoTrabajador Entity
        super(TipoTrabajador.class);
    }

    /**
     * Sets the "items" attribute with a collection of RelacionLaboral entities
     * that are retrieved from TipoTrabajador?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for RelacionLaboral page
     */
    public String navigateRelacionLaboralList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RelacionLaboral_items", this.getSelected().getRelacionLaboralList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/relacionLaboral/index";
    }

}
