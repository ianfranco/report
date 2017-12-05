package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.ParametroInterpolacion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "parametroInterpolacionController")
@ViewScoped
public class ParametroInterpolacionController extends AbstractController<ParametroInterpolacion> {

    @Inject
    private MobilePageController mobilePageController;

    public ParametroInterpolacionController() {
        // Inform the Abstract parent controller of the concrete ParametroInterpolacion Entity
        super(ParametroInterpolacion.class);
    }

}
