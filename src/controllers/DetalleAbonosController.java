/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import dao.Conexion;
import entities.TipoAbono;
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
import views.AbonosBoxModel;
import views.CargosBoxModel;
import views.DetalleAbonosView;
import views.ReporterVBView;

/**
 *
 * @author ianfr
 */
public class DetalleAbonosController {

    private ReporterVBView frame;
    private DetalleAbonosView view;    
    private AbonosBoxModel flotaModel;
    private TipoAbono flota;

    public DetalleAbonosController(DetalleAbonosView view, ReporterVBView frame) {
        this.view = view;
        this.frame = frame;
        this.flotaModel = new AbonosBoxModel();
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
            flota = (TipoAbono) this.view.getFlotaComboBox().getSelectedItem();
            jasper(Boolean.FALSE);
        }
    }

    private void view() {
        int indexFlota = this.view.getFlotaComboBox().getSelectedIndex();

        if (indexFlota > -1) {
            flota = (TipoAbono) this.view.getFlotaComboBox().getSelectedItem();
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
            params.put("idTipoCargo", this.flota.getIdTipoAbono());
            params.put("nombreCargo", this.flota.getNombreTipoAbono());

            jasperReport = JasperCompileManager.compileReport("jrxml/INF-Abonos.jrxml");
            Conexion con = new Conexion();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Detalle x Abonos");
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
