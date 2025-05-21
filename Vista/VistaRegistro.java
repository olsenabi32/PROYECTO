package Vista;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class VistaRegistro {

    private JFrame ventana;
    public JTextField campoUsuario;
    public JPasswordField campoContraseña;
    public JTextField campoNombre;
    public JTextField campoApellidos;
    public JTextField campoCorreo;
    public JButton btnRegistrar;
    public JButton btnVolver;

    public VistaRegistro() {
        initialize();
    }

    public void initialize() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.decode("#E6CCFF"));

        // Título
        JLabel titulo = new JLabel("Registro de usuario");
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setBounds(200, 60, 400, 60);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        ventana.getContentPane().add(titulo);

        // Usuario
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
        lblUsuario.setBounds(180, 140, 100, 30);
        ventana.getContentPane().add(lblUsuario);

        campoUsuario = new JTextField();
        campoUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
        campoUsuario.setBounds(300, 140, 300, 30);
        ventana.getContentPane().add(campoUsuario);

        // Contraseña
        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setFont(new Font("Arial", Font.PLAIN, 18));
        lblContraseña.setBounds(180, 190, 120, 30);
        ventana.getContentPane().add(lblContraseña);

        campoContraseña = new JPasswordField();
        campoContraseña.setFont(new Font("Arial", Font.PLAIN, 16));
        campoContraseña.setBounds(300, 190, 300, 30);
        ventana.getContentPane().add(campoContraseña);

        // Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        lblNombre.setBounds(180, 240, 100, 30);
        ventana.getContentPane().add(lblNombre);

        campoNombre = new JTextField();
        campoNombre.setFont(new Font("Arial", Font.PLAIN, 16));
        campoNombre.setBounds(300, 240, 300, 30);
        ventana.getContentPane().add(campoNombre);

        // Apellidos
        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setFont(new Font("Arial", Font.PLAIN, 18));
        lblApellidos.setBounds(180, 290, 100, 30);
        ventana.getContentPane().add(lblApellidos);

        campoApellidos = new JTextField();
        campoApellidos.setFont(new Font("Arial", Font.PLAIN, 16));
        campoApellidos.setBounds(300, 290, 300, 30);
        ventana.getContentPane().add(campoApellidos);

        // Correo
        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setFont(new Font("Arial", Font.PLAIN, 18));
        lblCorreo.setBounds(180, 340, 100, 30);
        ventana.getContentPane().add(lblCorreo);

        campoCorreo = new JTextField();
        campoCorreo.setFont(new Font("Arial", Font.PLAIN, 16));
        campoCorreo.setBounds(300, 340, 300, 30);
        ventana.getContentPane().add(campoCorreo);

        // Botón de registrar
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 20));
        btnRegistrar.setBounds(320, 410, 150, 50);
        ventana.getContentPane().add(btnRegistrar);

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        btnVolver.setBounds(630, 480, 120, 40); 
        ventana.getContentPane().add(btnVolver);

    }

    public void mostrarVentana() {
        ventana.setVisible(true);
    }

    public void cerrarVentana() {
        ventana.dispose();
    }

    public static void main(String[] args) {
        VistaRegistro vista = new VistaRegistro();
        vista.mostrarVentana();
    }
}

