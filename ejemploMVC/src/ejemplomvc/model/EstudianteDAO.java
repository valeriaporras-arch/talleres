/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplomvc.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Programer
 */
public class EstudianteDAO {
    
    
   //"base de datos" en memoria. 
    // Es static para que los datos se mantengan mientras la App esté abierta.
    private static List<Estudiante> listaEstudiantes = new ArrayList<>();

    // MÉTODO: CREATE (Registrar)
    public boolean guardar(Estudiante est) {
        try {
            return listaEstudiantes.add(est);
           
        } catch (Exception e) {
            System.err.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }

    // MÉTODO: READ (Consultar todos)
    public List<Estudiante> consultarTodos() {
        return listaEstudiantes;
    }

    // MÉTODO: DELETE (Eliminar por documento)
    public boolean eliminar(String documento) {
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getId().equals(documento)) {
                listaEstudiantes.remove(i);
                return true;
            }
        }
        return false;
    }

    // MÉTODO: READ (Buscar uno solo por documento)
    public Estudiante buscarPorDocumento(String documento) {
        for (Estudiante est : listaEstudiantes) {
            if (est.getId().equals(documento)) {
                return est;
            }
        }
        return null;
    }
    
    public boolean actualizarDatos(Estudiante estActualizado) {
    for (int i = 0; i < listaEstudiantes.size(); i++) {
        // Buscamos al estudiante por su documento
        if (listaEstudiantes.get(i).getId().equals(estActualizado.getId())) {
            
            // Reemplazamos el objeto viejo por el nuevo en esa misma posición
            listaEstudiantes.set(i, estActualizado);
            return true; // Actualización exitosa
        }
    }
    return false; // No se encontró el estudiante para actualizar
    }
}
