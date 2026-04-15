/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcestudiantes.view;

import mvcestudiantes.controller.CEstudiante;
import mvcestudiantes.model.EstudianteDAO;

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
        
    }
    //    PROFESORES
}
