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
import views.Abril2017;
import views.Abril2018;
import views.Agosto2017;
import views.Diciembre2016;
import views.Diciembre2017;
import views.Enero2017;
import views.Enero2018;
import views.Febrero2017;
import views.Febrero2018;
import views.Julio2017;
import views.Junio2017;
import views.Marzo2017;
import views.Marzo2018;
import views.Mayo2017;
import views.MesSelectorlLiquidacionView;
import views.Noviembre2016;
import views.Noviembre2017;
import views.Octubre2016;
import views.Octubre2017;
import views.ProcesoRecaudacionComboBoxModel;
import views.ReporterVBView;
import views.Septiembre2016;
import views.Septiembre2017;

/**
 *
 * @author Ian Franco
 */
public class LiquidacionDinamicaController {

    private ReporterVBView frame;
    private MesSelectorlLiquidacionView view;
    private ProcesoRecaudacionComboBoxModel boxModel;
    private ProcesoRecaudacion proceso;

    private Septiembre2016 septiembre2016;
    private Octubre2016 octubre2016;

    private Septiembre2017 septiembre2017;
    private Octubre2017 octubre2017;

    private Noviembre2016 noviembre2016;
    private Diciembre2016 diciembre2016;
    private Enero2017 enero2017;
    private Enero2018 enero2018;
    private Febrero2017 febrero2017;
    private Febrero2018 febrero2018;
    private Marzo2017 marzo2017;
    private Marzo2018 marzo2018;
    private Abril2017 abril2017;
    private Abril2018 abril2018;
    private Mayo2017 mayo2017;
    private Junio2017 junio2017;
    private Julio2017 julio2017;
    private Agosto2017 agosto2017;
    private Noviembre2017 noviembre2017;
    private Diciembre2017 diciembre2017;

    public LiquidacionDinamicaController(MesSelectorlLiquidacionView view, ReporterVBView frame) {
        this.view = view;
        this.frame = frame;

        this.view.getYearField().setText("2018");

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
        //boolean daHoja = this.view.get2daHoja();

        switch (mes) {
            case 0:

                if (this.view.getAnio().equals("2017")) {
                    System.err.println("INDICE:" + mes + " ENERO 2017");

                    enero2017 = new Enero2017(frame, view);
                    if (operador == 0) {
                        enero2017.loadLiquidacion(true, operador);
                    } else {
                        enero2017.loadLiquidacion(true, operador);
                    }
                } else if (this.view.getAnio().equals("2018")) {

                    System.err.println("INDICE:" + mes + " ENERO 2018");

                    enero2018 = new Enero2018(frame, view);
                    if (operador == 0) {
                        enero2018.loadLiquidacion(true, operador);
                    } else {
                        enero2018.loadLiquidacion(true, operador);
                    }

                } else {

                }

                break;
            case 1:
                if (this.view.getAnio().equals("2017")) {                    
                    System.err.println("INDICE:" + mes + " FEBRERO 2017");

                    febrero2017 = new Febrero2017(frame, view);
                    if (operador == 0) {
                        febrero2017.loadLiquidacion(true, operador);
                    } else {
                        febrero2017.loadLiquidacion(true, operador);
                    }

                } else {
                    System.err.println("INDICE:" + mes + " FEBRERO 2018");

                    febrero2018 = new Febrero2018(frame, view);
                    if (operador == 0) {
                        febrero2018.loadLiquidacion(true, operador);
                    } else {
                        febrero2018.loadLiquidacion(true, operador);
                    }
                }

                break;
            case 2:
                if (this.view.getAnio().equals("2017")) {         
                    System.err.println("INDICE:" + mes + " MARZO 2017");

                marzo2017 = new Marzo2017(frame, view);
                if (operador == 0) {
                    marzo2017.loadLiquidacion(true, operador);
                } else {
                    marzo2017.loadLiquidacion(true, operador);
                }
                }else{
                    System.err.println("INDICE:" + mes + " Marzo 2018");

                    marzo2018 = new Marzo2018(frame, view);
                    if (operador == 0) {
                        marzo2018.loadLiquidacion(true, operador);
                    } else {
                        marzo2018.loadLiquidacion(true, operador);
                    }
                }
                

                break;
            case 3:
                System.err.println("INDICE:" + mes + " ABRIL 2017");

                abril2017 = new Abril2017(frame, view);
                if (operador == 0) {
                    abril2017.loadLiquidacion(true, operador);
                } else {
                    abril2017.loadLiquidacion(true, operador);
                }

                break;
            case 4:
                System.err.println("INDICE:" + mes + "MAYO 2017");

                mayo2017 = new Mayo2017(frame, view);
                if (operador == 0) {
                    mayo2017.loadLiquidacion(true, operador);
                } else {
                    mayo2017.loadLiquidacion(true, operador);
                }

                break;
            case 5:
                System.err.println("INDICE:" + mes + " JUNIO 2017");

                junio2017 = new Junio2017(frame, view);
                if (operador == 0) {
                    junio2017.loadLiquidacion(true, operador);
                } else {
                    junio2017.loadLiquidacion(true, operador);
                }

                break;
            case 6:
                System.err.println("INDICE:" + mes + " JULIO 2017");

                julio2017 = new Julio2017(frame, view);
                if (operador == 0) {
                    julio2017.loadLiquidacion(true, operador);
                } else {
                    julio2017.loadLiquidacion(true, operador);
                }

                break;
            case 7:
                System.err.println("INDICE:" + mes + " AGOSTO 2017");

                agosto2017 = new Agosto2017(frame, view);
                if (operador == 0) {
                    agosto2017.loadLiquidacion(true, operador);
                } else {
                    agosto2017.loadLiquidacion(true, operador);
                }
                break;
            case 8:
                System.err.println("INDICE:" + mes + " SEPTIEMBRE");

                if (this.view.getAnio().equals("2016")) {
                    System.err.println("INDICE:" + mes + " SEPTIEMBRE 2016");
                    septiembre2016 = new Septiembre2016(frame, view);
                    if (operador == 0) {
                        septiembre2016.loadLiquidacion(true, operador);
                    } else {
                        septiembre2016.loadLiquidacion(true, operador);
                    }
                } else {
                    System.err.println("INDICE:" + mes + " SEPTIEMBRE 2017");
                    septiembre2017 = new Septiembre2017(frame, view);
                    if (operador == 0) {
                        septiembre2017.loadLiquidacion(true, operador);
                    } else {
                        septiembre2017.loadLiquidacion(true, operador);
                    }

                }

                break;
            case 9:

                if (this.view.getAnio().equals("2016")) {
                    System.err.println("INDICE:" + mes + " OCTUBRE 2016");
                    octubre2016 = new Octubre2016(frame, view);
                    if (operador == 0) {
                        octubre2016.loadLiquidacion(true, operador);
                    } else {
                        octubre2016.loadLiquidacion(true, operador);
                    }
                } else {
                    System.err.println("INDICE:" + mes + " OCTUBRE 2017");
                    octubre2017 = new Octubre2017(frame, view);
                    if (operador == 0) {
                        octubre2017.loadLiquidacion(true, operador);
                    } else {
                        octubre2017.loadLiquidacion(true, operador);
                    }
                }

                break;
            case 10:
                if (this.view.getAnio().equals("2016")) {
                    System.err.println("INDICE:" + mes + " NOVIEMBRE" + " OPERADOR:" + operador);
                    noviembre(true, operador);
                } else {
                    System.err.println("INDICE:" + mes + " NOVIEMBRE 2017");
                    noviembre2017 = new Noviembre2017(frame, view);
                    if (operador == 0) {
                        noviembre2017.loadLiquidacion(true, operador);
                    } else {
                        noviembre2017.loadLiquidacion(true, operador);
                    }
                }

                break;
            case 11:
                System.err.println("INDICE:" + mes + " DICIEMBRE");
                if (this.view.getAnio().equals("2016")) {
                    diciembre(true, operador);
                } else {
                    System.err.println("INDICE:" + mes + " DICIEMBRE 2017");
                    diciembre2017 = new Diciembre2017(frame, view);
                    if (operador == 0) {
                        diciembre2017.loadLiquidacion(true, operador);
                    } else {
                        diciembre2017.loadLiquidacion(true, operador);
                    }
                }

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

    //DICIEMBRE 2016
    private void mayo2017(boolean flag, int idOperador) {

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

            jasperReport = JasperCompileManager.compileReport("jrxml/INF-LiquidacionSueldoDinamicaMayo.jrxml");

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
