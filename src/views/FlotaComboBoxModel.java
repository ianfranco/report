/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import dao.FlotaDaoImpl;
import entities.Flota;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ianfr
 */
public class FlotaComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private FlotaDaoImpl daoImpl;
    private List<Flota> list;
    private Flota proceso;

    public FlotaComboBoxModel() {
        this.daoImpl = new FlotaDaoImpl();
        this.list = this.daoImpl.findAll();
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public Flota getElementAt(int index) {
        return this.list.get(index);
    }

    @Override
    public Flota getSelectedItem() {
        return proceso;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.proceso = (Flota) anItem;
    }

}
