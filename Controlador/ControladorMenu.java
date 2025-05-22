package Controlador;

import Vista.*;
import Modelo.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

public class ControladorMenu {


    public ControladorMenu(VistaInicioSesion vistainiciomenu,VistaInicioMenu vistaMenu, VistaResumenCompras vistaResumenCompras, VistaComponentes vistaComponentes, VistaMenuAdmin vistaAdmin, String  usuario) {

        vistaMenu.setNombreUsuario(usuario);

        vistaMenu.mostrarVentana();

            vistaMenu.btnVerCompras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaMenu.cerrarVentana();
                vistaResumenCompras.mostrarVentana();
                new ContResumenComp(vistaResumenCompras, vistaMenu, usuario);
            }
        });

        vistaMenu.btnComprarcomp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaMenu.cerrarVentana();
                vistaComponentes.mostrarVentana();
                new ContComponenetes(vistaComponentes, vistaMenu, usuario);
            }
        });

        vistaMenu.btnAdministrar.addActionListener(new ActionListener() {
            @Override
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
            public void actionPerformed(ActionEvent e) {
                vistaMenu.cerrarVentana();
                new ContInicioSesion().iniciar(new VistaInicioSesion(), new VistaLogin(), new VistaRegistro(), 
                        new VistaInicioMenu(), new VistaComponentes(), new VistaResumenCompras(), new VistaMenuAdmin());
            }
        });

    }
}
