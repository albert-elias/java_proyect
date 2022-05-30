/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import Modelos.Clientes_M;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Clientes_C extends Clientes_M {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec = null;
    private String querySQL;
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement state;
    private int answer;

    public Clientes_C() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public Clientes_C(int id, String ruc_ci, String nombre, String telefono, String direccion, int ciudad) {
        
        super(id, ruc_ci, nombre, telefono, direccion, ciudad);
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
            
            querySQL = "insert into clientes values ("+id+", '"+ruc_ci+"', '"+nombre+"', '"+telefono+"', '"+direccion+"', '"+ciudad+"')";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } 
            
        } catch (Exception ex) {
            
            Logger.getLogger(Clientes_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Delete (String code) {
        
        try {
            
            querySQL = "delete from clientes where id = '"+code+"'";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(Clientes_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Update () {
        
        try {
            
            querySQL = "update clientes set nombre = '"+nombre+"', ruc_ci = '"+ruc_ci+"', telefono = "+telefono+","
                     + "direccion = '"+direccion+"', ciudades_id = '"+ciudad+"' where id = "+id+"";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(Clientes_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public Clientes_C Search (String cod) {
        
        Clientes_C val = null;
        
        try {
            
            querySQL = "select * from clientes where id ='"+cod+"'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new Clientes_C(rs.getInt("id"), rs.getString("nombre"),
                rs.getString("ruc_ci"), rs.getString("telefono"),
                rs.getString("direccion"), rs.getInt("ciudades_id"));
                
            }
            
        } catch (SQLException ex) {
            
            System.err.println(ex);
            
        }
        
        return val;
        
    }
    
    public ArrayList <Clientes_C> SearchAll (){
        
        ArrayList<Clientes_C> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from clientes";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new Clientes_C(rs.getInt("id"), rs.getString("nombre"),
                rs.getString("ruc_ci"), rs.getString("telefono"),
                rs.getString("direccion"), rs.getInt("ciudades_id")));
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Clientes_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return all;
        
    }
    
    public String New () {
    
        String num = null;
        
        try {
            
            querySQL = "select max(id)+1 from clientes";
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                num = rs.getString(1);
            
            }
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Clientes_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return num != null ? num: "1";
    
    }
    
    public Clientes_C ConsultRuc (String cod) {
        
        Clientes_C val = null;
        
        try {
            
            querySQL = "select * from clientes where ruc_ci ='"+cod+"'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new Clientes_C(rs.getInt("id"), rs.getString("nombre"),
                rs.getString("ruc_ci"), rs.getString("telefono"),
                rs.getString("direccion"), rs.getInt("ciudades_id"));
                
            }
            
        } catch (SQLException ex) {
            
            System.err.println(ex);
            
        }
        
        return val;
        
    }
    
    public String CulsultName (int id) {
    
        String name = "";
        
        try {
            
            querySQL = "select nombre from clientes where id = "+id;
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                name = rs.getString("nombre");
                
            }
            
        } catch (Exception e) {
            
            System.err.println(e + "Error");
            
        }
        
        return name;
    
    }
    
    public DefaultTableModel Consult (String name) {
        
        String [] items = {"id", "nombre"};
        String [] files = new String [2];
        DefaultTableModel model = new DefaultTableModel(null, items);
        
        try {
            
            querySQL = "select * from clientes where nombre like '"+name+"%'";
            
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                files [0] = rs.getString("id");
                files [1] = rs.getString("nombre");
                
                model.addRow(files);
                
            }
            
        } catch (Exception ex) {
            
            System.err.println(ex);
            
        }
        
        return model;
        
    }
    
}
