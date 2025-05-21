package Controlador;

import Vista.*;
import Modelo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ContMenuAdmin {


    public ContMenuAdmin(VistaInicioMenu vistaMenu,VistaMenuAdmin vistaMenuAdmin, VistaBorrarComp vistaBorrar, VistaAñadirComp vistaAñadir, String usuario) {

        vistaMenu.setNombreUsuario(usuario);

        vistaMenuAdmin.btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaMenuAdmin.cerrarVentana();
                vistaBorrar.mostrarVentana();
                new ContBorrar(vistaBorrar, vistaMenuAdmin);
            }
        });

        vistaMenuAdmin.btnAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaMenuAdmin.cerrarVentana();
                vistaAñadir.mostrarVentana();
                new ContAñadir(vistaAñadir, vistaMenuAdmin);
            }
        });

        vistaMenuAdmin.btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaMenuAdmin.cerrarVentana();
                VistaActualizaComp vistaActualizaComp = new VistaActualizaComp();
                vistaActualizaComp.mostrarVentana();
                new ContActualizComp(vistaActualizaComp, vistaMenuAdmin);
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

