/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Conexion;
import entities.Terminal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import views.ReporterVBView;
import views.TerminalComboBoxModel;
import views.TerminalView;

/**
 *
 * @author ianfr
 */
public class LiquidacionTerminalController {

    private ReporterVBView frame;
    private TerminalView view;
    private TerminalComboBoxModel boxModel;
    private Terminal terminal;
    private int idTerminal;
    private int idOperador;

    public LiquidacionTerminalController(TerminalView view, ReporterVBView frame) {
        this.view = view;
        this.frame = frame;
        
        this.boxModel = new TerminalComboBoxModel();
        this.view.getTerminalComboBox().setModel(boxModel);

        this.view.getPrintButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                print();
            }
        });

        this.view.getViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view();
            }
        });
    }

    private void print() {
        jasper(false);
    }

    private void view() {
        jasper(true);
    }

    private void jasper(boolean flag) {

        JasperReport jasperReport;

        try {
            Map params = new HashMap();

            params.put("desde", this.view.getFecha());
            
            params.put("año", this.view.getAnio());
            params.put("mes", this.view.getMes());
            params.put("fechaCompleta", this.view.getMes() + " " + this.view.getAnio());

            int index = this.view.getTerminalComboBox().getSelectedIndex();
            
            this.terminal = boxModel.getElementAt(index);
            
            if (this.terminal.getIdTerminal()==16) {
                this.idOperador = 1;                
            } else {
                this.idOperador = 0;
            }
            
            params.put("idTerminal", this.terminal.getIdTerminal());
            params.put("idOperador", idOperador);
            
            Conexion con = new Conexion();

            jasperReport = JasperCompileManager.compileReport("jrxml/INF-LiquidacionSueldoDinamicaMayo.jrxml");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());
                        

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Liquidación x Terminal");
                System.err.println("VIEW");
            } else {
                JasperPrintManager.printReport(jasperPrint, true);
                System.err.println("PRINT");
            }

        } catch (JRException jre) {
            System.err.println(jre.getMessage());
        }
    }

}
