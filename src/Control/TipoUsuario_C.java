
package Control;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import Modelos.TipoUsuario_M;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albert Acosta
 */
public class TipoUsuario_C extends TipoUsuario_M {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec;
    private PreparedStatement ps;
    private String querySQL;
    private ResultSet rs;
    private Statement state;
    private int answer;

    public TipoUsuario_C() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public TipoUsuario_C(int id, String name) {
        
        super(id, name);
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
            
            querySQL = "insert into tipo_usuarios values ("+id+",'"+name+"')";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } 
            
        } catch (Exception ex) {
            
            Logger.getLogger(TipoUsuario_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Delete (String code) {
        
        try {
            
            querySQL = "delete from tipo_usuarios where id = '"+code+"'";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(TipoUsuario_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Update () {
        
        try {
            
            querySQL = "update tipo_usuarios set nombre = '"+name+"' where id = "+id+"";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(TipoUsuario_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public TipoUsuario_C Search (String cod) {
        
        TipoUsuario_C val = null;
        
        try {
            
            querySQL = "select * from tipo_usuarios where id ='"+cod+"'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new TipoUsuario_C(rs.getInt("id"), rs.getString("nombre"));
                
            }
            
        } catch (Exception ex) {
            
            System.err.println(ex);
            
        }
        
        return val;
        
    }
    
    public ArrayList <TipoUsuario_C> SearchAll (){
        
        ArrayList<TipoUsuario_C> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from tipo_usuarios";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new TipoUsuario_C(rs.getInt("id"), rs.getString("nombre")));
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(TipoUsuario_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return all;
    }
    
    public String New () {
    
        String numcar = null;
        
        try {
            
            querySQL = "select max(id)+1 from tipo_usuarios";
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                numcar = rs.getString(1);
            
            }
            
            
        } catch (Exception ex) {
            
            Logger.getLogger(TipoUsuario_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return numcar != null ? numcar: "1";
    
    }
    
}
