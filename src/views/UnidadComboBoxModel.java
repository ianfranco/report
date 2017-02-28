/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import dao.UnidadNegocioDaoImpl;
import entities.UnidadNegocio;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ianfr
 */
public class UnidadComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private UnidadNegocioDaoImpl daoImpl;
    private List<UnidadNegocio> list;
    private UnidadNegocio proceso;

    public UnidadComboBoxModel() {
        this.daoImpl = new UnidadNegocioDaoImpl();
        this.list = this.daoImpl.findAll();
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public UnidadNegocio getElementAt(int index) {
        return this.list.get(index);
    }

    @Override
    public UnidadNegocio getSelectedItem() {
        return proceso;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.proceso = (UnidadNegocio) anItem;
    }

}
