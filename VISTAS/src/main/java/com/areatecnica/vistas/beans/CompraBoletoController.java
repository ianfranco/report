package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.CompraBoleto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "compraBoletoController")
@ViewScoped
public class CompraBoletoController extends AbstractController<CompraBoleto> {

    @Inject
    private MobilePageController mobilePageController;

    public CompraBoletoController() {
        // Inform the Abstract parent controller of the concrete CompraBoleto Entity
        super(CompraBoleto.class);
    }

    /**
     * Sets the "items" attribute with a collection of DetalleCompraBoleto
     * entities that are retrieved from CompraBoleto?cap_first and returns the
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

}
