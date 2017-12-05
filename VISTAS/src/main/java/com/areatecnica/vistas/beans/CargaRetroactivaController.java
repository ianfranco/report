package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.CargaRetroactiva;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cargaRetroactivaController")
@ViewScoped
public class CargaRetroactivaController extends AbstractController<CargaRetroactiva> {

    @Inject
    private CargasTrabajadorController idCargaTrabajadorController;
    @Inject
    private TrabajadorController idTrabajadorController;
    @Inject
    private MobilePageController mobilePageController;

    public CargaRetroactivaController() {
        // Inform the Abstract parent controller of the concrete CargaRetroactiva Entity
        super(CargaRetroactiva.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCargaTrabajadorController.setSelected(null);
        idTrabajadorController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the CargasTrabajador controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCargaTrabajador(ActionEvent event) {
        if (this.getSelected() != null && idCargaTrabajadorController.getSelected() == null) {
            idCargaTrabajadorController.setSelected(this.getSelected().getIdCargaTrabajador());
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
}
