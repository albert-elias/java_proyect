/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContolesVista;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import ModelosVista.view_client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class vista_clientes extends view_client {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec;
    private String querySQL;
    private ResultSet rs;
    private Statement state;
    private int answer;

    public vista_clientes() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public vista_clientes(int codigo, String name, String ruc_ci, String telephone, String direction, String city) {
        
        super(codigo, name, ruc_ci, telephone, direction, city);
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }
    
    public String Consult (int id) {
        
        String tu = "";
        
        try {
            
            querySQL = "SELECT nombre FROM vista_clientes WHERE codigo = "+id;
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            while (answer > 0) {
                
                tu = String.valueOf(rs.getString("nombre"));
                
            }
            
        } catch (Exception e) {
            
            Logger.getLogger(vista_clientes.class.getName()).log(Level.SEVERE, null, e);
            
        }
        
        return tu;
        
    }
    
    public vista_clientes ShowCity (String id) {
        
        vista_clientes tu = null;
        
        try {
            
            querySQL = "SELECT * FROM vista_clientes WHERE codigo = '"+id+"'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                tu = new vista_clientes(rs.getInt("codigo"), rs.getString("nombre"),
                rs.getString("ruc/ci"), rs.getString("telefono"),
                rs.getString("direccion"), rs.getString("ciudad"));
                
            }
            
        } catch (Exception e) {
            
            Logger.getLogger(vista_clientes.class.getName()).log(Level.SEVERE, null, e);
            
        }
        
        return tu;
        
    }
        
    public ArrayList <vista_clientes> Buscar() {
        
        ArrayList <vista_clientes> all = new ArrayList<>();
        
        try {
            
            querySQL = "SELECT * FROM vista_clientes";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new vista_clientes(rs.getInt("codigo"), rs.getString("nombre"), rs.getString("ruc/ci"),
                rs.getString("telefono"), rs.getString("direccion"), rs.getString("ciudad")));
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(vista_clientes.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return all;
        
    }
    
}
