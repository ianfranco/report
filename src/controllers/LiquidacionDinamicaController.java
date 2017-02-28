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
import views.MesSelectorView;
import views.MesSelectorlLiquidacionView;
import views.ProcesoRecaudacionComboBoxModel;
import views.ReporterVBView;

/**
 *
 * @author Ian Franco
 */
public class LiquidacionDinamicaController {

    private ReporterVBView frame;
    private MesSelectorlLiquidacionView view;
    private ProcesoRecaudacionComboBoxModel boxModel;
    private ProcesoRecaudacion proceso;

    public LiquidacionDinamicaController(MesSelectorlLiquidacionView view, ReporterVBView frame) {
        this.view = view;
        this.frame = frame;
 
        this.view.getYearField().setText("2016");
        
        this.view.getViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view();
            }
        });
    }

    /*private void print() {
        int indexFlota = this.view.getMonthComboBox().getSelectedIndex();
        if (indexFlota == 8) {
            jasper(false);
        } else if (indexFlota == 10) {
            jasperDinamico2(false);
        } else if (indexFlota == 12) {
            
        } else {
            jasperDinamico(false);
        }

    }*/
    private void view() {
        int mes = this.view.getMonthComboBox().getSelectedIndex();
        int operador = this.view.getEmpresa().getSelectedIndex();
        
        
        switch (mes) {
            case 0:
                System.err.println("INDICE:" + mes + " ENERO 2017");                
                enero2017(true, operador);            
                break;
            case 8:                
                System.err.println("INDICE:" + mes + " SEPTIEMBRE");                
                if(operador == 0){
                    septiembreViñaBus(true);
                }else{
                    septiembreSolyMar(true);
                }                
                break;
            case 9:                
                System.err.println("INDICE:" + mes + " OCTUBRE");
                if(operador == 0){
                    octubreViñabus(true);
                }else{
                    octubreSolyMar(true);
                }
                break;
            case 10:
                System.err.println("INDICE:" + mes + " NOVIEMBRE"+" OPERADOR:"+operador);
                noviembre(true, operador);
                break;
            case 11:
                System.err.println("INDICE:" + mes + " DICIEMBRE");
                diciembre(true, operador);
                break;
            default:
                System.err.println("INDICE:" + mes);
        }

    }

    //SEPTIEMBRE 2016 VIÑA BUS 
    private void septiembreViñaBus(boolean flag) {

        JasperReport jasperReport;

        try {

            String codigo = this.view.getCodigo();
            Map params = new HashMap();

            params.put("fecha", this.view.getFecha());

            params.put("año", this.view.getAnio());
            params.put("mes", this.view.getMes());
            params.put("conductor", codigo);

            Conexion con = new Conexion();

            jasperReport = JasperCompileManager.compileReport("jrxml/INF-LiquidacionSueldo.jrxml");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Liquidación de Sueldo");
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
    
    //SEPTIEMBRE 2016 SOL Y MAR 
    private void septiembreSolyMar(boolean flag) {

        JasperReport jasperReport;

        try {

            String codigo = this.view.getCodigo();
            Map params = new HashMap();

            params.put("fecha", this.view.getFecha());

            params.put("año", this.view.getAnio());
            params.put("mes", this.view.getMes());
            params.put("conductor", codigo);

            Conexion con = new Conexion();

            jasperReport = JasperCompileManager.compileReport("jrxml/INF-LiquidacionSueldoSolyMar.jrxml");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Liquidación de Sueldo");
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
    
    //OCTUBRE 2016 VIÑA BUS
    private void octubreViñabus(boolean flag) {

        JasperReport jasperReport;

        try {

            String codigo = this.view.getCodigo();

            TrabajadorDaoImpl dao = new TrabajadorDaoImpl();
            Trabajador trabajador = dao.findByCodigo(Integer.valueOf(codigo));

            int idTrabajador = trabajador.getIdTrabajador();

            Map params = new HashMap();

            params.put("fecha", this.view.getFecha());

            params.put("año", this.view.getAnio());
            params.put("mes", this.view.getMes());
            params.put("conductor", this.view.getCodigo());
            params.put("idTrabajador", idTrabajador);

            Conexion con = new Conexion();

            jasperReport = JasperCompileManager.compileReport("jrxml/INF-LiquidacionSueldoDinamica.jrxml");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Liquidación de Sueldo");
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

    //OCTUBRE 2016 SOL Y MAR
    private void octubreSolyMar(boolean flag) {

        JasperReport jasperReport;

        try {

            String codigo = this.view.getCodigo();

            
            TrabajadorDaoImpl dao = new TrabajadorDaoImpl();
            Trabajador trabajador = dao.findByCodigo(Integer.valueOf(codigo));
            
            int idTrabajador = trabajador.getIdTrabajador();
            
            Map params = new HashMap();

            params.put("fecha", this.view.getFecha());

            params.put("año", this.view.getAnio());
            params.put("mes", this.view.getMes());
            params.put("conductor", this.view.getCodigo());
            params.put("idTrabajador", idTrabajador);

            Conexion con = new Conexion();
            
            jasperReport = JasperCompileManager.compileReport("jrxml/INF-LiquidacionSueldoDinamica_sm.jrxml");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Liquidación de Sueldo");
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
        
    //NOVIEMBRE 2016 
    private void noviembre(boolean flag, int idOperador) {

        JasperReport jasperReport;

        try {

            String codigo = this.view.getCodigo();

            TrabajadorDaoImpl dao = new TrabajadorDaoImpl();
            Trabajador trabajador = dao.findByCodigo(Integer.valueOf(codigo));

            int idTrabajador = trabajador.getIdTrabajador();

            Map params = new HashMap();

            params.put("desde", this.view.getFecha());

            params.put("año", this.view.getAnio());
            params.put("mes", this.view.getMes());
            params.put("conductor", this.view.getCodigo());
            params.put("idTrabajador", idTrabajador);
            params.put("idOperador", idOperador);

            Conexion con = new Conexion();

            jasperReport = JasperCompileManager.compileReport("jrxml/INF-LiquidacionSueldoDinamicaNoviembre.jrxml");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Liquidación de Sueldo");
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
    
    //DICIEMBRE 2016
    private void diciembre(boolean flag, int idOperador) {

        JasperReport jasperReport;

        try {

            String codigo = this.view.getCodigo();

            TrabajadorDaoImpl dao = new TrabajadorDaoImpl();
            Trabajador trabajador = dao.findByCodigo(Integer.valueOf(codigo));

            int idTrabajador = trabajador.getIdTrabajador();

            Map params = new HashMap();

            params.put("desde", this.view.getFecha());

            params.put("año", this.view.getAnio());
            params.put("mes", this.view.getMes());
            params.put("conductor", this.view.getCodigo());
            params.put("idTrabajador", idTrabajador);
            params.put("idOperador", idOperador);

            Conexion con = new Conexion();

            jasperReport = JasperCompileManager.compileReport("jrxml/INF-LiquidacionSueldoDinamicaDiciembre.jrxml");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Liquidación de Sueldo");
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
    
    //DICIEMBRE 2016
    private void enero2017(boolean flag, int idOperador) {

        JasperReport jasperReport;

        try {

            String codigo = this.view.getCodigo();

            TrabajadorDaoImpl dao = new TrabajadorDaoImpl();
            Trabajador trabajador = dao.findByCodigo(Integer.valueOf(codigo));

            int idTrabajador = trabajador.getIdTrabajador();

            Map params = new HashMap();

            params.put("desde", this.view.getFecha());

            params.put("año", this.view.getAnio());
            params.put("mes", this.view.getMes());
            params.put("conductor", this.view.getCodigo());
            params.put("idTrabajador", idTrabajador);
            params.put("idOperador", idOperador);

            Conexion con = new Conexion();

            jasperReport = JasperCompileManager.compileReport("jrxml/INF-LiquidacionSueldoDinamicaEnero.jrxml");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "Liquidación de Sueldo");
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
