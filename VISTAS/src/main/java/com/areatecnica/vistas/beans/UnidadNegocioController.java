package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.UnidadNegocio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "unidadNegocioController")
@ViewScoped
public class UnidadNegocioController extends AbstractController<UnidadNegocio> {

    @Inject
    private OperadorTransporteController idOperadorTransporteController;
    @Inject
    private RegionController idRegionController;
    @Inject
    private MobilePageController mobilePageController;

    public UnidadNegocioController() {
        // Inform the Abstract parent controller of the concrete UnidadNegocio Entity
        super(UnidadNegocio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idOperadorTransporteController.setSelected(null);
        idRegionController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of ContratoUnidad entities
     * that are retrieved from UnidadNegocio?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ContratoUnidad page
     */
    public String navigateContratoUnidadList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ContratoUnidad_items", this.getSelected().getContratoUnidadList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/contratoUnidad/index";
    }

    /**
     * Sets the "items" attribute with a collection of Bus entities that are
     * retrieved from UnidadNegocio?cap_first and returns the navigation
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

    /**
     * Sets the "items" attribute with a collection of ValorRolloUnidad entities
     * that are retrieved from UnidadNegocio?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ValorRolloUnidad page
     */
    public String navigateValorRolloUnidadList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ValorRolloUnidad_items", this.getSelected().getValorRolloUnidadList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/valorRolloUnidad/index";
    }

    /**
     * Sets the "selected" attribute of the OperadorTransporte controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdOperadorTransporte(ActionEvent event) {
        if (this.getSelected() != null && idOperadorTransporteController.getSelected() == null) {
            idOperadorTransporteController.setSelected(this.getSelected().getIdOperadorTransporte());
        }
    }

    /**
     * Sets the "selected" attribute of the Region controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdRegion(ActionEvent event) {
        if (this.getSelected() != null && idRegionController.getSelected() == null) {
            idRegionController.setSelected(this.getSelected().getIdRegion());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Servicio entities that
     * are retrieved from UnidadNegocio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Servicio page
     */
    public String navigateServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Servicio_items", this.getSelected().getServicioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/servicio/index";
    }

}
