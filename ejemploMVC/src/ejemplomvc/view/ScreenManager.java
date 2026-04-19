/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplomvc.view;

import ejemplomvc.controller.CEstudiante;
import ejemplomvc.model.EstudianteDAO;

/**
 *
 * @author Programer
 */
public class ScreenManager {
    
  
    
    // Método para abrir la pantalla de Estudiantes
 public static void abrirEstudiantes() {
        // 1. CREAR OBJETOS: Aquí nacen los componentes
        VEstudiante vista = new VEstudiante();
        EstudianteDAO dao = new EstudianteDAO();
        
        // 2. CONECTAR: El controlador une la vista con el dao
        // Guardamos la referencia del controlador para poder usarla luego
        CEstudiante controlador = new CEstudiante(vista, dao);
        
        // 3. MOSTRAR: Configuración visual
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Gestión Académica ");
    }

  
 
 // Método para cerrar y eliminar objetos de forma segura
    public static void cerrarEstudiantes(CEstudiante controlador) {
        if (controlador != null) {
            // 1. LLAMAR A LA AUTO-DESTRUCCIÓN: 
            // El controlador sabe cómo limpiar sus propios cables
            controlador.finalizar(); 
            
            // 2. ELIMINAR REFERENCIA:
            // Ayudamos al Garbage Collector de Java
            controlador = null;
            
            System.out.println("Pantalla cerrada y objetos liberados.");
        }
    }
    
   
   
}
