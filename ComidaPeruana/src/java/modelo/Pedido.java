/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fabian
 */
public class Pedido {
    private int id_pedido;
    private String rut_cliente;
    private String plato;
    private String bebida;
    private boolean despacho;
    private int total;
    private String fecha;

    public Pedido() {
    }

    public Pedido(String rut_cliente, String plato, String bebida, boolean despacho, int total, String fecha) {
                this.rut_cliente = rut_cliente;
        this.plato = plato;
        this.bebida = bebida;
        this.despacho = despacho;
        this.total = total;
        this.fecha = fecha;
    }

    
    
    
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(String rut_cliente) {
        this.rut_cliente = rut_cliente;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public boolean isDespacho() {
        return despacho;
    }

    public void setDespacho(boolean despacho) {
        this.despacho = despacho;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id_pedido=" + id_pedido + ", rut_cliente=" + rut_cliente + ", plato=" + plato + ", bebida=" + bebida + ", despacho=" + despacho + ", total=" + total + ", fecha=" + fecha + '}'+"\n";
    }

    
    
    
}
