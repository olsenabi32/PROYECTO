package Controlador;

import Vista.*;
import Modelo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;


public class ContLogin {


    public ContLogin(VistaLogin vistaLogin, VistaInicioMenu vistaMenu,VistaInicioSesion vistaInicioSesion) {
        vistaLogin.mostrarVentana();

        vistaLogin.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaLogin.cerrarVentana();
                vistaInicioSesion.mostrarVentana();  
            }
});

        vistaLogin.btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = vistaLogin.campoUsuario.getText();
                String contraseña = new String(vistaLogin.campoContraseña.getPassword());
                vistaMenu.setNombreUsuario(user);

                Connection cn = ConexionBD.conectar();


                if (UsuarioDAO.buscarUsuario(cn, user, contraseña)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión correcto");
                    vistaLogin.cerrarVentana();
                    vistaMenu.mostrarVentana();
                    new ControladorMenu(vistaMenu, new VistaResumenCompras(), new VistaComponentes());
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no registrado o contraseña incorrecta");
                }
            }
        });
    }
}
