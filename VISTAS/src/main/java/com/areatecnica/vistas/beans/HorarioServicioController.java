package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.HorarioServicio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "horarioServicioController")
@ViewScoped
public class HorarioServicioController extends AbstractController<HorarioServicio> {

    @Inject
    private ServicioController idServicioController;
    @Inject
    private TipoEstacionalidadController idTipoEstacionalidadController;
    @Inject
    private MobilePageController mobilePageController;

    public HorarioServicioController() {
        // Inform the Abstract parent controller of the concrete HorarioServicio Entity
        super(HorarioServicio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idServicioController.setSelected(null);
        idTipoEstacionalidadController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of ControlHorarioServicio
     * entities that are retrieved from HorarioServicio?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for ControlHorarioServicio page
     */
    public String navigateControlHorarioServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ControlHorarioServicio_items", this.getSelected().getControlHorarioServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/controlHorarioServicio/index";
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
     * Sets the "selected" attribute of the TipoEstacionalidad controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoEstacionalidad(ActionEvent event) {
        if (this.getSelected() != null && idTipoEstacionalidadController.getSelected() == null) {
            idTipoEstacionalidadController.setSelected(this.getSelected().getIdTipoEstacionalidad());
        }
    }
}
