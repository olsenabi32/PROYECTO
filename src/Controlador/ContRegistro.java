package Controlador;

import Vista.VistaRegistro;
import Vista.VistaInicioMenu;
import Vista.VistaInicioSesion;
import Modelo.UsuarioDAO;
import Modelo.ConexionBD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

/** 
 * Clase ContRegistro. 
 * Controlador que gestiona los eventos de la vista asociada y la lógica de interacción con el modelo. 
 * Se encarga de responder a las acciones del usuario y actualizar vistas o datos según sea necesario.
 */

public class ContRegistro {

    /** 
     * Método ContRegistro.
     * Lógica asociada a esta parte del controlador.
     */

    public ContRegistro(VistaRegistro vistaRegistro, VistaInicioSesion vistaInicioSesion, VistaInicioMenu vistaInicioMenu) {
        vistaRegistro.mostrarVentana();

        // Botón Volver
        vistaRegistro.btnVolver.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                vistaRegistro.cerrarVentana();
                vistaInicioSesion.mostrarVentana();
            }
        });

        // Botón Registrar
        vistaRegistro.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                String user = vistaRegistro.campoUsuario.getText();
                String pass = new String(vistaRegistro.campoContraseña.getPassword());
                String nombre = vistaRegistro.campoNombre.getText();
                String apellidos = vistaRegistro.campoApellidos.getText();
                String correo = vistaRegistro.campoCorreo.getText();
                vistaInicioMenu.setNombreUsuario(user); // user es el texto del campo de usuario


                Connection cn = ConexionBD.conectar();
                UsuarioDAO.insertarUsuario(cn, user, nombre, apellidos, correo, pass);

                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                vistaRegistro.cerrarVentana();
                vistaInicioMenu.mostrarVentana();
            }
        });
    }
}
