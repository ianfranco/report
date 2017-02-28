/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import dao.TrabajadorDaoImpl;
import entities.Trabajador;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ianfr
 */
public class ConductorComboBoxModel extends AbstractListModel implements ComboBoxModel{

    private TrabajadorDaoImpl daoImpl;
    private List<Trabajador> list;
    private Trabajador trabajador;
    
    public ConductorComboBoxModel() {
        this.daoImpl = new TrabajadorDaoImpl();
        this.list = this.daoImpl.findAll();
    }    
    
    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public Trabajador getElementAt(int index) {        
        return this.list.get(index);
    }

    @Override
    public Trabajador getSelectedItem() {
        return trabajador;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.trabajador = (Trabajador)anItem;
    }
    
}
