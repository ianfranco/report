package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.DetalleIntervalosMensual;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "detalleIntervalosMensualController")
@ViewScoped
public class DetalleIntervalosMensualController extends AbstractController<DetalleIntervalosMensual> {

    @Inject
    private AdministracionMensualController idAdministracionMensualController;
    @Inject
    private IntervalosAdministracionController idIntervaloAdministracionController;
    @Inject
    private MobilePageController mobilePageController;

    public DetalleIntervalosMensualController() {
        // Inform the Abstract parent controller of the concrete DetalleIntervalosMensual Entity
        super(DetalleIntervalosMensual.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idAdministracionMensualController.setSelected(null);
        idIntervaloAdministracionController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the AdministracionMensual controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdAdministracionMensual(ActionEvent event) {
        if (this.getSelected() != null && idAdministracionMensualController.getSelected() == null) {
            idAdministracionMensualController.setSelected(this.getSelected().getIdAdministracionMensual());
        }
    }

    /**
     * Sets the "selected" attribute of the IntervalosAdministracion controller
     * in order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdIntervaloAdministracion(ActionEvent event) {
        if (this.getSelected() != null && idIntervaloAdministracionController.getSelected() == null) {
            idIntervaloAdministracionController.setSelected(this.getSelected().getIdIntervaloAdministracion());
        }
    }
}
