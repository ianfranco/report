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
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import views.ProcesoRecaudacionComboBoxModel;
import views.ProcesoRecaudacionView;
import views.ReporterVBView;

/**
 *
 * @author ianfr
 */
public class ProcesoRecaudacionController {

    private ReporterVBView frame;
    private ProcesoRecaudacionView view;
    private ProcesoRecaudacionComboBoxModel boxModel;

    public ProcesoRecaudacionController(ProcesoRecaudacionView view, ReporterVBView frame) {
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
            System.err.println("PRINT");
            JasperReport jasperReport;

            try {
                Map params = new HashMap();
                ProcesoRecaudacion proceso = (ProcesoRecaudacion)this.boxModel.getElementAt(index);
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                
                params.put("FECHARECAUDACION", dateFormat.format(this.view.getFechaDate().getDate()));
                params.put("idProcesoRecaudacion", proceso.getIdProcesoRecaudacion());
                params.put("nombreProcesoRecaudacion", proceso.getNombreProceso());
                
                jasperReport = JasperCompileManager.compileReport("jrxml/INF-Correccion.jrxml");
                Conexion con = new Conexion();

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());
                JasperPrintManager.printReport(jasperPrint, true);
                
            } catch (JRException jre) {
                System.err.println(jre.getMessage());
            }
        }
    }

    private void view() {
        int index = this.view.getProcesoComboBox().getSelectedIndex();
        
        if (index > -1) {
            System.err.println("VIEW");
            JasperReport jasperReport;

            try {
                Map params = new HashMap();
                ProcesoRecaudacion proceso = (ProcesoRecaudacion)this.boxModel.getElementAt(index);
                
                
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                
                params.put("FECHARECAUDACION", dateFormat.format(this.view.getFechaDate().getDate()));
                params.put("idProcesoRecaudacion", proceso.getIdProcesoRecaudacion());
                params.put("nombreProcesoRecaudacion", proceso.getNombreProceso());
                
                jasperReport = JasperCompileManager.compileReport("jrxml/INF-Correccion.jrxml");
                Conexion con = new Conexion();

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());
                //JasperViewer.viewReport(jasperPrint, false);
                //this.frame.getTabbedPane().
                this.frame.setNewReport(new JRViewer(jasperPrint), "INF-Corrección:"+proceso.getNombreProceso());

            } catch (JRException jre) {
                System.err.println(jre.getMessage());
            }
        }

    }

}
