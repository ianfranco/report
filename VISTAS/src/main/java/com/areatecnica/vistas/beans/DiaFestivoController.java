package com.areatecnica.vistas.beans;

import com.areatecnica.vistas.beans.util.MobilePageController;
import com.areatecnica.vistas.entity.DiaFestivo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "diaFestivoController")
@ViewScoped
public class DiaFestivoController extends AbstractController<DiaFestivo> {

    @Inject
    private MobilePageController mobilePageController;

    public DiaFestivoController() {
        // Inform the Abstract parent controller of the concrete DiaFestivo Entity
        super(DiaFestivo.class);
    }

}
