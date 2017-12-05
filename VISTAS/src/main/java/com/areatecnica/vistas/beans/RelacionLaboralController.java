package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.RelacionLaboral;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "relacionLaboralController")
@ViewScoped
public class RelacionLaboralController extends AbstractController<RelacionLaboral> {

    @Inject
    private TipoContratoController idTipoContratoController;
    @Inject
    private TipoTrabajadorController idTipoTrabajadorController;
    @Inject
    private EmpresaController idEmpresaController;
    @Inject
    private TrabajadorController idTrabajadorController;
    @Inject
    private MobilePageController mobilePageController;

    public RelacionLaboralController() {
        // Inform the Abstract parent controller of the concrete RelacionLaboral Entity
        super(RelacionLaboral.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoContratoController.setSelected(null);
        idTipoTrabajadorController.setSelected(null);
        idEmpresaController.setSelected(null);
        idTrabajadorController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of LiquidacionSueldo
     * entities that are retrieved from RelacionLaboral?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for LiquidacionSueldo page
     */
    public String navigateLiquidacionSueldoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("LiquidacionSueldo_items", this.getSelected().getLiquidacionSueldoList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/liquidacionSueldo/index";
    }

    /**
     * Sets the "selected" attribute of the TipoContrato controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoContrato(ActionEvent event) {
        if (this.getSelected() != null && idTipoContratoController.getSelected() == null) {
            idTipoContratoController.setSelected(this.getSelected().getIdTipoContrato());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoTrabajador controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoTrabajador(ActionEvent event) {
        if (this.getSelected() != null && idTipoTrabajadorController.getSelected() == null) {
            idTipoTrabajadorController.setSelected(this.getSelected().getIdTipoTrabajador());
        }
    }

    /**
     * Sets the "selected" attribute of the Empresa controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEmpresa(ActionEvent event) {
        if (this.getSelected() != null && idEmpresaController.getSelected() == null) {
            idEmpresaController.setSelected(this.getSelected().getIdEmpresa());
        }
    }

    /**
     * Sets the "selected" attribute of the Trabajador controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTrabajador(ActionEvent event) {
        if (this.getSelected() != null && idTrabajadorController.getSelected() == null) {
            idTrabajadorController.setSelected(this.getSelected().getIdTrabajador());
        }
    }

    /**
     * Sets the "items" attribute with a collection of FiniquitoRelacionLaboral
     * entities that are retrieved from RelacionLaboral?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for FiniquitoRelacionLaboral page
     */
    public String navigateFiniquitoRelacionLaboralList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FiniquitoRelacionLaboral_items", this.getSelected().getFiniquitoRelacionLaboralList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/finiquitoRelacionLaboral/index";
    }

}
