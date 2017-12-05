package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.ParametroCesantia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "parametroCesantiaController")
@ViewScoped
public class ParametroCesantiaController extends AbstractController<ParametroCesantia> {

    @Inject
    private MobilePageController mobilePageController;

    public ParametroCesantiaController() {
        // Inform the Abstract parent controller of the concrete ParametroCesantia Entity
        super(ParametroCesantia.class);
    }

}
