package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
/** 
 * Clase ContResumenComp. 
 * Controlador que gestiona los eventos de la vista asociada y la lógica de interacción con el modelo. 
 * Se encarga de responder a las acciones del usuario y actualizar vistas o datos según sea necesario.
 */


public class ContResumenCompras {

    /** 
     * Método ContResumenComp.
     * Lógica asociada a esta parte del controlador.
     */
    
    public ContResumenCompras(VistaResumenCompras vistaCompras, VistaMenuPrincipal vistaInicioMenu,String usuario) {

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
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                vistaCompras.cerrarVentana();
                vistaInicioMenu.mostrarVentana();
            }
        });
    

    }


    
}
