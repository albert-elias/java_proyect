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
public class ConfirmarVenta_M {
    
    public int id_modo_pago;
    public int id_venta;
    public int monto;

    public ConfirmarVenta_M() {
    }

    public ConfirmarVenta_M(int id_modo_pago, int id_venta, int monto) {
        this.id_modo_pago = id_modo_pago;
        this.id_venta = id_venta;
        this.monto = monto;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_modo_pago() {
        return id_modo_pago;
    }

    public void setId_modo_pago(int id_modo_pago) {
        this.id_modo_pago = id_modo_pago;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
       
}