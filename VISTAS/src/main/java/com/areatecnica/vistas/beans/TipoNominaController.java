package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.TipoNomina;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "tipoNominaController")
@ViewScoped
public class TipoNominaController extends AbstractController<TipoNomina> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoNominaController() {
        // Inform the Abstract parent controller of the concrete TipoNomina Entity
        super(TipoNomina.class);
    }

}
