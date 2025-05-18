package Vista;

import javax.swing.*;

import java.awt.*;

public class VistaMenuAdmin {

    private JFrame ventana;
    public JButton btnBorrar;
    public JButton btnAñadir;
    public JButton btnVolver;

    public VistaMenuAdmin() {
        initialize();
    }

    public void initialize() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.decode("#E6CCFF"));

        JLabel titulo = new JLabel("Menu Administrador");
        titulo.setBounds(100, 80, 600, 50);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        ventana.getContentPane().add(titulo);

        btnBorrar = new JButton("Borrar Componente");
        btnBorrar.setBounds(250, 200, 300, 60);
        btnBorrar.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(btnBorrar);

        btnAñadir = new JButton("Añadir Componente");
        btnAñadir.setBounds(250, 280, 300, 60);
        btnAñadir.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(btnAñadir);

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        btnVolver.setBounds(630, 480, 120, 40); // posición abajo a la derecha
        ventana.getContentPane().add(btnVolver);
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
        VistaMenuAdmin vista = new VistaMenuAdmin();
        vista.mostrarVentana();
    }
}

