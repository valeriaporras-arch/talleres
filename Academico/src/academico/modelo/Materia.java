/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academico.modelo;

import java.util.ArrayList;

/**
 *
 * @author UIS
 */
public class Materia {
    
    int idmateria;
    String nombre;
    int creditos;
    ArrayList<Float> notas;

    public Materia(int idmateria, String nombre, int creditos) {
        this.idmateria = idmateria;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Materia{" + "idmateria=" + idmateria + ", nombre=" + nombre + ", creditos=" + creditos + '}';
    }
    
    
}
