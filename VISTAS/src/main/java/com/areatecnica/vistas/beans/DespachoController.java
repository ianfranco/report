package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Despacho;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "despachoController")
@ViewScoped
public class DespachoController extends AbstractController<Despacho> {

    @Inject
    private BusController idBusController;
    @Inject
    private TrabajadorController idTrabajadorController;
    @Inject
    private UsuarioController idInspectorController;
    @Inject
    private ServicioController idServicioController;
    @Inject
    private MobilePageController mobilePageController;

    public DespachoController() {
        // Inform the Abstract parent controller of the concrete Despacho Entity
        super(Despacho.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idBusController.setSelected(null);
        idTrabajadorController.setSelected(null);
        idInspectorController.setSelected(null);
        idServicioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Bus controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdBus(ActionEvent event) {
        if (this.getSelected() != null && idBusController.getSelected() == null) {
            idBusController.setSelected(this.getSelected().getIdBus());
        }
    }

    /**
     * Sets the "selected" attribute of the Trabajador controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTrabajador(ActionEvent event) {
        if (this.getSelected() != null && idTrabajadorController.getSelected() == null) {
            idTrabajadorController.setSelected(this.getSelected().getIdTrabajador());
        }
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdInspector(ActionEvent event) {
        if (this.getSelected() != null && idInspectorController.getSelected() == null) {
            idInspectorController.setSelected(this.getSelected().getIdInspector());
        }
    }

    /**
     * Sets the "selected" attribute of the Servicio controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdServicio(ActionEvent event) {
        if (this.getSelected() != null && idServicioController.getSelected() == null) {
            idServicioController.setSelected(this.getSelected().getIdServicio());
        }
    }
}
