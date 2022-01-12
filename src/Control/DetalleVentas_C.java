/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import Modelos.DetalleVentas_M;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DetalleVentas_C extends DetalleVentas_M {

    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec = null;
    private PreparedStatement ps = null;
    private String querySQL;
    private ResultSet rs = null;
    private Statement state;
    private int answer;
    
    public DetalleVentas_C() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public DetalleVentas_C(int id_venta, int id_mercaderia, int cantidad, int precio, int precio_final) {
        
        super(id_venta, id_mercaderia, cantidad, precio, precio_final);
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
            
            querySQL = "insert into detalle_ventas values ("+id_venta+","
            + " "+id_mercaderia+", "+cantidad+", "+precio+", "+precio_final+")";
            
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } 
            
        } catch (Exception ex) {
            
            Logger.getLogger(DetalleVentas_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Delete (String code) {
        
        try {
            
            querySQL = "delete from detalle_ventas where mercaderias_id = '"+code+"'";
            
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(DetalleVentas_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean DeleteAll (int id) {
    
        try {
            
            querySQL = "delete from detalle_ventas where ventas_id = " + id;
            
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
            
            }
            
        } catch (Exception e) {
            
            Logger.getLogger(DetalleVentas_C.class.getName()).log(Level.SEVERE, null, e.getMessage());
            
        }
        
        return false;
    
    }
    
    public boolean Update () {
        
        try {
            
            querySQL = "update detalle_ventas set mercaderias_id = "+id_mercaderia+","
            + " cantidad = "+cantidad+", precio = "+precio+", precio_final = "+precio_final+","
            + " where ventas_id = "+id_venta+"";
            
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(DetalleVentas_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public DetalleVentas_C Search (String cod) {
        
        DetalleVentas_C val = null;
        
        try {
            
            querySQL = "select * from detalle_ventas where mercaderias_id ='"+cod+"'";
            
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new DetalleVentas_C(rs.getInt("ventas_id"), rs.getInt("mercaderias_id"),
                rs.getInt("cantidad"), rs.getInt("precio"), rs.getInt("precio_final"));
                
            }
            
        } catch (Exception ex) {
            
            System.err.println(ex);
            
        }
        
        return val;
        
    }
    
    public ArrayList <DetalleVentas_C> SearchAll (){
        
        ArrayList<DetalleVentas_C> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from detalle_ventas";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new DetalleVentas_C(rs.getInt("ventas_id"), rs.getInt("mercaderias_id"),
                rs.getInt("cantidad"), rs.getInt("precio"), rs.getInt("precio_final")));
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(DetalleVentas_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return all;
        
    }
    
    public Integer Suma (int value) {
    
        Integer val = null;
        
        try {
            
            querySQL = "select sum(precio_final) from detalle_ventas where ventas_id = " + value;
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                val = rs.getInt(1);
                
            }
            
        } catch (Exception ex) {
            
            System.err.println(ex.getMessage());
            
        }
        
        return val;
    
    }
    
}
