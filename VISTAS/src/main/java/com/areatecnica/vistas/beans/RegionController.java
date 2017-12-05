package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Region;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "regionController")
@ViewScoped
public class RegionController extends AbstractController<Region> {

    @Inject
    private MobilePageController mobilePageController;

    public RegionController() {
        // Inform the Abstract parent controller of the concrete Region Entity
        super(Region.class);
    }

    /**
     * Sets the "items" attribute with a collection of UnidadNegocio entities
     * that are retrieved from Region?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for UnidadNegocio page
     */
    public String navigateUnidadNegocioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("UnidadNegocio_items", this.getSelected().getUnidadNegocioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/unidadNegocio/index";
    }

    /**
     * Sets the "items" attribute with a collection of Comuna entities that are
     * retrieved from Region?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Comuna page
     */
    public String navigateComunaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Comuna_items", this.getSelected().getComunaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/comuna/index";
    }

}
