/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
      java doc investigar.
 */
package ejemplometodos;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class EjemploMetodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println();

    }
    public static void sumar() { //sin parametros, sin retorno
        int a = Integer.valueOf(JOptionPane.showInputDialog("ingrse el primer numero que desea sumar"));
        int b = Integer.valueOf(JOptionPane.showInputDialog("ingrse el segindo numero que desea sumar"));
        int suma= a+b;
        JOptionPane.showMessageDialog(null, "su resultado es: " + suma);
        
    }
    //  System.out.println(); Debuelve el resultado en la consola.
    public static int sumar1() { // el "int" define la variable con la que trabaja el public. sin parametro, con retorno
        int a = Integer.valueOf(JOptionPane.showInputDialog("ingrse el primer numero que desea sumar"));
        int b = Integer.valueOf(JOptionPane.showInputDialog("ingrse el segindo numero que desea sumar"));
        int suma= a+b;
        return suma;
        
    }
    public static void sumar(int y, int x) { //los parentec son los parametros (lo que necesita para funciolnar), contienen argumentos. sin ret, con parametros
        int sum = x + y;
        JOptionPane.showInternalMessageDialog(null, "la suma equivale a: " + sum);
    }
    public static int sumar1(int y, int x) { //Con parametros, con retorno
        int sum = x + y;
        return sum;
        
    }
}
