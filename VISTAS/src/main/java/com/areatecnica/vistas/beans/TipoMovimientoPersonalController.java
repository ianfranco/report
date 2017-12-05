package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.TipoMovimientoPersonal;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "tipoMovimientoPersonalController")
@ViewScoped
public class TipoMovimientoPersonalController extends AbstractController<TipoMovimientoPersonal> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoMovimientoPersonalController() {
        // Inform the Abstract parent controller of the concrete TipoMovimientoPersonal Entity
        super(TipoMovimientoPersonal.class);
    }

}
