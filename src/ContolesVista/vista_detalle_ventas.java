/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContolesVista;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import ModelosVista.view_detail_sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class vista_detalle_ventas extends view_detail_sale {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec = null;
    private PreparedStatement ps = null;
    private String querySQL;
    private ResultSet rs = null;
    private Statement state;
    private int answer;

    public vista_detalle_ventas() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public vista_detalle_ventas(String producto, int cantidad, int precio, int monto_final) {
        
        super(producto, cantidad, precio, monto_final);
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }
    
    public ArrayList<vista_detalle_ventas> Search (int code) {
    
        ArrayList<vista_detalle_ventas> res = new ArrayList<>();
        
        try {
            
            querySQL = "select * from vista_detalle_venta where venta = " + code;
            
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                res.add(new vista_detalle_ventas(rs.getString("producto"),
                rs.getInt("cantidad"), rs.getInt("precio"), rs.getInt("monto_total")));
                
            }
            
        } catch (Exception e) {
            
            System.err.println(e);
            
        }
        
        return res;
    
    }
    
    public String ConsultMonto (int mer) {
    
        int price = 0;
        
        try {
            
            querySQL = "select sum(monto_total) from vista_detalle_venta where venta = " + mer;
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                price = rs.getInt("sum(monto_total)");
                
            }
            
        } catch (Exception e) {
            
            System.err.println("Error" + e.getMessage());
            
        }
        
        return String.valueOf(price);
    
    }
    
}
