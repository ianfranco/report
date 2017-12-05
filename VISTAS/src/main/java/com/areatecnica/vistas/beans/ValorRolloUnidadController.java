package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.ValorRolloUnidad;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "valorRolloUnidadController")
@ViewScoped
public class ValorRolloUnidadController extends AbstractController<ValorRolloUnidad> {

    @Inject
    private UnidadNegocioController idUnidadController;
    @Inject
    private MobilePageController mobilePageController;

    public ValorRolloUnidadController() {
        // Inform the Abstract parent controller of the concrete ValorRolloUnidad Entity
        super(ValorRolloUnidad.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idUnidadController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the UnidadNegocio controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdUnidad(ActionEvent event) {
        if (this.getSelected() != null && idUnidadController.getSelected() == null) {
            idUnidadController.setSelected(this.getSelected().getIdUnidad());
        }
    }
}
