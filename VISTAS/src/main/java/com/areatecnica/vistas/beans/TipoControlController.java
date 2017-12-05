package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.TipoControl;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoControlController")
@ViewScoped
public class TipoControlController extends AbstractController<TipoControl> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoControlController() {
        // Inform the Abstract parent controller of the concrete TipoControl Entity
        super(TipoControl.class);
    }

    /**
     * Sets the "items" attribute with a collection of Control entities that are
     * retrieved from TipoControl?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Control page
     */
    public String navigateControlList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Control_items", this.getSelected().getControlList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/control/index";
    }

}
