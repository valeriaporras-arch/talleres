/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcestudiantes.controller;

import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import mvcestudiantes.model.Estudiante;
import mvcestudiantes.model.Materia;
import mvcestudiantes.model.MateriaDAO;
import mvcestudiantes.view.ScreenManager;
import mvcestudiantes.view.VMateria;

/**
 *
 * @author Usuario
 */
public class CMateria {
    private VMateria vista;
    private MateriaDAO dao;
    
    public CMateria (VMateria vista, MateriaDAO dao) {
        this.vista = vista;
        this.dao = dao;
        
        this.vista.getBtnBuscar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
        this.vista.getBtnModificar().addActionListener(this);
        this.vista.getBtnRegistrar().addActionListener(this);
        
        this.vista.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                ScreenManager.cerrarEstudiantes(CEstudiante.this);
            }
        });
        
        llenarTabla();
        
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == vista.getBtnRegistrar()) {
            registrar();
        }else if (e.getSource() == vista.getBtnModificar()) {
            modificar();
        }else if (e.getSource() == vista.getBtnEliminar()) {
            eliminar();
        }else if (e.getSource() == vista.getBtnBuscar()) {
            consultar();
        }
    }
    
    private void registrar(){
        try {
            Materia mat = capturarDatos();
            if (dao.guardar(mat)) {
                JOptionPane.showMessageDialog(vista, "Materia guardado.");
                llenarTabla();
                limpiarcampos();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error en datos: " + ex.getMessage());
        }
    }
    
    private void consultar(){
        String doc = (String) vista.getSpnId().getValue();
    }
    private void actualizar(){
        
    }
    private void eliminar(){
        
    }
    public void llenarTabla() {
        
    }
    
    //   METODOS AUXILIARES
    private Materia capturarDatos() {
        return new Materia(
                (int) vista.getSpnId().getValue(),
                vista.getTxtNombre().getText(),
                (int) vista.getTxtCreditos().getText(),
                Double.parseDouble(vista.getTxtNota().getText())
        );
    }
    
    private void limpiarCampos() {
        
    }
    
    public void finalizar(){
        
    }
}
