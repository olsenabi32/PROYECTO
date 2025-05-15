package Vista;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class VistaLogin {

    private JFrame ventana;
    public JButton btnEntrar;
    public JTextField campoUsuario;
    public JPasswordField campoContraseña;

    public VistaLogin() {
        initialize();
    }

    public void initialize() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.decode("#E6CCFF"));

        // Título
        JLabel titulo = new JLabel("Iniciar sesión");
        titulo.setFont(new Font("Arial", Font.BOLD, 42));
        titulo.setBounds(250, 80, 300, 50);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        ventana.getContentPane().add(titulo);

        // Etiqueta Usuario
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
        lblUsuario.setBounds(200, 200, 100, 30);
        ventana.getContentPane().add(lblUsuario);

        campoUsuario = new JTextField();
        campoUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
        campoUsuario.setBounds(310, 200, 300, 35);
        ventana.getContentPane().add(campoUsuario);

        // Etiqueta Contraseña
        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setFont(new Font("Arial", Font.PLAIN, 20));
        lblContraseña.setBounds(180, 270, 130, 30);
        ventana.getContentPane().add(lblContraseña);

        campoContraseña = new JPasswordField();
        campoContraseña.setFont(new Font("Arial", Font.PLAIN, 18));
        campoContraseña.setBounds(310, 270, 300, 35);
        ventana.getContentPane().add(campoContraseña);

        // Botón de login
        btnEntrar = new JButton("Entrar");
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 22));
        btnEntrar.setBounds(310, 350, 150, 50);
        ventana.getContentPane().add(btnEntrar);
    }

    public void mostrarVentana() {
        ventana.setVisible(true);
    }

    public void cerrarVentana() {
        ventana.dispose();
    }

    // Para probar directamente
    public static void main(String[] args) {
        VistaLogin vista = new VistaLogin();
        vista.mostrarVentana();
    }
}

