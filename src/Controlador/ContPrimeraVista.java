package Controlador;

import Vista.VistaInicio;
import Vista.VistaLogin;
import Vista.VistaMenuAdmin;
import Vista.VistaRegistro;
import Vista.VistaResumenCompras;
import Vista.VistaComprarComponentes;
import Vista.VistaMenuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 
 * Clase ContInicioSesion. 
 * Controlador que gestiona los eventos de la vista asociada y la lógica de interacción con el modelo. 
 * Se encarga de responder a las acciones del usuario y actualizar vistas o datos según sea necesario.
 */

public class ContPrimeraVista {


    public void iniciar(VistaInicio vistaInicio, VistaLogin vistaLogin, VistaRegistro vistaRegistro, VistaMenuPrincipal vistaMenu, VistaComprarComponentes vistaComponentes, VistaResumenCompras vistaResumenCompras,
    VistaMenuAdmin vistaMenuAdmin) {
        
        vistaInicio.mostrarVentana();

        // Botón Iniciar sesión
        vistaInicio.btnLogin.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                vistaInicio.cerrarVentana();
                new ContLogin(vistaLogin, vistaMenu, vistaInicio, vistaComponentes, vistaResumenCompras, vistaMenuAdmin);
            }
        });

        // Botón Registrarse
        vistaInicio.btnRegistro.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                vistaInicio.cerrarVentana();
                new ContRegistro(vistaRegistro, vistaInicio, vistaMenu);
            }
        });
    }
}





    