package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Empresa;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "empresaController")
@ViewScoped
public class EmpresaController extends AbstractController<Empresa> {

    @Inject
    private CajaCompensacionController idCajaCompensacionController;
    @Inject
    private MutualController idMutualController;
    @Inject
    private MobilePageController mobilePageController;

    public EmpresaController() {
        // Inform the Abstract parent controller of the concrete Empresa Entity
        super(Empresa.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCajaCompensacionController.setSelected(null);
        idMutualController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of LiquidacionEmpresa
     * entities that are retrieved from Empresa?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for LiquidacionEmpresa page
     */
    public String navigateLiquidacionEmpresaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("LiquidacionEmpresa_items", this.getSelected().getLiquidacionEmpresaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/liquidacionEmpresa/index";
    }

    /**
     * Sets the "items" attribute with a collection of RepresentanteEmpresa
     * entities that are retrieved from Empresa?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for RepresentanteEmpresa page
     */
    public String navigateRepresentanteEmpresaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RepresentanteEmpresa_items", this.getSelected().getRepresentanteEmpresaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/representanteEmpresa/index";
    }

    /**
     * Sets the "items" attribute with a collection of Bus entities that are
     * retrieved from Empresa?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of RelacionLaboral entities
     * that are retrieved from Empresa?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for RelacionLaboral page
     */
    public String navigateRelacionLaboralList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RelacionLaboral_items", this.getSelected().getRelacionLaboralList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/relacionLaboral/index";
    }

    /**
     * Sets the "selected" attribute of the CajaCompensacion controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCajaCompensacion(ActionEvent event) {
        if (this.getSelected() != null && idCajaCompensacionController.getSelected() == null) {
            idCajaCompensacionController.setSelected(this.getSelected().getIdCajaCompensacion());
        }
    }

    /**
     * Sets the "selected" attribute of the Mutual controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMutual(ActionEvent event) {
        if (this.getSelected() != null && idMutualController.getSelected() == null) {
            idMutualController.setSelected(this.getSelected().getIdMutual());
        }
    }
}
