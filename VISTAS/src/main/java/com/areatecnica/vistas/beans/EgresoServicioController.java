package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.EgresoServicio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "egresoServicioController")
@ViewScoped
public class EgresoServicioController extends AbstractController<EgresoServicio> {

    @Inject
    private ServicioController idServicioController;
    @Inject
    private EgresoController idEgresoController;
    @Inject
    private MobilePageController mobilePageController;

    public EgresoServicioController() {
        // Inform the Abstract parent controller of the concrete EgresoServicio Entity
        super(EgresoServicio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idServicioController.setSelected(null);
        idEgresoController.setSelected(null);
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
     * Sets the "selected" attribute of the Egreso controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEgreso(ActionEvent event) {
        if (this.getSelected() != null && idEgresoController.getSelected() == null) {
            idEgresoController.setSelected(this.getSelected().getIdEgreso());
        }
    }

    /**
     * Sets the "items" attribute with a collection of EgresoGuia entities that
     * are retrieved from EgresoServicio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for EgresoGuia page
     */
    public String navigateEgresoGuiaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EgresoGuia_items", this.getSelected().getEgresoGuiaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/egresoGuia/index";
    }

}
