/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcestudiantes.controller;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import mvcestudiantes.model.Materia;
import mvcestudiantes.model.Profesores;
import mvcestudiantes.model.ProfesoresDAO;
import mvcestudiantes.view.ScreenManager;
import mvcestudiantes.view.VEstudiante;
import mvcestudiantes.view.VProfesor;

/**
 *
 * @author Usuario
 */
public class CProfesores implements ActionListener{
    private VProfesor vista;
    private ProfesoresDAO dao;
    
    public CEstudiante (VEstudiante vista, ProfesoresDAO dao){
        this.vista = vista;
        this.dao = dao;
        
        this.vista.getBtnBuscar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
        this.vista.getBtnModificar().addActionListener(this);
        this.vista.getBtnRegistrar().addActionListener(this);
        
        this.vista.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                ScreenManager.cerrarProfesor(CProfesores.this);
            }
        });
        llenarTabla();
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        
        if (e.getSource() == vista.getBtnRegistrar()) {
            registrar();
        }else if (e.getSource() == vista.getBtnModificar()) {
            actualizar();
        }else if (e.getSource() == vista.getBtnEliminar()) {
            eliminar();
        }else if (e.getSourse() == vista.getBtnBuscar()) {
            consultar();
        }
    }
    
    private void registrar() {
        try {
            Profesores prof = capturarDatos();
            if (dao.guardar(prof)) {
                JOptionPane.showMessageDialog(vista, "Profesor guardado.");
                llenarTabla();
                limpiarCampos();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error en datos: " + ex.getMessage());
        }
    }
    
    private void consultar(){
        
    }
}
