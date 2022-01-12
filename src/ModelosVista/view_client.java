/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosVista;

/**
 *
 * @author User
 */
public class view_client {
    
    public int codigo;
    public String name, ruc_ci, telephone, direction, city;

    public view_client() {
    }

    public view_client(int codigo, String name, String ruc_ci, String telephone, String direction, String city) {
        this.codigo = codigo;
        this.name = name;
        this.ruc_ci = ruc_ci;
        this.telephone = telephone;
        this.direction = direction;
        this.city = city;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuc_ci() {
        return ruc_ci;
    }

    public void setRuc_ci(String ruc_ci) {
        this.ruc_ci = ruc_ci;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
    
}
