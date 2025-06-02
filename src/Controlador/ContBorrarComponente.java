package Controlador;
import Vista.*;
import Modelo.*;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;

/** 
 * Clase ContBorrar. 
 * Controlador que gestiona los eventos de la vista asociada y la lógica de interacción con el modelo. 
 * Se encarga de responder a las acciones del usuario y actualizar vistas o datos según sea necesario.
 */

public class ContBorrarComponente {

    public ComponenteDAO componenteDAO;

    /** 
     * Método ContBorrar.
     * Lógica asociada a esta parte del controlador.
     */

    public ContBorrarComponente(VistaBorrarComp vistaBorrarComp, VistaMenuAdmin vistaMenuAdmin) {
        vistaBorrarComp.btnVolver.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
            */
            public void actionPerformed(ActionEvent e) {
                vistaBorrarComp.cerrarVentana();
                vistaMenuAdmin.mostrarVentana();
            }
        });

        vistaBorrarComp.btnBorrar.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                String nombre = vistaBorrarComp.campoNombre2.getText();
                Connection cn = ConexionBD.conectar();

                if (ComponenteDAO.borrarComponente(cn, nombre)) {
                    JOptionPane.showMessageDialog(null, "Componente borrado con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido borrar el componente");
                }
            }
        });
    }

}