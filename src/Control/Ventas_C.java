/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import Modelos.Ventas_M;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Ventas_C extends Ventas_M {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec = null;
    private PreparedStatement ps = null;
    private String querySQL;
    private ResultSet rs = null;
    private Statement state;
    private int answer;

    public Ventas_C() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public Ventas_C(int id, String fecha, String factura, int monto, int id_cliente, int id_vendedor, int estado) {
        
        super(id, fecha, factura, monto, id_cliente, id_vendedor, estado);
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
            
            querySQL = "insert into ventas values ("+id+", '"+fecha+"', '"+factura+"',"
            + " "+monto+", "+id_cliente+", "+id_vendedor+", "+estado+")";
            
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } 
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Ventas_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Delete (String code) {
        
        try {
            
            querySQL = "delete from ventas where id = '"+code+"'";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Ventas_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Update () {
        
        try {
            
            querySQL = "update ventas set fecha = '"+fecha+"', factura = '"+factura+"',"
            + " monto = "+monto+", clientes_id = "+id_cliente+", funcionarios_id = "+id_vendedor+","
            + " estado = "+estado+" where id = "+id+"";
            
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Ventas_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public Ventas_C Search (String cod) {
        
        Ventas_C val = null;
        
        try {
            
            querySQL = "select * from ventas where id ='"+cod+"'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new Ventas_C(rs.getInt("id"), rs.getString("fecha"),
                rs.getString("factura"), rs.getInt("monto"), rs.getInt("clientes_id"),
                rs.getInt("funcionarios_id"), rs.getInt("estado"));
                
            }
            
        } catch (SQLException ex) {
            
            System.err.println(ex);
            
        }
        
        return val;
        
    }
    
    public ArrayList <Ventas_C> SearchAll (){
        
        ArrayList<Ventas_C> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from ventas";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new Ventas_C(rs.getInt("id"), rs.getString("fecha"),
                rs.getString("factura"), rs.getInt("monto"), rs.getInt("clientes_id"),
                rs.getInt("funcionarios_id"), rs.getInt("estado")));
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Ventas_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return all;
        
    }
    
    public String New () {
    
        String num = null;
        
        try {
            
            querySQL = "select max(id)+1 from ventas";
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                num = rs.getString(1);
            
            }
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Ventas_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return num != null ? num: "1";
    
    }
    
    public static String fechaActual() {
        
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-YYYY");
        return formatoFecha.format(fecha);
        
    }
    
    public String Consulta (int venta) {
    
        int id = 0;
        
        try {
            
            querySQL = "select id from ventas where id = " + venta;
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {    
                
                id = rs.getInt("id");
                
            }
            
        } catch (SQLException e) {
            
            System.err.println("Error al consultar id de venta"+e.getMessage());
            
        }
        
        return String.valueOf(id);
    
    }
    
    public String buscaVend (int venta) {
    
        int id = 0;
        
        try {
            
            querySQL = "select clientes_id from ventas where id = " + venta;
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {    
                
                id = rs.getInt("clientes_id");
                
            }
            
        } catch (Exception e) {
            
            System.err.println("Error al consultar id de venta"+e.getMessage());
            
        }

        finally {
        
            try {
                
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (rutaConec != null) rutaConec.close();
                
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null, e);
                
            }
            
        }
        
        return String.valueOf(id);
    
    }
    
    public String buscaFun (int venta) {
    
        int id = 0;
        
        try {
            
            querySQL = "select funcionarios_id from ventas where id = " + venta;
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {    
                
                id = rs.getInt("funcionarios_id");
                
            }
            
        } catch (SQLException e) {
            
            System.err.println("Error al consultar id de venta"+e.getMessage());
            
        }
        
        return String.valueOf(id);
    
    }
    
    public Integer consultAmount (int venta) {
    
        int id = 0;
        
        try {
            
            querySQL = "SELECT monto FROM ventas WHERE id = " + venta;
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                id = rs.getInt("monto");
                
            }
            
        } catch (SQLException e) {
            
            System.err.println(e.getMessage());
            
        }
        
        return id;
    
    }
    
}
