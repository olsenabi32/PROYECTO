
import Controlador.*;
import Vista.*;


public class App {
    public static void main(String[] args) {

        new ContInicioSesion().iniciar(new VistaInicioSesion(), new VistaLogin(), new VistaRegistro(), 
        new VistaInicioMenu(), new VistaComponentes(), new VistaResumenCompras(), new VistaMenuAdmin());
        
    }
}
