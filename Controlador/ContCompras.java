package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;


public class ContCompras {
    
    public ContCompras(VistaResumenCompras vistaCompras, VistaInicioMenu vistaInicioMenu) {
    
        vistaCompras.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaCompras.cerrarVentana();
                vistaInicioMenu.mostrarVentana();
            }
        });

    }
    
}
