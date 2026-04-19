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
            
            System.out.println("Pantalla cerrada yobjetos liberados.");
        }
    }
    
    //    MATERIAS
    public static void abrirMaterias(){
        VMateria vista = new VMateria();
        MateriaDAO dao = new  MateriaDAO();
        
        CMateria controlador = new CMateria(vista, dao);
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Manu Gestion academica.");
    }
    
    public static void cerrarMateria(CMateria controlador) {
        if (controlador != null) {
            controlador.finalizar();
            controlador = null;
            
            System.out.println("Pantalla cerrada y objetos liberados.");
        }
    }
    //    PROFESORES
    public static void abrirProfesores(){
        VProfesor vista = new VProfesor();
        ProfesoresDAO dao = new  ProfesoresDAO();
        
        CProfesores controlador = new CProfesores(vista, dao);
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Manu gestion academica.");
    }
    
    public static void cerrarProfesor(CMateria controlador) {
        if (controlador != null) {
            controlador.finalizar();
            controlador = null;
            
            System.out.println("Pantalla cerrada y objetos liberados.");
        }
    }
    
}
