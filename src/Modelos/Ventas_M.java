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
public class Ventas_M {
    
    public int id;
    public String fecha;
    public String factura;
    public int monto;
    public int id_cliente;
    public int id_vendedor;
    public int estado;

    public Ventas_M() {
    }

    public Ventas_M(int id, String fecha, String factura, int monto, int id_cliente, int id_vendedor, int estado) {
        this.id = id;
        this.fecha = fecha;
        this.factura = factura;
        this.monto = monto;
        this.id_cliente = id_cliente;
        this.id_vendedor = id_vendedor;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
