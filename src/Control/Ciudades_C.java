/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import Modelos.Ciudades_M;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
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
public class Ciudades_C extends Ciudades_M {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec;
    private PreparedStatement ps;
    private String querySQL;
    private ResultSet rs;
    private Statement state;
    private int answer;

    public Ciudades_C() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public Ciudades_C(int id, String name) {
        
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
            
            querySQL = "insert into ciudades values ("+id+",'"+name+"')";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } 
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Ciudades_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Delete (String code) {
        
        try {
            
            querySQL = "delete from ciudades where id = '"+code+"'";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Ciudades_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Update () {
        
        try {
            
            querySQL = "update ciudades set nombre = '"+name+"' where id = "+id+"";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Ciudades_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public Ciudades_C Search (String cod) {
        
        Ciudades_C val = null;
        
        try {
            
            querySQL = "select * from ciudades where id ='"+cod+"'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new Ciudades_C(rs.getInt("id"), rs.getString("nombre"));
                
            }
            
        } catch (SQLException ex) {
            
            System.err.println(ex);
            
        }
        
        return val;
        
    }

    public Ciudades_C consultCiudad (String cod) {
        
        Ciudades_C val = null;
        
        try {
            
            querySQL = "select * from ciudades where nombre ='"+cod+"'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new Ciudades_C(rs.getInt("id"), rs.getString("nombre"));
                
            }
            
        } catch (SQLException ex) {
            
            System.err.println(ex);
            
        }
        
        return val;
        
    }
    
    public ArrayList <Ciudades_C> SearchAll (){
        
        ArrayList<Ciudades_C> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from ciudades";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new Ciudades_C(rs.getInt("id"), rs.getString("nombre")));
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(CargosC.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        return all;

    }

    public ArrayList <Ciudades_C> Consult (String search){
        
        ArrayList<Ciudades_C> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from ciudades where nombre like '%"+search+"%'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new Ciudades_C(rs.getInt("codigo"), rs.getString("nombre")));
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Ciudades_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        return all;

    }
    
    public String New () {
    
        String numciu = null;
        
        try {
            
            querySQL = "select max(id)+1 from ciudades";
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                numciu = rs.getString(1);
            
            }
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Ciudades_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return numciu != null ? numciu: "1";
    
    }
    
    public String CulsultName (int id) {
    
        String name = "";
        
        try {
            
            querySQL = "select nombre from ciudades where id = "+id;
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                name = rs.getString("nombre");
                
            }
            
        } catch (SQLException e) {
            
            System.err.println(e + "Error");
            
        }
        
        return name;
    
    }

    public void showCiudades(){

        String ubication = "C:\\Users\\User\\JaspersoftWorkspace\\estoy\\ciudades.jasper";
  
        try {

            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(ubication); 
            JasperPrint jp = JasperFillManager.fillReport(report, null, rutaConec); 
            JasperViewer view = new JasperViewer(jp, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
            view.setVisible(true);

        } catch (JRException e) {

            System.out.println(e.getMessage());

        }

    }
    
}
