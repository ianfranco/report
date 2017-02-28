/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import dao.Conexion;
import entities.Bus;
import entities.UnidadNegocio;
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
import views.BusComboBoxModel;
import views.BusView;
import views.ReporterVBView;
import views.UnidadComboBoxModel;

/**
 *
 * @author ianfr
 */
public class LiquidacionBusController {

    private ReporterVBView frame;
    private BusView view;
    private UnidadComboBoxModel unidadModel;
    private BusComboBoxModel busModel;
    private Bus bus;

    public LiquidacionBusController(BusView view, ReporterVBView frame) {
        this.view = view;
        this.frame = frame;
        this.unidadModel = new UnidadComboBoxModel();
        this.view.getUnidadComboBox().setModel(unidadModel);

        this.view.getUnidadComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadBuses();
            }
        });

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

    private void loadBuses() {
        int indexUnidad = this.view.getUnidadComboBox().getSelectedIndex();

        if (indexUnidad > -1) {
            UnidadNegocio unidadNegocio = (UnidadNegocio) this.view.getUnidadComboBox().getSelectedItem();
            busModel = new BusComboBoxModel(unidadNegocio);
            this.view.getBusComboBox().setModel(busModel);
        }
    }

    private void print() {
        int indexBus = this.view.getBusComboBox().getSelectedIndex();

        if (indexBus > -1) {
            bus = (Bus) this.view.getBusComboBox().getSelectedItem();
            jasper(Boolean.FALSE);
        }
    }

    private void view() {
        int indexBus = this.view.getBusComboBox().getSelectedIndex();

        if (indexBus > -1) {
            bus = (Bus) this.view.getBusComboBox().getSelectedItem();
            jasper(Boolean.TRUE);
        }
    }

    private void jasper(boolean flag) {

        JasperReport jasperReport;

        try {
            Map params = new HashMap();

            params.put("desde", this.view.getFecha());
            params.put("idBus", bus.getIdBus());
            params.put("numeroBus", bus.getNumeroBus());
            params.put("patenteBus", bus.getPatente());
            params.put("unidadBus", String.valueOf(bus.getUnidadNegocio().getNumeroUnidadNegocio()));
            params.put("mes", this.view.getMes());
            params.put("anio", this.view.getAnio());
            params.put("patente", bus.getPatente());            
            params.put("empresa", bus.getEmpresa().getNombreEmpresa());
            params.put("administrador", bus.getAdministrador());
            //params.put("SUBREPORT_DIR", "src/jrxml/");
            
            InputStream in = getClass().getResourceAsStream("/jrxml/INF-Liquidacion_bus.jrxml");

            jasperReport = JasperCompileManager.compileReport(in);
            Conexion con = new Conexion();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Liquidación x Bus:" + bus.getNumeroBus()+"-"+bus.getUnidadNegocio().getNumeroUnidadNegocio());
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
