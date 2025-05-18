package Controlador;
import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class ContAñadir {
public ComponenteDAO componenteDAO;
    
    public ContAñadir(VistaAñadirComp vistaAñadirComp, VistaMenuAdmin vistaMenuAdmin) {
        vistaAñadirComp.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaAñadirComp.cerrarVentana();
                vistaMenuAdmin.mostrarVentana();
            }
        });

        vistaAñadirComp.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = vistaAñadirComp.campoNombre.getText();
                String tipo = vistaAñadirComp.campoTipo.getText();
                String compatible = vistaAñadirComp.campoCompatible.getText();
                double precio = Double.parseDouble(vistaAñadirComp.campoPrecio.getText());
                int stock = Integer.parseInt(vistaAñadirComp.campoStock.getText());

                Connection cn = ConexionBD.conectar();
                componenteDAO.insertarComponente(cn, nombre, tipo, compatible, precio, stock);
                JOptionPane.showMessageDialog(null, "Componente añadido con éxito");
            }
        });
    }

}
