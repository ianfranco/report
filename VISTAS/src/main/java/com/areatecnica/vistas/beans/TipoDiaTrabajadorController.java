package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.TipoDiaTrabajador;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoDiaTrabajadorController")
@ViewScoped
public class TipoDiaTrabajadorController extends AbstractController<TipoDiaTrabajador> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoDiaTrabajadorController() {
        // Inform the Abstract parent controller of the concrete TipoDiaTrabajador Entity
        super(TipoDiaTrabajador.class);
    }

    /**
     * Sets the "items" attribute with a collection of DiaTrabajador entities
     * that are retrieved from TipoDiaTrabajador?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DiaTrabajador page
     */
    public String navigateDiaTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DiaTrabajador_items", this.getSelected().getDiaTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/diaTrabajador/index";
    }

}
