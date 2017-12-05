package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.FrecuenciaServicio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "frecuenciaServicioController")
@ViewScoped
public class FrecuenciaServicioController extends AbstractController<FrecuenciaServicio> {

    @Inject
    private PeriodoFrecuenciaController idPeriodoFrecuenciaController;
    @Inject
    private ServicioController idServicioController;
    @Inject
    private TipoDemandaController idTipoDemandaController;
    @Inject
    private TipoDiaFrecuenciaController idTipoDiaFrecuenciaController;
    @Inject
    private MobilePageController mobilePageController;

    public FrecuenciaServicioController() {
        // Inform the Abstract parent controller of the concrete FrecuenciaServicio Entity
        super(FrecuenciaServicio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idPeriodoFrecuenciaController.setSelected(null);
        idServicioController.setSelected(null);
        idTipoDemandaController.setSelected(null);
        idTipoDiaFrecuenciaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the PeriodoFrecuencia controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPeriodoFrecuencia(ActionEvent event) {
        if (this.getSelected() != null && idPeriodoFrecuenciaController.getSelected() == null) {
            idPeriodoFrecuenciaController.setSelected(this.getSelected().getIdPeriodoFrecuencia());
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

    /**
     * Sets the "selected" attribute of the TipoDemanda controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoDemanda(ActionEvent event) {
        if (this.getSelected() != null && idTipoDemandaController.getSelected() == null) {
            idTipoDemandaController.setSelected(this.getSelected().getIdTipoDemanda());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoDiaFrecuencia controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoDiaFrecuencia(ActionEvent event) {
        if (this.getSelected() != null && idTipoDiaFrecuenciaController.getSelected() == null) {
            idTipoDiaFrecuenciaController.setSelected(this.getSelected().getIdTipoDiaFrecuencia());
        }
    }
}
