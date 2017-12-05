package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.RepresentanteLegal;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "representanteLegalController")
@ViewScoped
public class RepresentanteLegalController extends AbstractController<RepresentanteLegal> {

    @Inject
    private MobilePageController mobilePageController;

    public RepresentanteLegalController() {
        // Inform the Abstract parent controller of the concrete RepresentanteLegal Entity
        super(RepresentanteLegal.class);
    }

    /**
     * Sets the "items" attribute with a collection of RepresentanteEmpresa
     * entities that are retrieved from RepresentanteLegal?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for RepresentanteEmpresa page
     */
    public String navigateRepresentanteEmpresaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RepresentanteEmpresa_items", this.getSelected().getRepresentanteEmpresaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/representanteEmpresa/index";
    }

}
