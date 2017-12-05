package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.CajaCompensacion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "cajaCompensacionController")
@ViewScoped
public class CajaCompensacionController extends AbstractController<CajaCompensacion> {

    @Inject
    private MobilePageController mobilePageController;

    public CajaCompensacionController() {
        // Inform the Abstract parent controller of the concrete CajaCompensacion Entity
        super(CajaCompensacion.class);
    }

    /**
     * Sets the "items" attribute with a collection of Empresa entities that are
     * retrieved from CajaCompensacion?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Empresa page
     */
    public String navigateEmpresaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Empresa_items", this.getSelected().getEmpresaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/empresa/index";
    }

}
