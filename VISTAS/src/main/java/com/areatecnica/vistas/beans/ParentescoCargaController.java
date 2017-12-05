package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.ParentescoCarga;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "parentescoCargaController")
@ViewScoped
public class ParentescoCargaController extends AbstractController<ParentescoCarga> {

    @Inject
    private MobilePageController mobilePageController;

    public ParentescoCargaController() {
        // Inform the Abstract parent controller of the concrete ParentescoCarga Entity
        super(ParentescoCarga.class);
    }

    /**
     * Sets the "items" attribute with a collection of CargasTrabajador entities
     * that are retrieved from ParentescoCarga?cap_first and returns the
     * navigation outcome.
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
