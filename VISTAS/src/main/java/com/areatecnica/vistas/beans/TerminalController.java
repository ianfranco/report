package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Terminal;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "terminalController")
@ViewScoped
public class TerminalController extends AbstractController<Terminal> {

    @Inject
    private MobilePageController mobilePageController;

    public TerminalController() {
        // Inform the Abstract parent controller of the concrete Terminal Entity
        super(Terminal.class);
    }

    /**
     * Sets the "items" attribute with a collection of InventarioTerminal
     * entities that are retrieved from Terminal?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for InventarioTerminal page
     */
    public String navigateInventarioTerminalList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("InventarioTerminal_items", this.getSelected().getInventarioTerminalList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/inventarioTerminal/index";
    }

    /**
     * Sets the "items" attribute with a collection of VentaBoleto entities that
     * are retrieved from Terminal?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for VentaBoleto page
     */
    public String navigateVentaBoletoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("VentaBoleto_items", this.getSelected().getVentaBoletoList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/ventaBoleto/index";
    }

    /**
     * Sets the "items" attribute with a collection of Usuario entities that are
     * retrieved from Terminal?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Usuario page
     */
    public String navigateUsuarioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuario_items", this.getSelected().getUsuarioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/usuario/index";
    }

    /**
     * Sets the "items" attribute with a collection of Bus entities that are
     * retrieved from Terminal?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Bus page
     */
    public String navigateBusList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Bus_items", this.getSelected().getBusList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/bus/index";
    }

    /**
     * Sets the "items" attribute with a collection of Servicio entities that
     * are retrieved from Terminal?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Servicio page
     */
    public String navigateServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Servicio_items", this.getSelected().getServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/servicio/index";
    }

    /**
     * Sets the "items" attribute with a collection of TrabajadorTerminal
     * entities that are retrieved from Terminal?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for TrabajadorTerminal page
     */
    public String navigateTrabajadorTerminalList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TrabajadorTerminal_items", this.getSelected().getTrabajadorTerminalList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/trabajadorTerminal/index";
    }

}
