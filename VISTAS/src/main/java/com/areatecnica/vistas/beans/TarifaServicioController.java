package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.TarifaServicio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tarifaServicioController")
@ViewScoped
public class TarifaServicioController extends AbstractController<TarifaServicio> {

    @Inject
    private BoletoController idBoletoController;
    @Inject
    private ServicioController idServicioController;
    @Inject
    private MobilePageController mobilePageController;

    public TarifaServicioController() {
        // Inform the Abstract parent controller of the concrete TarifaServicio Entity
        super(TarifaServicio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idBoletoController.setSelected(null);
        idServicioController.setSelected(null);
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
     * Sets the "selected" attribute of the Servicio controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdServicio(ActionEvent event) {
        if (this.getSelected() != null && idServicioController.getSelected() == null) {
            idServicioController.setSelected(this.getSelected().getIdServicio());
        }
    }
}
