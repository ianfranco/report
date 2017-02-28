/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author ianfr
 */
public class DetalleCargosView extends javax.swing.JPanel {

    /**
     * Creates new form FlotaView
     */
    public DetalleCargosView() {
        initComponents();
        Calendar calendar = GregorianCalendar.getInstance();
        int month = calendar.get(Calendar.MONTH);        
        this.monthComboBox.setSelectedIndex(month);
        this.yearField.setText(String.valueOf(calendar.get(Calendar.YEAR)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        flotaComboBox = new javax.swing.JComboBox<>();
        monthComboBox = new javax.swing.JComboBox<>();
        yearField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        viewButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Informes x Flotas"));

        jLabel1.setText("Cargos :");

        flotaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jLabel4.setText("Año :");

        jLabel3.setText("Mes :");

        viewButton.setText("Ver");

        printButton.setText("Imprimir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flotaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printButton)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(viewButton)
                        .addComponent(printButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(flotaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JComboBox getFlotaComboBox() {
        return flotaComboBox;
    }

    public JComboBox getMonthComboBox() {
        return monthComboBox;
    }

    public JButton getPrintButton() {
        return printButton;
    }

    public JButton getViewButton() {
        return viewButton;
    }

    public JTextField getYearField() {
        return yearField;
    }
    
    
    public Date getFecha(){
        Date fecha = null;
        int month = this.monthComboBox.getSelectedIndex();
        int year = Integer.parseInt(this.getYearField().getText());
        
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(year, month, 1);
        
        return calendar.getTime();
    }
    
    public String getMes(){
        int month = this.monthComboBox.getSelectedIndex();
        
        switch(month){
            case 0:
                return "ENERO";
            case 1:
                return "FEBRERO";
            case 2:
                return "MARZO";
            case 3:
                return "ABRIL";
            case 4:
                return "MAYO";
            case 5:
                return "JUNIO";
            case 6:
                return "JULIO";
            case 7:
                return "AGOSTO";
            case 8:
                return "SEPTIEMBRE";
            case 9:
                return "OCTUBRE";
            case 10:
                return "NOVIEMBRE";
            case 11:
                return "DICIEMBRE";
        }
        return null;
    }
    
    public String getAnio(){
        return this.getYearField().getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> flotaComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JButton printButton;
    private javax.swing.JButton viewButton;
    private javax.swing.JTextField yearField;
    // End of variables declaration//GEN-END:variables
}
