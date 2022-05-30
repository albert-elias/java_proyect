/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import Modelos.Mercaderias_M;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
public class Mercaderias_C extends Mercaderias_M {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec = null;
    private PreparedStatement ps = null;
    private String querySQL;
    private ResultSet rs = null;
    private Statement state;
    private int answer;

    public Mercaderias_C() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public Mercaderias_C(int id, String codigo, String nombre, int stock, int precio, String descripcion) {
        
        super(id, codigo, nombre, stock, precio, descripcion);
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
            
            querySQL = "insert into mercaderias values ("+id+", '"+codigo+"', '"+nombre+"', "+stock+", "+precio+", '"+descripcion+"')";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } 
            
        } catch (Exception ex) {
            
            Logger.getLogger(Mercaderias_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Delete (String code) {
        
        try {
            
            querySQL = "delete from mercaderias where id = '"+code+"'";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(Mercaderias_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Update () {
        
        try {
            
            querySQL = "update mercaderias set codigo = '"+codigo+"', nombre = '"+nombre+"', stock = "+stock+","
            + "precio = "+precio+", descripcion = '"+descripcion+"' where id = "+id+"";
            
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(Mercaderias_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public Mercaderias_C Search (String cod) {
        
        Mercaderias_C val = null;
        
        try {
            
            querySQL = "select * from mercaderias where id = '"+cod+"'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new Mercaderias_C(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"),
                rs.getInt("stock"), rs.getInt("precio"), rs.getString("descripcion"));
                
            }
            
        } catch (SQLException ex) {
            
            System.err.println(ex);
            
        }
        
        return val;
        
    }
    
    public Mercaderias_C Consult (String mer) {
    
        Mercaderias_C val = null;
        
        try {
            
            querySQL = "select * from mercaderias where codigo = '"+ mer +"' ";
            
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new Mercaderias_C(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"),
                rs.getInt("stock"), rs.getInt("precio"), rs.getString("descripcion"));
                
            }
            
        } catch (Exception e) {
            
            System.err.println("Error" + e.getMessage());
            
        }
        
        return val;
        
    }
    
    public Mercaderias_C Consult2 (String mer) {
    
        Mercaderias_C value = null;
        
        try {
            
            querySQL = "select codigo from estoy.mercaderias where codigo = ? ";
            
            ps = rutaConec.prepareStatement(querySQL);
            ps.setString(1, mer);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                value = new Mercaderias_C();
                value.setCodigo(rs.getString("codigo"));
                
            }
            
            return value;
            
        } catch (Exception ex) {
            
            return null;
            
        }
    
    }
    
    public ArrayList <Mercaderias_C> SearchAll (){
        
        ArrayList<Mercaderias_C> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from mercaderias";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new Mercaderias_C(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"),
                rs.getInt("stock"), rs.getInt("precio"), rs.getString("descripcion")));
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Mercaderias_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        return all;

    }
    
    public String New () {
    
        String num = null;
        
        try {
            
            querySQL = "select max(id)+1 from mercaderias";
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                num = rs.getString(1);
            
            }
            
            
        } catch (Exception ex) {
            
            Logger.getLogger(Mercaderias_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return num != null ? num: "1";
    
    }
    
    public String ConsultID (String mer) {
    
        int code = 0;
        
        try {
            
            querySQL = "select id from mercaderias where codigo = '"+mer+"' ";
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                code = rs.getInt("id");
                
            }
            
        } catch (Exception e) {
            
            System.err.println("Error" + e.getMessage());
            
        }
        
        return String.valueOf(code);
    
    }
    
    public String CulsultPrice (String mer) {
    
        int price = 0;
        
        try {
            
            querySQL = "select precio from mercaderias where codigo = '"+mer+"'";
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                price = rs.getInt("precio");
                
            }
            
        } catch (SQLException e) {
            
            System.err.println("Error" + e.getMessage());
            
        }
        
        return String.valueOf(price);
    
    }

    public ArrayList <Mercaderias_C> SearchID (String search){
        
        ArrayList<Mercaderias_C> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from mercaderias where id like '%"+search+"%'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new Mercaderias_C(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"),
                rs.getInt("stock"), rs.getInt("precio"), rs.getString("descripcion")));
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Mercaderias_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        return all;

    }

    public ArrayList <Mercaderias_C> SearchName (String search){
        
        ArrayList<Mercaderias_C> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from mercaderias where nombre like '%"+search+"%'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new Mercaderias_C(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"),
                rs.getInt("stock"), rs.getInt("precio"), rs.getString("descripcion")));
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Mercaderias_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        return all;

    }

    public ArrayList <Mercaderias_C> SearchCodigo (String search){
        
        ArrayList<Mercaderias_C> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from mercaderias where codigo like '%"+search+"%'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new Mercaderias_C(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"),
                rs.getInt("stock"), rs.getInt("precio"), rs.getString("descripcion")));
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Mercaderias_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        return all;

    }

    public ArrayList <Mercaderias_C> SearchDescription (String search){
        
        ArrayList<Mercaderias_C> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from mercaderias where descripcion like '%"+search+"%'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new Mercaderias_C(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"),
                rs.getInt("stock"), rs.getInt("precio"), rs.getString("descripcion")));
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Mercaderias_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        return all;

    }

    public void showMercaderias(){
  
        try {

            String ubicacion = "C:\\Users\\User\\JaspersoftWorkspace\\estoy\\mercaderas.jasper";
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
