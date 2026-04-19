/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplomvc.controller;

import ejemplomvc.model.Estudiante;
import ejemplomvc.model.EstudianteDAO;
import ejemplomvc.view.ScreenManager;
import ejemplomvc.view.VEstudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Programer
 */
public class CEstudiante implements ActionListener{
    
    
    // Referencias a la Vista y al DAO
    private VEstudiante vista;
    private EstudianteDAO dao;

    // El constructor une las piezas
    public CEstudiante(VEstudiante vista, EstudianteDAO dao) {
        this.vista = vista;
        this.dao = dao;

        // "Activamos" los botones para que el controlador lo escuche
        this.vista.getBtnRegistrar().addActionListener(this);
        this.vista.getBtnBuscar().addActionListener(this);
        this.vista.getBtnModificar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
        
        // Escuchador para la "X" de la ventana
        // se debe cambiar desde las propiedades del frame el defaultCloseOperation. Cámbiarlo a DO_NOTHING_ON_CLOSE.
    this.vista.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
            // Cuando el usuario presiona la X, llamamos al manejador
            // Usamos CEstudiante.this para referirnos a este controlador
            ScreenManager.cerrarEstudiantes(CEstudiante.this);
        }
    });
        
        
        // CARGA INICIAL: Llenamos la tabla apenas se crea el controlador
        llenarTabla();
       
    }

    //  Este método se ejecuta automáticamente al hacer clic en el botón
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

    private void consultar() {
        String doc = vista.getTxtId().getText();
        Estudiante est = dao.buscarPorDocumento(doc);
        
        if (est != null) {
            // Llenamos los campos de la vista con lo que encontró el DAO
            vista.getTxtNombre().setText(est.getNombre());
            vista.getTxtApellido().setText(est.getApellido());
            vista.getTxtPromedio().setText(String.valueOf(est.getPromedio()));
        } else {
            JOptionPane.showMessageDialog(vista, "Estudiante no encontrado.");
        }
    }

    private void actualizar() {
        String doc = vista.getTxtId().getText();
        try {
            // Creamos un objeto con los nuevos datos de los campos
            Estudiante actualizado = capturarDatos();
           
            // El DAO busca el existente y reemplaza sus datos
            if (dao.actualizarDatos(actualizado)) {
                JOptionPane.showMessageDialog(vista, "actualizado con éxito.");
                 llenarTabla();
            } else {
                JOptionPane.showMessageDialog(vista, "No se pudo actualizar.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al actualizar.");
        }
    }

    private void eliminar() {
        String doc = vista.getTxtId().getText();
        if (dao.eliminar(doc)) {
            JOptionPane.showMessageDialog(vista, "Estudiante eliminado.");
            limpiarCampos();
            llenarTabla();
        } else {
            JOptionPane.showMessageDialog(vista, "No se encontró el registro.");
        }
    }
    
    
    public void llenarTabla() {
        //  Obtener el modelo de la tabla de la vista
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.getTblEstudiantes().getModel();
        
        
        //  Limpiar la tabla para evitar datos duplicados
        modeloTabla.setRowCount(0);

        //  Pedir la lista de estudiantes al DAO
        List<Estudiante> lista = dao.consultarTodos();

        //  Recorrer la lista y agregar cada estudiante como una fila
        Object[] fila = new Object[4]; // 4 columnas: Doc, Nombre, Apellido, Nota
        for (Estudiante est : lista) {
            fila[0] = est.getId();
            fila[1] = est.getNombre();
            fila[2] = est.getApellido();
            fila[3] = est.getPromedio();
            modeloTabla.addRow(fila);
        }
    }
    
    
    // --- MÉTODOS AUXILIARES ---

    private Estudiante capturarDatos() {
        // Extrae los datos de la vista y crea el objeto
        return new Estudiante(
            vista.getTxtId().getText(),
            vista.getTxtNombre().getText(),
            vista.getTxtApellido().getText(),
            Double.parseDouble(vista.getTxtPromedio().getText())
        );
    }

    private void limpiarCampos() {
        vista.getTxtId().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getTxtPromedio().setText("");
        vista.getTxtId().requestFocus();
    }
    
    
    
    public void finalizar() {
    // Romper el vínculo con la vista
    this.vista.dispose();
    
    // Limpiar las variables internas
    this.vista = null;
    this.dao = null; 
    
    System.out.println("Controlador y referencias liberadas.");
}
    
}
