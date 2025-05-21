package Controlador;

import Vista.*;
import Modelo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ContActualizComp {

    public ContActualizComp(VistaActualizaComp vistaActualizaComp, VistaMenuAdmin vistaMenuAdmin) {

        vistaActualizaComp.btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String nombre = vistaActualizaComp.campoNombre.getText();
                    int stock = Integer.parseInt(vistaActualizaComp.campoStock.getText());

                    ComponenteDAO componenteDAO = new ComponenteDAO();
                    if (componenteDAO.actualizarComponente(nombre, stock)) {
                        JOptionPane.showMessageDialog(null, "Componente actualizado con éxito");
                        vistaActualizaComp.campoNombre.setText("");
                        vistaActualizaComp.campoStock.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido actualizar el componente");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar: " + ex.getMessage());
                }
            }
        });

        vistaActualizaComp.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaActualizaComp.cerrarVentana();
                vistaMenuAdmin.mostrarVentana();
            }
        });
    }

    
}
