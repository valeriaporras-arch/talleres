package taller5;

import com.sun.source.tree.BreakTree;
import java.text.BreakIterator;
import javax.swing.JOptionPane;

public class Taller5 {

    //1. Ingrese la cantidad de estudiantes que va a evaluar.
    public static void main(String[] args) {  // metodo sin retorno, con retorno es el int(return)
        int estm = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes que desea evaluar. "));
        String[] estudiantes = new String[estm];
        float[] notasProy = new float[estm];
        float[] notasParcial = new float[estm];
        float[] notasExamen = new float[estm];

        ponderado(estm, estudiantes, notasProy, notasParcial, notasExamen);

    }

    public static void registrarEstudiantes(int estm, String[] estudiantes, float[] notasProy, float[] notasParcial, float[] notasExamen) {

        for (int i = 0; i < estm; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante a registrar");
            estudiantes[i] = nombre;
            /*
            2. ingrese las calificaciones de cada estudiante. 
            una nota de proyecto
            una nota de examen parcial
            y una nota de examen final.
             */
            int notap = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota del proyecto."));
            int notaep = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota del examen parcial."));
            int notaef = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota del examen final."));

            notasProy[i] = notap;
            notasParcial[i] = notaep;
            notasExamen[i] = notaef;

        }
    }

    /*
    Opción 1: Proyecto (30%), Parcial (30%), Final (40%).
    Opción 2: Proyecto (40%), Parcial (40%), Final (20%).
     */
    public static void ponderado(int estm, String[] estudiantes, float[] notasProy, float[] notasParcial, float[] notasExamen) {
        String[] op = {"opcion 1 \n (30, 30, 40).", "Opcion 2 \n (40, 40, 20)."};
        int opc = JOptionPane.showOptionDialog(null, "Seleccione el ponderado que desea", "PONDERADO",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, op, op[0]);

        double[] pond = new double[estm];
        for (int i = 0; i < estm; i++) {
            float np = notasProy[i];
            float ne = notasParcial[i];
            float nf = notasExamen[i];
            double pnd;
            switch (opc) {
                case 0:
                    pnd = ((np * 0.30) + (ne * 0.30) + (nf * 0.40));
                    pond[i] = pnd;
                    break;
                case 1:
                    pnd = ((np * 0.40) + (ne * 0.40) + (nf * 0.20));
                    pond[i] = pnd;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no disponible");
            }

        }

    }

    public static void imprimirEstudiantes(String[] estudiantes) {

        System.out.println("listado de estudiantes");
        for (String estudiante : estudiantes) {
            System.out.println(estudiante);
        }

    }

}
