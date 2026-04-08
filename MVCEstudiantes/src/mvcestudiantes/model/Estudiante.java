/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcestudiantes.model;

/**
 *
 * @author UIS
 */
public class Estudiante {
    
    private int id;
    private String nombre;
    private String apellido;
    private double promedio;

    public Estudiante() {
    }
    
    

    public Estudiante(int idEst, String nombre, String apellido, double promedio) {
        this.id = idEst;
        this.nombre = nombre;
        this.apellido = apellido;
        this.promedio = promedio;
    }

    public int getIdEst() {
        return id;
    }

    public void setIdEst(int idEst) {
        this.id = idEst;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estiudiante{" + "idEst=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", promedio=" + promedio + '}';
    }

    Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
