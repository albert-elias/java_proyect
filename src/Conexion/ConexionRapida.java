/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class ConexionRapida {
    
    private static ConexionRapida instanciaConexion;
    private Connection Conexion = null;
    public ParametrosConexionBD p;
    public ConexionBD c;
    public Connection rutaConec;
    public PreparedStatement ps;
    public String querySQL;
    public ResultSet rs;
    public Statement state;

    public ConexionRapida() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }
    
    public static ConexionRapida getInstanciaConexion() {
        if (instanciaConexion == null) {
            instanciaConexion = new ConexionRapida();
        }
        return instanciaConexion;
    }
    
}
