/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcestudiantes.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class MateriaDAO {
    
    private static List<Materia> listaMaterias = new ArrayList<>();
    
    //    GUARDAR   
    public boolean guardar (Materia mat) {
        try {
            return listaMaterias.add(mat);
        } catch (Exception e) {
            System.err.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }
    
    //    CONSULTAR
    public List<Materia> consTodos (){
        return listaMaterias;
    }
    
    //   ELIMINAR
    public boolean eliminar(String doc){
        for (int i = 0; i < listaMaterias.size(); i++) {
            if (listaMaterias.get(i).getId() == Integer.parseInt(doc)) {
                listaMaterias.remove(i);
                return true;
            }
        }
        return false;
    }
    
    //    BUSCAR
    public Materia buscarPorDoc(int doc) {
        for (Materia materia : listaMaterias) {
            if (materia.getId() == doc) {
                return materia;
            }
        }
        return null;
    }
    
    //    ACTUALIZAR
    public boolean actualizarDatos (Materia mActualizada) {
        for (int i = 0; i < listaMaterias.size(); i++) {
            if (listaMaterias.get(i).getId() == mActualizada.getId()) {
                listaMaterias.set(i, mActualizada);
                return true;
            }
        }
        return false;
    }
}
