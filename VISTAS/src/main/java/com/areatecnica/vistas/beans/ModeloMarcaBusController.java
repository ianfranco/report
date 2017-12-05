package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.ModeloMarcaBus;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "modeloMarcaBusController")
@ViewScoped
public class ModeloMarcaBusController extends AbstractController<ModeloMarcaBus> {

    @Inject
    private MarcaBusController idMarcaBusController;
    @Inject
    private MobilePageController mobilePageController;

    public ModeloMarcaBusController() {
        // Inform the Abstract parent controller of the concrete ModeloMarcaBus Entity
        super(ModeloMarcaBus.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idMarcaBusController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the MarcaBus controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMarcaBus(ActionEvent event) {
        if (this.getSelected() != null && idMarcaBusController.getSelected() == null) {
            idMarcaBusController.setSelected(this.getSelected().getIdMarcaBus());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Bus entities that are
     * retrieved from ModeloMarcaBus?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Bus page
     */
    public String navigateBusList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Bus_items", this.getSelected().getBusList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/bus/index";
    }

}
