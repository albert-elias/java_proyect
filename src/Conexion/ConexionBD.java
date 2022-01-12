/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ConexionBD {
    
    private  ParametrosConexionBD parametros;
    private  Connection connection;
    private  String host,url;
    private  String msg;
    
    public ConexionBD(ParametrosConexionBD parametros) {
        
        this.parametros = parametros;
        
    }

    public Connection getConexion() {

        if (parametros != null) {
            
            try {
                
                switch (parametros.getTipoMotor()) {
                    
                    case MYSQL:
                        host = "localhost:3306";
                        url = "jdbc:mysql://"+ host +"/"+ parametros.getBaseDatos();
                        Class.forName("com.mysql.jdbc.Driver");
                        break;
                        
                }
                
                connection = DriverManager.getConnection(url, parametros.getUsuario(), parametros.getPass());
                
                if (connection != null) {
                    
                    msg = "Se conecto correctamente a la base de datos. " + host;
                    return connection;
                    
                } else {
                    
                    msg = "Error al conectar a la base de datos.";
                    return null;
                    
                }
                
            } catch (ClassNotFoundException | SQLException e) {
                
                msg = "Error al conectar a la base de datos.";
                return null;
                
            }

        }
        
        return connection;
        
    }

    public String getMsg() {
        
        return msg;
        
    }
    
    public  void cerrarConexion(){
        
        if (connection != null) {
            
            try {
                
                connection.close();
                
            } catch (SQLException ex) {
                
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
    }
    
}
