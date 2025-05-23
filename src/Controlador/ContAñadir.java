package Controlador;
import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;

/** 
 * Clase ContAñadir. 
 * Controlador que gestiona los eventos de la vista asociada y la lógica de interacción con el modelo. 
 * Se encarga de responder a las acciones del usuario y actualizar vistas o datos según sea necesario.
 */

public class ContAñadir {

    /** 
     * Método ContAñadir.
     * Lógica asociada a esta parte del controlador.
     */
    
    public ContAñadir(VistaAñadirComp vistaAñadirComp, VistaMenuAdmin vistaMenuAdmin) {

        vistaAñadirComp.btnVolver.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
            */
            public void actionPerformed(ActionEvent e) {
                vistaAñadirComp.cerrarVentana();
                vistaMenuAdmin.mostrarVentana();
            }
        });

        vistaAñadirComp.btnRegistrar.addActionListener(new ActionListener() {
            @Override
        /** 
         * Método actionPerformed.
         * Ejecuta la acción principal del controlador.
         * @param e evento recibido desde la interfaz de usuario
         */

            public void actionPerformed(ActionEvent e) {

            try{
                String nombre = vistaAñadirComp.campoNombre.getText();
                String tipo = vistaAñadirComp.campoTipo.getText();
                String compatible = vistaAñadirComp.campoCompatible.getText();
                if (compatible.isEmpty()) {
                        compatible = null; 
                }
                double precio = Double.parseDouble(vistaAñadirComp.campoPrecio.getText());
                int stock = Integer.parseInt(vistaAñadirComp.campoStock.getText());

                Connection cn = ConexionBD.conectar();
                if(new ComponenteDAO().insertarComponente(cn, nombre, tipo, compatible, precio, stock)){

                JOptionPane.showMessageDialog(null, "Componente añadido con éxito");
            
                vistaAñadirComp.campoNombre.setText("");
                vistaAñadirComp.campoTipo.setText("");
                vistaAñadirComp.campoCompatible.setText("");
                vistaAñadirComp.campoPrecio.setText("");
                vistaAñadirComp.campoStock.setText("");}
                else{
                    JOptionPane.showMessageDialog(null, "No se ha podido añadir el componente");}

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al registrar: " + ex.getMessage());
                }
            }
        });
    }

}
