package com.areatecnica.vistas.converters;

import com.areatecnica.vistas.entity.TipoEstacionalidad;
import com.areatecnica.vistas.controllers.TipoEstacionalidadFacade;
import com.areatecnica.vistas.beans.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "tipoEstacionalidadConverter")
public class TipoEstacionalidadConverter implements Converter {

    @Inject
    private TipoEstacionalidadFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof TipoEstacionalidad) {
            TipoEstacionalidad o = (TipoEstacionalidad) object;
            return getStringKey(o.getIdTipoEstacionalidad());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TipoEstacionalidad.class.getName()});
            return null;
        }
    }

}
