/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase.pkg3;

import javax.swing.JOptionPane;

/**
 *
 * @author UIS
 */
public class Clase3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        promedio();
    }
    public static void promNumeros() {
        float x1 =Float.valueOf(JOptionPane.showInputDialog("Ingrese su primer numero"));
        float x2 =Float.valueOf(JOptionPane.showInputDialog("Ingrese su segundo numero"));
        float x3 =Float.valueOf(JOptionPane.showInputDialog("Ingrese su tercer numero"));
        float x4 =Float.valueOf(JOptionPane.showInputDialog("Ingrese su cuarto numero"));
        float x5 =Float.valueOf(JOptionPane.showInputDialog("Ingrese su quinto numero"));
        float prom= ((x1+x2+x3+x4+x5)/5);
        JOptionPane.showMessageDialog(null, "El promedio de esod numeros es: "+prom);
    }
    public static void promedio() {
        float par=Float.valueOf(JOptionPane.showInputDialog("Ingrese la nota del parcial(55%): "));
        float quiz=Float.valueOf(JOptionPane.showInputDialog("Ingrese la nota de quizes (30%): "));
        float trab=Float.valueOf(JOptionPane.showInputDialog("Ingrese la nota del trabajo final(15%): "));
        Number pond=((par*0.55)+(quiz*0.30)+(trab*0.15));
        JOptionPane.showMessageDialog(null, "El promedio de la nota es: "+pond);
                
    }
//3.Calcular el sueldo mensual de un empleado tomando como datos de entrada: el nombre, horas trabajadas y el pago por hora.

    public static void sueldo() {
        String nombre= JOptionPane.showInputDialog("Ingrese el nombre del trabajador: ");
        float horas=Float.valueOf(JOptionPane.showInputDialog("Ingrese cuantas horas trabajo: "));
        float pagoh=Float.valueOf(JOptionPane.showInputDialog("Ingrese el pago por hora: "));
        float sueldo= (horas*pagoh);
        JOptionPane.showMessageDialog(null, "El sueldo del empleado es de: "+sueldo);
        
    }
//4.      Elaborar un algoritmo para determinar si un número es par o impar.

    public static void parOinpar() {
        float num=Float.valueOf(JOptionPane.showInputDialog("Ingrese un numero: "));
        if (num % 2 == 0) {
            JOptionPane.showMessageDialog(null, "El número "+num+" es par.");
        } 
        else {
            JOptionPane.showMessageDialog(null, "El número "+num+" es inpar.");
        }
    }
//5.      Elaborar un algoritmo para leer 3 números y determinar si uno es la suma de los otros dos.
    public static void numeros() {
        JOptionPane.showMessageDialog(null, "ingrese tres numeros cuya suma de dos de el tercero");
        float x1=Float.valueOf(JOptionPane.showInputDialog("Ingrese el primer numero: "));
        float x2=Float.valueOf(JOptionPane.showInputDialog("Ingrese el segundo numero: "));
        float x3=Float.valueOf(JOptionPane.showInputDialog("Ingrese el tercer numero: "));
        
        if (x3 + x2 == x1) {
            JOptionPane.showMessageDialog(null, "Su primer numero es la suma de los otros dos");
        }
        else if (x1 + x3 == x2) {
            JOptionPane.showMessageDialog(null, "Su segundo numero es la suma de los otros dos");
            
        }
        else if (x1 + x2 == x3) {
            JOptionPane.showMessageDialog(null, "Su tercer numero es la suma de los dos anteriores");
            
        }
        else {
            JOptionPane.showMessageDialog(null, "Estos numeros no cumplen la condicion dada" );
        }
        
    }

        
    
    
}
