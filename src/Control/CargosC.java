/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import Modelos.CargosM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class CargosC extends CargosM {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec;
    private PreparedStatement ps;
    private String querySQL;
    private ResultSet rs;
    private Statement state;
    private int answer;
    
    public CargosC () {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
    
    }
    
    public CargosC(int id, String name) {
        
        super(id, name);
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
            
            querySQL = "insert into cargos values ("+id+",'"+name+"')";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } 
            
        } catch (SQLException ex) {
            
            Logger.getLogger(CargosC.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Delete (String code) {
        
        try {
            
            querySQL = "delete from cargos where id = '"+code+"'";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(CargosC.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            
        }
    
        return false;
        
    }
    
    public boolean Update () {
        
        try {
            
            querySQL = "update cargos set nombre = '"+name+"' where id = "+id+"";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(CargosC.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public CargosC Search (String cod) {
        
        CargosC val = null;
        
        try {
            
            querySQL = "select * from cargos where id ='"+cod+"'";
            
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new CargosC(rs.getInt("id"), rs.getString("nombre"));
                
            }
            
        } catch (SQLException ex) {
            
            System.err.println(ex);
            
        }
        
        return val;
        
    }
    
    public ArrayList <CargosC> SearchAll (){
        
        ArrayList<CargosC> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from cargos";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new CargosC(rs.getInt("id"), rs.getString("nombre")));
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(CargosC.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return all;
        
    }
    
    public String New () {
    
        String numcar = null;
        
        try {
            
            querySQL = "select max(id)+1 from cargos";
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                numcar = rs.getString(1);
            
            }
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(CargosC.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return numcar != null ? numcar: "1";
    
    }
    
    public CargosC ConsultId (String name) {
    
        CargosC n = null;
        
        try {
            
            querySQL = "select * from cargos where nombre = '"+name+"'";
            
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {                
                
                n = new CargosC(rs.getInt("id"), rs.getString("nombre"));
                System.out.println(n);
                
            }
            
        } catch (SQLException e) {
            
            System.err.println(e+"Hubo un error en el SQL");
            
        }
        
        return n;
    
    }

    public void showCargos(){
  
        try {

            String ubicacion = "C:\\Users\\User\\JaspersoftWorkspace\\estoy\\cargos.jasper";
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(ubicacion);
            JasperPrint jp = JasperFillManager.fillReport(report, null, rutaConec); 
            JasperViewer view = new JasperViewer(jp, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
            view.setVisible(true);

        } catch (JRException e) {

            System.out.println(e.getMessage());

        }

    }

//    public class SizeProperties {
//
//        private static SizeProperties _instance;
//        private Sizes _selectedSize;
//
//        public enum Sizes{SMALL, MEDIUM, LARGE}
//
//        private SizeProperties(){
//            _selectedSize = Sizes.SMALL;
//        }
//
//        public static SizeProperties getInstance(){
//            if(_instance == null){
//                _instance = new SizeProperties();
//            }
//            return _instance;
//        }
//
//        public Sizes getSelectedSize(){
//            return _selectedSize;
//        }
//
//        public void setSelectedSize(Sizes size){
//            _selectedSize = size;
//        }
//    }

    
}
