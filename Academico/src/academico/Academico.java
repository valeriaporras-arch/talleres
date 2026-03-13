/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academico;

import academico.modelo.Estudiante;
import academico.modelo.Materia;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author UIS
 */
public class Academico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Estudiante> estuiante = new ArrayList<>();
        int op = 0;

        while (op != 6) {

            Scanner ps = new Scanner(System.in);

            System.out.println("===MENU=== ");
            System.out.println("1. Registrar estudantes.");
            System.out.println("2. Registrar materia.");
            System.out.println("3. Registrar nota.");
            System.out.println("4. Listar estudantes.");
            System.out.println("5. Mostrar promedio.");
            System.out.println("6. Salir.");

            op = ps.nextInt();

            switch (op) {
                case 1 ->
                    registrarEstudiante(estuiante);
                case 2 -> {
                }
                case 3 -> {
                }
                case 4 ->
                    listarEstudiante(estuiante);
                case 5 -> {
                }
                default ->
                    System.out.println("Opcion no registrada.");
            }
        }

    }

    public static void registrarEstudiante(ArrayList<Estudiante> estuiante) {
        Scanner cd = new Scanner(System.in);

        System.out.println("Ingrese el id:");
        int id = cd.nextInt();
        cd.nextLine();
        System.out.println("Ingrese el nombre:");
        String nom = cd.nextLine();
        System.out.println("Ingrese la direccion:");
        String direccion = cd.nextLine();
        System.out.println("Ingrese el telefono:");
        String telefono = cd.nextLine();

        Estudiante d = new Estudiante(id, nom, direccion, telefono);

        estuiante.add(d);

        System.out.println("Estudiante registrado con exito.");
        System.out.println("Presine cualquier tecla para continuar");
    }

    public static void registrarMateria(ArrayList<Estudiante> estuiante) {
        Scanner cd = new Scanner(System.in);
        //ingresasrcodigo del estudiante
        System.out.println("Ingrese el id del estudiante al que desea ingresar: ");
        int ides = cd.nextInt();
        for (Estudiante e : estuiante) {
            //buscar por id
            if (ides ==) {

                System.out.println("Ingrese el id:");
                int id = cd.nextInt();
                cd.nextLine();
                System.out.println("Ingrese el nombre:");
                String nombre = cd.nextLine();
                System.out.println("Ingrese el id:");
                int credito = cd.nextInt();
                cd.nextLine();

                Materia d = new Materia(id, nombre, credito);
            }

        }

    }

    public static void registrarNota(ArrayList<Estudiante> estuiante) {

    }

    public static void listarEstudiante(ArrayList<Estudiante> estuiante) {
        for (Estudiante est : estuiante) {
            System.out.println(est);
        }
    }

    public static void mostrarPromedio(ArrayList<Estudiante> estuiante) {

    }

}
