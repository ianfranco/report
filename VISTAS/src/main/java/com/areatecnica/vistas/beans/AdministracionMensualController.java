package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.AdministracionMensual;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "administracionMensualController")
@ViewScoped
public class AdministracionMensualController extends AbstractController<AdministracionMensual> {

    @Inject
    private MobilePageController mobilePageController;

    public AdministracionMensualController() {
        // Inform the Abstract parent controller of the concrete AdministracionMensual Entity
        super(AdministracionMensual.class);
    }

    /**
     * Sets the "items" attribute with a collection of DetalleIntervalosMensual
     * entities that are retrieved from AdministracionMensual?cap_first and
     * returns the navigation outcome.
     *
     * @return navigation outcome for DetalleIntervalosMensual page
     */
    public String navigateDetalleIntervalosMensualList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DetalleIntervalosMensual_items", this.getSelected().getDetalleIntervalosMensualList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/detalleIntervalosMensual/index";
    }

}
