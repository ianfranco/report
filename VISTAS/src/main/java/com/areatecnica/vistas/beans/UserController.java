package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.User;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "userController")
@ViewScoped
public class UserController extends AbstractController<User> {

    @Inject
    private MobilePageController mobilePageController;

    public UserController() {
        // Inform the Abstract parent controller of the concrete User Entity
        super(User.class);
    }

    /**
     * Sets the "items" attribute with a collection of UserDevice entities that
     * are retrieved from User?cap_first and returns the navigation outcome.
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
