package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Usuario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    @Inject
    private RolController idRolController;
    @Inject
    private TerminalController idTerminalController;
    @Inject
    private MobilePageController mobilePageController;

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario Entity
        super(Usuario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idRolController.setSelected(null);
        idTerminalController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Despacho entities that
     * are retrieved from Usuario?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Despacho page
     */
    public String navigateDespachoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Despacho_items", this.getSelected().getDespachoList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/despacho/index";
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

    /**
     * Sets the "selected" attribute of the Terminal controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTerminal(ActionEvent event) {
        if (this.getSelected() != null && idTerminalController.getSelected() == null) {
            idTerminalController.setSelected(this.getSelected().getIdTerminal());
        }
    }
}
