/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContolesVista;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import ModelosVista.view_users;
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
public class vista_usuarios extends view_users {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec;
    private String querySQL;
    private ResultSet rs;
    private Statement state;
    private int answer;

    public vista_usuarios() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public vista_usuarios(int codigo, String usuario, String clave, String tipo) {
        
        super(codigo, usuario, clave, tipo);
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }
        
    public ArrayList <vista_usuarios> buscarusuario() {
        
        ArrayList <vista_usuarios> all = new ArrayList<>();
        
        try {
            
            querySQL = "SELECT * FROM vista_usuarios";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new vista_usuarios(rs.getInt("codigo"), rs.getString("usuario"), rs.getString("clave"),
                rs.getString("tipo")));
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(vista_usuarios.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return all;
        
    }
    
}
