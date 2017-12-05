package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.BusDevice;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "busDeviceController")
@ViewScoped
public class BusDeviceController extends AbstractController<BusDevice> {

    @Inject
    private BusController idBusController;
    @Inject
    private DeviceController idDeviceController;
    @Inject
    private MobilePageController mobilePageController;

    public BusDeviceController() {
        // Inform the Abstract parent controller of the concrete BusDevice Entity
        super(BusDevice.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idBusController.setSelected(null);
        idDeviceController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Bus controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdBus(ActionEvent event) {
        if (this.getSelected() != null && idBusController.getSelected() == null) {
            idBusController.setSelected(this.getSelected().getIdBus());
        }
    }

    /**
     * Sets the "selected" attribute of the Device controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDevice(ActionEvent event) {
        if (this.getSelected() != null && idDeviceController.getSelected() == null) {
            idDeviceController.setSelected(this.getSelected().getIdDevice());
        }
    }
}
