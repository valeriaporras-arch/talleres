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
public class Estudiante {
    int id;
    String nom;
    String direccion;
    String telefono;
    ArrayList<Materia> materias;

    public Estudiante(int id, String nom, String direccion, String telefono) {
        this.id = id;
        this.nom = nom;
        this.direccion = direccion;
        this.telefono = telefono;
        materias = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nom=" + nom + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    
}
