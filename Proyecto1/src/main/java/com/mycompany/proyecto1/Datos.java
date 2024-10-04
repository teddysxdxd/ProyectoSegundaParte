/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Datos {
    List <Productos> productos;
    List <Clientes> clientes;
    List <Proveedores> proveedores;
    List <Pedidos> pedidos;

    public Datos() {
    }

    public Datos(List<Productos> productos, List<Clientes> clientes, List<Proveedores> proveedores, List<Pedidos> pedidos) {
        this.productos = productos;
        this.clientes = clientes;
        this.proveedores = proveedores;
        this.pedidos = pedidos;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }

    public List<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }

    public List<Proveedores> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedores> proveedores) {
        this.proveedores = proveedores;
    }

    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }
    

}
