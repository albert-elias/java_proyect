/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import Modelos.ModoPago_M;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albert Acosta
 */
public class ModoPago_C extends ModoPago_M {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec;
    private PreparedStatement ps;
    private String querySQL;
    private ResultSet rs;
    private Statement state;
    private int answer;

    public ModoPago_C() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public ModoPago_C(int id, String name) {
        
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
            
            querySQL = "insert into modo_pago values ("+id+", '"+name+"')";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } 
            
        } catch (Exception ex) {
            
            Logger.getLogger(ModoPago_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Delete (String code) {
        
        try {
            
            querySQL = "delete from modo_pago where id = '"+code+"'";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(ModoPago_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Update () {
        
        try {
            
            querySQL = "update modo_pago set nombre = '"+name+"' where id = "+id+"";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(ModoPago_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public ModoPago_C Search (String cod) {
        
        ModoPago_C val = null;
        
        try {
            
            querySQL = "select * from modo_pago where id ='"+cod+"'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new ModoPago_C(rs.getInt("id"), rs.getString("nombre"));
                
            }
            
        } catch (Exception ex) {
            
            System.err.println(ex);
            
        }
        
        return val;
        
    }
    
    public ArrayList <ModoPago_C> SearchAll (){
        
        ArrayList<ModoPago_C> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from modo_pago";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new ModoPago_C(rs.getInt("id"), rs.getString("nombre")));
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(ModoPago_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return all;
        
    }
    
    public String New () {
    
        String num = null;
        
        try {
            
            querySQL = "select max(id)+1 from modo_pago";
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                num = rs.getString(1);
            
            }
            
            
        } catch (Exception ex) {
            
            Logger.getLogger(ModoPago_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return num != null ? num: "1";
    
    }
    
    public String ConsultID (String name) {
    
        int id = 0;
        
        try {
            
            querySQL = "select id from modo_pago where nombre = '"+ name +"' ";
            
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                id = rs.getInt("id");
                
            }
            
        } catch (Exception e) {
            
            System.err.println(e.getMessage());
            
        }
        
        return String.valueOf(id);
    
    }
    
    public String ConultName (int id) {
    
        String name = "";
        
        try {
            
            querySQL = "select nombre from modo_pago where id = " + id;
            
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                name = rs.getString("nombre");
                
            }
            
        } catch (Exception e) {
            
            System.err.println("Error al consultar modo de pago" + e.getMessage());
            
        }
    
        return name;
        
    }
    
}
