package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.GastosAdministracionMensual;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "gastosAdministracionMensualController")
@ViewScoped
public class GastosAdministracionMensualController extends AbstractController<GastosAdministracionMensual> {

    @Inject
    private DepartamentoController idDepartamentoController;
    @Inject
    private MobilePageController mobilePageController;

    public GastosAdministracionMensualController() {
        // Inform the Abstract parent controller of the concrete GastosAdministracionMensual Entity
        super(GastosAdministracionMensual.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDepartamentoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Departamento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDepartamento(ActionEvent event) {
        if (this.getSelected() != null && idDepartamentoController.getSelected() == null) {
            idDepartamentoController.setSelected(this.getSelected().getIdDepartamento());
        }
    }
}
