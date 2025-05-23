package Controlador;

import Vista.*;
import Modelo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

/** 
 * Clase ContActualizComp. 
 * Controlador que gestiona los eventos de la vista asociada y la lógica de interacción con el modelo. 
 * Se encarga de responder a las acciones del usuario y actualizar vistas o datos según sea necesario.
 */

public class ContActualizComp {

    /** 
     * Método ContActualizComp.
     * Lógica asociada a esta parte del controlador.
     */

    public ContActualizComp(VistaActualizaComp vistaActualizaComp, VistaMenuAdmin vistaMenuAdmin) {

        Connection cn = ConexionBD.conectar();
        ComponenteDAO componenteDAO = new ComponenteDAO();
        String alamacen= componenteDAO.mostrarAlmacen(cn);
        vistaActualizaComp.almacenArea.setText(alamacen);
        vistaActualizaComp.almacenArea.setEditable(false); 

        vistaActualizaComp.btnActualizar.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {

                try {
                    String nombre = vistaActualizaComp.campoNombre.getText();
                    int stock = Integer.parseInt(vistaActualizaComp.campoStock.getText());

                    ComponenteDAO componenteDAO = new ComponenteDAO();
                    if (componenteDAO.actualizarComponente(nombre, stock)) {
                        JOptionPane.showMessageDialog(null, "Componente actualizado con éxito");
                        vistaActualizaComp.campoNombre.setText("");
                        vistaActualizaComp.campoStock.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido actualizar el componente");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar: " + ex.getMessage());
                }
            }
        });

        vistaActualizaComp.btnVolver.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                vistaActualizaComp.cerrarVentana();
                vistaMenuAdmin.mostrarVentana();
            }
        });
    }

    
}
