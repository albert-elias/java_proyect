/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import Modelos.ConfirmarVenta_M;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ConfirmarVentas_C extends ConfirmarVenta_M {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec = null;
    private PreparedStatement ps = null;
    private String querySQL;
    private ResultSet rs = null;
    private Statement state;
    private int answer;

    public ConfirmarVentas_C() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public ConfirmarVentas_C(int id_modo_pago, int id_venta, int monto) {
        
        super(id_modo_pago, id_venta, monto);
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
            
            querySQL = "insert into detalle_modopago values ("+id_modo_pago+", "+id_venta+", "+monto+")";
            
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } 
            
        } catch (Exception ex) {
            
            System.err.println(ex.getMessage());
            
        }
    
        return false;
        
    }
    
    public String Count (int venta) {
    
        String num = null;
        
        try {
            
            querySQL = "select count(modo_pago_id) from detalle_modopago where ventas_id = " + venta;
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                num = rs.getString(1);
            
            }
            
            
        } catch (Exception ex) {
            
            Logger.getLogger(DetalleVentas_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return num;
    
    }
    
    public String Monto (int id) {
        
        String precio = "";
        
        try {
            
            querySQL = "SELECT monto FROM detalle_modopago WHERE modo_pago_id = " + id;
            
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                precio = String.valueOf(rs.getInt("monto"));
                
            }
            
        } catch (Exception e) {
            
            Logger.getLogger(ConfirmarVentas_C.class.getName()).log(Level.SEVERE, null, e);
            System.err.println(e.getMessage());
            
        }
        
        return precio;
        
    }
    
}
