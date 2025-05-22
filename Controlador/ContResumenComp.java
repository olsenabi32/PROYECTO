package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;



public class ContResumenComp {
    
    public ContResumenComp(VistaResumenCompras vistaCompras, VistaInicioMenu vistaInicioMenu,String usuario) {

        Connection cn = ConexionBD.conectar();
        String compras= new CompraDAO().mostrarCompraSegunUser(cn, usuario);

        if (compras.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tienes compras registradas.");
        } else {
            vistaCompras.areaBlanca.setText(compras);
            vistaCompras.areaBlanca.setEditable(false); // Para que el usuario no pueda escribir
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
