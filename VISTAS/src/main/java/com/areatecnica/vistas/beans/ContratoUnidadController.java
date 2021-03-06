package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.ContratoUnidad;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "contratoUnidadController")
@ViewScoped
public class ContratoUnidadController extends AbstractController<ContratoUnidad> {

    @Inject
    private UnidadNegocioController idUnidadNegocioController;
    @Inject
    private MobilePageController mobilePageController;

    public ContratoUnidadController() {
        // Inform the Abstract parent controller of the concrete ContratoUnidad Entity
        super(ContratoUnidad.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idUnidadNegocioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the UnidadNegocio controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdUnidadNegocio(ActionEvent event) {
        if (this.getSelected() != null && idUnidadNegocioController.getSelected() == null) {
            idUnidadNegocioController.setSelected(this.getSelected().getIdUnidadNegocio());
        }
    }
}
