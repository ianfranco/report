/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import dao.Conexion;
import entities.TipoCargo;
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
import views.CargosBoxModel;
import views.DetalleCargosView;
import views.ReporterVBView;

/**
 *
 * @author ianfr
 */
public class DetalleCargosController {

    private ReporterVBView frame;
    private DetalleCargosView view;    
    private CargosBoxModel flotaModel;
    private TipoCargo flota;

    public DetalleCargosController(DetalleCargosView view, ReporterVBView frame) {
        this.view = view;
        this.frame = frame;
        this.flotaModel = new CargosBoxModel();
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
            flota = (TipoCargo) this.view.getFlotaComboBox().getSelectedItem();
            jasper(Boolean.FALSE);
        }
    }

    private void view() {
        int indexFlota = this.view.getFlotaComboBox().getSelectedIndex();

        if (indexFlota > -1) {
            flota = (TipoCargo) this.view.getFlotaComboBox().getSelectedItem();
            jasper(Boolean.TRUE);
        }
    }

    private void jasper(boolean flag) {

        JasperReport jasperReport;

        try {
            Map params = new HashMap();

            params.put("fecha", this.view.getFecha());            
            params.put("nombreMes", this.view.getMes());
            params.put("anio", this.view.getAnio());
            params.put("idTipoCargo", this.flota.getIdTipoCargo());
            params.put("nombreCargo", this.flota.getNombreTipoCargo());

            jasperReport = JasperCompileManager.compileReport("jrxml/INF-Cargos.jrxml");
            Conexion con = new Conexion();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Detalle x cargo");
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
