package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Departamento;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "departamentoController")
@ViewScoped
public class DepartamentoController extends AbstractController<Departamento> {

    @Inject
    private MobilePageController mobilePageController;

    public DepartamentoController() {
        // Inform the Abstract parent controller of the concrete Departamento Entity
        super(Departamento.class);
    }

    /**
     * Sets the "items" attribute with a collection of
     * GastosAdministracionMensual entities that are retrieved from
     * Departamento?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for GastosAdministracionMensual page
     */
    public String navigateGastosAdministracionMensualList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("GastosAdministracionMensual_items", this.getSelected().getGastosAdministracionMensualList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/gastosAdministracionMensual/index";
    }

}
