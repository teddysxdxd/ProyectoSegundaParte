/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ControlPedidos {
   List<ControlPedido> controlPedidos = new ArrayList ();

    public ControlPedidos() {
    }



    public List<ControlPedido> getControlPedidos() {
        return controlPedidos;
    }

    public void setControlPedidos(List<ControlPedido> controlPedidos) {
        this.controlPedidos = controlPedidos;
}
}

