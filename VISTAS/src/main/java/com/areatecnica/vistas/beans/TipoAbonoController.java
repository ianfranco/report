package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.TipoAbono;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoAbonoController")
@ViewScoped
public class TipoAbonoController extends AbstractController<TipoAbono> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoAbonoController() {
        // Inform the Abstract parent controller of the concrete TipoAbono Entity
        super(TipoAbono.class);
    }

    /**
     * Sets the "items" attribute with a collection of AbonoBus entities that
     * are retrieved from TipoAbono?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AbonoBus page
     */
    public String navigateAbonoBusList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AbonoBus_items", this.getSelected().getAbonoBusList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/abonoBus/index";
    }

}
