package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.Tope;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "topeController")
@ViewScoped
public class TopeController extends AbstractController<Tope> {

    @Inject
    private MobilePageController mobilePageController;

    public TopeController() {
        // Inform the Abstract parent controller of the concrete Tope Entity
        super(Tope.class);
    }

}
