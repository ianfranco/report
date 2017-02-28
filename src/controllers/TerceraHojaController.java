/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Conexion;
import dao.TrabajadorDaoImpl;
import entities.ProcesoRecaudacion;
import entities.Trabajador;
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
import views.LiquidacionVinabusView;
import views.ProcesoRecaudacionComboBoxModel;
import views.ReporterVBView;

/**
 *
 * @author ianfr
 */
public class TerceraHojaController {

    private ReporterVBView frame;
    private LiquidacionVinabusView view;
    private ProcesoRecaudacionComboBoxModel boxModel;
    private ProcesoRecaudacion proceso;
    private int idOperador; 

    public TerceraHojaController(LiquidacionVinabusView view, ReporterVBView frame) {
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
        int indexFlota = this.view.getMonthComboBox().getSelectedIndex();
        jasperDinamico(false);
    }

    private void view() {
        int indexFlota = this.view.getMonthComboBox().getSelectedIndex();
        jasperDinamico(true);

    }

    private void jasperDinamico(boolean flag) {

        JasperReport jasperReport;

        try {

            String codigo = this.view.getCodigo().getText();

            TrabajadorDaoImpl dao = new TrabajadorDaoImpl();
            Trabajador trabajador = dao.findByCodigo(Integer.valueOf(codigo));

            int idTrabajador = trabajador.getIdTrabajador();
            idOperador = 0;
            Map params = new HashMap();

            params.put("fecha", this.view.getFecha());
            params.put("fechaCompleta", this.view.getMes() + " " + this.view.getAnio());
            params.put("año", this.view.getAnio());
            params.put("mes", this.view.getMes());
            params.put("conductor", this.view.getCodigo().getText());
            params.put("idTrabajador", idTrabajador);
            params.put("parametroCodigoConductor", idTrabajador);
            params.put("idOperador", idOperador);

            Conexion con = new Conexion();

            jasperReport = JasperCompileManager.compileReport("jrxml/INF-Reconocimiento_deuda.jrxml");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "3ra Hoja Dctos.");
                System.err.println("conductor:" + codigo);
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
