
package Control;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import Modelos.Usuarios_M;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Albert Acosta
 */
public class Usuarios_C extends Usuarios_M {
    
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec;
    private PreparedStatement ps;
    private String querySQL;
    private ResultSet rs;
    private Statement state;
    private int answer;

    public Usuarios_C() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public Usuarios_C(int id, String usuario, String clave, int tipo_usuario) {
        
        super(id, usuario, clave, tipo_usuario);
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
            
            querySQL = "insert into usuarios values ("+id+",'"+usuario+"','"+clave+"',"+tipo_usuario+")";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } 
            
        } catch (Exception ex) {
            
            Logger.getLogger(Usuarios_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Delete (String code) {
        
        try {
            
            querySQL = "delete from usuarios where id = '"+code+"'";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(Usuarios_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public boolean Update () {
        
        try {
            
            querySQL = "update usuarios set usuario = '"+usuario+"', clave = '"+clave+"', tipo_usuarios_id = "+tipo_usuario+" where id = "+id+"";
            state = rutaConec.createStatement();
            answer = state.executeUpdate(querySQL);
            
            if (answer > 0) {
                
                return true;
                
            } else {
            
                return false;
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(Usuarios_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
        return false;
        
    }
    
    public Usuarios_C Search (String cod) {
        
        Usuarios_C val = null;
        
        try {
            
            querySQL = "select * from usuarios where id ='"+cod+"'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new Usuarios_C(rs.getInt("id"), rs.getString("usuario"),
                rs.getString("clave"), rs.getInt("tipo_usuarios_id"));
                
            }
            
        } catch (Exception ex) {
            
            System.err.println(ex);
            
        }
        
        return val;
        
    }
    
    public ArrayList <Usuarios_C> SearchAll (){
        
        ArrayList<Usuarios_C> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from usuarios";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new Usuarios_C(rs.getInt("id"), rs.getString("usuario"), rs.getString("clave"), rs.getInt("tipo_usuarios_id")));
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(Usuarios_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return all;
    }
    
    public String New () {
    
        String numcar = null;
        
        try {
            
            querySQL = "select max(id)+1 from usuarios";
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                numcar = rs.getString(1);
            
            }
            
            
        } catch (Exception ex) {
            
            Logger.getLogger(Usuarios_C.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return numcar != null ? numcar: "1";
    
    }
    
    public String CulsultUser (int id) {
    
        String name = "";
        
        try {
            
            querySQL = "select usuario from usuarios where id = "+id;
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                name = rs.getString("usuario");
                
            }
            
        } catch (Exception e) {
            
            System.err.println(e + "Error");
            
        }
        
        return name;
    
    }
    
    public DefaultTableModel Consult (String name) {
        
        String [] items = {"id", "usuario"};
        String [] files = new String [2];
        DefaultTableModel model = new DefaultTableModel(null, items);
        
        try {
            
            querySQL = "select * from usuarios where usuario like '"+name+"%'";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                files [0] = rs.getString("id");
                files [1] = rs.getString("usuario");
                
                model.addRow(files);
                
            }
            
        } catch (SQLException ex) {
            
            System.err.println(ex);
            
        }
        
        return model;
        
    }

    public void showUsers(){
  
        try {

            String ubicacion = "C:\\Users\\User\\JaspersoftWorkspace\\estoy\\usuarios.jasper";
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(ubicacion);
            JasperPrint jp = JasperFillManager.fillReport(report, null, rutaConec); 
            JasperViewer view = new JasperViewer(jp, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
            view.setVisible(true);

        } catch (JRException e) {

            System.out.println(e.getMessage());

        }

    }
    
}
