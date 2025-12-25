/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cafebar;

import cafebar.modelo.Bebida;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author UIS
 */
public class CafeBar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        
        

        
        Scanner sc= new Scanner(System.in);
        
        System.out.println("vamos aregistraruna bebida");
        System.out.println("deme el id: ");
        float id= sc.nextFloat();
        sc.nextLine(); //limpiar lo que quede
        System.out.println("deme el nombre: ");
        String nombre= sc.nextLine();
        System.out.println("Ingrese los ingredientes: ");
        String ing= sc.nextLine();
        System.out.println("Ingrese el precio: ");
        float precio= sc.nextFloat();
        
        Bebida b = new Bebida(id, nombre, ing, precio);
        
   
        System.out.println(b);
        
        //
        
        
    }
    
}
