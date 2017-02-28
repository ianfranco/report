/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import dao.Conexion;
import entities.Flota;
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
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import views.FlotaComboBoxModel;
import views.FlotaView;
import views.ReporterVBView;

/**
 *
 * @author ianfr
 */
public class DetalleLiquidacionBusFlotaController {

    private ReporterVBView frame;
    private FlotaView view;    
    private FlotaComboBoxModel flotaModel;
    private Flota flota;

    public DetalleLiquidacionBusFlotaController(FlotaView view, ReporterVBView frame) {
        this.view = view;
        this.frame = frame;
        this.flotaModel = new FlotaComboBoxModel();
        this.view.getFlotaComboBox().setModel(flotaModel);

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
        int indexFlota = this.view.getFlotaComboBox().getSelectedIndex();

        if (indexFlota > -1) {
            flota = (Flota) this.view.getFlotaComboBox().getSelectedItem();
            jasperIndividual(Boolean.FALSE);
            
        }else{
            //jasper(Boolean.FALSE);
        }
    }

    private void view() {
        int indexFlota = this.view.getFlotaComboBox().getSelectedIndex();
        System.err.println("indice:"+indexFlota);
        if (indexFlota > -1) {
            flota = (Flota) this.view.getFlotaComboBox().getSelectedItem();
            jasperIndividual(Boolean.TRUE);
            
        }else{
            /*jasper(Boolean.TRUE);
            System.err.println("SI ");*/
        }
    }

    private void jasper(boolean flag) {

        JasperReport jasperReport;

        try {
            Map params = new HashMap();

            params.put("desde", this.view.getFecha());
            
            params.put("mes", this.view.getMes());
            params.put("anio", this.view.getAnio());                  
            
            InputStream in = getClass().getResourceAsStream("/jrxml/Liquidacion_por_flota.jrxml");

            jasperReport = JasperCompileManager.compileReport(in);
            Conexion con = new Conexion();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Detalle Liquidacion Bus x Flota");
                System.err.println("VIEW");
            } else {
                JasperPrintManager.printReport(jasperPrint, true);
                System.err.println("PRINT");
            }

        } catch (JRException jre) {
            System.err.println(jre.getMessage());
        }
    }
    
    private void jasperIndividual(boolean flag) {

        JasperReport jasperReport;

        try {
            Map params = new HashMap();

            params.put("desde", this.view.getFecha());
            params.put("idFlota", flota.getIdFlota());
            params.put("mes", this.view.getMes());
            params.put("anio", this.view.getAnio());                  
            params.put("nombreFlota", flota.getNombreFlota());

            InputStream in = getClass().getResourceAsStream("/jrxml/Liquidacion_por_flota.jrxml");

            jasperReport = JasperCompileManager.compileReport(in);
            Conexion con = new Conexion();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Liquidacion Bus x Flota:" + flota.getNombreFlota());
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
