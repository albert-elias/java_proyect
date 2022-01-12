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
public class view_detail_sale {
    
    public String producto;
    public int cantidad;
    public int precio;
    public int monto_final;

    public view_detail_sale() {
    }

    public view_detail_sale(String producto, int cantidad, int precio, int monto_final) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.monto_final = monto_final;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getMonto_final() {
        return monto_final;
    }

    public void setMonto_final(int monto_final) {
        this.monto_final = monto_final;
    }
    
    
    
}
