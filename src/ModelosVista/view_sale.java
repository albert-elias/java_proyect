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
public class view_sale {
    
    public int codigo;
    public String factura, cliente;
    public int monto, valor;
    public String vendedor, fecha;

    public view_sale() {
    }

    public view_sale(int codigo, String factura, String cliente, int monto, int valor, String vendedor, String fecha) {
        this.codigo = codigo;
        this.factura = factura;
        this.cliente = cliente;
        this.monto = monto;
        this.valor = valor;
        this.vendedor = vendedor;
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
