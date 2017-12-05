package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Server;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "serverController")
@ViewScoped
public class ServerController extends AbstractController<Server> {

    @Inject
    private MobilePageController mobilePageController;

    public ServerController() {
        // Inform the Abstract parent controller of the concrete Server Entity
        super(Server.class);
    }

}
