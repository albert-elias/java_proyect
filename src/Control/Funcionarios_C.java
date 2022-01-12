/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import Modelos.Funcionarios_M;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Funcionarios_C extends Funcionarios_M {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec;
    private PreparedStatement ps;
    private String querySQL;
    private ResultSet rs;
    private Statement state;
    private int answer;

    public Funcionarios_C() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public Funcionarios_C(int code, String name, String ci, String telephone, String direction, int city, int job, int user) {
        
        super(code, name, ci, telephone, direction, city, job, user);
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
            
            querySQL = "insert into funcionarios values ("+code+", '"+name+"',"
            + " '"+ci+"', '"+telephone+"', '"+direction+"', "+city+", "+job+", "+user+")";
            
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } 
            
        } catch (Exception ex) {
            
            Logger.getLogger(Funcionarios_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Delete (String code) {
        
        try {
            
            querySQL = "delete from funcionarios where id = '"+code+"'";
            
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(Funcionarios_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Update () {
        
        try {
            
            querySQL = "update funcionarios set nombre = '"+name+"', ci = '"+ci+"',"
            + " telefono = '"+telephone+"', direccion = '"+direction+"',"
            + " ciudades_id = "+city+", cargos_id = "+job+", usuarios_id = "+user+""
            + " where id = "+code+"";
            
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(Funcionarios_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public Funcionarios_C Search (String cod) {
        
        Funcionarios_C val = null;
        
        try {
            
            querySQL = "select * from funcionarios where id ='"+cod+"'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new Funcionarios_C(rs.getInt("id"), rs.getString("nombre"),
                rs.getString("ci"), rs.getString("telefono"), rs.getString("direccion"),
                rs.getInt("ciudades_id"), rs.getInt("cargos_id"), rs.getInt("usuarios_id"));
                
            }
            
        } catch (Exception ex) {
            
            System.err.println(ex);
            
        }
        
        return val;
        
    }
    
    public ArrayList <Funcionarios_C> SearchAll (){
        
        ArrayList<Funcionarios_C> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from funcionarios";
            
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new Funcionarios_C(rs.getInt("id"), rs.getString("nombre"),
                rs.getString("ci"), rs.getString("telefono"), rs.getString("direccion"),
                rs.getInt("ciudades_id"), rs.getInt("cargos_id"), rs.getInt("usuarios_id")));
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(Funcionarios_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return all;
    }
    
    public String New () {
    
        String numciu = null;
        
        try {
            
            querySQL = "select max(id)+1 from funcionarios";
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                numciu = rs.getString(1);
            
            }
            
            
        } catch (Exception ex) {
            
            Logger.getLogger(Funcionarios_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return numciu != null ? numciu: "1";
    
    }
    
    public String CulsultName (int id) {
    
        String name = "";
        
        try {
            
            querySQL = "select nombre from funcionarios where id = "+id;
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                name = rs.getString("nombre");
                
            }
            
        } catch (Exception e) {
            
            System.err.println(e + "Error");
            
        }
        
        return name;
    
    }
    
    public DefaultTableModel Search4ID (String search) {
        
        String [] items = {"codigo", "nombre", "ci", "telefono", "direccion", "ciudad", "cargo", "usuario"};
        String [] files = new String [8];
        
        DefaultTableModel model = new DefaultTableModel(null, items);
        querySQL = "select * from funcionarios where id like '%"+search+"%'";
        
        try {
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                files [0] = rs.getString("id");
                files [1] = rs.getString("nombre");
                files [2] = rs.getString("ci");
                files [3] = rs.getString("telefono");
                files [4] = rs.getString("direccion");
                files [5] = rs.getString("ciudades_id");
                files [6] = rs.getString("cargos_id");
                files [7] = rs.getString("usuarios_id");
                
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
    
    public DefaultTableModel Search4Name (String search) {
        
        String [] items = {"codigo", "nombre", "ci", "telefono", "direccion", "ciudad", "cargo", "usuario"};
        String [] files = new String [8];
        
        DefaultTableModel model = new DefaultTableModel(null, items);
        querySQL = "select * from funcionarios where nombre like '%"+search+"%'";
        
        try {
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                files [0] = rs.getString("id");
                files [1] = rs.getString("nombre");
                files [2] = rs.getString("ci");
                files [3] = rs.getString("telefono");
                files [4] = rs.getString("direccion");
                files [5] = rs.getString("ciudades_id");
                files [6] = rs.getString("cargo_id");
                files [7] = rs.getString("usuarios_id");
                
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
    
    public DefaultTableModel Search4Ci (String search) {
        
        String [] items = {"codigo", "nombre", "ci", "telefono", "direccion", "ciudad", "cargo", "usuario"};
        String [] files = new String [8];
        
        DefaultTableModel model = new DefaultTableModel(null, items);
        querySQL = "select * from funcionarios where ci like '%"+search+"%'";
        
        try {
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                files [0] = rs.getString("id");
                files [1] = rs.getString("nombre");
                files [2] = rs.getString("ci");
                files [3] = rs.getString("telefono");
                files [4] = rs.getString("direccion");
                files [5] = rs.getString("ciudades_id");
                files [6] = rs.getString("cargos_id");
                files [7] = rs.getString("usuario_id");
                
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
    
    public DefaultTableModel Search4Teleph (String search) {
        
        String [] items = {"codigo", "nombre", "ci", "telefono", "direccion", "ciudad", "cargo", "usuario"};
        String [] files = new String [8];
        
        DefaultTableModel model = new DefaultTableModel(null, items);
        querySQL = "select * from funcionarios where telefono like '%"+search+"%'";
        
        try {
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                files [0] = rs.getString("id");
                files [1] = rs.getString("nombre");
                files [2] = rs.getString("ci");
                files [3] = rs.getString("telefono");
                files [4] = rs.getString("direccion");
                files [5] = rs.getString("ciudades_id");
                files [6] = rs.getString("cargos_id");
                files [7] = rs.getString("usuarios_id");
                
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
