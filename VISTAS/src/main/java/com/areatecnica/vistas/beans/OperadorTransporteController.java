package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.OperadorTransporte;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "operadorTransporteController")
@ViewScoped
public class OperadorTransporteController extends AbstractController<OperadorTransporte> {

    @Inject
    private MobilePageController mobilePageController;

    public OperadorTransporteController() {
        // Inform the Abstract parent controller of the concrete OperadorTransporte Entity
        super(OperadorTransporte.class);
    }

    /**
     * Sets the "items" attribute with a collection of UnidadNegocio entities
     * that are retrieved from OperadorTransporte?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for UnidadNegocio page
     */
    public String navigateUnidadNegocioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("UnidadNegocio_items", this.getSelected().getUnidadNegocioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/unidadNegocio/index";
    }

}
