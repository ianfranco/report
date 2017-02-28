/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import dao.TipoAbonoDaoImpl;
import entities.TipoAbono;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ianfr
 */
public class AbonosBoxModel extends AbstractListModel implements ComboBoxModel {

    private TipoAbonoDaoImpl daoImpl;
    private List<TipoAbono> list;
    private TipoAbono proceso;

    public AbonosBoxModel() {
        this.daoImpl = new TipoAbonoDaoImpl();
        this.list = this.daoImpl.findAll();
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public TipoAbono getElementAt(int index) {
        return this.list.get(index);
    }

    @Override
    public TipoAbono getSelectedItem() {
        return proceso;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.proceso = (TipoAbono) anItem;
    }

}
