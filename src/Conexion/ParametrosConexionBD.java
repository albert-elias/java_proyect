/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

/**
 *
 * @author User
 */
public class ParametrosConexionBD {
    
    public  enum MOTOR_BD{MYSQL};
    private MOTOR_BD tipoMotor;
    private  String baseDatos ;
    private  String usuario ;
    private  String pass ;

    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setTipoMotor(MOTOR_BD tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public MOTOR_BD getTipoMotor() {
        return tipoMotor;
    }
    
}
