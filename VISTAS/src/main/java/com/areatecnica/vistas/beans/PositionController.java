package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Position;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "positionController")
@ViewScoped
public class PositionController extends AbstractController<Position> {

    @Inject
    private DeviceController deviceIdController;
    @Inject
    private MobilePageController mobilePageController;

    public PositionController() {
        // Inform the Abstract parent controller of the concrete Position Entity
        super(Position.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        deviceIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Device controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDeviceId(ActionEvent event) {
        if (this.getSelected() != null && deviceIdController.getSelected() == null) {
            deviceIdController.setSelected(this.getSelected().getDeviceId());
        }
    }
}
