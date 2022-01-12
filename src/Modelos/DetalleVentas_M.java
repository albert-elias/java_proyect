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
public class DetalleVentas_M {
    
    public int id_venta;
    public int id_mercaderia;
    public int cantidad;
    public int precio;
    public int precio_final;

    public DetalleVentas_M() {
    }

    public DetalleVentas_M(int id_venta, int id_mercaderia, int cantidad, int precio, int precio_final) {
        this.id_venta = id_venta;
        this.id_mercaderia = id_mercaderia;
        this.cantidad = cantidad;
        this.precio = precio;
        this.precio_final = precio_final;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_mercaderia() {
        return id_mercaderia;
    }

    public void setId_mercaderia(int id_mercaderia) {
        this.id_mercaderia = id_mercaderia;
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

    public int getPrecio_final() {
        return precio_final;
    }

    public void setPrecio_final(int precio_final) {
        this.precio_final = precio_final;
    }
    
    
    
}
