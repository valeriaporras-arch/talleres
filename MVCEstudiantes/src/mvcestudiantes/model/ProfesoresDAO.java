package mvcestudiantes.model;


import java.util.ArrayList;
import java.util.List;
import mvcestudiantes.model.Profesores;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class ProfesoresDAO {
    //BASE DATOS
    private static List<Profesores> listaProf =new ArrayList<>();
    //    REGISTRAR
    public boolean guardar (Profesores prof){
        try {
            return listaProf.add(prof);
            
        } catch (Exception e) {
            System.err.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }
    //    CONSULTAR
    public List<Profesores> consultartodos(){
        return listaProf;
    }
    //    ELIMINAR
    public boolean eliminar(int doc){
        for (int i = 0; i < listaProf.size(); i++) {
            if (listaProf.get(i).getId() == doc) {
                listaProf.remove(i);
                return true;
            }
        }
        return false;
    }
    //    BUSCAR.PRO
    public Profesores buscarporDoc (int doc){
        for (Profesores prof : listaProf) {
            if (prof.getId() == doc) {
                return prof;
            }
        }
        return null;
    }
    //    ACTUALIZAR
    public boolean actualizarDatos (Profesores profActualizados){
        for (int i = 0; i < listaProf.size(); i++) {
            if (listaProf.get(i).getId() == profActualizados.getId()) {
                listaProf.set(i, profActualizados);
                return true;
            }
        }
        return false;
    }
}
