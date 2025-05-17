package Controlador;
import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;


public class ContComponenetes {
    

    public ContComponenetes(VistaComponentes vistaComponenetes,VistaInicioMenu vistaInicioMenu) {
    
        vistaComponenetes.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaComponenetes.cerrarVentana();
                vistaInicioMenu.mostrarVentana();
            }
        });


    }

}
