package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.ValorFijo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "valorFijoController")
@ViewScoped
public class ValorFijoController extends AbstractController<ValorFijo> {

    @Inject
    private MobilePageController mobilePageController;

    public ValorFijoController() {
        // Inform the Abstract parent controller of the concrete ValorFijo Entity
        super(ValorFijo.class);
    }

}
