package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.LiquidacionSueldo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "liquidacionSueldoController")
@ViewScoped
public class LiquidacionSueldoController extends AbstractController<LiquidacionSueldo> {

    @Inject
    private RelacionLaboralController idRelacionLaboralController;
    @Inject
    private MobilePageController mobilePageController;

    public LiquidacionSueldoController() {
        // Inform the Abstract parent controller of the concrete LiquidacionSueldo Entity
        super(LiquidacionSueldo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idRelacionLaboralController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the RelacionLaboral controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdRelacionLaboral(ActionEvent event) {
        if (this.getSelected() != null && idRelacionLaboralController.getSelected() == null) {
            idRelacionLaboralController.setSelected(this.getSelected().getIdRelacionLaboral());
        }
    }
}
