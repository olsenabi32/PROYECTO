package Controlador;

import Vista.*;
import Modelo.*;
import Controlador.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

public class ControladorMenu {


    public ControladorMenu(VistaInicioMenu vistaMenu, VistaResumenCompras vistaResumenCompras, VistaComponentes vistaComponentes){

        vistaMenu.mostrarVentana();

            vistaMenu.btnVerCompras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaMenu.cerrarVentana();
                vistaResumenCompras.mostrarVentana();
                new ContCompras(vistaResumenCompras, vistaMenu);
            }
        });

        vistaMenu.btnComprarcomp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaMenu.cerrarVentana();
                vistaComponentes.mostrarVentana();
                new ContComponenetes(vistaComponentes, vistaMenu);
            }
        });
    }
}
