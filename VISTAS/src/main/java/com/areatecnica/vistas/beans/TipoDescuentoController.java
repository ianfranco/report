package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.TipoDescuento;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoDescuentoController")
@ViewScoped
public class TipoDescuentoController extends AbstractController<TipoDescuento> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoDescuentoController() {
        // Inform the Abstract parent controller of the concrete TipoDescuento Entity
        super(TipoDescuento.class);
    }

    /**
     * Sets the "items" attribute with a collection of DescuentoTrabajador
     * entities that are retrieved from TipoDescuento?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DescuentoTrabajador page
     */
    public String navigateDescuentoTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DescuentoTrabajador_items", this.getSelected().getDescuentoTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/descuentoTrabajador/index";
    }

}
