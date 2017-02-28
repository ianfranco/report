/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import dao.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import views.DinerosRecaudadosView;
import views.ReporterVBView;

/**
 *
 * @author ianfr
 */
public class DinerosRecaudadosController {
     
    private ReporterVBView frame;
    private DinerosRecaudadosView view;

    public DinerosRecaudadosController(ReporterVBView frame, DinerosRecaudadosView view) {
        this.frame = frame;
        this.view = view;
        
        this.view.getViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jasper(true);
            }
        });
        
        this.view.getPrintButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jasper(false);
            }
        });
    }
    
    private void jasper(boolean flag) {

        JasperReport jasperReport;

        try {
            Map params = new HashMap();

            params.put("fecha", this.view.getFechaDate().getDate());
            //params.put("fecha", this.view.getFechaDate().getDate());

            jasperReport = JasperCompileManager.compileReport("jrxml/INF-DinerosRecaudados.jrxml");
            Conexion con = new Conexion();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Dineros Recaudados");
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
