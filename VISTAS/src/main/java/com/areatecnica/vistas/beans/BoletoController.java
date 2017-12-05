package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Boleto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "boletoController")
@ViewScoped
public class BoletoController extends AbstractController<Boleto> {

    @Inject
    private MobilePageController mobilePageController;

    public BoletoController() {
        // Inform the Abstract parent controller of the concrete Boleto Entity
        super(Boleto.class);
    }

    /**
     * Sets the "items" attribute with a collection of InventarioTerminal
     * entities that are retrieved from Boleto?cap_first and returns the
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
     * Sets the "items" attribute with a collection of SerieBoletoGuia entities
     * that are retrieved from Boleto?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for SerieBoletoGuia page
     */
    public String navigateSerieBoletoGuiaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SerieBoletoGuia_items", this.getSelected().getSerieBoletoGuiaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/serieBoletoGuia/index";
    }

    /**
     * Sets the "items" attribute with a collection of InventarioInterno
     * entities that are retrieved from Boleto?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for InventarioInterno page
     */
    public String navigateInventarioInternoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("InventarioInterno_items", this.getSelected().getInventarioInternoList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/inventarioInterno/index";
    }

    /**
     * Sets the "items" attribute with a collection of DetalleCompraBoleto
     * entities that are retrieved from Boleto?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DetalleCompraBoleto page
     */
    public String navigateDetalleCompraBoletoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DetalleCompraBoleto_items", this.getSelected().getDetalleCompraBoletoList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/detalleCompraBoleto/index";
    }

    /**
     * Sets the "items" attribute with a collection of TarifaServicio entities
     * that are retrieved from Boleto?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TarifaServicio page
     */
    public String navigateTarifaServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TarifaServicio_items", this.getSelected().getTarifaServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/tarifaServicio/index";
    }

}
