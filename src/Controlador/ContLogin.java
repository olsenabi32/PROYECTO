package Controlador;

import Vista.*;
import Modelo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

/** 
 * Clase ContLogin. 
 * Controlador que gestiona los eventos de la vista asociada y la lógica de interacción con el modelo. 
 * Se encarga de responder a las acciones del usuario y actualizar vistas o datos según sea necesario.
 */

public class ContLogin {

    public ContLogin(VistaLogin vistaLogin, VistaInicioMenu vistaMenu,VistaInicioSesion vistaInicioSesion, VistaComponentes vistaComponentes, 
    VistaResumenCompras vistaResumenCompras,VistaMenuAdmin vistaMenuAdmin) {
        vistaLogin.mostrarVentana();

        vistaLogin.btnVolver.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                vistaLogin.cerrarVentana();
                vistaInicioSesion.mostrarVentana();  
            }
});

        vistaLogin.btnEntrar.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                String user = vistaLogin.campoUsuario.getText();
                String contraseña = new String(vistaLogin.campoContraseña.getPassword());
                vistaMenu.setNombreUsuario(user);

                Connection cn = ConexionBD.conectar();

                if (UsuarioDAO.buscarUsuario(cn, user, contraseña)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión correcto");
                    vistaLogin.cerrarVentana();
                    vistaMenu.mostrarVentana();
                    new ControladorMenu(new VistaInicioSesion(),vistaMenu, vistaResumenCompras, vistaComponentes,vistaMenuAdmin, user);
                } else {

                    JOptionPane.showMessageDialog(null, "Usuario no registrado o contraseña incorrecta");
                }
            }
        });
    }
}
