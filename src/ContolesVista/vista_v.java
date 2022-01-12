/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContolesVista;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import ModelosVista.view_v;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class vista_v extends view_v {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec;
    private String querySQL;
    private ResultSet rs;
    private Statement state;
    private int answer;

    public vista_v() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public vista_v(int vend, String fun, int usu, int cod) {
        
        super(vend, fun, usu, cod);
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }
    
    public ArrayList <vista_v> SearchAll() {
        
        ArrayList <vista_v> all = new ArrayList<>();
        
        try {
            
            querySQL = "SELECT * FROM vista_vendedor WHERE codigo = 1";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new vista_v(rs.getInt("vendedor"), rs.getString("funcionario"), rs.getInt("usuario"), rs.getInt("codigo")));
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(vista_v.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return all;
        
    }
    
    public vista_v Search (String cod) {
        
        vista_v val = null;
        
        try {
            
            querySQL = "select * from vista_vendedor where vendedor = '"+cod+"'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new vista_v(rs.getInt("vendedor"), rs.getString("funcionario"), rs.getInt("usuario"), rs.getInt("codigo"));
                
            }
            
        } catch (Exception ex) {
            
            System.err.println(ex);
            
        }
        
        return val;
        
    }
    
    public DefaultTableModel Consult (String name) {
        
        String [] items = {"vendedor", "funcionario"};
        String [] files = new String [2];
        DefaultTableModel model = new DefaultTableModel(null, items);
        
        try {
            
            querySQL = "select * from vista_vendedor where funcionario like '"+name+"%'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                files [0] = rs.getString("vendedor");
                files [1] = rs.getString("funcionario");
                
                model.addRow(files);
                
            }
            
        } catch (Exception ex) {
            
            System.err.println(ex);
            
        }
        
        return model;
        
    }
    
}
