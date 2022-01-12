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
public class view_clerk {
    
    public int code;
    public String name;
    public String ci;
    public String telephone;
    public String direction;
    public String city;
    public String office;
    public String user;

    public view_clerk() {
    }

    public view_clerk(int code, String name, String ci, String telephone, String direction, String city, String office, String user) {
        this.code = code;
        this.name = name;
        this.ci = ci;
        this.telephone = telephone;
        this.direction = direction;
        this.city = city;
        this.office = office;
        this.user = user;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
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

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    
}
