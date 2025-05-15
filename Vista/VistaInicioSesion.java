package Vista;

import javax.swing.*;

import java.awt.*;

public class VistaInicioSesion {

    private JFrame ventana;
    public JButton btnLogin;
    public JButton btnRegistro;

    public VistaInicioSesion() {
        initialize();
    }

    public void initialize() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.decode("#E6CCFF"));

        JLabel titulo = new JLabel("Componentes +Olg");
        titulo.setBounds(100, 80, 600, 50);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        ventana.getContentPane().add(titulo);

        btnLogin = new JButton("Iniciar sesión");
        btnLogin.setBounds(300, 200, 200, 60);
        btnLogin.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(btnLogin);

        btnRegistro = new JButton("Registrarse");
        btnRegistro.setBounds(300, 280, 200, 60);
        btnRegistro.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(btnRegistro);
    }

    // Método para mostrar la ventana
    public void mostrarVentana() {
        ventana.setVisible(true);
    }

    // Método para cerrarla
    public void cerrarVentana() {
        ventana.dispose();
    }

    // Para probar directamente
    public static void main(String[] args) {
        VistaInicioSesion vista = new VistaInicioSesion();
        vista.mostrarVentana();
    }
}
