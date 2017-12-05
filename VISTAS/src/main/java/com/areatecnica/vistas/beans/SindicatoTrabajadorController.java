package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.SindicatoTrabajador;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "sindicatoTrabajadorController")
@ViewScoped
public class SindicatoTrabajadorController extends AbstractController<SindicatoTrabajador> {

    @Inject
    private SindicatoController idSindicatoController;
    @Inject
    private TrabajadorController idTrabajadorController;
    @Inject
    private MobilePageController mobilePageController;

    public SindicatoTrabajadorController() {
        // Inform the Abstract parent controller of the concrete SindicatoTrabajador Entity
        super(SindicatoTrabajador.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idSindicatoController.setSelected(null);
        idTrabajadorController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Sindicato controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdSindicato(ActionEvent event) {
        if (this.getSelected() != null && idSindicatoController.getSelected() == null) {
            idSindicatoController.setSelected(this.getSelected().getIdSindicato());
        }
    }

    /**
     * Sets the "selected" attribute of the Trabajador controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTrabajador(ActionEvent event) {
        if (this.getSelected() != null && idTrabajadorController.getSelected() == null) {
            idTrabajadorController.setSelected(this.getSelected().getIdTrabajador());
        }
    }

    /**
     * Sets the "items" attribute with a collection of MontoSindicatoTrabajador
     * entities that are retrieved from SindicatoTrabajador?cap_first and
     * returns the navigation outcome.
     *
     * @return navigation outcome for MontoSindicatoTrabajador page
     */
    public String navigateMontoSindicatoTrabajadorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MontoSindicatoTrabajador_items", this.getSelected().getMontoSindicatoTrabajadorList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/montoSindicatoTrabajador/index";
    }

}
