/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ESport.model;

import java.util.List;

/**
 *
 * @author UIS
 */
public class Equipo {
    private String id;
    private String nombre;
    private double prosupuesto;
    private List<Jugador>jugadores;

    public Equipo(String id, String nombre, double prosupuesto) {
        this.id = id;
        this.nombre = nombre;
        this.prosupuesto = prosupuesto;
    }

    public Equipo(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getProsupuesto() {
        return prosupuesto;
    }

    public void setProsupuesto(double prosupuesto) {
        this.prosupuesto = prosupuesto;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
}
