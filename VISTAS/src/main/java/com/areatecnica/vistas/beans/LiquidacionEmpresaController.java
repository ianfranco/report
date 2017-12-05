package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.LiquidacionEmpresa;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "liquidacionEmpresaController")
@ViewScoped
public class LiquidacionEmpresaController extends AbstractController<LiquidacionEmpresa> {

    @Inject
    private EmpresaController idEmpresaController;
    @Inject
    private MobilePageController mobilePageController;

    public LiquidacionEmpresaController() {
        // Inform the Abstract parent controller of the concrete LiquidacionEmpresa Entity
        super(LiquidacionEmpresa.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEmpresaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Empresa controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEmpresa(ActionEvent event) {
        if (this.getSelected() != null && idEmpresaController.getSelected() == null) {
            idEmpresaController.setSelected(this.getSelected().getIdEmpresa());
        }
    }
}
