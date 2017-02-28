/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import dao.TipoCargoDaoImpl;
import entities.TipoCargo;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ianfr
 */
public class CargosBoxModel extends AbstractListModel implements ComboBoxModel {

    private TipoCargoDaoImpl daoImpl;
    private List<TipoCargo> list;
    private TipoCargo proceso;

    public CargosBoxModel() {
        this.daoImpl = new TipoCargoDaoImpl();
        this.list = this.daoImpl.findAll();
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public TipoCargo getElementAt(int index) {
        return this.list.get(index);
    }

    @Override
    public TipoCargo getSelectedItem() {
        return proceso;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.proceso = (TipoCargo) anItem;
    }

}
