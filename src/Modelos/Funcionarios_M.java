/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Albet
 */
public class Funcionarios_M {
    
    public int code;
    public String name;
    public String ci;
    public String telephone;
    public String direction;
    public int city;
    public int job;
    public int user;

    public Funcionarios_M() {
    }

    public Funcionarios_M(int code, String name, String ci, String telephone, String direction, int city, int job, int user) {
        this.code = code;
        this.name = name;
        this.ci = ci;
        this.telephone = telephone;
        this.direction = direction;
        this.city = city;
        this.job = job;
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

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
    
    
    
}
