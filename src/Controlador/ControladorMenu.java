package Controlador;

import Vista.*;
import Modelo.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

/** 
 * Clase ControladorMenu. 
 * Controlador que gestiona los eventos de la vista asociada y la lógica de interacción con el modelo. 
 * Se encarga de responder a las acciones del usuario y actualizar vistas o datos según sea necesario.
 */

public class ControladorMenu {


    /** 
     * Método ControladorMenu.
     * Lógica asociada a esta parte del controlador.
     */
    public ControladorMenu(VistaInicioSesion vistainiciomenu,VistaInicioMenu vistaMenu, VistaResumenCompras vistaResumenCompras, VistaComponentes vistaComponentes, VistaMenuAdmin vistaAdmin, String  usuario) {

        vistaMenu.setNombreUsuario(usuario);

        vistaMenu.mostrarVentana();

            vistaMenu.btnVerCompras.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                vistaMenu.cerrarVentana();
                vistaResumenCompras.mostrarVentana();
                new ContResumenComp(vistaResumenCompras, vistaMenu, usuario);
            }
        });

        vistaMenu.btnComprarcomp.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                vistaMenu.cerrarVentana();
                vistaComponentes.mostrarVentana();
                new ContComponenetes(vistaComponentes, vistaMenu, usuario);
            }
        });

        vistaMenu.btnAdministrar.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                Connection cn = ConexionBD.conectar();
                if (UsuarioDAO.esAdmin(cn, usuario)) {
                    vistaMenu.cerrarVentana();
                    vistaAdmin.mostrarVentana();
                    new ContMenuAdmin(vistaMenu, vistaAdmin, new VistaBorrarComp(),new VistaAñadirComp(), usuario);
                } else {
                    JOptionPane.showMessageDialog(null, "No estás autorizada para acceder a esta función.");
                }
            }
        });

        vistaMenu.btnVolver.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                vistaMenu.cerrarVentana();
                new ContInicioSesion().iniciar(new VistaInicioSesion(), new VistaLogin(), new VistaRegistro(), 
                        new VistaInicioMenu(), new VistaComponentes(), new VistaResumenCompras(), new VistaMenuAdmin());
            }
        });

    }
}
