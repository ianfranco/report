package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.CargasTrabajador;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cargasTrabajadorController")
@ViewScoped
public class CargasTrabajadorController extends AbstractController<CargasTrabajador> {

    @Inject
    private ParentescoCargaController idParentescoCargaController;
    @Inject
    private TipoCargaController idTipoCargaController;
    @Inject
    private TrabajadorController idTrabajadorController;
    @Inject
    private MobilePageController mobilePageController;

    public CargasTrabajadorController() {
        // Inform the Abstract parent controller of the concrete CargasTrabajador Entity
        super(CargasTrabajador.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idParentescoCargaController.setSelected(null);
        idTipoCargaController.setSelected(null);
        idTrabajadorController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the ParentescoCarga controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdParentescoCarga(ActionEvent event) {
        if (this.getSelected() != null && idParentescoCargaController.getSelected() == null) {
            idParentescoCargaController.setSelected(this.getSelected().getIdParentescoCarga());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoCarga controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoCarga(ActionEvent event) {
        if (this.getSelected() != null && idTipoCargaController.getSelected() == null) {
            idTipoCargaController.setSelected(this.getSelected().getIdTipoCarga());
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
     * Sets the "items" attribute with a collection of CargaRetroactiva entities
     * that are retrieved from CargasTrabajador?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for CargaRetroactiva page
     */
    public String navigateCargaRetroactivaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CargaRetroactiva_items", this.getSelected().getCargaRetroactivaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/cargaRetroactiva/index";
    }

}
