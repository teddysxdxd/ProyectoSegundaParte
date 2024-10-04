/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Creacion {
    
    
        DaoCrudJSON daoCrudJSON = new DaoCrudJSON();
         Datos datos = new Datos();
         ControlPedidos controlPedidos = new ControlPedidos();
                 
         public void crearCliente (){
        Scanner sp = new Scanner (System.in);
        datos = daoCrudJSON.leer();
        Clientes cliente = new Clientes();
           System.out.println("Ingrese su nombre");
        cliente.setNombre(sp.nextLine());
             System.out.println("Ingrese el correo");
        cliente.setCorreo(sp.nextLine());
             System.out.println("Ingrese NIT");
        cliente.setNit(sp.nextLine());
        datos.getClientes().add(cliente);
        daoCrudJSON.Insert(datos);
     
    }
         public void mostrarClientes (){
             
           datos  = daoCrudJSON.leer();
           for (Clientes cliente : datos.getClientes()){
               System.out.println("_______________________________________");
               System.out.println("el nombre es: " +cliente.getNombre());
               System.out.println("el nit es: " +cliente.getNit());
               System.out.println("el correo es: " +cliente.getCorreo());
               System.out.println("_______________________________________");
               
           }
         }
    public void crearPedido (){
       datos  = daoCrudJSON.leer();
       Scanner sp = new Scanner (System.in);
       int i =1;
       Pedidos pedidos = new Pedidos();
       controlPedidos = daoCrudJSON.leerPedidos();
       int idPedido = controlPedidos.getControlPedidos().getLast().getId();
       idPedido = idPedido+1;
       int j = 1;
       String agregarProducto = "";
       int eleccion ;
        List <Productos> productos = new ArrayList<Productos>();
        ControlPedido controlPedido = new ControlPedido();
        ProductoPedido productoPedidos = new ProductoPedido();
       //mostrar los nombres de los clientes 
        System.out.println("Elija el cliente para el pedido");
       for (Clientes cliente : datos.getClientes()){
           System.out.println(cliente.getNombre()+"  "+ i);
           i++;
       }
        System.out.println("cliente elegido");
       pedidos.setCliente(datos.getClientes().get(sp.nextInt()-1).getNombre());
       pedidos.setFecha(sp.nextLine());
       pedidos.setId(idPedido);
       
        System.out.println("Estos son los productos en stock");
        do{ 
            j= 1;
        for(Productos producto : datos.getProductos()){
            System.out.println(producto.getNombre()+"   " + j);
            System.out.println(producto.getPrecio());
            System.out.println("");
            j++;
            
        }
            System.out.println("Ingrese el numero de producto a agregar");
            eleccion = sp.nextInt();
            productoPedidos.setId(datos.getProductos().get(eleccion-1).getId());
            System.out.println("Ingrese la cantidad");
            productoPedidos.setCantidad(sp.nextInt());
            productos.add( datos.getProductos().get(eleccion-1));
            System.out.println("desea agregar otro producto");
            agregarProducto = sp.nextLine();
            agregarProducto = sp.nextLine();
    }while (!agregarProducto.equals("no"));     
            pedidos.getProductos().add(productoPedidos);
            controlPedido.setCliente(pedidos.getCliente());
            controlPedido.setEstadoPedido("creado");
            controlPedido.setId(idPedido);
            datos.getPedidos().add(pedidos);
            controlPedidos.getControlPedidos().add(controlPedido);
            daoCrudJSON.Insertpedido(controlPedidos);
            daoCrudJSON.Insert(datos);
    
    } 
    public void verPedidos() {
            List <Productos> productos = new ArrayList();
        controlPedidos = daoCrudJSON.leerPedidos();
       datos = daoCrudJSON.leer(); 
        List<Pedidos> pedidos = new ArrayList();
        List<ControlPedido> controlPedidoss = new ArrayList();
        pedidos = datos.getPedidos();
        controlPedidoss = controlPedidos.getControlPedidos();
        productos = datos.getProductos();
        
        for (Pedidos pedido : pedidos){
            System.out.println("pedido numero :"+pedido.getId());
            System.out.println("el cliente es :"+ controlPedidoss.get(pedido.getId()-1).getCliente());
            System.out.println("el estado del pedido es :"+controlPedidoss.get(pedido.getId()-1).getEstadoPedido());
            for (ProductoPedido productoPedido : pedidos.get(pedido.getId()-1).getProductos()){
                System.out.println("producto "+productos.get((productoPedido.getId()-1)).getNombre());
                System.out.println("categoria "+productos.get((productoPedido.getId()-1)).getCategoria());
            }
            System.out.println("");
   }

}
    public void avanzarFlujo (){
        int numeroPedido = 0;
        Scanner sp = new Scanner (System.in);
        controlPedidos = daoCrudJSON.leerPedidos();
       datos = daoCrudJSON.leer(); 
        List<Pedidos> pedidos = new ArrayList();
        List<ControlPedido> controlPedidoss = new ArrayList();
        pedidos = datos.getPedidos();
        controlPedidoss = controlPedidos.getControlPedidos();
        
        
         for (Pedidos pedido : pedidos){
            System.out.println("pedido numero :"+pedido.getId());
            System.out.println("el estado del pedido es :"+controlPedidoss.get(pedido.getId()-1).getEstadoPedido());
         }
         System.out.println("Eliga el pedido al que le dara avance ");
         numeroPedido = sp.nextInt();
         System.out.println("Ingrese el nuevo estado");
         sp.nextLine();
         controlPedidoss.get(numeroPedido-1).setEstadoPedido(sp.nextLine());
         controlPedidos.setControlPedidos(controlPedidoss);
         daoCrudJSON.Insertpedido(controlPedidos);
    }      
    }

