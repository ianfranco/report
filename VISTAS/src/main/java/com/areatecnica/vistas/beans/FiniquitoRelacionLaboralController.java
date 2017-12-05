package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.FiniquitoRelacionLaboral;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "finiquitoRelacionLaboralController")
@ViewScoped
public class FiniquitoRelacionLaboralController extends AbstractController<FiniquitoRelacionLaboral> {

    @Inject
    private CausalFiniquitoController idCausalFiniquitoController;
    @Inject
    private RelacionLaboralController idRelacionLaboralController;
    @Inject
    private MobilePageController mobilePageController;

    public FiniquitoRelacionLaboralController() {
        // Inform the Abstract parent controller of the concrete FiniquitoRelacionLaboral Entity
        super(FiniquitoRelacionLaboral.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCausalFiniquitoController.setSelected(null);
        idRelacionLaboralController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the CausalFiniquito controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCausalFiniquito(ActionEvent event) {
        if (this.getSelected() != null && idCausalFiniquitoController.getSelected() == null) {
            idCausalFiniquitoController.setSelected(this.getSelected().getIdCausalFiniquito());
        }
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
