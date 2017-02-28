/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import dao.ProcesoRecaudacionDaoImpl;
import entities.ProcesoRecaudacion;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ianfr
 */
public class ProcesoRecaudacionComboBoxModel extends AbstractListModel implements ComboBoxModel{

    private ProcesoRecaudacionDaoImpl daoImpl;
    private List<ProcesoRecaudacion> list;
    private ProcesoRecaudacion proceso;
    
    public ProcesoRecaudacionComboBoxModel() {
        this.daoImpl = new ProcesoRecaudacionDaoImpl();
        this.list = this.daoImpl.findAllClean();
    }

    
    
    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public ProcesoRecaudacion getElementAt(int index) {        
        return this.list.get(index);
    }

    @Override
    public ProcesoRecaudacion getSelectedItem() {
        return proceso;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.proceso = (ProcesoRecaudacion)anItem;
    }
    
    
}
