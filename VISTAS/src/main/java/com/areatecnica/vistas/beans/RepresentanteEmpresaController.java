package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.RepresentanteEmpresa;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "representanteEmpresaController")
@ViewScoped
public class RepresentanteEmpresaController extends AbstractController<RepresentanteEmpresa> {

    @Inject
    private EmpresaController idEmpresaController;
    @Inject
    private RepresentanteLegalController idRepresentanteLegalController;
    @Inject
    private MobilePageController mobilePageController;

    public RepresentanteEmpresaController() {
        // Inform the Abstract parent controller of the concrete RepresentanteEmpresa Entity
        super(RepresentanteEmpresa.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEmpresaController.setSelected(null);
        idRepresentanteLegalController.setSelected(null);
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

    /**
     * Sets the "selected" attribute of the RepresentanteLegal controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdRepresentanteLegal(ActionEvent event) {
        if (this.getSelected() != null && idRepresentanteLegalController.getSelected() == null) {
            idRepresentanteLegalController.setSelected(this.getSelected().getIdRepresentanteLegal());
        }
    }
}
