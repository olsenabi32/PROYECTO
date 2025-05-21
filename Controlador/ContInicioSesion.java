package Controlador;

import Vista.VistaInicioSesion;
import Vista.VistaLogin;
import Vista.VistaMenuAdmin;
import Vista.VistaRegistro;
import Vista.VistaResumenCompras;
import Vista.VistaComponentes;
import Vista.VistaInicioMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContInicioSesion {


    public void iniciar(VistaInicioSesion vistaInicio, VistaLogin vistaLogin, VistaRegistro vistaRegistro, VistaInicioMenu vistaMenu, VistaComponentes vistaComponentes, VistaResumenCompras vistaResumenCompras,
    VistaMenuAdmin vistaMenuAdmin) {
        
        vistaInicio.mostrarVentana();

        // Botón Iniciar sesión
        vistaInicio.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaInicio.cerrarVentana();
                new ContLogin(vistaLogin, vistaMenu, vistaInicio, vistaComponentes, vistaResumenCompras, vistaMenuAdmin);
            }
        });

        // Botón Registrarse
        vistaInicio.btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaInicio.cerrarVentana();
                new ContRegistro(vistaRegistro, vistaInicio, vistaMenu);
            }
        });
    }
}





    