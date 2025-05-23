package Controlador;

import Vista.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 
 * Clase ContMenuAdmin. 
 * Controlador que gestiona los eventos de la vista asociada y la lógica de interacción con el modelo. 
 * Se encarga de responder a las acciones del usuario y actualizar vistas o datos según sea necesario.
 */

public class ContMenuAdmin {

    /** 
     * Método ContMenuAdmin.
     * Lógica asociada a esta parte del controlador.
     */

    public ContMenuAdmin(VistaInicioMenu vistaMenu,VistaMenuAdmin vistaMenuAdmin, VistaBorrarComp vistaBorrar, VistaAñadirComp vistaAñadir, String usuario) {

        vistaMenu.setNombreUsuario(usuario);

        vistaMenuAdmin.btnBorrar.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                vistaMenuAdmin.cerrarVentana();
                vistaBorrar.mostrarVentana();
                new ContBorrar(vistaBorrar, vistaMenuAdmin);
            }
        });

        vistaMenuAdmin.btnAñadir.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                vistaMenuAdmin.cerrarVentana();
                vistaAñadir.mostrarVentana();
                new ContAñadir(vistaAñadir, vistaMenuAdmin);
            }
        });

        vistaMenuAdmin.btnActualizar.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                vistaMenuAdmin.cerrarVentana();
                VistaActualizaComp vistaActualizaComp = new VistaActualizaComp();
                vistaActualizaComp.mostrarVentana();
                new ContActualizComp(vistaActualizaComp, vistaMenuAdmin);
            }
        });

        vistaMenuAdmin.btnVolver.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                vistaMenuAdmin.cerrarVentana();
                vistaMenu.mostrarVentana();
            }
        });

        

    }
}

