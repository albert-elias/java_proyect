/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;



/**
 *
 * @author User
 */
public class AperturaCierre_M {
    
    public int id;
    public String date;
    public String collect;
    public int fun;

    public AperturaCierre_M() {
    }

    public AperturaCierre_M(int id, String date, String collect, int fun) {
        this.id = id;
        this.date = date;
        this.collect = collect;
        this.fun = fun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public int getFun() {
        return fun;
    }

    public void setFun(int fun) {
        this.fun = fun;
    }
    
    
    
}
