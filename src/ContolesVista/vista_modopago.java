/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContolesVista;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import ModelosVista.view_modepay;
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
public class vista_modopago extends view_modepay {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec;
    private String querySQL;
    private ResultSet rs;
    private Statement state;
    private int answer;

    public vista_modopago() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public vista_modopago(String modo, int monto) {
        
        super(modo, monto);
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }
    
    public ArrayList <vista_modopago> buscarmodopago(int id) {
        
        ArrayList <vista_modopago> all = new ArrayList<>();
        
        try {
            
            querySQL = "SELECT * FROM vista_modp_pago where venta = 0" + id;
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new vista_modopago(rs.getString("modo"), rs.getInt("monto")));
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(vista_modopago.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return all;
        
    }
    
}
