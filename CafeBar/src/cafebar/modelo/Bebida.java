/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafebar.modelo;

import java.util.ArrayList;

/**
 *
 * @author UIS
 */
public class Bebida {

     float idBebida;
    String nombre;
     ArrayList<Ingrediente> ingredientes;
     float precio;

    public Bebida(float idBebida, String nombre, float precio) {
        this.idBebida = idBebida;
        this.nombre = nombre;
        this.ingredientes = new ArrayList<>();
        this.precio = precio;
    }

  

    @Override
    public String toString() {
        return "Bebida{" + "idBebida=" + idBebida + ", nombre=" + nombre + ", ingredientes=" + ingredientes + ", precio=" + precio + '}';
    }
    
    

}
