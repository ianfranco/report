/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import dao.Conexion;
import entities.ProcesoRecaudacion;
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
import views.ProcesoGeneralView;
import views.ProcesoRecaudacionComboBoxModel;
import views.ReporterVBView;

/**
 *
 * @author ianfr
 */
public class ProcesoGeneralController {

    private ReporterVBView frame;
    private ProcesoGeneralView view;
    private ProcesoRecaudacionComboBoxModel boxModel;
    private ProcesoRecaudacion proceso;

    public ProcesoGeneralController(ProcesoGeneralView view, ReporterVBView frame) {
        this.view = view;
        this.frame = frame;
        this.boxModel = new ProcesoRecaudacionComboBoxModel();
        this.view.getProcesoComboBox().setModel(boxModel);

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
        int index = this.view.getProcesoComboBox().getSelectedIndex();
        
        if (index > -1) {
            
            proceso = (ProcesoRecaudacion)this.view.getProcesoComboBox().getSelectedItem();
            
            jasper(false);
        }
    }

    private void view() {
        int index = this.view.getProcesoComboBox().getSelectedIndex();
        
        if (index > -1) {
            
            proceso = (ProcesoRecaudacion)this.view.getProcesoComboBox().getSelectedItem();
            
            jasper(true);
        }

    }
    
    private void jasper(boolean flag) {

        JasperReport jasperReport;

        try {
            Map params = new HashMap();
            
            params.put("fecha", this.view.getFecha());
            params.put("idProcesoGeneral", this.proceso.getIdGeneral());
            params.put("nombreProcesoRecaudacion", this.proceso.getNombreGeneral());
            params.put("año", this.view.getAnio());
            params.put("mes", this.view.getMes());

            InputStream in = getClass().getResourceAsStream("/jrxml/INF-DinerosRecaudadosxid_general.jrxml");
            
            jasperReport = JasperCompileManager.compileReport(in);
            Conexion con = new Conexion();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Dineros Recaudados x Proceso");
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
