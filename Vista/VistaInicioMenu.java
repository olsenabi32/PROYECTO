package Vista;

import javax.swing.*;

import java.awt.*;

public class VistaInicioMenu {

    private JFrame ventana;
    public JButton btnVerCompras;
    public JButton btnComprarcomp;

    public VistaInicioMenu() {
        initialize();
    }

    public void initialize() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.decode("#E6CCFF"));

        JLabel titulo = new JLabel("Menu Principal");
        titulo.setBounds(100, 50, 600, 60);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        ventana.getContentPane().add(titulo);

        btnVerCompras = new JButton("Ver Compras");
        btnVerCompras.setBounds(250, 200, 300, 70);
        btnVerCompras.setFont(new Font("Arial", Font.PLAIN, 20));
        ventana.getContentPane().add(btnVerCompras);

        btnComprarcomp = new JButton("Comprar Componenetes");
        btnComprarcomp.setBounds(250, 300, 300, 70);
        btnComprarcomp.setFont(new Font("Arial", Font.PLAIN, 20));
        ventana.getContentPane().add(btnComprarcomp);
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
        VistaInicioMenu vista = new VistaInicioMenu();
        vista.mostrarVentana();
    }
}
