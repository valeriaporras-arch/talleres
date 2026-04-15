/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvcestudiantes.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mvcestudiantes.model.Estudiante;
import mvcestudiantes.model.EstudianteDAO;
import mvcestudiantes.view.VEstudiante;
import mvcestudiantes.view.ScreenManager;

/**
 *
 * @author UIS
 */
public class CEstudiante implements ActionListener{// val.
    
    private VEstudiante vista;
    private EstudianteDAO dao;
    
    public CEstudiante (VEstudiante vista, EstudianteDAO dao) {
        this.vista = vista;
        this.dao = dao;
        
        this.vista.getBtnBuscar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
        this.vista.getBtnModificar().addActionListener(this);
        this.vista.getBtnRegistrar().addActionListener(this);
        
        this.vista.addWindowListener(new java.awt.event.WindowAdapter(){
        @Override
        public void windowClosing (java.awt.event.WindowEvent e) {
            ScreenManager.cerrarEstudiantes(CEstudiante.this);
        }
    });
        llenarTabla();
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       //  Identificar qué botón disparó el evento
        if (e.getSource() == vista.getBtnRegistrar()) {
            registrar();
        } else if (e.getSource() == vista.getBtnBuscar()) {
            consultar();
        } else if (e.getSource() == vista.getBtnModificar()) {
            actualizar();
        } else if (e.getSource() == vista.getBtnEliminar()) {
            eliminar();
        }
    }
   
    private void registrar() {
        try {
            Estudiante est = capturarDatos();
            if (dao.guardar(est)) {
                JOptionPane.showMessageDialog(vista, "Estudiante guardado.");
                llenarTabla();
                limpiarCampos();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error en datos: " + ex.getMessage());
        }
    }
    
    private void consultar(){
        String doc = String.valueOf(vista.getSpnId().getValue());
        Estudiante est = dao.buscarPorDocumento(doc);
        
        if (est != null) {
            vista.getTxtNombres().setText(est.getNombre());
            vista.getTxtApellidos().setText(est.getApellido());
            vista.getTxtPromedio().setText(String.valueOf(est.getPromedio()));
        } else {
            JOptionPane.showMessageDialog(vista, "Estudiante no encontrado.");
        }
    }
    
    private void actualizar() {
        int doc = (int) vista.getSpnId().getValue();
        try {
            Estudiante actualizado = capturarDatos();
            
            if (dao.actializarDatos(actualizado)) {
                JOptionPane.showMessageDialog(vista, "Actualizad con exito.");
                llenarTabla();
            } else {
                JOptionPane.showMessageDialog(vista, "No se pudo actualizar.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al actualizar.");
        }
    }
    
    private void eliminar() {
        String doc = String.valueOf(vista.getSpnId().getValue());
        if (dao.eliminar(doc)) {
            JOptionPane.showMessageDialog(vista, "Estudiante eliminado.");
            limpiarCampos();
            llenarTabla();
        } else {
            JOptionPane.showMessageDialog(vista, "No se encontro el registro");
        }
    }

    public void llenarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.getTblEstudiantes().getModel();
        
        modeloTabla.setRowCount(0);
        
        List<Estudiante> lista = dao.consultarTodos();
        
        Object[] fila = new Object[4];
        for (Estudiante est : lista) {
            fila[0] = est.getId();
            fila[1] = est.getNombre();
            fila[2] = est.getApellido();
            fila[3] = est.getPromedio();
            modeloTabla.addRow(fila);
        }
   }
    
    private Estudiante capturarDatos() {
        return new Estudiante(
        (int) vista.getSpnId().getValue(),
        vista.getTxtNombres().getText(),
        vista.getTxtApellidos().getText(),
        Double.parseDouble(vista.getTxtPromedio().getText())
        );
    }
    private void limpiarCampos() {
        vista.getSpnId().setValue("");
        vista.getTxtNombres().setText("");
        vista.getTxtApellidos().setText("");
        vista.getTxtPromedio().setText("");
        vista.getSpnId().requestFocus();
    }
    
    public void finalizar () {
        //Romper el vinculo con la vista
        this.vista = null;
        this.dao = null;
        
        System.out.println("Controlador y referencias liberadas.");
    }
}
