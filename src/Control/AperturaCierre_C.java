/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import Modelos.AperturaCierre_M;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class AperturaCierre_C extends AperturaCierre_M {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec;
    private PreparedStatement ps;
    private String querySQL;
    private ResultSet rs;
    private Statement state;
    private int answer;

    public AperturaCierre_C() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public AperturaCierre_C(int id, String date, String collect, int fun) {
        
        super(id, date, collect, fun);
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }
    
    public boolean Insert () {
        
        try {
            
            querySQL = "insert into apertura_cierre values ("+id+", '"+date+"', '"+collect+"', "+fun+")";
            
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } 
            
        } catch (Exception ex) {
            
            Logger.getLogger(AperturaCierre_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Update () {
        
        try {
            
            querySQL = "update apertura_cierre set "
            + " fecha = '"+date+"', total_recaudacion = '"+collect+"',"
            + " funcionarios_id = '"+fun+"' where id = "+id+"";
            
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(AperturaCierre_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public AperturaCierre_C Search (String cod) {
        
        AperturaCierre_C val = null;
        
        try {
            
            querySQL = "select * from apertura_cierre where id ='"+cod+"'";
            
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new AperturaCierre_C(rs.getInt("id"),
                rs.getString("fecha"), rs.getString("total_recaudacion"),
                rs.getInt("funcionarios_id"));
                
            }
            
        } catch (Exception ex) {
            
            System.err.println(ex);
            
        }
        
        return val;
        
    }
    
    public ArrayList <AperturaCierre_C> SearchAll (){
        
        ArrayList<AperturaCierre_C> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from apertura_cierre";
            
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new AperturaCierre_C(rs.getInt("id"),
                rs.getString("fecha"), rs.getString("total_recaudacion"),
                rs.getInt("funcionarios_id")));
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(AperturaCierre_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return all;
        
    }
    
    public String New() {
        
        String val = null;
        
        try {
            
            querySQL = "select max(id)+1 from apertura_cierre";
            
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = rs.getString(1);
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(AperturaCierre_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return val != null ? val: "1";
        
    }
    
    public static String fechaActual() {
        
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-YYYY");
        return formatoFecha.format(fecha);
        
    }

    public void showApC(){
  
        try {

            String ubicacion = "C:\\Users\\User\\JaspersoftWorkspace\\estoy\\apertura_cierre.jasper";
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(ubicacion);
            JasperPrint jp = JasperFillManager.fillReport(report, null, rutaConec); 
            JasperViewer view = new JasperViewer(jp, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
            view.setVisible(true);

        } catch (JRException e) {

            System.out.println(e.getMessage());

        }

    }
    
}
