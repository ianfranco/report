package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.UserDevice;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "userDeviceController")
@ViewScoped
public class UserDeviceController extends AbstractController<UserDevice> {

    @Inject
    private UserController userIdController;
    @Inject
    private DeviceController deviceIdController;
    @Inject
    private MobilePageController mobilePageController;

    public UserDeviceController() {
        // Inform the Abstract parent controller of the concrete UserDevice Entity
        super(UserDevice.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        userIdController.setSelected(null);
        deviceIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the User controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUserId(ActionEvent event) {
        if (this.getSelected() != null && userIdController.getSelected() == null) {
            userIdController.setSelected(this.getSelected().getUserId());
        }
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
