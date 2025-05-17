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

public class ContRegistro {

    public ContRegistro(VistaRegistro vistaRegistro, VistaInicioSesion vistaInicioSesion, VistaInicioMenu vistaInicioMenu) {
        vistaRegistro.mostrarVentana();

        // Botón Volver
        vistaRegistro.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaRegistro.cerrarVentana();
                vistaInicioSesion.mostrarVentana();
            }
        });

        // Botón Registrar
        vistaRegistro.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = vistaRegistro.campoUsuario.getText();
                String pass = new String(vistaRegistro.campoContraseña.getPassword());
                String nombre = vistaRegistro.campoNombre.getText();
                String apellidos = vistaRegistro.campoApellidos.getText();
                String correo = vistaRegistro.campoCorreo.getText();

                Connection cn = ConexionBD.conectar();
                UsuarioDAO.insertarUsuario(cn, user, nombre, apellidos, correo, pass);

                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                vistaRegistro.cerrarVentana();
                vistaInicioMenu.mostrarVentana();
            }
        });
    }
}
