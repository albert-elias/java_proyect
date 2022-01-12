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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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

    public Ventas_C(int id, String fecha, String factura, int id_cliente, int id_vendedor) {
        
        super(id, fecha, factura, id_cliente, id_vendedor);
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
            + " "+id_cliente+", "+id_vendedor+")";
            
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } 
            
        } catch (Exception ex) {
            
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
            
        } catch (Exception ex) {
            
            Logger.getLogger(Ventas_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Update () {
        
        try {
            
            querySQL = "update ventas set fecha = '"+fecha+"', factura = '"+factura+"',"
            + " clientes_id = "+id_cliente+", funcionarios_id = "+id_vendedor+" where id = "+id+"";
            
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
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
                rs.getString("factura"), rs.getInt("clientes_id"),
                rs.getInt("funcionarios_id"));
                
            }
            
        } catch (Exception ex) {
            
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
                rs.getString("factura"), rs.getInt("clientes_id"),
                rs.getInt("funcionarios_id")));
                
            }
            
        } catch (Exception ex) {
            
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
            
            
        } catch (Exception ex) {
            
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
            
        } catch (Exception e) {
            
            System.err.println("Error al consultar id de venta"+e.getMessage());
            
        }
        
        return String.valueOf(id);
    
    }
    
    public DefaultTableModel Search4ID (String search) {
        
        String [] items = {"codigo", "factura", "cliente", "monto", "vendedor", "fecha"};
        String [] files = new String [6];
        
        DefaultTableModel model = new DefaultTableModel(null, items);
        querySQL = "select * from vista_ventas where codigo like '%"+search+"%'";
        
        try {
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                files [0] = rs.getString("codigo");
                files [1] = rs.getString("factura");
                files [2] = rs.getString("cliente");
                files [3] = rs.getString("monto");
                files [4] = rs.getString("vendedor");
                files [5] = rs.getString("fecha");
                
                model.addRow(files);
                
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al conectar. "+e.getMessage());
            
        }
        
        finally {
        
            try {
                
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (rutaConec != null) rutaConec.close();
                
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, e);
                
            }
            
        }
        
        return model;
    
    }
    
    public DefaultTableModel Search4Client (String search) {
        
        String [] items = {"codigo", "factura", "cliente", "monto", "vendedor", "fecha"};
        String [] files = new String [6];
        
        DefaultTableModel model = new DefaultTableModel(null, items);
        querySQL = "select * from vista_ventas where cliente like '%"+search+"%'";
        
        try {
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                files [0] = rs.getString("codigo");
                files [1] = rs.getString("factura");
                files [2] = rs.getString("cliente");
                files [3] = rs.getString("monto");
                files [4] = rs.getString("vendedor");
                files [5] = rs.getString("fecha");
                
                model.addRow(files);
                
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al conectar. "+e.getMessage());
            
        }
        
        finally {
        
            try {
                
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (rutaConec != null) rutaConec.close();
                
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, e);
                
            }
            
        }
        
        return model;
    
    }
    
    public DefaultTableModel Search4Seller (String search) {
        
        String [] items = {"codigo", "factura", "cliente", "monto", "vendedor", "fecha"};
        String [] files = new String [6];
        
        DefaultTableModel model = new DefaultTableModel(null, items);
        querySQL = "select * from vista_ventas where vendedor like '%"+search+"%'";
        
        try {
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                files [0] = rs.getString("codigo");
                files [1] = rs.getString("factura");
                files [2] = rs.getString("cliente");
                files [3] = rs.getString("monto");
                files [4] = rs.getString("vendedor");
                files [5] = rs.getString("fecha");
                
                model.addRow(files);
                
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al conectar. "+e.getMessage());
            
        }
        
        finally {
        
            try {
                
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (rutaConec != null) rutaConec.close();
                
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, e);
                
            }
            
        }
        
        return model;
    
    }
    
}
