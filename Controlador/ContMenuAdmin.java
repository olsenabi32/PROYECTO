package Controlador;

import Vista.*;
import Modelo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class ContMenuAdmin {


    public ContMenuAdmin(VistaInicioMenu vistaMenu,VistaMenuAdmin vistaMenuAdmin, VistaBorrarComp vistaBorrar, VistaAñadirComp vistaAñadir, String usuario) {

        vistaMenu.setNombreUsuario(usuario);

        vistaMenuAdmin.btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaMenu.cerrarVentana();
                vistaBorrar.mostrarVentana();
                new ContBorrar(vistaBorrar, vistaMenuAdmin);
            }
        });

        vistaMenuAdmin.btnAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaMenu.cerrarVentana();
                vistaAñadir.mostrarVentana();
                new ContAñadir(vistaAñadir, vistaMenuAdmin);
            }
        });

        vistaMenuAdmin.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaMenuAdmin.cerrarVentana();
                vistaMenu.mostrarVentana();
            }
        });

    }
}

