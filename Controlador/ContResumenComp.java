package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class ContResumenComp {
    
    public ContResumenComp(VistaResumenCompras vistaCompras, VistaInicioMenu vistaInicioMenu,String usuario) {

        Connection cn = ConexionBD.conectar();
        String compras= new CompraDAO().mostrarCompraSegunUser(cn, usuario);

        if (compras.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tienes compras registradas.");
        } else {
            vistaCompras.areaBlanca = new JLabel("<html>" + compras.replaceAll("\n", "<br>") + "</html>");
            vistaCompras.areaBlanca.setFont(vistaCompras.areaBlanca.getFont().deriveFont(16f));
            vistaCompras.areaBlanca.setBounds(100, 150, 600, 250);
            vistaCompras.ventana.getContentPane().add(vistaCompras.areaBlanca);

        }
        
        vistaCompras.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaCompras.cerrarVentana();
                vistaInicioMenu.mostrarVentana();
            }
        });
    

    }


    
}
