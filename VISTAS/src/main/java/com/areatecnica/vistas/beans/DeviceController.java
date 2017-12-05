package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Device;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "deviceController")
@ViewScoped
public class DeviceController extends AbstractController<Device> {

    @Inject
    private MobilePageController mobilePageController;

    public DeviceController() {
        // Inform the Abstract parent controller of the concrete Device Entity
        super(Device.class);
    }

    /**
     * Sets the "items" attribute with a collection of BusDevice entities that
     * are retrieved from Device?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for BusDevice page
     */
    public String navigateBusDeviceList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("BusDevice_items", this.getSelected().getBusDeviceList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/busDevice/index";
    }

    /**
     * Sets the "items" attribute with a collection of Position entities that
     * are retrieved from Device?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Position page
     */
    public String navigatePositionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Position_items", this.getSelected().getPositionList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/position/index";
    }

    /**
     * Sets the "items" attribute with a collection of UserDevice entities that
     * are retrieved from Device?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for UserDevice page
     */
    public String navigateUserDeviceList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("UserDevice_items", this.getSelected().getUserDeviceList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/userDevice/index";
    }

}
