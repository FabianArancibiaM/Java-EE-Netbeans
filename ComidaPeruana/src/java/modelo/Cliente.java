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
public class Cliente {
    private String clave;
    private String rut;
    private String nombre;
    private String direccion;
    private int comuna;
    private int telefono;
    private String comodin;
    public Cliente() {
    }

    public Cliente(String clave, String rut, String nombre, String direccion, int comuna, int telefono) {
        this.clave = clave;
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.comuna = comuna;
        this.telefono = telefono;
    }
    
    
    
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getComuna() {
        return comuna;
    }

    public void setComuna(int comuna) {
        this.comuna = comuna;
    }

    @Override
    public String toString() {
        return "Cliente{" + "clave=" + clave + ", rut=" + rut + ", nombre=" + nombre + ", direccion=" + direccion + ", comuna=" + comodin + ", telefono=" + telefono + '}'+"\n";
    }

    public String getComodin() {
        return comodin;
    }

    public void setComodin(String comodin) {
        this.comodin = comodin;
    }
    
    
}
