package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.InventarioInterno;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "inventarioInternoController")
@ViewScoped
public class InventarioInternoController extends AbstractController<InventarioInterno> {

    @Inject
    private BoletoController idBoletoController;
    @Inject
    private MobilePageController mobilePageController;

    public InventarioInternoController() {
        // Inform the Abstract parent controller of the concrete InventarioInterno Entity
        super(InventarioInterno.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idBoletoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Boleto controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdBoleto(ActionEvent event) {
        if (this.getSelected() != null && idBoletoController.getSelected() == null) {
            idBoletoController.setSelected(this.getSelected().getIdBoleto());
        }
    }

    /**
     * Sets the "items" attribute with a collection of DetalleVentaBoleto
     * entities that are retrieved from InventarioInterno?cap_first and returns
     * the navigation outcome.
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
