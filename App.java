import Vista.VistaInicioSesion;
import Vista.VistaLogin;
import Vista.VistaRegistro;
import Vista.VistaInicioMenu;
import Controlador.ContInicioSesion;
import Controlador.ContRegistro;

public class App {
    public static void main(String[] args) {
        VistaInicioSesion vistaInicio = new VistaInicioSesion();
        VistaLogin vistaLogin = new VistaLogin();
        VistaRegistro vistaRegistro = new VistaRegistro();
        VistaInicioMenu vistaInicioMenu = new VistaInicioMenu();

        ContInicioSesion controlador = new ContInicioSesion();
        controlador.iniciar(vistaInicio, vistaLogin, vistaRegistro,vistaInicioMenu);
        
    }
}
