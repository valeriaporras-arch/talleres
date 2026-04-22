/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcestudiantes.view;

import mvcestudiantes.controller.CEstudiante;
import mvcestudiantes.controller.CMateria;
import mvcestudiantes.controller.CProfesores;
import mvcestudiantes.model.EstudianteDAO;
import mvcestudiantes.model.MateriaDAO;
import mvcestudiantes.model.ProfesoresDAO;

/**
 *
 * @author UIS
 */
public class ScreenManager {
    
    //    ESTUDIANTES
    public static void abrirEstudiantes() {
        
        VEstudiante vista = new VEstudiante();
        EstudianteDAO dao = new EstudianteDAO();
        
        CEstudiante controlador = new CEstudiante(vista, dao);
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Gestion Academina Menu");
    }
    
    public static void cerrarEstudiantes(CEstudiante controlador) {
        if (controlador != null) {
            controlador.finalizar();
            controlador = null;
            
            System.out.println("Pantalla cerrada y objetos liberados.");
            controlador.getVista().setVisible(false);
        }
    }
    
    //    MATERIAS
    public static void abrirMaterias(){
        VMateria vista = new VMateria();
        MateriaDAO dao = new  MateriaDAO();
        
        CMateria controlador = new CMateria(vista, dao);
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Menu Gestion academica.");
    }
    
    public static void cerrarMateria(CMateria controlador) {
        if (controlador != null) {
            controlador.finalizar();
            controlador = null;
            
            System.out.println("Pantalla cerrada y objetos liberados.");
            controlador.getVista().setVisible(false);
        }
    }
    //    PROFESORES
    public static void abrirProfesores(){
        VProfesor vista = new VProfesor();
        ProfesoresDAO dao = new  ProfesoresDAO();
        
        CProfesores controlador = new CProfesores(vista, dao);
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Menu gestion academica.");
    }
    
    public static void cerrarProfesor(CProfesores controlador) {
        if (controlador != null) {
            controlador.finalizar();//1 forma de cerrar desde el controller
            controlador = null;
            
            System.out.println("Pantalla cerrada y objetos liberados.");
            controlador.getVista().setVisible(false);// otra forma llamando la vista
        }
    }
    
    // Menu
    public static void abrirMenu() {
        VMenuClases vista = new VMenuClases();
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Menu de inicio.");
    }
    public static void cerrarMenu (VMenuClases vista) {
    vista.setVisible(false);
        System.out.println("Cerrando sistemasde estudiantes");
}
    
}
