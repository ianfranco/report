package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Traccar;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "traccarController")
@ViewScoped
public class TraccarController extends AbstractController<Traccar> {

    @Inject
    private MobilePageController mobilePageController;

    public TraccarController() {
        // Inform the Abstract parent controller of the concrete Traccar Entity
        super(Traccar.class);
    }

}
