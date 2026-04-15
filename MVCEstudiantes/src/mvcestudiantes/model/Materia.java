/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcestudiantes.model;

/**
 *
 * @author Usuario
 */
public class Materia {
    
    private int id;
    private String nombre;
    private int creditos;
    private double promedio;
    
    public Materia(){
    }

    public Materia(int id, String nombre, int creditos, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
        this.promedio = promedio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", nombre=" + nombre + ", creditos=" + creditos + ", promedio=" + promedio + '}';
    }
    
        
}
