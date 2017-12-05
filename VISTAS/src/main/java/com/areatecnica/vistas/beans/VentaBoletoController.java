package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.VentaBoleto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ventaBoletoController")
@ViewScoped
public class VentaBoletoController extends AbstractController<VentaBoleto> {

    @Inject
    private TerminalController idTerminalController;
    @Inject
    private MobilePageController mobilePageController;

    public VentaBoletoController() {
        // Inform the Abstract parent controller of the concrete VentaBoleto Entity
        super(VentaBoleto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTerminalController.setSelected(null);
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

    /**
     * Sets the "items" attribute with a collection of DetalleVentaBoleto
     * entities that are retrieved from VentaBoleto?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DetalleVentaBoleto page
     */
    public String navigateDetalleVentaBoletoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DetalleVentaBoleto_items", this.getSelected().getDetalleVentaBoletoList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/detalleVentaBoleto/index";
    }

}
