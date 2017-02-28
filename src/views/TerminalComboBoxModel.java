/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import dao.TerminalDaoImpl;
import entities.Terminal;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ianfr
 */
public class TerminalComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private TerminalDaoImpl daoImpl;
    private List<Terminal> list;
    private Terminal proceso;

    public TerminalComboBoxModel() {
        this.daoImpl = new TerminalDaoImpl();
        this.list = this.daoImpl.findAll();
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public Terminal getElementAt(int index) {
        return this.list.get(index);
    }

    @Override
    public Terminal getSelectedItem() {
        return proceso;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.proceso = (Terminal) anItem;
    }

}
