/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

/**
 *
 * @author USUARIO
 */
public class DaoCrudJSON {

    public Datos leer (){
       ObjectMapper map = new ObjectMapper();
       Datos datos = new Datos();
        try {
             datos = map.readValue(new File ("promocional.json"), Datos.class);
        } catch (Exception e) {
            return null;
        }
        return datos;
}

    public Datos Insert (Datos datos) {
       ObjectMapper map = new ObjectMapper();
 try {
  map.writeValue(new File ("promocional.json"), datos );
  
 } catch (Exception e){
     System.out.println("Este es el error del metodo json" +e);
    return null; 
 }
    return datos;
    }
    
    
     public ControlPedidos Insertpedido (ControlPedidos controlPedidos) {
       ObjectMapper map = new ObjectMapper();
 try {
  map.writeValue(new File ("ControlPedidos.json"), controlPedidos );
  
 } catch (Exception e){
     System.out.println("Este es el error del metodo json" +e);
    return null; 
 }
    return controlPedidos;
    }
     
         public ControlPedidos leerPedidos (){
       ObjectMapper map = new ObjectMapper();
       ControlPedidos controlPedidos = new ControlPedidos();
        try {
             controlPedidos = map.readValue(new File ("ControlPedidos.json"), ControlPedidos.class);
        } catch (Exception e) {
            return null;
        }
        return controlPedidos;
}

}





