/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dao.Conexion;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author ianfr
 */
public class Noviembre2017 {

    private ReporterVBView frame;
    private MesSelectorlLiquidacionView view;

    public Noviembre2017(ReporterVBView frame, MesSelectorlLiquidacionView view) {
        this.frame = frame;
        this.view = view;
    }
    
    public void loadLiquidacion(boolean flag, int operador) {
        JasperReport jasperReport;

        try {

            String codigo = this.view.getCodigo();
            Map params = new HashMap();

            params.put("fecha", this.view.getFecha());

            params.put("año", this.view.getAnio());
            params.put("mes", this.view.getMes());
            params.put("conductor", codigo);

            Conexion con = new Conexion();
            
            if(operador == 0){
                jasperReport = JasperCompileManager.compileReport("jrxml/junio17/INF-LiquidacionSueldoNoviembre17.jrxml");
            }else{
                jasperReport = JasperCompileManager.compileReport("jrxml/junio17/INF-LiquidacionSueldoNoviembre17_sm.jrxml");
            }
            

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
