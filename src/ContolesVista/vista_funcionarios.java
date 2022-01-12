/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContolesVista;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import ModelosVista.view_clerk;
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
public class vista_funcionarios extends view_clerk {

    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec;
    private String querySQL;
    private ResultSet rs;
    private Statement state;
    private int answer;
    
    public vista_funcionarios() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public vista_funcionarios(int code, String name, String ci, String telephone, String direction, String city, String office, String user) {
        
        super(code, name, ci, telephone, direction, city, office, user);
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
            
            querySQL = "SELECT nombre FROM vista_funcionarios WHERE codigo = "+id;
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            while (answer > 0) {
                
                tu = String.valueOf(rs.getString("nombre"));
                
            }
            
        } catch (Exception e) {
            
            Logger.getLogger(vista_funcionarios.class.getName()).log(Level.SEVERE, null, e);
            
        }
        
        return tu;
        
    }
    
    public vista_funcionarios Show (String id) {
        
        vista_funcionarios tu = null;
        
        try {
            
            querySQL = "SELECT * FROM vista_funcionarios WHERE codigo = '"+id+"'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                tu = new vista_funcionarios(rs.getInt("codigo"), rs.getString("nombre"),
                rs.getString("ci"), rs.getString("telefono"), rs.getString("direccion"),
                rs.getString("ciudad"), rs.getString("cargo"), rs.getString("usuario"));
                
            }
            
        } catch (Exception e) {
            
            Logger.getLogger(vista_clientes.class.getName()).log(Level.SEVERE, null, e);
            
        }
        
        return tu;
        
    }
        
    public ArrayList <vista_funcionarios> Buscar() {
        
        ArrayList <vista_funcionarios> all = new ArrayList<>();
        
        try {
            
            querySQL = "SELECT * FROM vista_funcionarios";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new vista_funcionarios(rs.getInt("codigo"), rs.getString("nombre"),
                rs.getString("ci"), rs.getString("telefono"), rs.getString("direccion"),
                rs.getString("ciudad"), rs.getString("cargo"), rs.getString("usuario")));
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(vista_funcionarios.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return all;
        
    }
    
}
