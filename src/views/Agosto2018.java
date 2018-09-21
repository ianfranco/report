package views;

import dao.Conexion;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;









public class Agosto2018
{
  private ReporterVBView frame;
  private MesSelectorlLiquidacionView view;
  
  public Agosto2018(ReporterVBView frame, MesSelectorlLiquidacionView view)
  {
    this.frame = frame;
    this.view = view;
  }
  
  public void loadLiquidacion(boolean flag, int operador) {
    JasperReport jasperReport = null;
    
    try
    {
      String codigo = view.getCodigo();
      Map params = new HashMap();
      
      params.put("fecha", view.getFecha());
      
      System.err.println("FECHA LIQUIDACION:" + view.getFecha());
      
      params.put("año", view.getAnio());
      params.put("mes", view.getMes());
      params.put("conductor", codigo);
      
      Conexion con = new Conexion();
      
      switch (operador) {
      case 0: 
        jasperReport = JasperCompileManager.compileReport("jrxml/junio17/INF-LiquidacionSueldoAgosto18_conductor.jrxml");
        break;
      case 1: 
        jasperReport = JasperCompileManager.compileReport("jrxml/junio17/INF-LiquidacionSueldoJulio18_conductor_sm.jrxml");
        break;
      case 2: 
        jasperReport = JasperCompileManager.compileReport("jrxml/junio17/INF-LiquidacionSueldoAgosto18_flota_conductor.jrxml");
      }
      
      

      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con.getConnection());
      
      if (flag) {
        frame.setNewReport(new JRViewer(jasperPrint), "Liquidación de Sueldo");
        System.err.println("conductor:" + codigo);
        System.err.println("VIEW");
      } else {
        JasperPrintManager.printReport(jasperPrint, false);
        System.err.println("PRINT");
      }
    }
    catch (JRException jre) {
      System.err.println(jre.getMessage());
    }
  }
}
