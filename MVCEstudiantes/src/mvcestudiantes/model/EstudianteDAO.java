/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcestudiantes.model;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UIS
 */
public class EstudianteDAO {
    //base de datos psra guardar dat  val
    private static List<Estudiante> listaEstudiantes = new ArrayList<>();
    
    //METODO Crear (registrar)
    public boolean guardar(Estudiante est){
        try {
            return listaEstudiantes.add(est);
        } catch (Exception e) {
            System.err.print("Error al guardar: " + e.getMessage());
            return false;
        }
        
    }
    //METODO Read (consultar)
    public List<Estudiante> consultarTodos() {
        return listaEstudiantes;
    }
    
    //METODO Delelte (Eliminar por documento)
    public boolean eliminar (String documento) {
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getId() == Integer.parseInt(documento)) {
                listaEstudiantes.remove(i);
                return true;   
            }
        }
        return false;
        }
    
    //METODO Read (buscar dea uno por documento)
    public Estudiante buscarPorDocumento (String documento) {
        for (Estudiante est : listaEstudiantes) {
            if (est.getId() == Integer.parseInt(documento)) {
                return est;
            }
        }
        return null;
    }
    
    //METODO Actualizar
    
    public boolean actializarDatos (Estudiante estActualizado) {
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getId() == (estActualizado.getId())) {
                listaEstudiantes.set(i, estActualizado);
                return true;
            }
        }
        return false;
    }
}
