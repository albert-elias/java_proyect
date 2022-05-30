/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContolesVista;

import Conexion.ConexionBD;
import Conexion.ParametrosConexionBD;
import ModelosVista.view_sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class vista_ventas extends view_sale {
 
    private ParametrosConexionBD p;
    private ConexionBD c;
    private Connection rutaConec;
    private PreparedStatement ps = null;
    private String querySQL;
    private ResultSet rs;
    private Statement state;
    private int answer;

    public vista_ventas() {
        
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }

    public vista_ventas(int codigo, String factura, String cliente, int monto, String vendedor, String fecha, int estado) {
        
        super(codigo, factura, cliente, monto, vendedor, fecha, estado);
        p = new ParametrosConexionBD();
        p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
        p.setBaseDatos("estoy");
        p.setUsuario("root");
        p.setPass("");
        
        c = new ConexionBD(p);
        rutaConec = c.getConexion();
        
    }
    
    public ArrayList <vista_ventas> buscarventa() {
        
        ArrayList <vista_ventas> all = new ArrayList<>();
        
        try {
            
            querySQL = "SELECT * FROM vista_ventas WHERE estado = 1";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new vista_ventas(rs.getInt("codigo"), rs.getString("fecha"), rs.getString("factura"),
                rs.getInt("monto"), rs.getString("clientes"), rs.getString("vendedor"), rs.getInt("estado")));
                
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(vista_ventas.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return all;
        
    }
    
    public String CulsultMonto (int mer) {
    
        int price = 0;
        
        try {
            
            querySQL = "select sum(monto) from vista_ventas where ventas_id = " + mer;
            
            ps = rutaConec.prepareStatement(querySQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                price = rs.getInt("monto");
                
            }
            
        } catch (Exception e) {
            
            System.err.println("Error" + e.getMessage());
            
        }
        
        return String.valueOf(price);
    
    }
    
    public vista_ventas Search (String cod) {
        
        vista_ventas val = null;
        
        try {
            
            querySQL = "select * from vista_ventas where codigo = '"+cod+"' ";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                val = new vista_ventas(rs.getInt("codigo"), rs.getString("fecha"), rs.getString("factura"),
                rs.getInt("monto"), rs.getString("clientes"), rs.getString("vendedor"), rs.getInt("estado"));
                
            }
            
        } catch (SQLException ex) {
            
            System.err.println(ex);
            
        }
        
        return val;
        
    }

    public ArrayList <vista_ventas> SearchCodigo (String search){
        
        ArrayList<vista_ventas> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from vista_ventas where codigo like '%"+search+"%' AND estado = 1";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new vista_ventas(rs.getInt("codigo"), rs.getString("fecha"), rs.getString("factura"),
                rs.getInt("monto"), rs.getString("clientes"), rs.getString("vendedor"), rs.getInt("estado")));
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(vista_ventas.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        return all;

    }

    public ArrayList <vista_ventas> SearchCliente (String search){
        
        ArrayList<vista_ventas> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from vista_ventas where clientes like '%"+search+"%' AND estado = 1";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new vista_ventas(rs.getInt("codigo"), rs.getString("fecha"), rs.getString("factura"),
                rs.getInt("monto"), rs.getString("clientes"), rs.getString("vendedor"), rs.getInt("estado")));
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(vista_ventas.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        return all;

    }

    public ArrayList <vista_ventas> SearchVendedor (String search){
        
        ArrayList<vista_ventas> all = new ArrayList<>();
        
        try {
            
            querySQL = "select * from vista_ventas where vendedor like '%"+search+"%' AND estado = 1";
            state = rutaConec.createStatement();
            rs = state.executeQuery(querySQL);
            
            while (rs.next()) {
                
                all.add(new vista_ventas(rs.getInt("codigo"), rs.getString("fecha"), rs.getString("factura"),
                rs.getInt("monto"), rs.getString("clientes"), rs.getString("vendedor"), rs.getInt("estado")));
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(vista_ventas.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        return all;

    }

    public void showVentas(){
  
        try {

            String ubicacion = "C:\\Users\\User\\JaspersoftWorkspace\\estoy\\ventas.jasper";
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
