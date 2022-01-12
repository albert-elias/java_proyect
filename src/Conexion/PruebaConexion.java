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
public class PruebaConexion {
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       ParametrosConexionBD p = new ParametrosConexionBD();
       p.setTipoMotor(ParametrosConexionBD.MOTOR_BD.MYSQL);
       p.setBaseDatos("estoy");
       p.setUsuario("root");
       p.setPass("");
       
       ConexionBD cc = new ConexionBD(p);
       cc.getConexion();
       System.out.println(cc.getMsg());

    }
    
}
