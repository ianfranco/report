/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import dao.Conexion;
import dao.TrabajadorDaoImpl;
import entities.Trabajador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import views.ConductorComboBoxModel;
import views.ConductoresView;
import views.ReporterVBView;

/**
 *
 * @author ianfr
 */
public class DiasTrabajadosConductorController {

    private ReporterVBView frame;
    private ConductoresView view;
    private ConductorComboBoxModel boxModel;
    private String rut;
    private Trabajador trabajador;
    private TrabajadorDaoImpl daoImpl;

    public DiasTrabajadosConductorController(ConductoresView view, ReporterVBView frame) {
        this.view = view;
        this.frame = frame;
        this.boxModel = new ConductorComboBoxModel();
        this.view.getConductoresComboBox().setModel(boxModel);

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

        this.view.getRutTextField().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                setRut();
            }
        });
    }

    private void print() {
        int index = this.view.getConductoresComboBox().getSelectedIndex();

        if (trabajador != null) {
            jasper(false);
        } else if (index > -1) {
            trabajador = (Trabajador) this.boxModel.getElementAt(index);
            jasper(false);
        }
    }

    private void view() {
        int index = this.view.getConductoresComboBox().getSelectedIndex();

        if (trabajador != null) {
            jasper(true);
        } else if (index > -1) {
            trabajador = (Trabajador) this.boxModel.getElementAt(index);
            jasper(true);
        }
    }

    public void setRut() {
        this.rut = this.view.getRutTextField().getText();
        if (validarRut(rut)) {
            daoImpl = new TrabajadorDaoImpl();
            trabajador = daoImpl.findByRut(rut);
            
            if(trabajador == null){
                JOptionPane.showMessageDialog(null, "No existe rut en la base de datos");
                this.view.getRutTextField().requestFocus();
                this.view.getRutTextField().selectAll();
            }
            
        } else {
            this.view.getRutTextField().setText("");
        }
    }

    public static boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

    private void jasper(boolean flag) {

        JasperReport jasperReport;

        try {
            Map params = new HashMap();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

            String nombre = trabajador.getApellidoPaternoTrabajador() + " " + trabajador.getApellidoMaternoTrabajador() + " " + trabajador.getNombreTrabajador();
            
            params.put("desde", this.view.getDesdeDate().getDate());
            params.put("hasta", this.view.getHastaDate().getDate());
            params.put("idConductor", trabajador.getIdTrabajador());
            params.put("rutConductor", String.valueOf(trabajador.getRutTrabajador()));
            params.put("nombreConductor", nombre);
            params.put("codigoConductor", trabajador.getCodigoTrabajador());

            //InputStream in = getClass().getResourceAsStream("/jrxml/INF-Liquidacion_bus.jrxml");
            
            
            jasperReport = JasperCompileManager.compileReport("jrxml/INF-DiasTrabajadosConductor.jrxml");
            Conexion con = new Conexion();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());

            if (flag) {
                this.frame.setNewReport(new JRViewer(jasperPrint), "INF-Días Trabajados Conductor:" + nombre);
                System.err.println("VIEW");
            } else {
                JasperPrintManager.printReport(jasperPrint, true);
                System.err.println("PRINT");
            }
            this.trabajador = null;

        } catch (JRException jre) {
            System.err.println(jre.getMessage());
        }
    }

}
