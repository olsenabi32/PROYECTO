package Controlador;
import Vista.*;
import Modelo.*;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;


public class ContBorrar {

    public ComponenteDAO componenteDAO;

    public ContBorrar(VistaBorrarComp vistaBorrarComp, VistaMenuAdmin vistaMenuAdmin) {
        vistaBorrarComp.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaBorrarComp.cerrarVentana();
                vistaMenuAdmin.mostrarVentana();
            }
        });

        vistaBorrarComp.btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = vistaBorrarComp.campoNombre2.getText();
                Connection cn = ConexionBD.conectar();

                if (ComponenteDAO.borrarComponente(cn, nombre)) {
                    JOptionPane.showMessageDialog(null, "Componente borrado con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido borrar el componente");
                }
            }
        });
    }

}