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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
            
            querySQL = "select * from mercaderias where id ='"+cod+"'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new Mercaderias_C(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"),
                rs.getInt("stock"), rs.getInt("precio"), rs.getString("descripcion"));
                
            }
            
        } catch (Exception ex) {
            
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
            
        } catch (Exception ex) {
            
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
            
        } catch (Exception e) {
            
            System.err.println("Error" + e.getMessage());
            
        }
        
        return String.valueOf(price);
    
    }
    
    public DefaultTableModel Search4ID (String search) {
        
        String [] items = {"id", "codigo", "nombre", "stock", "precio", "descipcion"};
        String [] files = new String [6];
        
        DefaultTableModel model = new DefaultTableModel(null, items);
        querySQL = "select * from mercaderias where id like '%"+search+"%'";
        
        try {
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                files [0] = rs.getString("id");
                files [1] = rs.getString("codigo");
                files [2] = rs.getString("nombre");
                files [3] = rs.getString("stock");
                files [4] = rs.getString("precio");
                files [5] = rs.getString("descripcion");
                
                model.addRow(files);
                
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al conectar. "+e.getMessage());
            
        }
        
        finally {
        
            try {
                
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (rutaConec != null) rutaConec.close();
                
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, e);
                
            }
            
        }
        
        return model;
    
    }
    
    public DefaultTableModel Search4Name (String search) {
        
        String [] items = {"id", "codigo", "nombre", "stock", "precio", "descipcion"};
        String [] files = new String [6];
        
        DefaultTableModel model = new DefaultTableModel(null, items);
        querySQL = "select * from mercaderias where nombre like '%"+search+"%'";
        
        try {
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                files [0] = rs.getString("id");
                files [1] = rs.getString("codigo");
                files [2] = rs.getString("nombre");
                files [3] = rs.getString("stock");
                files [4] = rs.getString("precio");
                files [5] = rs.getString("descripcion");
                
                model.addRow(files);
                
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al conectar. "+e.getMessage());
            
        }
        
        finally {
        
            try {
                
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (rutaConec != null) rutaConec.close();
                
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, e);
                
            }
            
        }
        
        return model;
    
    }
    
    public DefaultTableModel Search4Code (String search) {
        
        String [] items = {"id", "codigo", "nombre", "stock", "precio", "descipcion"};
        String [] files = new String [6];
        
        DefaultTableModel model = new DefaultTableModel(null, items);
        querySQL = "select * from mercaderias where codigo like '%"+search+"%'";
        
        try {
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                files [0] = rs.getString("id");
                files [1] = rs.getString("codigo");
                files [2] = rs.getString("nombre");
                files [3] = rs.getString("stock");
                files [4] = rs.getString("precio");
                files [5] = rs.getString("descripcion");
                
                model.addRow(files);
                
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al conectar. "+e.getMessage());
            
        }
        
        finally {
        
            try {
                
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (rutaConec != null) rutaConec.close();
                
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, e);
                
            }
            
        }
        
        return model;
    
    }
    
    public DefaultTableModel Search4Desc (String search) {
        
        String [] items = {"id", "codigo", "nombre", "stock", "precio", "descipcion"};
        String [] files = new String [6];
        
        DefaultTableModel model = new DefaultTableModel(null, items);
        querySQL = "select * from mercaderias where descripcion like '%"+search+"%'";
        
        try {
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                files [0] = rs.getString("id");
                files [1] = rs.getString("codigo");
                files [2] = rs.getString("nombre");
                files [3] = rs.getString("stock");
                files [4] = rs.getString("precio");
                files [5] = rs.getString("descripcion");
                
                model.addRow(files);
                
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al conectar. "+e.getMessage());
            
        }
        
        finally {
        
            try {
                
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (rutaConec != null) rutaConec.close();
                
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, e);
                
            }
            
        }
        
        return model;
    
    }
    
    public DefaultTableModel Search4View (String name) {
        
        String [] items = {"Codigo", "Nombre", "Descripcion"};
        String [] files = new String [3];
        DefaultTableModel model = new DefaultTableModel(null, items);
        
        try {
            
            querySQL = "select * from mercaderias where codigo like '"+name+"%'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                files [0] = rs.getString("codigo");
                files [1] = rs.getString("nombre");
                files [2] = rs.getString("descripcion");
                
                model.addRow(files);
                
            }
            
        } catch (Exception ex) {
            
            System.err.println(ex);
            
        }
        
        return model;
        
    }
    
}
