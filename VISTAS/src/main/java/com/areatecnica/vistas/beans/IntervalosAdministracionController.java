package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.IntervalosAdministracion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "intervalosAdministracionController")
@ViewScoped
public class IntervalosAdministracionController extends AbstractController<IntervalosAdministracion> {

    @Inject
    private MobilePageController mobilePageController;

    public IntervalosAdministracionController() {
        // Inform the Abstract parent controller of the concrete IntervalosAdministracion Entity
        super(IntervalosAdministracion.class);
    }

    /**
     * Sets the "items" attribute with a collection of DetalleIntervalosMensual
     * entities that are retrieved from IntervalosAdministracion?cap_first and
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
