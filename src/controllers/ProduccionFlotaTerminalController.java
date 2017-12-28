/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Conexion;
import entities.Flota;
import entities.Terminal;
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
import views.FlotaComboBoxModel;
import views.FlotaTerminalView;
import views.ReporterVBView;
import views.TerminalComboBoxModel;

/**
 *
 * @author ianfr
 */
public class ProduccionFlotaTerminalController {

    private ReporterVBView frame;
    private FlotaTerminalView view;
    private FlotaComboBoxModel flotaModel;
    private TerminalComboBoxModel terminalComboBoxModel;
    private Flota flota;
    private Terminal terminal;

    public ProduccionFlotaTerminalController(FlotaTerminalView view, ReporterVBView frame) {
        this.view = view;
        this.frame = frame;
        this.flotaModel = new FlotaComboBoxModel();
        this.terminalComboBoxModel = new TerminalComboBoxModel();

        this.view.getFlotaComboBox().setModel(flotaModel);
        this.view.getTerminalComboBox().setModel(terminalComboBoxModel);

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
            terminal = (Terminal) this.view.getTerminalComboBox().getSelectedItem();
            jasper(Boolean.FALSE);
        }
    }

    private void view() {
        int indexFlota = this.view.getFlotaComboBox().getSelectedIndex();

        if (indexFlota > -1) {
            flota = (Flota) this.view.getFlotaComboBox().getSelectedItem();
            terminal = (Terminal) this.view.getTerminalComboBox().getSelectedItem();
            jasper(Boolean.TRUE);
        }
    }

    private void jasper(boolean flag) {

        JasperReport jasperReport;

        try {
            Map params = new HashMap();

            params.put("desde", this.view.getFecha());
            params.put("idFlota", flota.getIdFlota());
            params.put("nombreMes", this.view.getMes());
            params.put("anioMes", this.view.getAnio());
            params.put("nombreFlota", flota.getNombreFlota());
            params.put("idTerminal", this.terminal.getIdTerminal());

            jasperReport = JasperCompileManager.compileReport("jrxml/INF-Produccion_bruta_flota_terminal.jrxml");
            Conexion con = new Conexion();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Detalle Producción x Flota x Terminal:" + flota.getNombreFlota());
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
