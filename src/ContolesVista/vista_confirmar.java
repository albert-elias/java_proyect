/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContolesVista;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import ModelosVista.view_confirm;
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
public class vista_confirmar extends view_confirm {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec = null;
    private PreparedStatement ps = null;
    private String querySQL;
    private ResultSet rs = null;
    private Statement state;
    private int answer;

    public vista_confirmar() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public vista_confirmar(int code, String client, String clerk) {
        
        super(code, client, clerk);
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }
    
    public ArrayList <vista_confirmar> SearchAll (){
        
        ArrayList<vista_confirmar> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from vista_confirmar_venta";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new vista_confirmar(rs.getInt("codigo"), rs.getString("cliente"), rs.getString("vendedor")));
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(vista_confirmar.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return all;
        
    }
    
}
