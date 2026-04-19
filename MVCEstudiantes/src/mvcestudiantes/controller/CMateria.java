/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcestudiantes.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mvcestudiantes.model.Estudiante;
import mvcestudiantes.model.Materia;
import mvcestudiantes.model.MateriaDAO;
import mvcestudiantes.view.ScreenManager;
import mvcestudiantes.view.VMateria;

/**
 *
 * @author Usuario
 */
public class CMateria implements ActionListener{
    
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
                ScreenManager.cerrarMateria(CMateria.this);
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
                limpiarCampos();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error en datos: " + ex.getMessage());
        }
    }
    
    private void consultar(){
        int doc = (int) vista.getSpnId().getValue();
        Materia mat = dao.buscarPorDoc(doc);
        
        if (mat != null) {
            vista.getTxtNombre().setText(mat.getNombre());
            vista.getTxtCreditos().setText(mat.getCreditos());
            vista.getTxtNota().setText(String.valueOf(mat.getPromedio()));
        }else {
            JOptionPane.showMessageDialog(vista, "Materia no encontrada.");
        }
                
    }
    private void actualizar(){
        String doc = (String) vista.getSpnId().getValue();
        try {
            Materia actualizado = capturarDatos();
            
            if (dao.actualizarDatos(actualizado)) {
                JOptionPane.showMessageDialog(vista, "Actualizado con éxito.");
                llenarTabla();
            }else{
                JOptionPane.showMessageDialog(vista, "No se pudo actualizar.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al acruaaalizar.");
        }
    }
    
    private void eliminar(){
        String doc = (String)vista.getSpnId().getValue();
        if (dao.eliminar(doc)) {
            JOptionPane.showMessageDialog(vista, "Materia eliminada.");
            limpiarCampos();
            llenarTabla();
        }else{
            JOptionPane.showMessageDialog(vista, "No se encontro el registro.");
        }
    }
    public void llenarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.getTblMateria().getModel();
        modeloTabla.setRowCount(0);
        
        List<Materia> lista = dao.consTodos();
        
        Object[] fila = new Object[4];
        for (Materia mat : lista) {
            fila[0] = mat.getId();
            fila[1] = mat.getNombre();
            fila[2] = mat.getCreditos();
            fila[3] = mat.getPromedio();
            modeloTabla.addRow(fila);
        }
    }
    
    //   METODOS AUXILIARES
    private Materia capturarDatos() {
        return new Materia(
                (int) vista.getSpnId().getValue(),
                vista.getTxtNombre().getText(),
                vista.getTxtCreditos().getText(),
                Double.parseDouble(vista.getTxtNota().getText())
        );
    }
    
    private void limpiarCampos() {
        vista.getSpnId().setValue("");
        vista.getTxtNombre().setText("");
        vista.getTxtCreditos().setText("");
        vista.getTxtNota().setText("");
        vista.getSpnId().requestFocus();
    }
    
    public void finalizar(){
        this.vista.dispose();
        this.vista = null;
        this.dao = null;
        
        System.out.println("Controlador y referencias liberadas");
    }
}
