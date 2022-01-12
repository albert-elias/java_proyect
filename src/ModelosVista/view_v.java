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
public class view_v {
    
    public int vend;
    public String fun;
    public int usu;
    public int cod;

    public view_v() {
    }

    public view_v(int vend, String fun, int usu, int cod) {
        this.vend = vend;
        this.fun = fun;
        this.usu = usu;
        this.cod = cod;
    }

    public int getVend() {
        return vend;
    }

    public void setVend(int vend) {
        this.vend = vend;
    }

    public String getFun() {
        return fun;
    }

    public void setFun(String fun) {
        this.fun = fun;
    }
    
    public int getUsu() {
        return usu;
    }

    public void setUsu(int usu) {
        this.usu = usu;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
    
    
}
