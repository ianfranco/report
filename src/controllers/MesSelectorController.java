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
import views.MesSelectorView;
import views.ProcesoGeneralView;
import views.ProcesoRecaudacionComboBoxModel;
import views.ReporterVBView;

/**
 *
 * @author ianfr
 */
public class MesSelectorController {

    private ReporterVBView frame;
    private MesSelectorView view;
    private ProcesoRecaudacionComboBoxModel boxModel;
    private ProcesoRecaudacion proceso;
    private int idOperador;

    public MesSelectorController(MesSelectorView view, ReporterVBView frame) {
        this.view = view;
        this.frame = frame;

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

            params.put("fecha", this.view.getFecha());

            params.put("año", this.view.getAnio());
            params.put("mes", this.view.getMes());
            params.put("fechaCompleta", this.view.getMes() + " " + this.view.getAnio());

            int index = this.view.getEmpresa().getSelectedIndex();

            String nombreOperador = "";
            InputStream in = null;

            if (index == 2) {
                in = getClass().getResourceAsStream("/jrxml/INF-Planillon_imposiciones_vg_julio.jrxml");
                idOperador = 0;
            } else {
                if (index == 0) {
                    nombreOperador = "VIÑA BUS S.A.";
                    idOperador = 0;
                } else {
                    nombreOperador = "SOL Y MAR S.A.";
                    idOperador = 1;
                }
                in = getClass().getResourceAsStream("/jrxml/INF-Planillon_imposiciones.jrxml");
            }

            params.put("nombreOperador", nombreOperador);

            params.put("idOperador", idOperador);

            jasperReport = JasperCompileManager.compileReport(in);

            Conexion con = new Conexion();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Planillón Imposiciones");
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
