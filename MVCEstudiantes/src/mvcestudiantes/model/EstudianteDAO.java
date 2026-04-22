/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcestudiantes.model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UIS
 */
public class EstudianteDAO {
    //base de datos psra guardar dat  val
    private final String RUTA_ARCHIVO = "estudiantes.json";
    private static List<Estudiante> listaEstudiantes = new ArrayList<>();
    private Gson gson;
    
    public EstudianteDAO() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.listaEstudiantes = cargarDesdeArchivo();
    }
    
    private List<Estudiante> cargarDesdeArchivo () {
        File archivo = new File(RUTA_ARCHIVO);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        
        try (Reader reader = new FileReader(RUTA_ARCHIVO)){
            Type tipoLista = new TypeToken<ArrayList<Estudiante>>(){}.getType();
            List<Estudiante> lista = gson.fromJson(reader, tipoLista);
            return (lista != null) ? lista : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    
    private void guardarEnArchivo () {
        try (Writer writer = new FileWriter(RUTA_ARCHIVO)){
            gson.toJson(listaEstudiantes, writer);
        } catch (Exception e) {
            System.err.println("Error al gustdasr en JSON: " + e.getMessage());
        }
    }
    
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
