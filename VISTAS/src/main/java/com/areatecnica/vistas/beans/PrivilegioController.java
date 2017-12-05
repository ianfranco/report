package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Privilegio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "privilegioController")
@ViewScoped
public class PrivilegioController extends AbstractController<Privilegio> {

    @Inject
    private RolController idRolController;
    @Inject
    private MobilePageController mobilePageController;

    public PrivilegioController() {
        // Inform the Abstract parent controller of the concrete Privilegio Entity
        super(Privilegio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idRolController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Rol controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdRol(ActionEvent event) {
        if (this.getSelected() != null && idRolController.getSelected() == null) {
            idRolController.setSelected(this.getSelected().getIdRol());
        }
    }
}
