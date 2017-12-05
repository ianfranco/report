package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.ImpuestoSegundaCategoria;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "impuestoSegundaCategoriaController")
@ViewScoped
public class ImpuestoSegundaCategoriaController extends AbstractController<ImpuestoSegundaCategoria> {

    @Inject
    private MobilePageController mobilePageController;

    public ImpuestoSegundaCategoriaController() {
        // Inform the Abstract parent controller of the concrete ImpuestoSegundaCategoria Entity
        super(ImpuestoSegundaCategoria.class);
    }

}
