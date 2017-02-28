/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import dao.BusDaoImpl;
import entities.Bus;
import entities.UnidadNegocio;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ianfr
 */
public class BusComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private BusDaoImpl daoImpl;
    private List<Bus> list;
    private Bus proceso;

    public BusComboBoxModel(UnidadNegocio unidadNegocio) {
        this.daoImpl = new BusDaoImpl();
        this.list = this.daoImpl.findByUnidad(unidadNegocio.getIdUnidadNegocio());
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public Bus getElementAt(int index) {
        return this.list.get(index);
    }

    @Override
    public Bus getSelectedItem() {
        return proceso;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.proceso = (Bus) anItem;
    }

}
